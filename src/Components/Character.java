package Components;

import java.awt.*;

public class Character {

    private String name;
    private int speed;
    private int xPosition;
    private int yPosition;
    private int orientation;
    private Image sprite[];
    private boolean enable;

    public Character(){

    }

    public Character(String name, int xPosition, int yPosition) {
        this.name = "Pokemon";
        this.speed = 4;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.setSprite("Pokemon");
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

    public Image[] getSprite() {
        return sprite;
    }

    public void setSprite(String carpet) {
        String ruta_down = "src/Sprites/"+ carpet +"/down_Pokemon.png";
        String ruta_left = "src/Sprites/"+ carpet +"/left_Pokemon.png";
        String ruta_right = "src/Sprites/"+ carpet +"/right_Pokemon.png";
        String ruta_up = "src/Sprites/"+ carpet +"/up_Pokemon.png";
        
        Toolkit t_down = Toolkit.getDefaultToolkit();
        Image image_down = t_down.getImage(ruta_down);
        Toolkit t_left = Toolkit.getDefaultToolkit();
        Image image_left = t_left.getImage(ruta_left);
        Toolkit t_right = Toolkit.getDefaultToolkit();
        Image image_right = t_right.getImage(ruta_right);
        Toolkit t_up = Toolkit.getDefaultToolkit();
        Image image_up = t_up.getImage(ruta_up);
        
        Image new_sprite[] = {image_down, image_left, image_right, image_up};
        this.sprite = new_sprite;
        
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
