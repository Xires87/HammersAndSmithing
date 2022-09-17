package net.fryc.hammersandtables.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(RuinedPortalStructurePiece.class)
abstract class RuinedPortalMixin extends SimpleStructurePiece {
    public RuinedPortalMixin(StructurePieceType type, int length, StructureTemplateManager structureTemplateManager, Identifier id, String template, StructurePlacementData placementData, BlockPos pos) {
        super(type, length, structureTemplateManager, id, template, placementData, pos);
    }

    //replaces gold blocks with nether gold ores
    @Inject(method = "createReplacementRule(Lnet/minecraft/block/Block;FLnet/minecraft/block/Block;)Lnet/minecraft/structure/processor/StructureProcessorRule;", at = @At("RETURN"), cancellable = true)
    private static void replaceGoldBlock(Block old, float chance, Block updated , CallbackInfoReturnable<StructureProcessorRule> dur) {
        if(old == Blocks.GOLD_BLOCK && chance == 0.3F && updated == Blocks.AIR){
            chance = 1.0F;
            updated = Blocks.NETHER_GOLD_ORE;
            dur.setReturnValue(new StructureProcessorRule(new RandomBlockMatchRuleTest(old,chance), AlwaysTrueRuleTest.INSTANCE, updated.getDefaultState()));
        }
    }


}
