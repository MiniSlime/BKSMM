package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class TokiniumSword extends SwordItem {
    public TokiniumSword(Tier p_43269_, int p_43270_, float p_43271_, Item.Properties p_43272_){
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        player.sendSystemMessage(Component.literal("トキニウムの剣を使った！"));
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2));

        Entity lightning_bolt = new LightningBolt(EntityType.LIGHTNING_BOLT,level);
        lightning_bolt.moveTo(player.position());
        level.addFreshEntity(lightning_bolt);

        return super.use(level, player, hand);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.move(MoverType.SELF, new Vec3(0,10,0));

        return super.onLeftClickEntity(stack, player, entity);
    }
}
