package com.pacgame.provider;

import com.pacgame.provider.interfaces.IChildrenProvider;
import com.pacgame.provider.interfaces.IParentableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.layer.LayerProxy;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;

import java.util.HashMap;
import java.util.Map;

public abstract class LayerProvidedObject extends ViewProvidedObject implements VisibleProvider, IParentableProvider<LayerProvidedObject>, IChildrenProvider<ViewProvidedObject> {

    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    private LayerProvidedObject parent;
    protected Map<String, ViewProvidedObject> children;

    public LayerProvidedObject() {
        super();
        children = new HashMap<>();
        width = new WidthProperty(0);
        height = new HeightProperty(0);
    }

    public LayerProvidedObject(int width, int height) {
        this();
        this.width.set(width);
        this.height.set(height);
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
        return this.width.get();
    }

    public int getHeight()
    {
        return this.height.get();
    }

    public void setBorder(Paint paint, int width)
    {
        getProxy().setBorder(paint.getProxy(), width);
    }

    @Override
    public void addChildren(ViewProvidedObject el) {
        if (!hasChildren(el)) {
            children.put(String.valueOf(el.hashCode()), el);
            getProxy().addChildren(el.getProxy());

        }
    }

    public void setFocusTraversable(boolean val)
    {
        getProxy().setFocusTraversable(val);
    }

    @Override
    public void removeChildren(ViewProvidedObject el) {
        if (hasChildren(el)) {
            children.remove(String.valueOf(el.hashCode()));
            getProxy().removeChildren(el.getProxy());
        }
    }

    @Override
    public Map<String, ViewProvidedObject> getChildren() {
        return children;
    }

    @Override
    protected abstract LayerProxy getProxy();

    @Override
    public boolean hasChildren(ViewProvidedObject el) {
        return children.containsKey(String.valueOf(el.hashCode()));
    }

    @Override
    public void setParent(LayerProvidedObject el) {
        parent = el;
        el.addChildren(this);
    }

    @Override
    public LayerProvidedObject getParent() {
        return parent;
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
