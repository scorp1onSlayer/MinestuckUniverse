package com.cibernet.minestuckuniverse.proxy;

import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.cibernet.minestuckuniverse.alchemy.MSUAlchemyRecipes;
import com.cibernet.minestuckuniverse.alchemy.MinestuckUniverseGrist;
import com.cibernet.minestuckuniverse.blocks.MinestuckUniverseBlocks;
import com.cibernet.minestuckuniverse.items.MinestuckUniverseItems;
import com.mraof.minestuck.client.gui.playerStats.GuiGristCache;
import com.mraof.minestuck.util.KindAbstratusList;
import com.mraof.minestuck.util.KindAbstratusType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

import java.util.ArrayList;
import java.util.List;

public class CommonProxy
{
    public CommonProxy(){}

    public void preInit()
    {
        MinecraftForge.EVENT_BUS.register(new MinestuckUniverseGrist());
        MinecraftForge.EVENT_BUS.register(MinestuckUniverseBlocks.class);
        MinecraftForge.EVENT_BUS.register(MinestuckUniverseItems.class);

    }

    public void init()
    {
        List<KindAbstratusType> abstrata = KindAbstratusList.getTypeList();
        if(MinestuckUniverse.isThaumLoaded)
        {
            ResearchCategories.registerCategory("SBURBOMANCY", "FIRSTSTEPS", new AspectList(), new ResourceLocation("minestuckuniverse", "textures/gui/tab.png"), new ResourceLocation("minestuckuniverse", "textures/gui/gui_research_bg.jpg"));
            ThaumcraftApi.registerResearchLocation(new ResourceLocation("minestuckuniverse", "research/sburb.json"));


        }



        MSUAlchemyRecipes.registerRecipes();
    }
}