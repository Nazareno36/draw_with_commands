package App;

import Components.Canvas;
import Components.Character;
import Components.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App {

    private UserInterface gui;

    public App(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);
        this.gui = new UserInterface(screenSize.width, screenSize.height);
        initActionsListeners();
    }

    private void readInput(){
        Canvas canvas = this.gui.getCanvas();
        Character character = canvas.getCharacter();
        JTextArea txtArea = this.gui.getCommandConsole();
        String command = txtArea.getText();
        if(command.equals("de")){
            character.turnRight();
            canvas.repaint();
        }else if(command.equals("iz")){
            character.turnLeft();
            canvas.repaint();
        }else if(command.equals("ad")){
            canvas.moveAlong(1);
        }
        txtArea.setText(null);
    }

    private void initActionsListeners(){
        this.gui.getExecute().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readInput();
            }
        });
        this.gui.getCommandConsole().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) readInput();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        new App();
    }

}
