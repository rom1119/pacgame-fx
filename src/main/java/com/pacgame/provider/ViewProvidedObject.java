package com.pacgame.provider;

import com.pacgame.provider.event.IEventHandlerProvider;
import com.pacgame.provider.interfaces.ColorableProvider;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.*;

public abstract class ViewProvidedObject extends EventTargetProvidedObject
        implements PositionableProvider, ColorableProvider, Comparable<ViewProvidedObject>, VisibleProvider {

    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;


    public ViewProvidedObject() {
        x = new TranslateXProperty(0);
        y = new TranslateYProperty(0);
    }

    public final  <T extends EventProvidedObject> void addEventHandler(
                EventTypeProvidedObject<T> eventType,
            IEventHandlerProvider<? super T> eventHandler
            )
    {
        T event = eventType.getEvent();
        event.setSource(this);
        getProxy().addEventHandler(eventType, eventHandler, event);
    }

    public final <T extends EventProvidedObject> void removeEventHandler(
            EventTypeProvidedObject<T> eventType,
            IEventHandlerProvider<? super T> eventHandler
    )
    {
        getProxy().removeEventHandler(eventType, eventHandler);
    }

    public void setFocusTraversable(boolean val)
    {
        getProxy().setFocusTraversable(val);
    }
    public void requestFocus()
    {
        getProxy().requestFocus();
    }


    public SceneProvidedObject getScene()
    {
        getProxy().getScene();
        return null;
    }

    @Override
    public abstract boolean isVisible();

    @Override
    public abstract void show();

    @Override
    public abstract void hide();

    @Override
    public int compareTo(ViewProvidedObject o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }

    @Override
    protected abstract ViewProxy getProxy();

    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public PropertyProvider<Integer> XProperty() {
        return x;
    }

    @Override
    public PropertyProvider<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
        getProxy().setX(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
        getProxy().setY(y);
    }

    @Override
    public abstract void setBackground(Paint paint);


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
        sbuf.append("]");

        return sbuf.toString();
    }
}
