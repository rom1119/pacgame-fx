package com.pacgame.provider;

import com.pacgame.provider.appTools.AppTools;

public class PlatformToolsProviderImpl implements PlatformToolsProvider {

    private AppTools tools;

    public PlatformToolsProviderImpl() {
        tools = new AppTools();
    }

    @Override
    public AppTools platformTools() {
        return tools;
    }
}
