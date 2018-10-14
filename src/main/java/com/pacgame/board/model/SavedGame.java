package com.pacgame.board.model;

import com.pacgame.board.controller.MazeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class SavedGame
{
    private int id;
    private String name;
    private Date createdAt;
    private int score;
    private int lives;
    private MapPoint pacmanMapPoint;
    private ObservableList<MazeController> mazeCollection;

    public SavedGame() {
        mazeCollection = FXCollections.observableArrayList();
        setCreatedAt(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public MapPoint getPacmanMapPoint() {
        return pacmanMapPoint;
    }

    public void setPacmanMapPoint(MapPoint pacmanMapPoint) {
        this.pacmanMapPoint = pacmanMapPoint;
    }

    public ObservableList<MazeController> getMazeCollection() {
        return mazeCollection;
    }

    public void setMazeCollection(ObservableList<MazeController> mazeCollection) {
        this.mazeCollection = mazeCollection;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code User}
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
        if (getCreatedAt() != null) {

        }
        Date date = getCreatedAt();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Locale l = Locale.US;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", l);
        String text = localDate.format(formatter);
//        LocalDate parsedDate = LocalDate.parse(text, formatter);
        return getName() + " ; Data utworzenia: " + text;
    }
}
