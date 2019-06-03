package com.thesledgehammer.emcengines.client;

import com.thesledgehammer.emcengines.tiles.engines.EMCEngineMK1;
import com.thesledgehammer.groovymc.client.model.MutableQuad;

public class RenderEngineMK1 extends RenderEngine<EMCEngineMK1> {
/*
    RenderEngineMK1(GroovyStaticModel model) {
        //model.setModelElements("model elements here");
        //model.setModelTextures("model textures here");
    }*/

    @Override
    protected MutableQuad[] getEngineModel(EMCEngineMK1 engine, float partialTicks) {
        return EngineModels.getMK1EngineQuads(engine, partialTicks);
    }
}
