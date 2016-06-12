package techreborn.blocks.advanced_machine;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import reborncore.common.blocks.BlockMachineBase;
import reborncore.common.blocks.IRotationTexture;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.client.TechRebornCreativeTab;
import techreborn.tiles.energy.tier2.TileIndustrialSawmill;

public class BlockIndustrialSawmill extends BlockMachineBase implements IRotationTexture
{

	private final String prefix = "techreborn:blocks/machine/advanced_machines/";

	public BlockIndustrialSawmill(Material material)
	{
		super();
		setUnlocalizedName("techreborn.industrialsawmill");
		setCreativeTab(TechRebornCreativeTab.instance);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileIndustrialSawmill();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ)
	{
		if (fillBlockWithFluid(world, new BlockPos(x, y, z), player))
		{
			return true;
		}
		if (!player.isSneaking())
			player.openGui(Core.INSTANCE, GuiHandler.sawMillID, world, x, y, z);
		return true;
	}

	@Override
	public String getFrontOff()
	{
		return prefix + "industrial_sawmill_front_off";
	}

	@Override
	public String getFrontOn()
	{
		return prefix + "industrial_sawmill_front_on";
	}

	@Override
	public String getSide()
	{
		return prefix + "advanced_machine_side";
	}

	@Override
	public String getTop()
	{
		return prefix + "advanced_machine_side";
	}

	@Override
	public String getBottom()
	{
		return prefix + "advanced_machine_side";
	}
}
