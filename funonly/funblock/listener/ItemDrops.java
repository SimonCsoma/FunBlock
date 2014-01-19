package funonly.funblock.listener;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import funonly.funblock.FunBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class ItemDrops {

	@ForgeSubscribe
    public void onEntityDrop(LivingDropsEvent event) {
    	
    	Random random = new Random();
    	int rand = random.nextInt(10);
    	if (event.entityLiving instanceof EntityGhast){
    		if (rand > 4) {
    			event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX,
    					event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(FunBlock.diamondChip, 1)));
    			if (rand > 6) {
    				event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX,
    						event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(FunBlock.diamondChip, 1)));
    			}
    		}
    	}
    }
}
