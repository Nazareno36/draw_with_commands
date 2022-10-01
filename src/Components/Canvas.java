package Components;

import Components.Character;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {


    private Character character;

    public Canvas(){
        this.character = character;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

    }

    //Getters and Setters
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
