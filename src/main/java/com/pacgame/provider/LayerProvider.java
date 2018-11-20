package com.pacgame.provider;

import com.pacgame.provider.layer.FlowLayerBuilder;
import com.pacgame.provider.layer.GroupLayerBuilder;
import com.pacgame.provider.layer.VerticalLayerBuilder;

public interface LayerProvider {

    int createFlowLayer();
    int createGroupLayer();
    int createVerticalLayer();

    void addChildren(int id);
    void removeChildren(int id);

    void setBackground(int backgroundId);
    void setWidth(int backgroundId, int width);
    void setHeight(int backgroundId, int height);
}
