package com.thesledgehammer.emcengines.client;

import com.thesledgehammer.emcengines.EnumPowerStage;
import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineMK1;
import com.thesledgehammer.emcengines.tiles.engines.TileEmcEngineBase;
import com.thesledgehammer.groovymc.client.model.GroovyStaticModel;
import com.thesledgehammer.groovymc.client.model.ModelEntryStatic;
import com.thesledgehammer.groovymc.client.model.MutableQuad;
import com.thesledgehammer.groovymc.experimental.variables.VariableDouble;
import com.thesledgehammer.groovymc.experimental.variables.VariableObject;
import net.minecraft.util.EnumFacing;

public class EngineModels {

    private static final VariableDouble ENGINE_PROGRESS;
    private static final VariableObject<EnumPowerStage> ENGINE_STAGE;
    private static final VariableObject<EnumFacing> ENGINE_FACING;

    private static final ModelEntryStatic ENGINE_MK1;
    //RenderEngineMK1 engineMK1 = new RenderEngineMK1();

    static {
        ENGINE_PROGRESS = new VariableDouble();
        ENGINE_STAGE = new VariableObject<>();
        ENGINE_FACING = new VariableObject<>();
        ENGINE_MK1 = new ModelEntryStatic(new GroovyStaticModel("block", "engine_mk1"));
    }

    public static void onModelBake() {
        ENGINE_PROGRESS.setValue(0.2);
        ENGINE_STAGE.setValue(EnumPowerStage.BLUE);
        ENGINE_FACING.setValue(EnumFacing.UP);
    }

    private static MutableQuad[] getEngineQuads(ModelEntryStatic model, TileEmcEngineBase tile, float partialTicks) {

        return model.getCutoutQuads();
    }

    public static MutableQuad[] getMK1EngineQuads(TileEmcEngineMK1 tile, float partialTicks) {
        return getEngineQuads(ENGINE_MK1, tile, partialTicks);
    }
}
