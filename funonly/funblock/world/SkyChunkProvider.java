package funonly.funblock.world;

import java.util.List;

import funonly.funblock.structure.GenerateStructure;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class SkyChunkProvider implements IChunkProvider{
	
	private World world;
	
	SkyChunkProvider(World world){
		this.world = world;
	}

	@Override
	public boolean chunkExists(int i, int j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
		byte[] abyte = new byte[32768];
		Chunk chunk = new Chunk(this.world, abyte, i, j);
		
		return chunk;
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		ChunkCoordinates spawn = world.getSpawnPoint();
		if (spawn.posX > i * 16 && spawn.posX < i * 16 + 16 && spawn.posZ > j * 16 && spawn.posZ < j * 16 + 16 ){
			GenerateStructure.makeSpawn(spawn.posX, spawn.posY, spawn.posZ, world);
		}
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "SkyBlock world";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
		BiomeGenBase biomegenbase = this.world.getBiomeGenForCoords(par2, par4);
        return null;
    }
	
	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,
			int j, int k) {
		
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub
		
	}


}
