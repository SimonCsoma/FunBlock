package funonly.funblock.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class GenerateStructure {

	public static void makeSpawn(int posX, int posY, int posZ, World world) {
		
		WorldGenTrees wgt = new WorldGenTrees(true, 4, 0, 0, false);
		
		for(int y = posY; y < posY + 3;y++){
			for(int x = posX-1; x < posX + 5; x++){			
				for( int z = posZ - 1; z < posZ+2;z++){
					if (y - posY == 2){
						world.setBlock(x, y , z, Block.grass.blockID);
						continue;
					}
					world.setBlock(x, y , z, Block.dirt.blockID);
				}
			}
		}
		for(int y = posY; y < posY + 3;y++){
			for(int x = posX-1; x < posX + 2; x++){			
				for( int z = posZ + 2; z < posZ+5;z++){
					if (y - posY == 2){
						world.setBlock(x, y , z, Block.grass.blockID);
						continue;
					}
					world.setBlock(x, y , z, Block.dirt.blockID);
				}
			}
		}
		wgt.generate(world, new Random(), posX+1, posY+3, posZ+4);
		world.setBlock(posX, posY, posZ, Block.bedrock.blockID);
		
	}

}
