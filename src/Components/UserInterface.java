package Components;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private Canvas canvas;
    private JPanel background;
    public UserInterface(int width, int height){
        this.setSize(width,height);
        this.canvas = new Canvas();
        this.background = new JPanel();
        initComponents();
    }

    private void initComponents() {
        //gui
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(background);
        //background
        this.background.setBackground(Color.black);
        background.setLayout(null);
        background.add(canvas);
        //canvas
        canvas.setBounds(this.getWidth()/2 - (this.getWidth()-180)/2,20, (this.getWidth()-180), this.getHeight()-170);

        this.setVisible(true);
    }


}
