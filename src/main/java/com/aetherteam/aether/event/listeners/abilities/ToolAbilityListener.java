package com.aetherteam.aether.event.listeners.abilities;

import com.aetherteam.aether.event.hooks.AbilityHooks;
import io.github.fabricators_of_create.porting_lib.entity.events.PlayerEvents;
import io.github.fabricators_of_create.porting_lib.entity.events.player.AttackEntityEvent;
import io.github.fabricators_of_create.porting_lib.event.common.BlockEvents;
import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class ToolAbilityListener {
    public static InteractionHand INTERACTION_HAND;

    /**
     * @see AbilityHooks.ToolHooks#setupToolActions(LevelAccessor, BlockPos, BlockState, ToolAction)
     */
    public static void setupToolModifications(BlockEvents.BlockToolModificationEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState oldState = event.getState();
        ToolAction toolAction = event.getToolAction();
        BlockState newState = AbilityHooks.ToolHooks.setupToolActions(levelAccessor, pos, oldState, toolAction);
        if (newState != oldState && !event.isSimulated() && !event.isCanceled()) {
            event.setFinalState(newState);
        }
    }

    /**
     * @see AbilityHooks.ToolHooks#handleHolystoneToolAbility(Player, Level, BlockPos, ItemStack, BlockState)
     */
    public static void doHolystoneAbility(BlockEvents.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = player.level();
        BlockPos blockPos = event.getPos();
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState = event.getState();
        if (!event.isCanceled()) {
            AbilityHooks.ToolHooks.handleHolystoneToolAbility(player, level, blockPos, itemStack, blockState);
        }
    }
    
    /**
     * @see AbilityHooks.ToolHooks#handleZaniteToolAbility(ItemStack, float)
     * @see AbilityHooks.ToolHooks#reduceToolEffectiveness(Player, BlockState, ItemStack, float)
     */
    public static void modifyBreakSpeed(PlayerEvents.BreakSpeed event) {
        BlockState blockState = event.getState();
        Player player = event.getEntity();
        ItemStack itemStack = player.getMainHandItem();
        if (!event.isCanceled()) {
            event.setNewSpeed(AbilityHooks.ToolHooks.handleZaniteToolAbility(itemStack, event.getNewSpeed()));
            event.setNewSpeed(AbilityHooks.ToolHooks.reduceToolEffectiveness(player, blockState, itemStack, event.getNewSpeed()));
        }
    }

    /**
     * @see AbilityHooks.ToolHooks#stripGoldenOak(LevelAccessor, BlockState, ItemStack, ToolAction, UseOnContext)
     */
    public static void doGoldenOakStripping(BlockEvents.BlockToolModificationEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        BlockState oldState = event.getState();
        ItemStack itemStack = event.getHeldItemStack();
        ToolAction toolAction = event.getToolAction();
        UseOnContext context = event.getContext();
        if (!event.isSimulated() && !event.isCanceled()) {
            AbilityHooks.ToolHooks.stripGoldenOak(levelAccessor, oldState, itemStack, toolAction, context);
        }
    }

    /**
     * @see ToolAbilityListener#checkEntityTooFar(PlayerEvents, Entity, Player, InteractionHand)
     */
    public static void onEntityAttack(AttackEntityEvent event) {
        checkEntityTooFar(event, event.getTarget(), event.getEntity(), InteractionHand.MAIN_HAND);
    }

    // TODO: PORT (Reintroduce these as events in 1.21 instead of mixins)
//    /**
//     * @see ToolAbilityListener#checkEntityTooFar(PlayerEvents, Entity, Player, InteractionHand)
//     * @see ToolAbilityListener#checkBlockTooFar(PlayerEvents, Player, InteractionHand)
//     * @see com.aetherteam.aether.mixin.mixins.common.ItemMixin#getPlayerPOVHitResult(Level, Player, ClipContext.Fluid, CallbackInfoReturnable)
//     */
//    public static void onEntityInteract(PlayerInteractEvent event) {
//        if (event instanceof PlayerInteractEvent.EntityInteractSpecific entityInteractSpecific) {
//            checkEntityTooFar(entityInteractSpecific, entityInteractSpecific.getTarget(), entityInteractSpecific.getEntity(), entityInteractSpecific.getHand());
//        } else if (event instanceof PlayerInteractEvent.EntityInteract entityInteract) {
//            checkEntityTooFar(entityInteract, entityInteract.getTarget(), entityInteract.getEntity(), entityInteract.getHand());
//        } else if (event instanceof PlayerInteractEvent.RightClickBlock rightClickBlock) {
//            checkBlockTooFar(event, rightClickBlock.getEntity(), rightClickBlock.getHand());
//        } else if (event instanceof PlayerInteractEvent.LeftClickBlock leftClickBlock) {
//            checkBlockTooFar(event, leftClickBlock.getEntity(), leftClickBlock.getHand());
//        } else if (event instanceof PlayerInteractEvent.RightClickItem rightClickItem) {
//            INTERACTION_HAND = rightClickItem.getHand();
//        }
//    }

    /**
     * Cancels the given event if the targeted entity is too far away.
     * @see AbilityHooks.ToolHooks#entityTooFar(Entity, Player, InteractionHand)
     */
    private static void checkEntityTooFar(PlayerEvents event, Entity target, Player player, InteractionHand hand) {
        if (!event.isCanceled() && AbilityHooks.ToolHooks.entityTooFar(target, player, hand)) {
            event.setCanceled(true);
        }
    }

    /**
     * Cancels the given event if the targeted block is too far away.
     * @see AbilityHooks.ToolHooks#blockTooFar(Player, InteractionHand)
     */
    private static void checkBlockTooFar(PlayerEvents event, Player player, InteractionHand hand) {
        if (!event.isCanceled() && AbilityHooks.ToolHooks.blockTooFar(player, hand)) {
            event.setCanceled(true);
        }
    }

    public static void init() {
        BlockEvents.BLOCK_MODIFICATION.register(ToolAbilityListener::setupToolModifications);
        PlayerEvents.BREAK_SPEED.register(ToolAbilityListener::modifyBreakSpeed);
        BlockEvents.BLOCK_BREAK.register(ToolAbilityListener::doHolystoneAbility);
        BlockEvents.BLOCK_MODIFICATION.register(ToolAbilityListener::doGoldenOakStripping);
        AttackEntityEvent.ATTACK_ENTITY.register(ToolAbilityListener::onEntityAttack);
    }
}
