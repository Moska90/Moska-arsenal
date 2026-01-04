package name.modid.item;

import name.modid.End_sword;
import net.minecraft.world.item.ToolMaterial;

public class MaceItem extends net.minecraft.world.item.MaceItem {
    public MaceItem(ToolMaterial material, Properties properties) {
        super(properties
                .durability(material.durability())
                .attributes(net.minecraft.world.item.MaceItem.createAttributes()));
    }
}