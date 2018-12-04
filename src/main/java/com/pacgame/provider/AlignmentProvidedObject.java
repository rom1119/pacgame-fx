package com.pacgame.provider;

import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.alignment.AlignmentProxy;

public abstract class AlignmentProvidedObject extends ProvidedObject {
    @Override
    public abstract AlignmentProxy getProxy();
}
