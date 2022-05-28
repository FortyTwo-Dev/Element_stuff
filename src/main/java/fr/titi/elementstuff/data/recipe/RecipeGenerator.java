package fr.titi.elementstuff.data.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;


import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer){


    }
}
