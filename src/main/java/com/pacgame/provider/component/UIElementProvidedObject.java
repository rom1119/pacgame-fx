package com.pacgame.provider.component;


import com.pacgame.provider.ComponentProvidedObject;
import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ui.UIElementProxy;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

public abstract class UIElementProvidedObject extends ComponentProvidedObject {

    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    public UIElementProvidedObject() {
        super();
        width = new WidthProperty(0);
        height = new HeightProperty(0);
    }

    public UIElementProvidedObject(int width, int height) {
        this();
        this.width.set(width);
        this.height.set(height);
    }
    public void setBorder(Paint paint, int width)
    {
        getProxy().setBorder(paint.getProxy(), width);
    }

    public void setWidth(int width)
    {
        this.width.set(width);
        getProxy().setWidth(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
        getProxy().setHeight(height);
    }

    public int getWidth()
    {
        return width.get();
    }

    public int getHeight()
    {
        return height.get();
    }


    @Override
    public boolean isVisible() {
        return getProxy().isVisible();
    }

    @Override
    public void show() {
        getProxy().show();
    }

    @Override
    public void hide() {
        getProxy().hide();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        getProxy().setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        getProxy().setY(y);
    }

    @Override
    protected abstract UIElementProxy getProxy();

    @Override
    public void setBackground(Paint paint) {
        getProxy().setBackground(paint.getProxy());
    }

    public void setPadding(int top, int bottom, int left, int right) {
        getProxy().setPadding(top, bottom, left, right);
    }

    public void setPadding(int x, int y) {
        getProxy().setPadding(x, y);
    }

    public void setPadding(int topRightBottomLeft){
        getProxy().setPadding(topRightBottomLeft);
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
        String klassName = getClass().getName();
        String simpleName = klassName.substring(klassName.lastIndexOf('.')+1);
        StringBuilder sbuf = new StringBuilder(simpleName);

        sbuf.append("[");
        sbuf.append("X=" + getX());
        sbuf.append(", ");
        sbuf.append("Y=" + getY());
        sbuf.append(", ");
        sbuf.append("Width=" + getWidth());
        sbuf.append(", ");
        sbuf.append("Height=" + getHeight());
        sbuf.append("]");

        return sbuf.toString();
    }

}
