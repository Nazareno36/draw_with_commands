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

    private Color color;

    public Character(){

    }

    public Character(int xPosition, int yPosition) {
        this.name = "Goku";
        this.speed = 10;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.enable = true;
        this.setSprite("Goku");
        this.orientation = 2;
        this.color = Color.BLACK;
    }

    public void turnRight(){
        if(orientation < 3) orientation +=1;
        else this.orientation = 0;
    }

    public void turnLeft(){
        if(orientation > 0) orientation -=1;
        else this.orientation = 3;
    }

    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setSprite(name);
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
        this.name = carpet;
        String ruta_down;
        String ruta_left;
        String ruta_right;
        String ruta_up;
        
        if(this.enable){
            ruta_down = "src/Images/Sprites/"+ carpet +"/down_" + carpet + ".png";
            ruta_left = "src/Images/Sprites/"+ carpet +"/left_" + carpet + ".png";
            ruta_right = "src/Images/Sprites/"+ carpet +"/right_" + carpet + ".png";
            ruta_up = "src/Images/Sprites/"+ carpet +"/up_" + carpet + ".png";
        } else {
            ruta_down = "src/Images/Sprites/"+ carpet +"/disable_down_" + carpet + ".png";
            ruta_left = "src/Images/Sprites/"+ carpet +"/disable_left_" + carpet + ".png";
            ruta_right = "src/Images/Sprites/"+ carpet +"/disable_right_" + carpet + ".png";
            ruta_up = "src/Images/Sprites/"+ carpet +"/disable_up_" + carpet + ".png"; 
        }
        
        Toolkit t_down = Toolkit.getDefaultToolkit();
        Image image_down = t_down.getImage(ruta_down);
        Toolkit t_left = Toolkit.getDefaultToolkit();
        Image image_left = t_left.getImage(ruta_left);
        Toolkit t_right = Toolkit.getDefaultToolkit();
        Image image_right = t_right.getImage(ruta_right);
        Toolkit t_up = Toolkit.getDefaultToolkit();
        Image image_up = t_up.getImage(ruta_up);
        
        Image new_sprite[] = {image_up, image_right, image_down, image_left};
        this.sprite = new_sprite;
            
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setSprite(Image[] sprite) {
        this.sprite = sprite;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
