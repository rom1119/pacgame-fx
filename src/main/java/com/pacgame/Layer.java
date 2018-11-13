package com.pacgame;

import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ViewProvidedObject;

import java.util.Map;

public abstract class Layer extends View implements Visible, Comparable<Layer>, Parentable<Layer>, IChildren<View> {

    protected LayerProvidedObject providedObject;
    protected int order;
    protected Layer parent;
    protected Map<String, View> children;

    public Layer(LayerProvidedObject providedObject) {
        this.providedObject = providedObject;
    }

    public Layer(int width, int height, LayerProvidedObject providedObject) {
        super(width, height);
        this.providedObject = providedObject;
    }

    public void setWidth(int width)
    {
        this.width.set(width);
        providedObject.setWidth(width);
    }

    public void setHeight(int height)
    {
        this.height.set(height);
        providedObject.setHeight(height);
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
    public void addChildren(View el) {
        if (!hasChildren(el)) {
            providedObject.addChildren(el.providedObject);
            children.put(String.valueOf(el.hashCode()), el);
        }
    }

    @Override
    public void removeChildren(View el) {
        if (hasChildren(el)) {
            providedObject.removeChildren(el.providedObject);
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
    public int compareTo(Layer o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }
}
