package techreborn.compat.jei.fusionReactor;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.text.translation.I18n;
import techreborn.client.gui.GuiFusionReactor;
import techreborn.compat.jei.RecipeCategoryUids;

public class FusionReactorRecipeCategory extends BlankRecipeCategory
{

	private static final int inputSlotTop = 0;
	private static final int inputSlotBottom = 1;
	private static final int outputSlot = 2;

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String title;

	public FusionReactorRecipeCategory(IGuiHelper guiHelper)
	{
		background = guiHelper.createDrawable(GuiFusionReactor.texture, 86, 16, 85, 64, 0, 40, 20, 20);
		title = I18n.translateToLocal("tile.techreborn.fusioncontrolcomputer.name");
	}

	@Nonnull
	@Override
	public String getUid()
	{
		return RecipeCategoryUids.FUSION_REACTOR;
	}

	@Nonnull
	@Override
	public String getTitle()
	{
		return title;
	}

	@Nonnull
	@Override
	public IDrawable getBackground()
	{
		return background;
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper)
	{
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
		itemStacks.init(inputSlotTop, true, 21, 0);
		itemStacks.init(inputSlotBottom, true, 21, 36);
		itemStacks.init(outputSlot, false, 81, 18);

		if (recipeWrapper instanceof FusionReactorRecipeWrapper)
		{
			FusionReactorRecipeWrapper fusionRecipe = (FusionReactorRecipeWrapper) recipeWrapper;
			itemStacks.set(inputSlotTop, fusionRecipe.getTopInput());
			itemStacks.set(inputSlotBottom, fusionRecipe.getBottomInput());
			itemStacks.set(outputSlot, fusionRecipe.getOutputs());
		}
	}

}
