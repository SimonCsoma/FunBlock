package funonly.funblock.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class SkyBlockWorld extends WorldType {

	public SkyBlockWorld(int par1, String par2Str) {
		super(par1, par2Str, 0);
	}
	
	@Override
	public WorldChunkManager getChunkManager(World world){
		return new WorldChunkManager(world);
	}
	
	//Sets up the ChunkProvider. Use ChunkProviderHell for single biome worlds else use ChunkProviderGenerate or a custom provider.
    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
        return new SkyChunkProvider(world); //
    }

    //Gets the spawn fuzz for players who join the world.
    @Override
    public int getSpawnFuzz()
    {
        return 1;
    }

}
