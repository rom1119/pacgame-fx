package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProxy;
import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.interfaces.*;
import com.pacgame.provider.property.HeightProperty;
import com.pacgame.provider.property.PropertyProvider;
import com.pacgame.provider.property.WidthProperty;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.Map;

public abstract class LayerProxy extends ViewProxy implements VisibleProvider, IParentableProviderProxy<LayerProxy>, IChildrenProviderProxy<ViewProxy> {


    private LayerProxy parent;
    protected Map<String, ViewProxy> children;
    protected PropertyProvider<Integer> width;
    protected PropertyProvider<Integer> height;

    public LayerProxy() {
        super();
        children = new HashMap<>();
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);
    }

    public LayerProxy(int width, int height) {
        super();
        children = new HashMap<>();
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }



    public void setBorder(PaintProxy color, int width)
    {
        ((Pane)getProxyObject()).setBorder(new Border(new BorderStroke(color.getProxyObject(), BorderStrokeStyle.SOLID, null, new BorderWidths(width))));
    }

    @Override
    public abstract void addChildren(ViewProxy el);

    @Override
    public abstract void removeChildren(ViewProxy el);

    @Override
    public Map<String, ViewProxy> getChildren() {
        return children;
    }

    @Override
    public abstract Parent getProxyObject();


    @Override
    public boolean hasChildren(ViewProxy el) {
        return children.containsKey(String.valueOf(el.hashCode()));
    }

    public void setFocusTraversable(boolean val)
    {
        getProxyObject().setFocusTraversable(val);
    }

    @Override
    public void setParent(LayerProxy el) {
        parent = el;
        el.addChildren(this);
    }

    @Override
    public LayerProxy getParent() {
        return parent;
    }

    @Override
    public boolean isVisible() {
        return getProxyObject().isVisible();
    }

    @Override
    public void show() {
        getProxyObject().setVisible(true);
    }

    @Override
    public void hide() {
        getProxyObject().setVisible(false);
    }

    public void setWidth(int width)
    {
        this.width.set(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
    }

    public int getWidth()
    {
        return this.width.get();
    }

    public int getHeight()
    {
        return this.height.get();
    }



    public void setPadding(int top, int right, int bottom, int left)
    {
        ((Pane)getProxyObject()).setPadding(new Insets(top, right, bottom, left));
    }

    public void setPadding(int x, int y)
    {
        ((Pane)getProxyObject()).setPadding(new Insets(y, x, y, x));
    }

    public void setPadding(int topRightBottomLeft)
    {
        ((Pane)getProxyObject()).setPadding(new Insets(topRightBottomLeft));
    }

    @Override
    public void setBackground(PaintProxy color) {
        super.setBackground(color);
        ((Pane)getProxyObject()).setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

//    @Override
//    public abstract void setBackground(Paint color);
}
