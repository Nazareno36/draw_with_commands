package Interfaz;

import Components.*;
import Components.Character;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.Clip;

public class Canvas extends JPanel {
    private Character character;
    private ArrayList<ArrayList<Line>> draws;

    public Canvas(){
        this.draws = new ArrayList<>();
    }

    private void drawCharacter(Graphics g){
        g.drawImage(character.getSprite()[character.getOrientation()], character.getxPosition(), character.getyPosition(), 30, 46, this);
    }

    private void draw(Graphics g){
        for(ArrayList<Line> points : this.draws){
            for(int i = 0; i < points.size(); i ++){
                if(points.get(i).getPoint2() != null){
                    g.setColor(points.get(i).getColor());
                    g.drawLine(points.get(i).getPoint1().x, points.get(i).getPoint1().y,
                        points.get(i).getPoint2().x, points.get(i).getPoint2().y);
                }
            }
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(character.getColor());
        draw(g);
        this.drawCharacter(g);
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
            ArrayList<Line> currentDraw1 = draws.get(draws.size() - 1);
            
            Line line = new Line(new Point(currentDraw1.get(currentDraw1.size() - 1).getPoint2().x, 
                    currentDraw1.get(currentDraw1.size() - 1).getPoint2().y),
                    null, character.getColor());
            int newY = line.getPoint1().y - displacement;
            if(newY < 0){
                newY = Math.abs(newY);
                line.setPoint2(new Point(line.getPoint1().x, 0));
                currentDraw1.add(line);

                ArrayList<Line> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Line(new Point(line.getPoint1().x, this.getHeight()),
                        new Point(line.getPoint1().x, this.getHeight() -newY), character.getColor()));

                this.draws.add(currentDraw2);
            }
            else {
                line.setPoint2(new Point(line.getPoint1().x,newY));
                currentDraw1.add(line);
            }
        }else if(orientation == 1){
            ArrayList<Line> currentDraw1 = draws.get(draws.size() - 1);
            
            Line line = new Line(new Point(currentDraw1.get(currentDraw1.size() - 1).getPoint2().x, 
                    currentDraw1.get(currentDraw1.size() - 1).getPoint2().y),
                    null, character.getColor());
            
            int newX = line.getPoint1().x + displacement;
            if(newX > this.getWidth()){
                newX = newX - this.getWidth();
                line.setPoint2(new Point(this.getWidth(), line.getPoint1().y));
                currentDraw1.add(line);

                ArrayList<Line> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Line(new Point(0, line.getPoint1().y),
                        new Point(newX, line.getPoint1().y), character.getColor()));
                
                this.draws.add(currentDraw2);

            }else{
                line.setPoint2(new Point(newX, line.getPoint1().y));
                currentDraw1.add(line);
            }
        }else if(orientation == 2){
            ArrayList<Line> currentDraw1 = draws.get(draws.size() - 1);
            
            Line line = new Line(new Point(currentDraw1.get(currentDraw1.size() - 1).getPoint2().x, 
                    currentDraw1.get(currentDraw1.size() - 1).getPoint2().y),
                    null, character.getColor());
            int newY = line.getPoint1().y + displacement;
            if(newY > this.getHeight()){
                newY = newY - this.getHeight();
                line.setPoint2(new Point(line.getPoint1().x, this.getHeight()));
                currentDraw1.add(line);

                ArrayList<Line> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Line(new Point(line.getPoint1().x, 0),
                        new Point(line.getPoint1().x, newY), character.getColor()));

                this.draws.add(currentDraw2);
            }
            else {
                line.setPoint2(new Point(line.getPoint1().x, newY));
                currentDraw1.add(line);
            }
        }else if(orientation == 3) {
            ArrayList<Line> currentDraw1 = draws.get(draws.size() - 1);
            
            Line line = new Line(new Point(currentDraw1.get(currentDraw1.size() - 1).getPoint2().x, 
                    currentDraw1.get(currentDraw1.size() - 1).getPoint2().y),
                    null, character.getColor());
            
            int newX = line.getPoint1().x - displacement;
            if(newX < 0){
                newX = Math.abs(newX);
                line.setPoint2(new Point(0, line.getPoint1().y));
                currentDraw1.add(line);

                ArrayList<Line> currentDraw2 = new ArrayList<>();
                currentDraw2.add(new Line(new Point(this.getWidth(), line.getPoint1().y),
                        new Point(this.getWidth() - newX, line.getPoint1().y), character.getColor()));
                
                this.draws.add(currentDraw2);

            }else{
                line.setPoint2(new Point(newX, line.getPoint1().y));
                currentDraw1.add(line);
            }
        }
    }

    public void clean(){
        Point p = draws.get(draws.size() - 1).get(draws.get(draws.size() - 1).size() - 1).getPoint2();
        Line line = new Line(p, p, character.getColor());
        this.draws.clear();
        ArrayList<Line> currentDraw = new ArrayList<>();
        currentDraw.add(line);
        this.draws.add(currentDraw);
    }

    public void reset(){
        Point p = new Point(this.getWidth() / 2, this.getHeight() / 2);
        this.draws.clear();
        Line line = new Line(p, p, character.getColor());
        ArrayList<Line> currentDraw = new ArrayList<>();
        currentDraw.add(line);
        this.draws.add(currentDraw);

        character.setxPosition(this.getWidth()/2 - 30);
        character.setyPosition(this.getHeight()/2 - 42);
        character.setOrientation(2);
    }

    public void upPencil(){
        character.setEnable(false);
        this.character.setSprite(this.character.getName());
        ArrayList<Line> currentDraw = new ArrayList<>();
        this.getDraws().add(currentDraw);
    }

    public void downPencil(){
        Point p = new Point(character.getxPosition() + 30, character.getyPosition() + 42);
        Line line = new Line(p, p, character.getColor());
        this.getDraws().get(this.getDraws().size() - 1).add(line);
        character.setEnable(true);
        this.character.setSprite(this.character.getName());
    }

    public void tp(int x, int y){
        if(!this.character.isEnable() && x < this.getWidth() && x > 0 && y > 0 && y < this.getHeight()){
            this.getCharacter().setxPosition(x);
            this.getCharacter().setyPosition(y);
        } else {
            File soundNoup = AudioManager.get("Noup.wav");
            Clip clipNoup = AudioManager.createClip(soundNoup);
            clipNoup.start();
        }
    }

    //Getters and Setters
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public ArrayList<ArrayList<Line>> getDraws() {
        return draws;
    }

    public void setDraws(ArrayList<ArrayList<Line>> draws) {
        this.draws = draws;
    }
    
}
