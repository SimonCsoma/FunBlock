package funonly.funblock.biome;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Void extends BiomeGenBase{

	private WorldGenerator UnDeadworldGeneratorBigTree;
	public final Material blockMaterial;
	public Void(int par1){
		super(par1);
		this.blockMaterial = Material.water;
		this.minHeight = 0.1F;
		this.maxHeight = 0.6F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = (0);
		this.fillerBlock = (0);
		this.setBiomeName("Void");

/** this changes the water colour, its set to red now but ggole the java colours **/
this.waterColorMultiplier = 0xE42D17;
}
}