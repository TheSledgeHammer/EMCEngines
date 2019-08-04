package com.thesledgehammer.emcengines.client;

/*
public class EngineModels {

    private static final VariableDouble ENGINE_PROGRESS;
    private static final VariableObject<EnumPowerStage> ENGINE_STAGE;
    private static final VariableObject<EnumFacing> ENGINE_FACING;

    //private static final ModelEntryHolderVariable ENGINE_MK1;

    static {
        ENGINE_PROGRESS = new VariableDouble();
        ENGINE_STAGE = new VariableObject<>();
        ENGINE_FACING = new VariableObject<>();
        //ENGINE_MK1 = new ModelEntryHolderVariable("block", "engine_base");
    }

    public static void fmlPreInit() {
        MinecraftForge.EVENT_BUS.register(EngineModels.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEmcEngineMK1.class, RenderEngineMk1.INSTANCE);
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        ENGINE_PROGRESS.setValue(0.2);
        ENGINE_STAGE.setValue(EnumPowerStage.BLUE);
        ENGINE_FACING.setValue(EnumFacing.UP);
        event.getModelRegistry().putObject(new ModelResourceLocation("emcengines:models/block/engine_mk1", "inventory"),  new ModelItemSimple(Arrays.stream(ENGINE_MK1.getCutoutQuads()).map(MutableQuad::toBakedItem).collect(Collectors.toList()), ModelItemSimple.TRANSFORM_BLOCK, true));
    }

    private static MutableQuad[] getEngineQuads(ModelEntryHolderVariable model, TileEmcEngineRFBase tile, float partialTicks) {
        ENGINE_PROGRESS.setValue(0.2);
        ENGINE_STAGE.setValue(EnumPowerStage.BLUE);
        ENGINE_FACING.setValue(EnumFacing.UP);
        return model.getCutoutQuads();
    }

    public static MutableQuad[] getMK1EngineQuads(TileEmcEngineMK1 tile, float partialTicks) {
        return getEngineQuads(ENGINE_MK1, tile, partialTicks);
    }
}
*/