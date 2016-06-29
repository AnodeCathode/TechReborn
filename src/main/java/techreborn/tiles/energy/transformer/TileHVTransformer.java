package techreborn.tiles.energy.transformer;

import reborncore.api.power.EnumPowerTier;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;

/**
 * Created by modmuss50 on 16/03/2016.
 */
public class TileHVTransformer extends TileTransformer
{

	public TileHVTransformer()
	{
		super("HVTransformer", ModBlocks.hvt, EnumPowerTier.EXTREME, ConfigTechReborn.HVTransformerMaxInput * 2);
	}

}
