package Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class UserInterface extends JFrame {

    private Canvas canvas;
    private JPanel background;
    private JScrollPane commandConsole;
    private JButton execute;
    private Border defaultBorder = BorderFactory.createEtchedBorder(0, new Color(0,128,131,255), Color.black);
    public UserInterface(int width, int height){
        this.setSize(width,height);
        createComponents();
        initComponents();
    }

    private void createComponents(){
        this.canvas = new Canvas();
        this.background = new JPanel();
        this.commandConsole = new JScrollPane();
        this.execute = new JButton();
    }

    private void initComponents() {

        initGui();

        initBackground();

        initCanvas();

        initCommandConsole();

        initButtons();

        this.setVisible(true);
    }

    private void initGui(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initBackground(){
        this.background.setBackground(new Color(204,204,204,255));
        this.background.setBorder(defaultBorder);
        this.background.setLayout(null);
        this.getContentPane().add(this.background);
    }

    private void initCommandConsole(){
        this.commandConsole.setBorder(defaultBorder);
        JTextArea txtArea = new JTextArea();
        commandConsole.setViewportView(txtArea);
        commandConsole.setBounds(
                this.canvas.getX(),
                this.canvas.getY() + this.canvas.getHeight() + 10,
                this.canvas.getWidth() -100,
                this.canvas.getHeight() / 5
        );
        this.background.add(this.commandConsole);
    }

    private void initCanvas(){
        canvas.setBounds(
                this.getWidth()/2 - (this.getWidth()-300)/2,
                20,
                this.getWidth()-180,
                this.getHeight()-210
        );
        canvas.setBackground(Color.WHITE);
        canvas.setBorder(this.defaultBorder);
        background.add(canvas);
    }

    private void initButtons(){
        this.execute.setBackground(Color.green);
        this.execute.setBorder(defaultBorder);
        this.execute.setBounds(
                this.getWidth() - 100,
                this.getHeight() - 160,
                60,
                60
        );
        this.background.add(this.execute);
    }

}
