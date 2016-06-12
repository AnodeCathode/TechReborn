package techreborn.blocks.machine;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import reborncore.common.blocks.BlockMachineBase;
import reborncore.common.blocks.IRotationTexture;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.client.TechRebornCreativeTab;
import techreborn.tiles.energy.tier1.TileAssemblingMachine;

public class BlockAssemblingMachine extends BlockMachineBase implements IRotationTexture
{

	private final String prefix = "techreborn:blocks/machine/greg_machines/";

	public BlockAssemblingMachine(Material material)
	{
		super();
		setUnlocalizedName("techreborn.assemblingmachine");
		setCreativeTab(TechRebornCreativeTab.instance);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileAssemblingMachine();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ)
	{
		if (!player.isSneaking())
			player.openGui(Core.INSTANCE, GuiHandler.assemblingmachineID, world, x, y, z);
		return true;
	}

	@Override
	public String getFrontOff()
	{
		return prefix + "assembling_machine_front_off";
	}

	@Override
	public String getFrontOn()
	{
		return prefix + "assembling_machine_front_on";
	}

	@Override
	public String getSide()
	{
		return prefix + "machine_side";
	}

	@Override
	public String getTop()
	{
		return prefix + "machine_top";
	}

	@Override
	public String getBottom()
	{
		return prefix + "assembling_machine_top";
	}
}
