package com.cibernet.minestuckuniverse.entity.classes;

import com.cibernet.minestuckuniverse.MinestuckUniverse;
import com.mraof.minestuck.entity.underling.EntityUnderling;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.io.FileNotFoundException;

public abstract class EntityMSUUnderling extends EntityUnderling
{
    public EntityMSUUnderling(World par1World) {super(par1World);  }

    @Override
    public ResourceLocation getTextureResource()
    {
        //System.out.println("archieron");
        this.textureResource = new ResourceLocation(MinestuckUniverse.MODID, this.getTexture());

        if(this.textureResource == null) {
            this.textureResource = new ResourceLocation(MinestuckUniverse.MODID, this.getUnderlingName() + ".png");
        }
        return this.textureResource;
    }

    @Override
    public String getTexture() {
        return "textures/mobs/underlings/" + this.type.getName() + '_' + this.getUnderlingName() + ".png";
    }

}
