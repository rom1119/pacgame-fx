package com.pacgame.uiElement.menu.element;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MenuElement;

public class NormalMenuElement extends MenuElement {
    public NormalMenuElement(UIProvider provider, AlignmentProvider alignmentProvider, String text) {
        super(provider, alignmentProvider, text);
        getProvidedObject().setPadding(0, 20);

    }
}
