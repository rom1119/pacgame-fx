package com.pacgame.board.controller;

import com.pacgame.App;
import com.pacgame.board.Controller;
import com.pacgame.board.event.eventHandler.OnPacmanTouchPoint;
import com.pacgame.board.model.Point;
import com.pacgame.board.model.Pacman;
import com.pacgame.board.event.PointEvent;
import com.pacgame.Direction;
import com.pacgame.board.model.MapPoint;
import com.pacgame.board.service.MapPathCreator;
import com.pacgame.board.service.MirrorDoorEffect;
import com.pacgame.board.service.MovementManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.apache.commons.collections.BidiMap;

import javax.lang.model.type.NullType;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PacmanController extends Controller implements EventHandler<KeyEvent> {

    public static final int SIZE = 24;

    protected Pacman controlledObject;
    protected SimpleStringProperty score;
    protected ObservableList<Point> allPoints;
    private ObservableList<MazeController> mazeControllerList;
    private Scene scene;
    private OnPacmanTouchPoint onPacmanTouchPoint;

    public PacmanController( Scene scene, Group root) {

        super(root);

        this.score = new SimpleStringProperty("0");

        this.controlledObject = new Pacman(new Point2D(0, 0), SIZE / 2);
        this.scene = scene;
        this.onPacmanTouchPoint = new OnPacmanTouchPoint(this);

    }

    private void setOnPacmanMove()
    {
        this.getControlledObject().getCollider().translateXProperty().addListener(onPacmanTouchPoint);

        this.getControlledObject().getCollider().translateYProperty().addListener(onPacmanTouchPoint);
    }

    public void addScore(int score)
    {
        int allScore = Integer.parseInt(getScore());
        allScore = allScore + score;

        scoreProperty().set(String.valueOf(allScore));
    }

    public void initialize()
    {
        root.getChildren().add(App.indexForMaze, getControlledObject().getCollider());
        root.getChildren().add(App.indexForMaze, getControlledObject().getIcon());

        BidiMap allPoints = MapPathCreator.getAllPoints();
        movementManager = new MovementManager(allPoints, this.controlledObject, root);
        movementManager.setCanMoveInDoor(false);

        MirrorDoorEffect mirrorDoorEffect = new MirrorDoorEffect(this);

        movementManager.setSpecialAction(mirrorDoorEffect);

        this.getControlledObject().setLives(String.valueOf(Pacman.INITIAL_LIVES));
//
        this.setOnPacmanMove();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, this);



    }

    public void deinitialize()
    {

        scene.removeEventHandler(KeyEvent.KEY_PRESSED, this);
        getControlledObject().getCollider().translateXProperty().removeListener(onPacmanTouchPoint);
        getControlledObject().getCollider().translateYProperty().removeListener(onPacmanTouchPoint);

        root.getChildren().remove(getControlledObject().getCollider());
        root.getChildren().remove(getControlledObject().getIcon());
    }

    public void setInitPosition()
    {
        BidiMap allPoints = MapPathCreator.getAllPoints();
//        MapPoint currentPoint = (MapPoint) allPoints.get("h5A");
        MapPoint currentPoint = (MapPoint) allPoints.get("e3");

        movementManager.setCurrentPoint(currentPoint);
        MapPoint newPoint = currentPoint;

        this.getControlledObject().setPoint(newPoint);
        this.getControlledObject().updatePosition();

        this.getControlledObject().setCheckedDirection(Direction.RIGHT);
        this.getControlledObject().turnRight();

        getMovementManager().stopAnimation();
//        getMovementManager().setCurrentPoint(newPoint);
        startMove();

    }

    public void setAllPoints(ObservableList<Point> allPoints) {
        this.allPoints = allPoints;
    }


    public ObservableList<MazeController> getMazeControllerList() {
        return mazeControllerList;
    }

    public void setMazeControllerList(ObservableList<MazeController> mazeControllerList) {
        this.mazeControllerList = mazeControllerList;
    }

    @Override
    public Pacman getControlledObject() {
        return controlledObject;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handle(KeyEvent event) {

        if (!App.isPlaying()) {
            return;
        }
        switch (event.getCode()) {
            case UP:
                if (getControlledObject().isTurnedTo(Direction.DOWN)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.UP);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }

                break;
            case RIGHT:
                if (getControlledObject().isTurnedTo(Direction.LEFT)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.RIGHT);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case DOWN:
                if (getControlledObject().isTurnedTo(Direction.UP)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.DOWN);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
            case LEFT:
                if (getControlledObject().isTurnedTo(Direction.RIGHT)) {
                    movementManager.turnBack();
                    break;
                }
                getControlledObject().setCheckedDirection(Direction.LEFT);
                if (!getControlledObject().isAnimated()) {
                    movementManager.selectNextPoint();
                }
                break;
        }


    }

    @Override
    public void startMove() {
        KeyFrame actionsOnTime = new KeyFrame(Duration.millis(MovementManager.PERIOD_DELAY), new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        });


        initTimer = new Timeline();

        initTimer.getKeyFrames().clear();
        initTimer.getKeyFrames().add(actionsOnTime);
        initTimer.setDelay(Duration.millis(0));

        initTimer.setCycleCount(1);
        initTimer.setAutoReverse(false);
//        initTimer.play();

        initTimer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (movementManager != null && !getControlledObject().isSelectFirstPoint()) {
                    movementManager.selectNextPoint();
                    getControlledObject().setSelectFirstPoint(true);
                }
            }
        });
    }

    public void playInitTimer()
    {
        if (initTimer != null) {
            initTimer.play();
        }
    }

    public void pauseInitTimer()
    {
        if (initTimer != null) {
            initTimer.pause();
        }
    }

    public void stopInitTimer()
    {
        if (initTimer != null) {
            initTimer.stop();
        }
    }


    public void startEatAnimation()
    {
        final PacmanController that = this;
        mainAnimation = new Timeline();

        KeyValue keyValueAngle = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 0);
        KeyValue keyValueLength = new KeyValue(getControlledObject().getIcon().lengthProperty(), 360);
        KeyValue keyValueCenterX = new KeyValue(getControlledObject().getIcon().centerXProperty(), -3);
        KeyValue keyValueCenterY = new KeyValue(getControlledObject().getIcon().centerYProperty(), -3);
//        KeyValue keyValueStart = new KeyValue(getControlledObject().getIcon().startAngleProperty(), 45);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValueAngle, keyValueLength, keyValueCenterX, keyValueCenterY);

        mainAnimation.getKeyFrames().add(keyFrame);

        mainAnimation.setCycleCount(Timeline.INDEFINITE);
        mainAnimation.setAutoReverse(true);
//        mainAnimation.play();
    }

    public void stopEatAnimation()
    {
        if (getMainAnimation() != null){
            getMainAnimation().stop();
        }
    }

    public void subtractLive()
    {
        int actualLives = Integer.parseInt(getControlledObject().getLives());
        actualLives--;
        getControlledObject().setLives(String.valueOf(actualLives));
    }

    public String getScore() {
        return score.get();
    }

    public SimpleStringProperty scoreProperty() {
        return score;
    }

    public static int getSIZE() {
        return SIZE;
    }

    @Override
    public void setControlledObject(Pacman controlledObject) {
        this.controlledObject = controlledObject;
    }

    public void setScore(String score) {
        this.score.set(score);
    }

    private void setScoreProperty(SimpleStringProperty scorePropArg)
    {
        this.score = scorePropArg;
    }

    private SimpleStringProperty getScoreProperty()
    {
        return this.score;
    }

    public ObservableList<Point> getAllPoints() {
        return allPoints;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        PacmanController clone = new PacmanController(this.getScene(), this.getRoot());
        clone.setAllPoints(this.getAllPoints());
        clone.setMazeControllerList(this.getMazeControllerList());
//        clone.setControlledObject(this.getControlledObject());
//        clone.setScore(this.getScore());
        clone.setScoreProperty(this.getScoreProperty());
//        clone.getControlledObject().setCheckedDirection(this.getControlledObject().getCheckedDirection());

//        clone.setMovementManager(this.getMovementManager());
//        clone.setInitTimer(this.getInitTimer());
//        clone.setMainAnimation(this.getMainAnimation());

        return clone;
    }
}
