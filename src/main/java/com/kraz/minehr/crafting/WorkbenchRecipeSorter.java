package com.kraz.minehr.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WorkbenchRecipeSorter implements Comparator {

    final WorkbenchCraftingManager workbench;

    public WorkbenchRecipeSorter(WorkbenchCraftingManager workbenchCraftingManager) {
        this.workbench = workbenchCraftingManager;
    }

    public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
        return irecipe1 instanceof WorkbenchShapelessRecipes && irecipe2 instanceof WorkbenchShapedRecipes ? 1 : (irecipe2 instanceof WorkbenchShapelessRecipes && irecipe1 instanceof WorkbenchShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object arg0, Object arg1) {
        return this.compareRecipes((IRecipe)arg0, (IRecipe)arg1);
    }

}
