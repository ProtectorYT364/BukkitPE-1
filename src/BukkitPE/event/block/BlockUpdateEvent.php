<?php
namespace BukkitPE\event\block;

use BukkitPE\event\Cancellable;

/**
 * Called when a block tries to be updated due to a neighbor change
 */
class BlockUpdateEvent extends BlockEvent implements Cancellable{
	public static $handlerList = null;

}