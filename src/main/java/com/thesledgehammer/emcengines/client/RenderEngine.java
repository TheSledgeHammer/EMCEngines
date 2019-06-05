package com.thesledgehammer.emcengines.client;

import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineBase;
import com.thesledgehammer.groovymc.client.model.MutableQuad;
import com.thesledgehammer.groovymc.client.render.GroovyFastTESR;
import net.minecraft.client.renderer.BufferBuilder;

import javax.annotation.Nonnull;

public abstract class RenderEngine<T extends TileEmcEngineBase> extends GroovyFastTESR<T> {

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
}
