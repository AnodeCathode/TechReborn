package techreborn.tiles.energy.storage;

import reborncore.api.power.EnumPowerTier;
import techreborn.init.ModBlocks;

/**
 * Created by modmuss50 on 14/03/2016.
 */
public class TileBatBox extends TileEnergyStorage {

	public TileBatBox() {
		super("BatBox", ModBlocks.batBox, EnumPowerTier.LOW, 40000);
	}
}
