package com.cibernet.minestuckuniverse.blocks;

import com.cibernet.minestuckuniverse.TabMinestuckUniverse;
import com.cibernet.minestuckuniverse.tileentity.TileEntityParadoxTransportalizer;
import com.mraof.minestuck.MinestuckConfig;
import com.mraof.minestuck.tileentity.TileEntityTransportalizer;
import com.mraof.minestuck.util.Teleport;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;

public class BlockParadoxTransportalizer extends BlockContainer
{
	protected static final AxisAlignedBB TRANSPORTALIZER_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	public BlockParadoxTransportalizer()
	{
		super(Material.IRON, MapColor.IRON);
		setUnlocalizedName("paradoxTransportalizer");
		setRegistryName("paradox_transportalizer");
		this.setHardness(3.5F);
		this.setHarvestLevel("pickaxe", 0);
		setCreativeTab(TabMinestuckUniverse.instance);
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return TRANSPORTALIZER_AABB;
	}
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		if (!world.isRemote && entity.getRidingEntity() == null && entity.getPassengers().isEmpty())
		{
			TileEntityParadoxTransportalizer te = (TileEntityParadoxTransportalizer)world.getTileEntity(pos);
			if(te != null)
				if (entity.timeUntilPortal == 0) {
					te.teleport(world, pos, entity);
				} else {
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
		}
	}
	
	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityParadoxTransportalizer();
	}
}
