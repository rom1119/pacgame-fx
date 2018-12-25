package com.pacgame.uiElement.menu;

import com.pacgame.event.listener.ChangeListener;
import com.pacgame.property.ListViewProperty;
import com.pacgame.property.ObjectProperty;
import com.pacgame.provider.*;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.provider.event.IEventHandler;
import com.pacgame.provider.event.type.MouseEvent;
import com.pacgame.provider.layer.VerticalLayer;

import java.util.ArrayList;
import java.util.Map;

public class MainMenu extends Menu {

    protected VerticalLayer providedObject;
    protected int iterator;
    protected ListViewProperty<MenuElement> menuOptions;
    protected ObjectProperty<MenuElement> checkedMenuOption;


    public MainMenu(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider, EventProvider eventProvider, PaintProvider paintProvider, int width, int height) {
        super(provider, positionAlignmentProvider, eventProvider, paintProvider, width, height);
        providedObject = provider.createVerticalLayer();
        providedObject.setWidth(width);
        providedObject.setHeight(height);
        providedObject.setAlignment(positionAlignmentProvider.topCenter());
        providedObject.setFocusTraversable(true);
        menuOptions = new ListViewProperty<>(new ArrayList<MenuElement>(menuItems.values()));
        checkedMenuOption = new ObjectProperty<>();

        setOnCheckedMenuItem();
        setCheckedMenuOptionOnFirst();

        removeBorderColorMenuOptions();
        setOnChangeCheckedOption();
        setIterator(0);


    }

    @Override
    public void addMenuItem(MenuElement menuElement) {
        super.addMenuItem(menuElement);
        menuOptions.add(menuElement);
        menuElement.setOnSelect(e -> {
            System.out.println(e.getText());
        });
        checkFirstMenuOption();
    }

    private void checkFirstMenuOption() {
        checkMenuOption(menuOptions.get(0));
    }

    @Override
    protected void setOnCheckedMenuItem()
    {
        getProvidedObject().addEventHandler(eventProvider.mouseEventFacade().enterTarget(), e -> {
            if (e.getTarget() instanceof Label) {
                Label target = (Label) e.getTarget();
                MenuElement findItem = getMenuItemByProvidedObject(target);
                iterator = menuOptions.indexOf(findItem);
                checkMenuOption(findItem);
            }
        });

        getProvidedObject().addEventHandler(eventProvider.mouseEventFacade().exitTarget(), e -> {
            removeBorderColorMenuOptions();
            setIterator(0);

        });

        getProvidedObject().addEventHandler(eventProvider.keyEventFacade().keyPressed(), e -> {
            if (e.isArrowUp()) {
                checkMenuOption(getPrevMenuOption());
            } else if (e.isArrowBottom()) {
                checkMenuOption(getNextMenuOption());
            }
        });
    }

    private MenuElement getMenuItemByProvidedObject(Label label)
    {
        for(Map.Entry<Integer, MenuElement> el : menuItems.entrySet()) {
            if (el.getValue().getProvidedObject().equals(label)) {
                return el.getValue();
            }

        }
        return null;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }

    protected void checkMenuOption(MenuElement opt) {
        setCheckedMenuOption(opt);
        if (opt != null) {
            opt.setFocusTraversable(false);
            opt.requestFocus();

        }
    }

    private void setCheckedMenuOption(MenuElement checkedMenuOption) {
        this.checkedMenuOption.set(checkedMenuOption);
    }

    protected void setOnChangeCheckedOption()
    {
        checkedMenuOption.setOnChangeProperty(new ChangeListener<MenuElement>() {
            @Override
            public void onChange(MenuElement oldValue, MenuElement newValue) {
                MenuElement menuOption = newValue;
                removeBorderColorMenuOptions();

                menuOption.check();
            }
        });
    }

    protected void setCheckedMenuOptionOnFirst()
    {
        if (menuOptions.size() > 0) {
            menuOptions.get(0).check();
            checkMenuOption( menuOptions.get(0));
        }
    }

    private MenuElement getNextMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }
//        System.out.println(iterator);
//        System.out.println(menuOptions.size());
        if ( iterator == menuOptions.size() - 1 ) {
            iterator = 0;
            return menuOptions.get(iterator);
        } else {
            iterator++;
            return menuOptions.get(iterator);
        }
    }

    private MenuElement getPrevMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }
//        System.out.println(menuOptions.size());
        if (iterator == 0) {
            iterator = menuOptions.size() - 1;
            return menuOptions.get(iterator);
        } else {
            iterator--;
            return menuOptions.get(iterator);
        }
    }

    protected void removeBorderColorMenuOptions()
    {
        menuItems.forEach((key, val) -> {
            val.unCheck();
        });
    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }
}
