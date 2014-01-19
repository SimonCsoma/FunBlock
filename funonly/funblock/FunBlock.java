package funonly.funblock;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import funonly.funblock.item.DiamondChip;
import funonly.funblock.listener.ItemDrops;
import funonly.funblock.world.SkyBlockWorld;

@Mod(modid="FunBlock", name="FunBlock", version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class FunBlock {
	
	public final static Item diamondChip = new DiamondChip(5000);
	
	public static WorldType tutorialWorld = new SkyBlockWorld(15, "CUSTOM");

	// The instance of your mod that Forge uses.
    @Instance(value = "FunBlock")
    public static FunBlock instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="funonly.funblock.client.ClientProxy", serverSide="funonly.funblock.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }
    
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	
    	
    	
    	MinecraftForge.EVENT_BUS.register(new ItemDrops());
    	
    	LanguageRegistry.addName(diamondChip, "Diamond Chip");
    	//LanguageRegistry.addName(tutorialWorld, "Custom World");
    	
    	ItemStack diamondChipStack = new ItemStack(FunBlock.diamondChip);
    	ItemStack diamondStack = new ItemStack(Item.diamond);
    	proxy.registerRenderers();
    	
    	
    	GameRegistry.addRecipe(diamondStack, "xx", "xx", 
    	        'x', diamondChipStack);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}
