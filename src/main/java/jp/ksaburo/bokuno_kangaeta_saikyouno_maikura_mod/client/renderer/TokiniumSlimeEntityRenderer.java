package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.client.renderer;

import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.BKSMM;
import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.TokiniumSlimeEntity;
import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.client.models.TokiniumSlimeEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TokiniumSlimeEntityRenderer extends MobRenderer<TokiniumSlimeEntity, TokiniumSlimeEntityModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(BKSMM.MODID, "textures/entities/tokinium_slime_entity.png");
    public TokiniumSlimeEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new TokiniumSlimeEntityModel(ctx.bakeLayer(TokiniumSlimeEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TokiniumSlimeEntity p_114482_) {
        return TEXTURE;
    }
}
