package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayer;
import com.pacgame.provider.layer.GroupLayer;
import com.pacgame.provider.layer.VerticalLayer;

public interface LayerProvider extends ViewProvider {

    FlowLayer createFlowLayer();
    GroupLayer createGroupLayer();
    VerticalLayer createVerticalLayer();

}
