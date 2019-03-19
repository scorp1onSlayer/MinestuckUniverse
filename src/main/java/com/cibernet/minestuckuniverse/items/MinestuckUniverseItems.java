package com.cibernet.minestuckuniverse.items;

import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.mraof.minestuck.item.block.ItemAlchemiter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.cibernet.minestuckuniverse.blocks.MinestuckUniverseBlocks.*;

public class MinestuckUniverseItems
{

    public static Item spaceSalt = new ItemSpaceSalt();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        registerItemBlock(registry, magicBlock);

        if(MinestuckUniverse.isThaumLoaded)
        {
            registry.register(spaceSalt);

            registerItemBlock(registry, thaumChasis);
            registerItemBlock(registry, gristDecomposer);

        }
    }

    private static Item registerItemBlock(IForgeRegistry<Item> registry, Block block)
    {
        ItemBlock item = new ItemBlock(block);
        registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
        return item;
    }
}