package com.thesledgehammer.emcengines.client;

import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineRFBase;
import com.thesledgehammer.groovymc.client.definitions.model.TextureEntry;
import com.thesledgehammer.groovymc.client.model.MutableQuad;
import com.thesledgehammer.groovymc.client.render.GroovyFastTESR;
import com.thesledgehammer.groovymc.experimental.models.GroovyVariableModel;
import net.minecraft.client.renderer.BufferBuilder;

import javax.annotation.Nonnull;

import java.util.Map;

public abstract class RenderEngine<T extends TileEmcEngineRFBase> extends GroovyFastTESR<T> {

    RenderEngine(GroovyVariableModel blockModel, GroovyVariableModel itemModel) {
        registerTextures(blockModel, itemModel);
    }

    @Override
    public void renderTileEntityFast(@Nonnull T engine, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder bufferBuilder) {
        bufferBuilder.setTranslation(x, y, z);
        MutableQuad[] quads = getEngineModel(engine, partialTicks);
        MutableQuad copy = new MutableQuad(0, null);
        int lightc = engine.getWorld().getCombinedLight(engine.getPos(), 0);
        int light_block = (lightc >> 4) & 15;
        int light_sky = (lightc >> 20) & 15;
        for(MutableQuad q : quads) {
            copy.copyFrom(q);
            copy.maxLighti(light_block, light_sky);
            copy.multShade();
            copy.render(bufferBuilder);
        }
        bufferBuilder.setTranslation(0, 0, 0);
    }

    protected abstract MutableQuad[] getEngineModel(T engine, float partialTicks);

    private void registerTextures(GroovyVariableModel blockModel, GroovyVariableModel itemModel) {
        blockModel.setModelElements("base");
        blockModel.setModelElements("base_moving");
        blockModel.setModelElements("trunk");
        blockModel.setModelElements("chamber");

        blockModel.setModelTextures("#trunk_blue");
        blockModel.setModelTextures("#trunk_green");
        blockModel.setModelTextures("#trunk_yellow");
        blockModel.setModelTextures("#trunk_red");
        blockModel.setModelTextures("#trunk_overheat");
        blockModel.setModelTextures("#trunk_black");
        blockModel.setModelTextures("#chamber");
        blockModel.setModelTextures("#back");
        blockModel.setModelTextures("#side");

        for(Map.Entry<String, String> entry : blockModel.getGroovysonModel().getRawModelTextures().entrySet()) {
            TextureEntry.Register.add(entry.getValue()).build();
        }
    }
}
