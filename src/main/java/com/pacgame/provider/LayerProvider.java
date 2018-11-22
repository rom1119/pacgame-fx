package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayer;

public interface LayerProvider extends ViewProvider {

    FlowLayer createFlowLayer();
    FlowLayer createGroupLayer();
    FlowLayer createVerticalLayer();

}
