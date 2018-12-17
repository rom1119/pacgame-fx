package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.Paint;
import com.pacgame.provider.alignment.PositionAlignment;
import com.pacgame.provider.component.UIElementProvidedObject;

public class Label extends UIElementProvidedObject {

    protected LabelProxy proxy;
    protected String text;

    public Label(String text) {
        this.text = text;
        proxy = new LabelProxy();
        proxy.setText(text);
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }

    public void setText(String text) {
        this.text = text;
        proxy.setText(text);
    }

    public String getText() {
        return text;
    }

    @Override
    public void setBorder(Paint paint, int width) {
        proxy.setBorder(paint.getProxy(), width);
    }

    @Override
    protected LabelProxy getProxy() {
        return proxy;
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
        sbuf.append("Text=\"" + getText() + "\"");
        sbuf.append(", ");
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
