package com.pacgame;

import com.pacgame.color.Paint;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.ViewProvidedObject;

import java.util.HashMap;
import java.util.Map;

public abstract class Layer extends View implements Visible, Comparable<View>, Parentable<Layer>, IChildren<View> {

//    protected LayerProvidedObject providedObject;
    protected int order;
    protected Layer parent;
    protected Map<String, View> children;
    protected Property<Integer> width;
    protected Property<Integer> height;

    public Layer(LayerProvider provider) {
        children = new HashMap<>();
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);
    }

    public Layer(int width, int height, LayerProvider provider) {
        super();
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
        children = new HashMap<>();

    }

    public void setWidth(int width)
    {
        this.width.set(width);
        getProvidedObject().setWidth(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
        getProvidedObject().setHeight(height);
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
    public void addChildren(View el) {
        if (!hasChildren(el)) {
            getProvidedObject().addChildren(el.getProvidedObject());
            children.put(String.valueOf(el.hashCode()), el);
        }
    }

    @Override
    public void removeChildren(View el) {
        if (hasChildren(el)) {
            getProvidedObject().removeChildren(el.getProvidedObject());
            children.remove(el.hashCode());
        }
    }

    @Override
    public boolean hasChildren(View el) {
        return children.containsKey(el.hashCode());
    }

    @Override
    public void setParent(Layer el) {
        parent = el;
    }

    @Override
    public Layer getParent() {
        return parent;
    }

    @Override
    protected abstract LayerProvidedObject getProvidedObject();

    @Override
    public boolean isVisible() {
        return getProvidedObject().isVisible();
    }

    @Override
    public void show() {
        getProvidedObject().show();
    }

    @Override
    public void hide() {
        getProvidedObject().hide();
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(View o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }

    @Override
    public void setBackground(Paint color) {
        getProvidedObject().setBackground(color.getValue());
    }
}
