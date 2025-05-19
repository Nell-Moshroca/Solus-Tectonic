package net.nellm.solustectonic.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.naming.Context;

public class ProspectingPickItem extends Item {
    public ProspectingPickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Level level = context.getLevel();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }

                //context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No ore detected."));
            }

            context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
        }



        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found traces of ").append(Component.translatable(block.getDescriptionId())).append(Component.literal(".")));
        //player.sendSystemMessage(Component.literal("Found traces of " + I18n.get(Component.translatable() + ".")));
        //Component.literal("Found traces of ").append(Component.translatable(block.getDescriptionId())
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.COPPER_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.COAL_ORE)
                || state.is(Blocks.REDSTONE_ORE) || state.is(Blocks.EMERALD_ORE) || state.is(Blocks.LAPIS_ORE) || state.is(Blocks.RAW_COPPER_BLOCK)
                || state.is(Blocks.RAW_GOLD_BLOCK) || state.is(Blocks.RAW_IRON_BLOCK) || state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(Blocks.DEEPSLATE_GOLD_ORE) || state.is(Blocks.DEEPSLATE_COPPER_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE) || state.is(Blocks.DEEPSLATE_COAL_ORE)
                || state.is(Blocks.DEEPSLATE_REDSTONE_ORE) || state.is(Blocks.DEEPSLATE_EMERALD_ORE) || state.is(Blocks.DEEPSLATE_LAPIS_ORE) ;
    }
}
