package com.pacgame.uiElement.menu;

import com.pacgame.Property;
import com.pacgame.color.Paint;
import com.pacgame.event.IEventHandler;
import com.pacgame.property.TextProperty;
import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.uiElement.UIElement;
import com.pacgame.uiElement.text.Text;

public abstract class MenuElement extends UIElement {

    protected Label providedObject;
    protected Property<String> text;
    protected PositionAlignmentProvider positionAlignmentProvider;
    protected Menu menu;
    protected IEventHandler<MenuElement> selectHandler;

    public MenuElement(UIProvider provider, PositionAlignmentProvider positionAlignmentProvider, String textArg) {
        super(provider);
        text = new TextProperty(textArg);
        providedObject = provider.createTextElement(textArg);
        this.positionAlignmentProvider = positionAlignmentProvider;
    }

    public abstract void check();
    public abstract void unCheck();

    public void setOnSelect(IEventHandler<MenuElement> selectHandlerArg)
    {
//        if () {
//
//        }
    }


    private void calculateWidth()
    {
        if (menu != null) {
            setWidth(menu.getWidth() / 2);
        }
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getText() {
        return this.text.get();
    }

    @Override
    public void setBorder(Paint color, int width) {
        providedObject.setBorder(color.getValue(), width);
    }

    @Override
    public boolean isVisible() {
        return providedObject.isVisible();
    }

    @Override
    public void show() {
        providedObject.show();
    }

    @Override
    public void hide() {
        providedObject.hide();
    }

    @Override
    public void setBackground(Paint color) {
        providedObject.setBackground(color.getValue());
    }



    @Override
    protected Label getProvidedObject() {
        return providedObject;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return text.get().toLowerCase().replace(" ", "-");
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        calculateWidth();
    }
}
