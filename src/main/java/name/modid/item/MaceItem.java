package name.modid.item;

import name.modid.Moska_arsenal;
import net.minecraft.world.item.ToolMaterial;

public class MaceItem extends net.minecraft.world.item.MaceItem {
    public MaceItem(ToolMaterial material, Properties properties) {
        super(properties
                .durability(material.durability())
                .attributes(net.minecraft.world.item.MaceItem.createAttributes()));
    }
}