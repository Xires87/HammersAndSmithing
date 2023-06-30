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
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE;
    private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE;
    private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE;
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE;
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE;
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE;
    private static final Identifier EMPTY_SLOT_IRON_NUGGET_TEXTURE;
    private static final Identifier EMPTY_SLOT_GOLD_NUGGET_TEXTURE;


    public static SmithingTemplateItem createDiamondReinforcement() {
        return new SmithingTemplateItem(DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT, DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT, DIAMOND_REINFORCEMENT_TEXT,
                DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getGoldenReinforcementEmptyAdditionsSlotTextures());
    }
    // todo
    public static SmithingTemplateItem createGoldenUpgrade() {
        return new SmithingTemplateItem(DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT, DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT, DIAMOND_REINFORCEMENT_TEXT,
                DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getGoldenReinforcementEmptyAdditionsSlotTextures());
    }
    // todo
    public static SmithingTemplateItem createIronUpgrade() {
        return new SmithingTemplateItem(DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT, DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT, DIAMOND_REINFORCEMENT_TEXT,
                DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT, DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT, getUpgradeEmptyBaseSlotTextures(),
                getGoldenReinforcementEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getCopperUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_IRON_NUGGET_TEXTURE);
    }

    private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_GOLD_NUGGET_TEXTURE);
    }

    private static List<Identifier> getGoldenReinforcementEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_DIAMOND_TEXTURE);
    }

    static{
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;

        DIAMOND_REINFORCEMENT_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier(HammersAndTables.MOD_ID,"diamond_reinforcement"))).formatted(TITLE_FORMATTING);
        DIAMOND_REINFORCEMENT_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        DIAMOND_REINFORCEMENT_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        DIAMOND_REINFORCEMENT_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.base_slot_description")));
        DIAMOND_REINFORCEMENT_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(HammersAndTables.MOD_ID,"smithing_template.diamond_reinforcement.additions_slot_description")));

        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");
        EMPTY_SLOT_REDSTONE_DUST_TEXTURE = new Identifier("item/empty_slot_redstone_dust");
        EMPTY_SLOT_QUARTZ_TEXTURE = new Identifier("item/empty_slot_quartz");
        EMPTY_SLOT_EMERALD_TEXTURE = new Identifier("item/empty_slot_emerald");
        EMPTY_SLOT_DIAMOND_TEXTURE = new Identifier("item/empty_slot_diamond");
        EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = new Identifier("item/empty_slot_lapis_lazuli");
        EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = new Identifier("item/empty_slot_amethyst_shard");
        EMPTY_SLOT_IRON_NUGGET_TEXTURE = new Identifier(HammersAndTables.MOD_ID ,"item/empty_slot_iron_nugget");
        EMPTY_SLOT_GOLD_NUGGET_TEXTURE = new Identifier(HammersAndTables.MOD_ID ,"item/empty_slot_gold_nugget");
    }
}
