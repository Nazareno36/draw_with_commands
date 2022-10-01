package Components;

import Components.Character;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {


    private Character character;

    public Canvas(){
        this.character = character;
    }

    private void drawCharacter(Graphics g){
        g.drawImage(character.getSprite()[character.getOrientation()], character.getxPosition(), character.getyPosition(), 30, 30, this);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.drawCharacter(g);
    }

    //Getters and Setters
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
