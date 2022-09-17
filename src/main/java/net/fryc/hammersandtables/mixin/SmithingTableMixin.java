package net.fryc.hammersandtables.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SmithingTableBlock.class)
abstract class SmithingTableMixin extends CraftingTableBlock {

    public SmithingTableMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.FAIL;
    }
}
