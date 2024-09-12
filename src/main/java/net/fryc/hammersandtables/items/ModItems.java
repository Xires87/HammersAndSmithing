package net.fryc.hammersandtables.items;

import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.items.custom.*;
import net.fryc.hammersandtables.util.AttributesHelper;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    
    //hammer
    private static final float HAMMER_ATTACK_SPEED = -3.3f;
    private static final float HAMMER_ATTACK_DAMAGE = 4f;
    
    //pickaxe
    private static final float PICKAXE_ATTACK_SPEED = -2.8f;
    private static final float PICKAXE_ATTACK_DAMAGE = 0f;
    
    //axe
    private static final float AXE_ATTACK_SPEED = -3.1f;
    private static final float AXE_ATTACK_DAMAGE = 5f;
    
    //shovel
    private static final float SHOVEL_ATTACK_SPEED = -3f;
    private static final float SHOVEL_ATTACK_DAMAGE = 0.5f;
    
    //hoe
    private static final float HOE_ATTACK_SPEED = -1f;
    private static final float HOE_ATTACK_DAMAGE = 1f;
    
    //sword
    private static final float SWORD_ATTACK_SPEED = -2.4f;
    private static final float SWORD_ATTACK_DAMAGE = 2f;


    //hammers----------------------------------------------------------------------------------

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer" ,
            new HammerItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ToolMaterials.WOOD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item STONE_HAMMER = registerItem("stone_hammer" ,
            new HammerItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(
                            AttributesHelper.createHammerAttributeModifiers(ToolMaterials.STONE, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
                    )));
    public static final Item SHINY_GOLDEN_HAMMER = registerItem("shiny_golden_hammer" ,
            new HammerItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.GOLD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));
    public static final Item COPPER_HAMMER = registerItem("copper_hammer" ,
            new HammerItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.COPPER, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item NUGGET_COPPER_HAMMER = registerItem("nugget_copper_hammer" ,
            new HammerItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.NUGGET_COPPER, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_HAMMER = registerItem("ingot_copper_hammer" ,
            new HammerItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.INGOT_COPPER, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item IRON_HAMMER = registerItem("iron_hammer" ,
            new HammerItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_HAMMER = registerItem("nugget_iron_hammer" ,
            new HammerItem(ModToolMaterials.NUGGET_IRON , new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.NUGGET_IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_HAMMER = registerItem("ingot_iron_hammer" ,
            new HammerItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.INGOT_IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer" ,
            new HammerItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.GOLD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_HAMMER = registerItem("diamond_golden_hammer" ,
            new HammerItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer" ,
            new HammerItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.DIAMOND, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer" ,
            new HammerItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.NETHERITE, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            )));
    
    //pickaxes ----------------------------------------------------------------------------------
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe" ,
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.COPPER, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item NUGGET_COPPER_PICKAXE = registerItem("nugget_copper_pickaxe" ,
            new PickaxeItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_COPPER, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_PICKAXE = registerItem("ingot_copper_pickaxe" ,
            new PickaxeItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_COPPER, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_PICKAXE = registerItem("nugget_iron_pickaxe" ,
            new PickaxeItem(ModToolMaterials.NUGGET_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_IRON, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_PICKAXE = registerItem("ingot_iron_pickaxe" ,
            new PickaxeItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_IRON, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_PICKAXE = registerItem("golden_pickaxe" ,
            new PickaxeItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.GOLD, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_PICKAXE = registerItem("diamond_golden_pickaxe" ,
            new PickaxeItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, PICKAXE_ATTACK_DAMAGE, PICKAXE_ATTACK_SPEED)
            )));
    
    //axes ---------------------------------------------------------------------------------------
    public static final Item COPPER_AXE = registerItem("copper_axe" ,
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.COPPER, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));
    public static final Item NUGGET_COPPER_AXE = registerItem("nugget_copper_axe" ,
            new AxeItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.NUGGET_COPPER, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_AXE = registerItem("ingot_copper_axe" ,
            new AxeItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.INGOT_COPPER, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_AXE = registerItem("nugget_iron_axe" ,
            new AxeItem(ModToolMaterials.NUGGET_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.NUGGET_IRON, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_AXE = registerItem("ingot_iron_axe" ,
            new AxeItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.INGOT_IRON, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_AXE = registerItem("golden_axe" ,
            new AxeItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.GOLD, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_AXE = registerItem("diamond_golden_axe" ,
            new AxeItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAxeAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, AXE_ATTACK_DAMAGE, AXE_ATTACK_SPEED)
            )));

    //shovels -----------------------------------------------------------------------------------------

    public static final Item COPPER_SHOVEL = registerItem("copper_shovel" ,
            new ShovelItem(ModToolMaterials.COPPER , new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.COPPER, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item NUGGET_COPPER_SHOVEL = registerItem("nugget_copper_shovel" ,
            new ShovelItem(ModToolMaterials.NUGGET_COPPER , new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_COPPER, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_SHOVEL = registerItem("ingot_copper_shovel" ,
            new ShovelItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_COPPER, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_SHOVEL = registerItem("nugget_iron_shovel" ,
            new ShovelItem(ModToolMaterials.NUGGET_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_IRON, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_SHOVEL = registerItem("ingot_iron_shovel" ,
            new ShovelItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_IRON, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_SHOVEL = registerItem("golden_shovel" ,
            new ShovelItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.GOLD, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_SHOVEL = registerItem("diamond_golden_shovel" ,
            new ShovelItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, SHOVEL_ATTACK_DAMAGE, SHOVEL_ATTACK_SPEED)
            )));

    //hoes ---------------------------------------------------------------------------------------------

    public static final Item COPPER_HOE = registerItem("copper_hoe" ,
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item NUGGET_COPPER_HOE = registerItem("nugget_copper_hoe" ,
            new HoeItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_HOE = registerItem("ingot_copper_hoe" ,
            new HoeItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_HOE = registerItem("nugget_iron_hoe" ,
            new HoeItem(ModToolMaterials.NUGGET_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_HOE = registerItem("ingot_iron_hoe" ,
            new HoeItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_HOE = registerItem("golden_hoe" ,
            new HoeItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_HOE = registerItem("diamond_golden_hoe" ,
            new HoeItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(HOE_ATTACK_DAMAGE, HOE_ATTACK_SPEED)
            )));

    //swords ------------------------------------------------------------------------------

    public static final Item COPPER_SWORD = registerItem("copper_sword" ,
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.COPPER, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item NUGGET_COPPER_SWORD = registerItem("nugget_copper_sword" ,
            new SwordItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_COPPER, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item INGOT_COPPER_SWORD = registerItem("ingot_copper_sword" ,
            new SwordItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_COPPER, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item NUGGET_IRON_SWORD = registerItem("nugget_iron_sword" ,
            new SwordItem(ModToolMaterials.NUGGET_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.NUGGET_IRON, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item INGOT_IRON_SWORD = registerItem("ingot_iron_sword" ,
            new SwordItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.INGOT_IRON, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item GOLDEN_SWORD = registerItem("golden_sword" ,
            new SwordItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.GOLD, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));

    public static final Item DIAMOND_GOLDEN_SWORD = registerItem("diamond_golden_sword" ,
            new SwordItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, SWORD_ATTACK_DAMAGE, SWORD_ATTACK_SPEED)
            )));


    //copper armor --------------------------------------------------------------------------------

    public static final Item COPPER_HELMET = registerItem("copper_helmet" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item COPPER_BOOTS = registerItem("copper_boots" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    public static final Item NUGGET_COPPER_HELMET = registerItem("nugget_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item NUGGET_COPPER_CHESTPLATE = registerItem("nugget_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item NUGGET_COPPER_LEGGINGS = registerItem("nugget_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item NUGGET_COPPER_BOOTS = registerItem("nugget_copper_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    public static final Item INGOT_COPPER_HELMET = registerItem("ingot_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item INGOT_COPPER_CHESTPLATE = registerItem("ingot_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item INGOT_COPPER_LEGGINGS = registerItem("ingot_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item INGOT_COPPER_BOOTS = registerItem("ingot_copper_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    //iron armor ----------------------------------------------------------------------------------

    public static final Item NUGGET_IRON_HELMET = registerItem("nugget_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item NUGGET_IRON_CHESTPLATE = registerItem("nugget_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item NUGGET_IRON_LEGGINGS = registerItem("nugget_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item NUGGET_IRON_BOOTS = registerItem("nugget_iron_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    public static final Item INGOT_IRON_HELMET = registerItem("ingot_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item INGOT_IRON_CHESTPLATE = registerItem("ingot_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item INGOT_IRON_LEGGINGS = registerItem("ingot_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item INGOT_IRON_BOOTS = registerItem("ingot_iron_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    //golden armor --------------------------------------------------------------------------------

    public static final Item GOLDEN_HELMET = registerItem("golden_helmet" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item GOLDEN_CHESTPLATE = registerItem("golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item GOLDEN_LEGGINGS = registerItem("golden_leggings" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item GOLDEN_BOOTS = registerItem("golden_boots" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    public static final Item DIAMOND_GOLDEN_HELMET = registerItem("diamond_golden_helmet" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item DIAMOND_GOLDEN_CHESTPLATE = registerItem("diamond_golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item DIAMOND_GOLDEN_LEGGINGS = registerItem("diamond_golden_leggings" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item DIAMOND_GOLDEN_BOOTS = registerItem("diamond_golden_boots" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    //bone armor ----------------------------------------------------------------------------------
    public static final Item BONE_HELMET = registerItem("bone_helmet" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.HELMET ,
                    new Item.Settings()));

    public static final Item BONE_CHESTPLATE = registerItem("bone_chestplate" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings()));

    public static final Item BONE_LEGGINGS = registerItem("bone_leggings" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings()));

    public static final Item BONE_BOOTS = registerItem("bone_boots" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.BOOTS ,
                    new Item.Settings()));

    //smithing templates----------------------------------------------------------------------------

    public static final Item DIAMOND_REINFORCEMENT_SMITHING_TEMPLATE = registerItem("diamond_reinforcement_smithing_template",
            TemplatesHelper.createDiamondReinforcement());

    public static final Item GOLDEN_UPGRADE_SMITHING_TEMPLATE = registerItem("golden_upgrade_smithing_template",
            TemplatesHelper.createGoldenUpgrade());

    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItem("iron_upgrade_smithing_template",
            TemplatesHelper.createIronUpgrade());


    //registers------------------------------------------------------------------------------------------
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(HammersAndTables.MOD_ID, name), item);
    }
    public static void registerModItems(){
    }

}
