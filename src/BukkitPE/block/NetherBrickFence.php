<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class NetherBrickFence extends Transparent {

	protected $id = self::NETHER_BRICK_FENCE;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}
	
	public function getBreakTime(Item $item){
		if ($item instanceof Air){
			//Breaking by hand
			return 10;
		}
		else{
			// Other breaktimes are equal to woodfences.
			return parent::getBreakTime($item);
		}
	}

	public function getHardness(){
		return 2;
	}
        
	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}
	
	public function getName(){
		return "Nether Brick Fence";
	}
	
	public function canConnect(Block $block){
		//TODO: activate comments when the NetherBrickFenceGate class has been created.
		return ($block instanceof NetherBrickFence /* or $block instanceof NetherBrickFenceGate */) ? true : $block->isSolid() and !$block->isTransparent();
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= Tool::TIER_WOODEN){
			return [
				[$this->id, $this->meta, 1],
			];
		}else{
			return [];
		}
	}        
}
