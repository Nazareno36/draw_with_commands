package App;

import Components.*;
import Components.Character;
import Interfaz.Canvas;
import Interfaz.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.Clip;

public class App {

    private UserInterface gui;

    public App(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        this.gui = new UserInterface(screenSize.width, screenSize.height);
        AudioManager.loadAudio();
        initActionsListeners();
    }

    private void readInput(){
        Canvas canvas = this.gui.getCanvas();
        Character character = (Components.Character) canvas.getCharacter();
        JTextArea txtArea = this.gui.getCommandConsole();
        String[] commands = txtArea.getText().split(",");

        for(int i = 0; i < commands.length; i ++){
            String[] command = commands[i].strip().split(" ");
            if(command[0].equals("de")) character.turnRight();
            else if(command[0].equals("iz")) character.turnLeft();
            else if(command[0].equals("ad") && command.length == 2) canvas.moveAlong(Integer.parseInt(command[1]));
            else if (command[0].equals("cv") && command.length == 2) canvas.getCharacter().setSpeed(Integer.parseInt(command[1]));
            else if (command[0].equals("cl")) canvas.clean();
            else if (command[0].equals("rs")) canvas.reset();
            else if (command[0].equals("lv")) canvas.upPencil();
            else if (command[0].equals("po")) canvas.downPencil();
            else if (command[0].equals("tp")&& command.length == 3) canvas.tp(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            else {
                File soundNoup = AudioManager.get("Noup.wav");
                Clip clipNoup = AudioManager.createClip(soundNoup);
                clipNoup.start(); 
            }
            canvas.repaint();
        }
        txtArea.setText(null);
    }

    private void initActionsListeners(){
        this.gui.getExecute().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File sound = AudioManager.get("click.wav");
                Clip clip = AudioManager.createClip(sound);
                clip.start();
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
