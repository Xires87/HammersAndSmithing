package net.fryc.hammersandtables.items;

import net.fryc.hammersandtables.HammersAndTables;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class TemplatesHelper {
    private static final Formatting TITLE_FORMATTING;
    private static final Formatting DESCRIPTION_FORMATTING;

    private static final Text DIAMOND_REINFORCEMENT_TEXT;
    private static final Text DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT;
    private static final Text DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT;
    private static final Text DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT;

    private static final Text GOLDEN_UPGRADE_TEXT;
    private static final Text GOLDEN_UPGRADE_APPLIES_TO_TEXT;
    private static final Text GOLDEN_UPGRADE_INGREDIENTS_TEXT;
    private static final Text GOLDEN_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text GOLDEN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;

    private static final Text IRON_UPGRADE_TEXT;
    private static final Text IRON_UPGRADE_APPLIES_TO_TEXT;
    private static final Text IRON_UPGRADE_INGREDIENTS_TEXT;
    private static final Text IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;


    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE;
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE;
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE;
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE;
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE;
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE;

    private static final Identifier EMPTY_SLOT_IRON_NUGGET_TEXTURE;
    private static final Identifier EMPTY_SLOT_GOLD_NUGGET_TEXTURE;


    public static SmithingTemplateItem createDiamondReinforcement() {
        return new SmithingTemplateItem(DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT, DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT, DIAMOND_REINFORCEMENT_TEXT,
                DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getDiamondReinforcementEmptyAdditionsSlotTextures());
    }

    public static SmithingTemplateItem createGoldenUpgrade() {
        return new SmithingTemplateItem(GOLDEN_UPGRADE_APPLIES_TO_TEXT, GOLDEN_UPGRADE_INGREDIENTS_TEXT, GOLDEN_UPGRADE_TEXT,
                GOLDEN_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, GOLDEN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getGoldenUpgradeEmptyAdditionsSlotTextures());
    }

    public static SmithingTemplateItem createIronUpgrade() {
        return new SmithingTemplateItem(IRON_UPGRADE_APPLIES_TO_TEXT, IRON_UPGRADE_INGREDIENTS_TEXT, IRON_UPGRADE_TEXT,
                IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getIronUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_IRON_NUGGET_TEXTURE);
    }

    private static List<Identifier> getGoldenUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_GOLD_NUGGET_TEXTURE);
    }

    private static List<Identifier> getDiamondReinforcementEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_DIAMOND_TEXTURE);
    }

    static{
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;

        DIAMOND_REINFORCEMENT_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HammersAndTables.MOD_ID,"diamond_reinforcement"))).formatted(TITLE_FORMATTING);
        DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.base_slot_description")));
        DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.additions_slot_description")));

        GOLDEN_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HammersAndTables.MOD_ID,"golden_upgrade"))).formatted(TITLE_FORMATTING);
        GOLDEN_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.golden_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        GOLDEN_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.golden_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        GOLDEN_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.golden_upgrade.base_slot_description")));
        GOLDEN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.golden_upgrade.additions_slot_description")));

        IRON_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HammersAndTables.MOD_ID,"iron_upgrade"))).formatted(TITLE_FORMATTING);
        IRON_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.iron_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        IRON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.iron_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        IRON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.iron_upgrade.base_slot_description")));
        IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(HammersAndTables.MOD_ID,"smithing_template.iron_upgrade.additions_slot_description")));

        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.of("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.of("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.of("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.of("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = Identifier.of("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = Identifier.of("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = Identifier.of("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.of("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.of("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT_TEXTURE = Identifier.of("item/empty_slot_ingot");
        EMPTY_SLOT_DIAMOND_TEXTURE = Identifier.of("item/empty_slot_diamond");
        EMPTY_SLOT_IRON_NUGGET_TEXTURE = Identifier.of(HammersAndTables.MOD_ID ,"item/empty_slot_iron_nugget");
        EMPTY_SLOT_GOLD_NUGGET_TEXTURE = Identifier.of(HammersAndTables.MOD_ID ,"item/empty_slot_gold_nugget");
    }
}
