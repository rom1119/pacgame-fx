package com.pacgame.uiElement.menu.element;

import com.pacgame.Property;
import com.pacgame.property.TextProperty;
import com.pacgame.uiElement.UIElement;
import com.pacgame.uiElement.text.Text;

public abstract class MenuElement extends UIElement {

    protected Text providedObject;
    protected Property<String> text;

    public MenuElement(int width, int height) {
        super(width, height);
        text = new TextProperty();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public String getText() {
        return this.text.get();
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
        return text.get().replace(" ", "");
    }
}
