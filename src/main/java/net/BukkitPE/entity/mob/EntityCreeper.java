package net.BukkitPE.entity.mob;

import net.BukkitPE.Player;
import net.BukkitPE.entity.data.ByteEntityData;
import net.BukkitPE.entity.weather.EntityLightningStrike;
import net.BukkitPE.event.entity.CreeperPowerEvent;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;
import net.BukkitPE.network.protocol.AddEntityPacket;

/**
 * @author Box.
 */
public class EntityCreeper extends EntityMob {
    public static final int NETWORK_ID = 33;

    public static final int DATA_SWELL_DIRECTION = 16;
    public static final int DATA_SWELL = 17;
    public static final int DATA_SWELL_OLD = 18;
    public static final int DATA_POWERED = 19;

    public EntityCreeper(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public boolean isPowered() {
        return getDataPropertyBoolean(DATA_POWERED);
    }

    public void setPowered(boolean powered) {
        CreeperPowerEvent ev = new CreeperPowerEvent(this, powered ? CreeperPowerEvent.PowerCause.SET_ON : CreeperPowerEvent.PowerCause.SET_OFF);
        this.getServer().getPluginManager().callEvent(ev);

        if (!ev.isCancelled()) {
            this.setDataProperty(new ByteEntityData(DATA_POWERED, powered ? 1 : 0));
            this.namedTag.putBoolean("powered", powered);
        }
    }

    public void setPowered(EntityLightningStrike bolt) {
        CreeperPowerEvent ev = new CreeperPowerEvent(this, bolt, CreeperPowerEvent.PowerCause.LIGHTNING);
        this.getServer().getPluginManager().callEvent(ev);

        if (!ev.isCancelled()) {
            this.setDataProperty(new ByteEntityData(DATA_POWERED, 1));
            this.namedTag.putBoolean("powered", true);
        }
    }

    @Override
    protected void initEntity() {
        super.initEntity();

        if (this.namedTag.getBoolean("powered") || this.namedTag.getBoolean("IsPowered")) {
            this.dataProperties.putBoolean(DATA_POWERED, true);
        }
    }

    @Override
    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.type = this.getNetworkId();
        pk.eid = this.getId();
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = (float) this.motionX;
        pk.speedY = (float) this.motionY;
        pk.speedZ = (float) this.motionZ;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }
}
