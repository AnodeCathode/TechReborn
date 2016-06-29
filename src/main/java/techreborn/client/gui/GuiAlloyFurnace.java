package techreborn.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import techreborn.client.container.energy.tier0.ContainerIronAlloyFurnace;
import techreborn.tiles.energy.tier0.TileIronAlloyFurnace;

public class GuiAlloyFurnace extends GuiContainer
{

	private static final ResourceLocation texture = new ResourceLocation("techreborn",
			"textures/gui/alloy_furnace.png");

	TileIronAlloyFurnace alloyfurnace;

	ContainerIronAlloyFurnace containerAlloyFurnace;

	public GuiAlloyFurnace(EntityPlayer player, TileIronAlloyFurnace tileAlloyFurnace)
	{
		super(new ContainerIronAlloyFurnace(tileAlloyFurnace, player));
		this.xSize = 176;
		this.ySize = 167;
		this.alloyfurnace = tileAlloyFurnace;
		this.containerAlloyFurnace = (ContainerIronAlloyFurnace) this.inventorySlots;
	}

	@Override
	public void initGui()
	{
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		super.initGui();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.alloyfurnace.isBurning())
		{
			int i1 = 0; //this.alloyfurnace.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
//			i1 = this.alloyfurnace.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		String name = I18n.translateToLocal("tile.techreborn.alloyfurnace.name");
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);

	}
}
