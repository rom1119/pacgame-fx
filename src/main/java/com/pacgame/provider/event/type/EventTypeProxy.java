package com.pacgame.provider.event.type;

import com.google.common.cache.RemovalListener;
import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.Proxy;
import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class EventTypeProxy<T extends EventProxy> extends Proxy {


    /**
     * This event occurs when a key has been pressed.
     */
    private static final EventType<javafx.scene.input.KeyEvent> KEY_ANY = KeyEvent.ANY;

    /**
     * This event occurs when a key has been pressed.
     */
    private static final EventType<javafx.scene.input.KeyEvent> KEY_PRESSED = javafx.scene.input.KeyEvent.KEY_PRESSED;

    /**
     * This event occurs when a key has been released.
     */
    private static final EventType<javafx.scene.input.KeyEvent> KEY_RELEASED = javafx.scene.input.KeyEvent.KEY_RELEASED;

    /**
     * This event occurs when a character-generating key was typed
     * (pressed and released).  The event contains the {@code character}
     * field containing the typed string, the {@code code} and {@code text}
     * fields are not used.
     */
    private static final EventType<javafx.scene.input.KeyEvent> KEY_TYPED = javafx.scene.input.KeyEvent.KEY_TYPED;

    /**
     * Common supertype for all mouse event types.
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_ANY = javafx.scene.input.MouseEvent.ANY;

    /**
     * This event occurs when mouse button is pressed. This activates a
     * press-drag-release gesture, so all subsequent mouse events until
     * the button is released are delivered to the same node.
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_PRESSED = javafx.scene.input.MouseEvent.MOUSE_PRESSED;

    /**
     * This event occurs when mouse button is released. It is delivered
     * to the same node where the button has been pressed which activated
     * a press-drag-release gesture.
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_RELEASED = javafx.scene.input.MouseEvent.MOUSE_RELEASED;

    /**
     * This event occurs when mouse button has been clicked (pressed and
     * released on the same node). This event provides a button-like behavior
     * to any node. Note that even long drags can generate click event (it
     * is delivered to the top-most node on which the mouse was both
     * pressed and released).
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_CLICKED = javafx.scene.input.MouseEvent.MOUSE_CLICKED;

    /**
     * This event occurs when mouse enters a node. It's the bubbling variant,
     * which is delivered also to all parents of the entered node (unless it
     * was consumed). When notifications about mouse entering some of node's
     * children are not desired, {@code MOUSE_ENTERED} event handler should
     * be used.
     *
     * @see javafx.scene.input.MouseEvent MouseEvent for more information about mouse entered/exited handling
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_ENTERED_TARGET = javafx.scene.input.MouseEvent.MOUSE_ENTERED_TARGET;

    /**
     * This event occurs when mouse enters a node. This event type is delivered
     * only to the entered node, if parents want to filter it or get the
     * bubbling event, they need to use {@code MOUSE_ENTERED_TARGET}.
     *
     * @see javafx.scene.input.MouseEvent MouseEvent for more information about mouse entered/exited handling
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_ENTERED = javafx.scene.input.MouseEvent.MOUSE_ENTERED;

    /**
     * This event occurs when mouse exits a node. It's the bubbling variant,
     * which is delivered also to all parents of the exited node (unless it
     * was consumed). When notifications about mouse exiting some of node's
     * children are not desired, {@code MOUSE_EXITED} event handler should
     * be used.
     *
     * @see javafx.scene.input.MouseEvent MouseEvent for more information about mouse entered/exited handling
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_EXITED_TARGET = javafx.scene.input.MouseEvent.MOUSE_EXITED_TARGET;

    /**
     * This event occurs when mouse exits a node. This event type is delivered
     * only to the exited node, if parents want to filter it or get the
     * bubbling event, they need to use {@code MOUSE_EXITED_TARGET}.
     *
     * @see javafx.scene.input.MouseEvent MouseEvent for more information about mouse entered/exited handling
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_EXITED = javafx.scene.input.MouseEvent.MOUSE_EXITED;

    /**
     * This event occurs when mouse moves within a node and no buttons
     * are pressed. If any mouse button is pressed, MOUSE_DRAGGED event
     * occurs instead.
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_MOVED = javafx.scene.input.MouseEvent.MOUSE_MOVED;

    /**
     * This event occurs when mouse moves with a pressed button.
     * It is delivered to the same node where the button has been pressed
     * which activated a press-drag-release gesture. It is delivered
     * regardless of the mouse being within bounds of the node.
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_DRAGGED = javafx.scene.input.MouseEvent.MOUSE_DRAGGED;

    /**
     * This event is delivered to a node that is identified as a source of a
     * dragging gesture. Handler of this event is the only place where
     * full press-drag-release gesture or a drag and drop gesture can be
     * started (by calling {@link javafx.scene.Node#startFullDrag startFullDrag()}
     * of {@link javafx.scene.Node#startDragAndDrop startDragAndDrop()} method).
     * If none of them is called, simple press-drag-release gesture will continue.
     * <p>
     * Note that his event is generated based on dragging the mouse over a
     * platform-specific distance threshold. You can modify this behavior
     * by calling {@code setDragDetect} method on any MOUSE_PRESSED or
     * MOUSE_DRAGGED event.
     *
     * @see javafx.scene.input.MouseEvent MouseEvent for more details about simple press-drag-release gestures
     * @see MouseDragEvent MouseDragEvent for more details about full press-drag-release gestures
     * @see DragEvent DragEvent for more details about drag and drop gestures
     */
    private static final EventType<javafx.scene.input.MouseEvent> MOUSE_DRAG_DETECTED = javafx.scene.input.MouseEvent.DRAG_DETECTED;

    /**
     * The only valid EventType for the ActionEvent.
     */
    private static final EventType<javafx.event.ActionEvent> ANY_ACTION =
            new EventType<javafx.event.ActionEvent>(Event.ANY, "ACTION");


    private EventType<? extends Event> proxyObject;

    private Class<? extends EventProxy> clazz;

    private Map<Integer, EventHandler> eventHandlersProxy;

     public EventTypeProxy(String name, Class<? extends EventProvidedObject> eventClass) {
        this.proxyObject = createProxy(name, eventClass);
         eventHandlersProxy = new HashMap<>();
    }

     public EventTypeProxy(final String name,
            final EventTypeProxy superType,
             Class<? extends EventProvidedObject> eventClass)
    {
        proxyObject = createProxy(name, eventClass);
        eventHandlersProxy = new HashMap<>();

    }

    public <T extends EventProxy, S extends EventProvidedObject> int addEventHandlerProxy(T eventProxy, S event, IEventHandler<? super S> eventHandler)
    {
//        if (eventHandler == null) {
//            throw new NullPointerException("Event handler can not be empty for EventType " + proxyObject.getName());
//        }
//
//        if (hasEventHandlerProxy(eventHandler)) {
//            throw new IllegalArgumentException("Can not add second same eventHandler to EventType " + proxyObject.getName() + " .");
//        }

        EventHandler eventHandlerProxyObject = e -> {
//            System.out.println(e.getSource());
//            System.out.println(e.getTarget());
            eventProxy.setProxyObject(e);
            if (e.getTarget() instanceof Text) {
                event.initTarget(((Text) e.getTarget()).getParent().hashCode());

            } else {
                event.initTarget(e.getTarget().hashCode());

            }
            eventHandler.handle(event);
        };

        eventHandlersProxy.put(eventHandlerProxyObject.hashCode(), eventHandlerProxyObject);

        return eventHandlerProxyObject.hashCode();
    }

    public <T extends Event> EventHandler<? super T> getEventHandlerProxy(int eventHandlerProxyId)
    {
            return eventHandlersProxy.get(eventHandlerProxyId);

    }



    private boolean hasEventHandlerProxy(EventHandler eventHandler)
    {
        for (Map.Entry<Integer, EventHandler> el: eventHandlersProxy.entrySet()) {
            if (el.getValue().hashCode() == eventHandler.hashCode()) {
                return true;
            }
        }

        return false;
    }

    public <T extends Event> EventHandler<? super T> removeEventHandlerProxy(int eventHandlerProxyId)
    {
        if (eventHandlerProxyId < 1) {
            throw new NullPointerException("Event handler ID can not be empty for EventType " + proxyObject.getName());
        }
        EventHandler<? super Event> eventHandlerProxy = getEventHandlerProxy(eventHandlerProxyId);

        if (eventHandlerProxy == null) {
            throw new IllegalArgumentException("Can not remove eventHandler to EventTypeProxy " + proxyObject.getName() + " because not exist .");
        }

        return eventHandlersProxy.remove(eventHandlerProxyId);
    }

    public EventType<? extends Event> getProxyObject() {
        return proxyObject;
    }

    public String getName()
    {
        return proxyObject.getName();
    }

    private EventType createProxy(String name, Class<? extends EventProvidedObject> eventClass) {

        if (eventClass.equals(com.pacgame.provider.event.type.KeyEvent.class)) {
            return createKeyEventType(name);

        } else if (eventClass.equals(com.pacgame.provider.event.type.MouseEvent.class)) {
            return createMouseEventType(name);
        } else if (eventClass.equals(com.pacgame.provider.event.type.ActionEvent.class)) {
            return createActionEventType(name);
        }


        return null;
    }

    private EventType createActionEventType(String name) {
        switch(name) {
            case "ANY_ACTION":
                return ANY_ACTION;
            default:
                throw new IllegalArgumentException("KeyEvent type " + name + " is not supported for Action Event." );

        }
    }

    private EventType<KeyEvent> createKeyEventType(String name) {

        switch(name) {
            case "KEY_PRESSED":
                return KEY_PRESSED;
            case "KEY_RELEASED":
                return KEY_RELEASED;
            case "KEY_TYPED":
                return KEY_TYPED;
            case "KEY":
                return KEY_ANY;
            default:
                throw new IllegalArgumentException("KeyEvent type " + name + " is not supported Key Event." );

        }
    }

    private EventType<MouseEvent> createMouseEventType(String name) {

        switch(name) {
            case "MOUSE_CLICKED":
                return MOUSE_CLICKED;
            case "MOUSE_DRAG_DETECTED":
                return MOUSE_DRAG_DETECTED;
            case "MOUSE_DRAGGED":
                return MOUSE_DRAGGED;
            case "MOUSE_ENTERED":
                return MOUSE_ENTERED;
            case "MOUSE_ENTERED_TARGET":
                return MOUSE_ENTERED_TARGET;
            case "MOUSE_EXITED":
                return MOUSE_EXITED;
            case "MOUSE_EXITED_TARGET":
                return MOUSE_EXITED_TARGET;
            case "MOUSE_MOVED":
                return MOUSE_MOVED;
            case "MOUSE_PRESSED":
                return MOUSE_PRESSED;
            case "MOUSE_RELEASED":
                return MOUSE_RELEASED;
            case "MOUSE":
                return MOUSE_ANY;
            default:
                throw new IllegalArgumentException("MouseEvent type " + name + " is not supported for Mouse Event." );

        }
    }
}
