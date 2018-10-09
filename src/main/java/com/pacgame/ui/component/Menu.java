package com.pacgame.ui.component;

import com.pacgame.App;
import com.pacgame.View;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;

public abstract class Menu extends View {

    protected SimpleObjectProperty<Label> checkedMenuOption;
    protected Scene scene;
    public ObservableList<Node> menuOptions;
    protected int iterator;

    public Menu(Scene scene) {
        this.scene = scene;
        menuOptions = FXCollections.observableArrayList();
        checkedMenuOption = new SimpleObjectProperty<>();
        iterator = 0;

    }

    protected void setOnMouseOver()
    {

        for (Node el: menuOptions) {
            el.setOnMouseEntered(event -> {
                if (!App.isPlaying()) {
                    Label l = (Label) event.getTarget();
                    checkMenuOption(l);
                }
            });
        }


    }

    protected void setOnMouseClick()
    {

        for (Node el: menuOptions) {
            Label elLabel = (Label) el;
            elLabel.setOnMouseClicked( event -> {
                if (App.isPlaying()) {
                    return;
                }


                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if (event.getTarget() instanceof Label) {
                        Label l = (Label) event.getTarget();
                        l.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.ENTER, false, false, false, false));
                    } else {
                        Text l = (Text) event.getTarget();
                        l.getParent().fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.ENTER, false, false, false, false));
                    }
                }


            });
        }


    }

    protected void setOnKeyPress()
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == UP && !App.isPlaying()) {
                Label prev = (Label) getPrevMenuOption();
                checkMenuOption(prev);
            } else if (e.getCode() == DOWN && !App.isPlaying()) {
                Label next = (Label) getNextMenuOption();
                checkMenuOption(next);
            }
        });

    }

    protected void checkMenuOption(Label opt) {
        setCheckedMenuOption(opt);
        if (opt != null) {
            opt.requestFocus();

        }
    }

    protected void setOnChangeCheckedOption()
    {
        checkedMenuOption.addListener(new ChangeListener<Label>() {
            @Override
            public void changed(ObservableValue<? extends Label> observable, Label oldValue, Label newValue) {
                Label menuOption = newValue;
                removeBorderColorMenuOptions();
                menuOption.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));
            }
        });
    }

    private Node getNextMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }
//        System.out.println(iterator);
//        System.out.println(menuOptions.size());
        if ( iterator == menuOptions.size() - 1 ) {
            iterator = 0;
            return menuOptions.get(iterator);
        } else {
            iterator++;
            return menuOptions.get(iterator);
        }
    }

    private Node getPrevMenuOption()
    {
        if (menuOptions.isEmpty()) {
            return null;
        }

        if (iterator == 0) {
            iterator = menuOptions.size() - 1;
            return menuOptions.get(iterator);
        } else {
            iterator--;
            return menuOptions.get(iterator);
        }
    }

    protected void removeBorderColorMenuOptions()
    {
        for (Node el: menuOptions) {
            Label label = (Label) el;
            if (label != null) {

                label.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));
            }

        }
    }

    public Label getCheckedMenuOption() {
        return checkedMenuOption.get();
    }

    public SimpleObjectProperty<Label> checkedMenuOptionProperty() {
        return checkedMenuOption;
    }

    public void setCheckedMenuOption(Label checkedMenuOption) {
        this.checkedMenuOption.set(checkedMenuOption);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ObservableList<Node> getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(ObservableList<Node> menuOptions) {
        menuOptions = menuOptions;
    }

    public int getIterator() {
        return iterator;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }

    protected void setCheckedMenuOptionOnFirst()
    {
        if (getMenuOptions().size() > 0) {
            ((Label)getMenuOptions().get(0)).setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));
            checkMenuOption((Label) getMenuOptions().get(0));
        }
    }

    @Override
    public void show()
    {

        super.show();
        setCheckedMenuOptionOnFirst();
    }

}
