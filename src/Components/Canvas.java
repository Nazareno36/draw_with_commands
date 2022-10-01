package Components;

import Components.Character;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canvas extends JPanel {


    private Character character;
    private ArrayList<Integer> xs;
    private ArrayList<Integer> ys;

    public Canvas(){
        this.character = character;
        this.xs = new ArrayList<>();
        this.ys = new ArrayList<>();
    }

    private void drawCharacter(Graphics g){
        g.drawImage(character.getSprite()[character.getOrientation()], character.getxPosition(), character.getyPosition(), 30, 42, this);
    }

    private void draw(Graphics g){
        int[] xs = this.xs.stream().mapToInt(Integer::intValue).toArray();
        int[] ys = this.ys.stream().mapToInt(Integer::intValue).toArray();
        g.drawPolyline(xs,ys, xs.length);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(character.getColor());
        this.drawCharacter(g);
        if(character.isEnable()){
            draw(g);
        }
    }

    public void moveAlong(int steps){
        int orientation = character.getOrientation();
        int xPosition = character.getxPosition();
        int yPosition = character.getyPosition();
        int displacement = character.getSpeed() * steps;

        if(orientation == 0){
            character.setyPosition(yPosition -= displacement);
            xs.add(xs.get(xs.size()-1));
            ys.add(ys.get(ys.size()-1) - displacement);
        }else if(orientation == 1){
            character.setxPosition(xPosition += displacement);
            xs.add(xs.get(xs.size()-1) + displacement);
            ys.add(ys.get(ys.size()-1));
        }else if(orientation == 2){
            character.setyPosition(yPosition += displacement);
            xs.add(xs.get(xs.size()-1));
            ys.add(ys.get(ys.size()-1) + displacement);
        }else if(orientation == 3){
            character.setxPosition(xPosition -= displacement);
            xs.add(xs.get(xs.size()-1) - displacement);
            ys.add(ys.get(ys.size()-1));
        }
        repaint();
    }

    //Getters and Setters
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public ArrayList<Integer> getXs() {
        return xs;
    }

    public void setXs(ArrayList<Integer> xs) {
        this.xs = xs;
    }

    public ArrayList<Integer> getYs() {
        return ys;
    }

    public void setYs(ArrayList<Integer> ys) {
        this.ys = ys;
    }
}
