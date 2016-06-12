package techreborn.blocks.advanced_machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import reborncore.common.blocks.BlockMachineBase;
import reborncore.common.blocks.IRotationTexture;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.client.TechRebornCreativeTab;
import techreborn.tiles.energy.tier2.TileCentrifuge;

public class BlockCentrifuge extends BlockMachineBase implements IRotationTexture
{

	private final String prefix = "techreborn:blocks/machine/advanced_machines/";

	public BlockCentrifuge()
	{
		super();
		setUnlocalizedName("techreborn.centrifuge");
		setCreativeTab(TechRebornCreativeTab.instance);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileCentrifuge();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ)
	{
		if (!player.isSneaking())
		{
			player.openGui(Core.INSTANCE, GuiHandler.centrifugeID, world, x, y, z);
		}
		return true;
	}

	@Override
	public String getFrontOff()
	{
		return prefix + "industrial_centrifuge_side_off";
	}

	@Override
	public String getFrontOn()
	{
		return prefix + "industrial_centrifuge_side_on";
	}

	@Override
	public String getSide()
	{
		return getFrontOff();
	}

	@Override
	public String getTop()
	{
		return prefix + "industrial_centrifuge_top_off";
	}

	@Override
	public String getBottom()
	{
		return prefix + "industrial_centrifuge_bottom";
	}
}
