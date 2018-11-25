package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayer;
import com.pacgame.provider.layer.GroupLayer;
import com.pacgame.provider.layer.VerticalLayer;

public class LayerProviderImpl implements LayerProvider {
    @Override
    public FlowLayer createFlowLayer() {
        return new FlowLayer();
    }

    @Override
    public GroupLayer createGroupLayer() {
        return new GroupLayer();
    }

    @Override
    public VerticalLayer createVerticalLayer() {
        return new VerticalLayer();
    }
}
