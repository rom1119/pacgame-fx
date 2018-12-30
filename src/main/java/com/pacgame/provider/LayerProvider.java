package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayer;
import com.pacgame.provider.layer.GroupLayer;
import com.pacgame.provider.layer.VerticalLayer;

public interface LayerProvider {

    FlowLayer createFlowLayer();
    GroupLayer createGroupLayer();
    VerticalLayer createVerticalLayer();

}
