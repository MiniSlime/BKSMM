package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.w3c.dom.Attr;

public class TokiniumSlimeEntity extends Slime {
    public TokiniumSlimeEntity(EntityType<? extends Slime> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2));
        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2));
        super.tick();
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
    }

    public static AttributeSupplier.Builder getTokiniumSlimeEntityAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.ARMOR, 1f)
                .add(Attributes.MAX_HEALTH, 40f)
                .add(Attributes.MOVEMENT_SPEED, 2f);
    }
}
