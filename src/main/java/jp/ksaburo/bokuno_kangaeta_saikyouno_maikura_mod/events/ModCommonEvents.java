package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.events;

import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.BKSMM;
import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.TokiniumSlimeEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BKSMM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(BKSMM.TOKINIUM_SLIME_ENTITY.get(), TokiniumSlimeEntity.getTokiniumSlimeEntityAttributes().build());
    }
}
