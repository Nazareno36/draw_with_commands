package Components;

import java.awt.*;

public class Character {

    private String name;
    private int speed;
    private int xPosition;
    private int yPosition;
    private int orientation;
    private Image sprite;
    private boolean enable;

    public Character(){

    }

    public Character(String name, int speed, int xPosition, int yPosition, Image sprite) {
        this.name = name;
        this.speed = speed;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.sprite = sprite;
        this.orientation = 3;
        this.enable = true;
    }

    //Methods
    public boolean moveAlong(int steps, int screenWidth, int screenHeight){
        return false;
    }

    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
