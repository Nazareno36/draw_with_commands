package Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UserInterface extends JFrame {

    private Canvas canvas;
    private JPanel background;
    private JTextArea commandConsole;
    private JButton execute;
    private JButton color;
    private Border defaultBorder = BorderFactory.createEtchedBorder(0, new Color(0,128,131,255), Color.black);
    public UserInterface(int width, int height){
        this.setSize(width,height);
        createComponents();
        initComponents();
    }

    private void createComponents(){
        this.canvas = new Canvas();
        this.background = new JPanel();
        this.commandConsole = new JTextArea();
        this.execute = new JButton();
        this.color = new JButton();
    }

    private void initComponents() {

        initGui();

        initBackground();

        initCanvas();

        initCommandConsole();

        initButtons();

        initCharacter();

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
        JScrollPane jsp = new JScrollPane(this.commandConsole);
        jsp.setBounds(
                this.canvas.getX(),
                this.canvas.getY() + this.canvas.getHeight() + 10,
                this.canvas.getWidth() -100,
                this.canvas.getHeight() / 5
        );
        this.background.add(jsp);
    }

    private void initCanvas(){
        canvas.setBounds(
                this.getWidth()/2 - (this.getWidth()-300)/2,
                20,
                this.getWidth()-180,
                this.getHeight()-210
        );
        Point p = new Point(this.canvas.getWidth() / 2, this.canvas.getHeight() / 2);
        ArrayList<Line> currentDraw = new ArrayList<>();
        Line line = new Line(p, p, Color.black);
        currentDraw.add(line);
        canvas.getDraws().add(currentDraw);
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
        
        this.color.setBorder(defaultBorder);
        this.color.setBounds(15, 20, 120, 120);
        this.color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == color){
                    JColorChooser colorChooser = new JColorChooser();
                    Color color = JColorChooser.showDialog(null, "Seleccione un color para el lapiz", Color.black);
                    canvas.getCharacter().setColor(color);
                }
            }
        });
        
        this.background.add(color);
    }

    private void initCharacter(){
        Character character = new Character(this.canvas.getWidth()/2 - 30, this.canvas.getHeight()/2 - 42);
        this.canvas.setCharacter(character);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JPanel getbackground() {
        return background;
    }

    public void setBackground(JPanel background) {
        this.background = background;
    }

    public JTextArea getCommandConsole() {
        return commandConsole;
    }

    public void setCommandConsole(JTextArea commandConsole) {
        this.commandConsole = commandConsole;
    }

    public JButton getExecute() {
        return execute;
    }

    public void setExecute(JButton execute) {
        this.execute = execute;
    }

    public Border getDefaultBorder() {
        return defaultBorder;
    }

    public void setDefaultBorder(Border defaultBorder) {
        this.defaultBorder = defaultBorder;
    }
}
