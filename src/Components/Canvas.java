package Components;

import Components.Character;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private Character character;
    private ArrayList<ArrayList<Point>> draws;

    public Canvas(){
        this.character = character;
        this.draws = new ArrayList<>();
    }

    private void drawCharacter(Graphics g){
        g.drawImage(character.getSprite()[character.getOrientation()], character.getxPosition(), character.getyPosition(), 30, 42, this);
    }

    private void draw(Graphics g){
        for(ArrayList<Point> points : this.draws){
            int[] xs = new int[points.size()];
            int[] ys = new int[points.size()];
            for(int i = 0; i < points.size(); i ++){
                xs[i] = points.get(i).x;
                ys[i] = points.get(i).y;
            }
            g.drawPolyline(xs,ys, xs.length);
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(character.getColor());
        this.drawCharacter(g);
        draw(g);
    }

    public void moveAlong(int steps){
        int orientation = character.getOrientation();
        int displacement = character.getSpeed() * steps;
        updateCharacter(orientation,displacement);
        if(character.isEnable()) updateDraws(orientation,displacement);
    }

    private void updateCharacter(int orientation, int displacement){
        int xPos = this.character.getxPosition();
        int yPos = this.character.getyPosition();

        if(orientation == 0){
            int newY = yPos-displacement;
            if(newY < 0){
                newY = Math.abs(newY);
                character.setyPosition(this.getHeight()-newY);
            }
            else{
                character.setyPosition(newY);
            }
        }else if(orientation == 1){
            int newX = xPos+displacement;
            if(newX > this.getWidth()){
                newX -= this.getWidth();
                character.setxPosition(newX);
            }
            else{
                character.setxPosition(newX);
            }
        }else if(orientation == 2){
            int newY = yPos+displacement;
            if(newY > this.getHeight()){
                newY -= this.getHeight();
                character.setyPosition(newY);
            }
            else{
                character.setyPosition(newY);
            }
        }else if(orientation == 3){
            int newX = xPos-displacement;
            if(newX < 0){
                newX = Math.abs(newX);
                character.setxPosition(this.getWidth()-newX);
            }
            else{
                character.setxPosition(newX);
            }
        }

    }

    private void updateDraws(int orientation, int displacement){
        if(orientation == 0){
            ArrayList<Point> currentDraw1 = draws.get(draws.size() - 1);
            int newY = currentDraw1.get(currentDraw1.size() - 1).y - displacement;
            if(newY < 0){

                newY = Math.abs(newY);
                currentDraw1.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, 0));

                ArrayList<Point> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, this.getHeight()));
                currentDraw2.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, this.getHeight() -newY));
                this.draws.add(currentDraw2);
            }
            else {
                currentDraw1.add(new Point(
                        currentDraw1.get(currentDraw1.size() - 1).x,
                        newY
                ));
            }
        }else if(orientation == 1){
            ArrayList<Point> currentDraw1 = draws.get(draws.size() - 1);
            int newX = currentDraw1.get(currentDraw1.size() - 1).x + displacement;
            if(newX > this.getWidth()){
                newX = newX - this.getWidth();
                currentDraw1.add(new Point(this.getWidth(), currentDraw1.get(currentDraw1.size() - 1).y));

                ArrayList<Point> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Point(0, currentDraw1.get(currentDraw1.size() - 1).y));
                currentDraw2.add(new Point(newX, currentDraw1.get(currentDraw1.size() - 1).y));
                this.draws.add(currentDraw2);

            }else{
                currentDraw1.add(new Point(
                        newX,
                        currentDraw1.get(currentDraw1.size() - 1).y
                ));
            }
        }else if(orientation == 2){
            ArrayList<Point> currentDraw1 = draws.get(draws.size() - 1);
            int newY = currentDraw1.get(currentDraw1.size() - 1).y + displacement;
            if(newY > this.getHeight()){

                newY = newY - this.getHeight();
                currentDraw1.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, this.getHeight()));

                ArrayList<Point> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, 0));
                currentDraw2.add(new Point(currentDraw1.get(currentDraw1.size() - 1).x, newY));
                this.draws.add(currentDraw2);
            }
            else {
                currentDraw1.add(new Point(
                        currentDraw1.get(currentDraw1.size() - 1).x,
                        newY
                ));
            }
        }else if(orientation == 3) {
            ArrayList<Point> currentDraw1 = draws.get(draws.size() - 1);
            int newX = currentDraw1.get(currentDraw1.size() - 1).x - displacement;
            if (newX < 0) {
                newX = Math.abs(newX);
                currentDraw1.add(new Point(0, currentDraw1.get(currentDraw1.size() - 1).y));

                ArrayList<Point> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Point(this.getWidth(), currentDraw1.get(currentDraw1.size() - 1).y));
                currentDraw2.add(new Point(this.getWidth() - newX, currentDraw1.get(currentDraw1.size() - 1).y));
                this.draws.add(currentDraw2);

            } else {
                currentDraw1.add(new Point(
                        newX,
                        currentDraw1.get(currentDraw1.size() - 1).y
                ));
            }
        }
    }

    public void clean(){
        Point p = draws.get(draws.size() - 1).get(draws.get(draws.size() - 1).size() - 1);
        this.draws.clear();
        ArrayList<Point> currentDraw = new ArrayList<>();
        currentDraw.add(p);
        this.draws.add(currentDraw);
    }

    public void reset(){
        Point p = new Point(this.getWidth() / 2, this.getHeight() / 2);
        this.draws.clear();
        ArrayList<Point> currentDraw = new ArrayList<>();
        currentDraw.add(p);
        this.draws.add(currentDraw);

        character.setxPosition(this.getWidth()/2 - 30);
        character.setyPosition(this.getHeight()/2 - 42);
        character.setOrientation(2);
    }

    public void upPencil(){
        character.setEnable(false);
        ArrayList<Point> currentDraw = new ArrayList<>();
        this.getDraws().add(currentDraw);
    }

    public void downPencil(){
        Point p = new Point(character.getxPosition() + 30, character.getyPosition() + 42);
        this.getDraws().get(this.getDraws().size() - 1).add(p);
        character.setEnable(true);
    }

    public void tp(int x, int y){
        if(!this.character.isEnable() && x < this.getWidth() && x > 0 && y > 0 && y < this.getHeight()){
            this.getCharacter().setxPosition(x);
            this.getCharacter().setyPosition(y);
        }
    }

    //Getters and Setters
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public ArrayList<ArrayList<Point>> getDraws() {
        return draws;
    }

    public void setDraws(ArrayList<ArrayList<Point>> draws) {
        this.draws = draws;
    }
}
