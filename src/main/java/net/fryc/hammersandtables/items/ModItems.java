package net.fryc.hammersandtables.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fryc.hammersandtables.HammersAndTables;
import net.fryc.hammersandtables.blocks.ModBlocks;
import net.fryc.hammersandtables.items.custom.*;
import net.fryc.hammersandtables.util.AttributesHelper;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
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
    private static final float HOE_ATTACK_DAMAGE = 0f;
    
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
            ), 1));

    public static final Item NUGGET_COPPER_HAMMER = registerItem("nugget_copper_hammer" ,
            new HammerItem(ModToolMaterials.NUGGET_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.NUGGET_COPPER, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 1));

    public static final Item INGOT_COPPER_HAMMER = registerItem("ingot_copper_hammer" ,
            new HammerItem(ModToolMaterials.INGOT_COPPER, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.INGOT_COPPER, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 2));

    public static final Item IRON_HAMMER = registerItem("iron_hammer" ,
            new HammerItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 2));

    public static final Item NUGGET_IRON_HAMMER = registerItem("nugget_iron_hammer" ,
            new HammerItem(ModToolMaterials.NUGGET_IRON , new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.NUGGET_IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 2));

    public static final Item INGOT_IRON_HAMMER = registerItem("ingot_iron_hammer" ,
            new HammerItem(ModToolMaterials.INGOT_IRON, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.INGOT_IRON, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 3));

    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer" ,
            new HammerItem(ModToolMaterials.GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.GOLD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 3));

    public static final Item DIAMOND_GOLDEN_HAMMER = registerItem("diamond_golden_hammer" ,
            new HammerItem(ModToolMaterials.DIAMOND_GOLD, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ModToolMaterials.DIAMOND_GOLD, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 3));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer" ,
            new HammerItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.DIAMOND, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 4));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer" ,
            new HammerItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(
                    AttributesHelper.createHammerAttributeModifiers(ToolMaterials.NETHERITE, HAMMER_ATTACK_DAMAGE, HAMMER_ATTACK_SPEED)
            ), 5));
    
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
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(8))));

    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(8))));

    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(8))));

    public static final Item COPPER_BOOTS = registerItem("copper_boots" ,
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(8))));

    public static final Item NUGGET_COPPER_HELMET = registerItem("nugget_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(10))));

    public static final Item NUGGET_COPPER_CHESTPLATE = registerItem("nugget_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(10))));

    public static final Item NUGGET_COPPER_LEGGINGS = registerItem("nugget_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(10))));

    public static final Item NUGGET_COPPER_BOOTS = registerItem("nugget_copper_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(10))));

    public static final Item INGOT_COPPER_HELMET = registerItem("ingot_copper_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(12))));

    public static final Item INGOT_COPPER_CHESTPLATE = registerItem("ingot_copper_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(12))));

    public static final Item INGOT_COPPER_LEGGINGS = registerItem("ingot_copper_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(12))));

    public static final Item INGOT_COPPER_BOOTS = registerItem("ingot_copper_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_COPPER, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(12))));

    //iron armor ----------------------------------------------------------------------------------

    public static final Item NUGGET_IRON_HELMET = registerItem("nugget_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(17))));

    public static final Item NUGGET_IRON_CHESTPLATE = registerItem("nugget_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(17))));

    public static final Item NUGGET_IRON_LEGGINGS = registerItem("nugget_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(17))));

    public static final Item NUGGET_IRON_BOOTS = registerItem("nugget_iron_boots" ,
            new ArmorItem(ModArmorMaterials.NUGGET_IRON, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(17))));

    public static final Item INGOT_IRON_HELMET = registerItem("ingot_iron_helmet" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20))));

    public static final Item INGOT_IRON_CHESTPLATE = registerItem("ingot_iron_chestplate" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20))));

    public static final Item INGOT_IRON_LEGGINGS = registerItem("ingot_iron_leggings" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20))));

    public static final Item INGOT_IRON_BOOTS = registerItem("ingot_iron_boots" ,
            new ArmorItem(ModArmorMaterials.INGOT_IRON, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(20))));

    //golden armor --------------------------------------------------------------------------------

    public static final Item GOLDEN_HELMET = registerItem("golden_helmet" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(23))));

    public static final Item GOLDEN_CHESTPLATE = registerItem("golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(23))));

    public static final Item GOLDEN_LEGGINGS = registerItem("golden_leggings" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(23))));

    public static final Item GOLDEN_BOOTS = registerItem("golden_boots" ,
            new ArmorItem(ModArmorMaterials.GOLD, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(23))));

    public static final Item DIAMOND_GOLDEN_HELMET = registerItem("diamond_golden_helmet" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(27))));

    public static final Item DIAMOND_GOLDEN_CHESTPLATE = registerItem("diamond_golden_chestplate" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(27))));

    public static final Item DIAMOND_GOLDEN_LEGGINGS = registerItem("diamond_golden_leggings" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(27))));

    public static final Item DIAMOND_GOLDEN_BOOTS = registerItem("diamond_golden_boots" ,
            new ArmorItem(ModArmorMaterials.DIAMOND_GOLD, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(27))));

    //bone armor ----------------------------------------------------------------------------------
    public static final Item BONE_HELMET = registerItem("bone_helmet" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.HELMET ,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(7))));

    public static final Item BONE_CHESTPLATE = registerItem("bone_chestplate" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.CHESTPLATE ,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(7))));

    public static final Item BONE_LEGGINGS = registerItem("bone_leggings" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.LEGGINGS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(7))));

    public static final Item BONE_BOOTS = registerItem("bone_boots" ,
            new ArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.BOOTS ,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(7))));

    //smithing templates----------------------------------------------------------------------------

    public static final Item DIAMOND_REINFORCEMENT_SMITHING_TEMPLATE = registerItem("diamond_reinforcement_smithing_template",
            TemplatesHelper.createDiamondReinforcement());

    public static final Item GOLDEN_UPGRADE_SMITHING_TEMPLATE = registerItem("golden_upgrade_smithing_template",
            TemplatesHelper.createGoldenUpgrade());

    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItem("iron_upgrade_smithing_template",
            TemplatesHelper.createIronUpgrade());

    //master tools------------------------------------------------------------------------------------

    public static final Item MASTER_TOOLS = registerItem("master_tools",
            new MasterToolsItem(new Item.Settings().maxDamage(21)));

    public static final Item IRON_CRAFTING_KIT = registerItem("iron_crafting_kit",
            new CraftingKitItem(new Item.Settings().maxDamage(21), "copper"));

    public static final Item GOLDEN_CRAFTING_KIT = registerItem("golden_crafting_kit",
            new CraftingKitItem(new Item.Settings().maxDamage(21), "iron"));

    public static final Item DIAMOND_CRAFTING_KIT = registerItem("diamond_crafting_kit",
            new CraftingKitItem(new Item.Settings().maxDamage(21), "gold"));

    //registers------------------------------------------------------------------------------------------
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(HammersAndTables.MOD_ID, name), item);
    }
    public static void registerModItems(){
        //Item Group
        Registry.register(Registries.ITEM_GROUP, HammersAndTables.HAMMERS_AND_SMITHING, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.COPPER_TABLE))
                .displayName(Text.literal("Hammers and Smithing"))
                .entries((enabledFeatures, entries) -> {
                    //tables
                    entries.add(ModBlocks.COPPER_TABLE);
                    entries.add(ModBlocks.IRON_TABLE);
                    entries.add(ModBlocks.GOLD_TABLE);
                    entries.add(ModBlocks.DIAMOND_TABLE);
                    entries.add(ModBlocks.PIGLINS_FORGE);

                    //hammers
                    entries.add(ModItems.WOODEN_HAMMER);
                    entries.add(ModItems.STONE_HAMMER);
                    entries.add(ModItems.SHINY_GOLDEN_HAMMER);
                    entries.add(ModItems.COPPER_HAMMER);
                    entries.add(ModItems.NUGGET_COPPER_HAMMER);
                    entries.add(ModItems.INGOT_COPPER_HAMMER);

                    entries.add(ModItems.IRON_HAMMER);
                    entries.add(ModItems.NUGGET_IRON_HAMMER);
                    entries.add(ModItems.INGOT_IRON_HAMMER);

                    entries.add(ModItems.GOLDEN_HAMMER);
                    entries.add(ModItems.DIAMOND_GOLDEN_HAMMER);

                    entries.add(ModItems.DIAMOND_HAMMER);
                    entries.add(ModItems.NETHERITE_HAMMER);

                    //copper
                    entries.add(ModItems.COPPER_PICKAXE);
                    entries.add(ModItems.COPPER_AXE);
                    entries.add(ModItems.COPPER_SHOVEL);
                    entries.add(ModItems.COPPER_HOE);
                    entries.add(ModItems.COPPER_SWORD);
                    entries.add(ModItems.COPPER_HELMET);
                    entries.add(ModItems.COPPER_CHESTPLATE);
                    entries.add(ModItems.COPPER_LEGGINGS);
                    entries.add(ModItems.COPPER_BOOTS);

                    //nugget copper
                    entries.add(ModItems.NUGGET_COPPER_PICKAXE);
                    entries.add(ModItems.NUGGET_COPPER_AXE);
                    entries.add(ModItems.NUGGET_COPPER_SHOVEL);
                    entries.add(ModItems.NUGGET_COPPER_HOE);
                    entries.add(ModItems.NUGGET_COPPER_SWORD);
                    entries.add(ModItems.NUGGET_COPPER_HELMET);
                    entries.add(ModItems.NUGGET_COPPER_CHESTPLATE);
                    entries.add(ModItems.NUGGET_COPPER_LEGGINGS);
                    entries.add(ModItems.NUGGET_COPPER_BOOTS);

                    //ingot copper
                    entries.add(ModItems.INGOT_COPPER_PICKAXE);
                    entries.add(ModItems.INGOT_COPPER_AXE);
                    entries.add(ModItems.INGOT_COPPER_SHOVEL);
                    entries.add(ModItems.INGOT_COPPER_HOE);
                    entries.add(ModItems.INGOT_COPPER_SWORD);
                    entries.add(ModItems.INGOT_COPPER_HELMET);
                    entries.add(ModItems.INGOT_COPPER_CHESTPLATE);
                    entries.add(ModItems.INGOT_COPPER_LEGGINGS);
                    entries.add(ModItems.INGOT_COPPER_BOOTS);

                    //nugget iron
                    entries.add(ModItems.NUGGET_IRON_PICKAXE);
                    entries.add(ModItems.NUGGET_IRON_AXE);
                    entries.add(ModItems.NUGGET_IRON_SHOVEL);
                    entries.add(ModItems.NUGGET_IRON_HOE);
                    entries.add(ModItems.NUGGET_IRON_SWORD);
                    entries.add(ModItems.NUGGET_IRON_HELMET);
                    entries.add(ModItems.NUGGET_IRON_CHESTPLATE);
                    entries.add(ModItems.NUGGET_IRON_LEGGINGS);
                    entries.add(ModItems.NUGGET_IRON_BOOTS);

                    //ingot iron
                    entries.add(ModItems.INGOT_IRON_PICKAXE);
                    entries.add(ModItems.INGOT_IRON_AXE);
                    entries.add(ModItems.INGOT_IRON_SHOVEL);
                    entries.add(ModItems.INGOT_IRON_HOE);
                    entries.add(ModItems.INGOT_IRON_SWORD);
                    entries.add(ModItems.INGOT_IRON_HELMET);
                    entries.add(ModItems.INGOT_IRON_CHESTPLATE);
                    entries.add(ModItems.INGOT_IRON_LEGGINGS);
                    entries.add(ModItems.INGOT_IRON_BOOTS);

                    //gold
                    entries.add(ModItems.GOLDEN_PICKAXE);
                    entries.add(ModItems.GOLDEN_AXE);
                    entries.add(ModItems.GOLDEN_SHOVEL);
                    entries.add(ModItems.GOLDEN_HOE);
                    entries.add(ModItems.GOLDEN_SWORD);
                    entries.add(ModItems.GOLDEN_HELMET);
                    entries.add(ModItems.GOLDEN_CHESTPLATE);
                    entries.add(ModItems.GOLDEN_LEGGINGS);
                    entries.add(ModItems.GOLDEN_BOOTS);

                    //diamond gold
                    entries.add(ModItems.DIAMOND_GOLDEN_PICKAXE);
                    entries.add(ModItems.DIAMOND_GOLDEN_AXE);
                    entries.add(ModItems.DIAMOND_GOLDEN_SHOVEL);
                    entries.add(ModItems.DIAMOND_GOLDEN_HOE);
                    entries.add(ModItems.DIAMOND_GOLDEN_SWORD);
                    entries.add(ModItems.DIAMOND_GOLDEN_HELMET);
                    entries.add(ModItems.DIAMOND_GOLDEN_CHESTPLATE);
                    entries.add(ModItems.DIAMOND_GOLDEN_LEGGINGS);
                    entries.add(ModItems.DIAMOND_GOLDEN_BOOTS);

                    //bone armor
                    entries.add(ModItems.BONE_HELMET);
                    entries.add(ModItems.BONE_CHESTPLATE);
                    entries.add(ModItems.BONE_LEGGINGS);
                    entries.add(ModItems.BONE_BOOTS);

                    //templates
                    entries.add(ModItems.DIAMOND_REINFORCEMENT_SMITHING_TEMPLATE);
                    entries.add(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE);
                    entries.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE);

                    //master tools
                    entries.add(ModItems.MASTER_TOOLS);
                    entries.add(ModItems.IRON_CRAFTING_KIT);
                    entries.add(ModItems.GOLDEN_CRAFTING_KIT);
                    entries.add(ModItems.DIAMOND_CRAFTING_KIT);

                })
                .build());

    }

}
