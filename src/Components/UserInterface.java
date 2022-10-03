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
    private JButton colors;
    private JButton theme;
    private JButton characters;
    private JButton instructions;
    private JButton trash;
    private Border defaultBorder = BorderFactory.createEtchedBorder(0, new Color(0,128,131,255), Color.black);
    private Border customBorder =  BorderFactory.createEtchedBorder(0, Color.red, Color.DARK_GRAY);
    
    public UserInterface(int width, int height){
        this.setSize(width,height);
        createComponents();
        initComponents();
        setAppTheme(Color.white, defaultBorder,Color.pink,Color.gray,new Font("Monospaced", 1, 12),Color.DARK_GRAY);
    }

    private void createComponents(){
        this.canvas = new Canvas();
        this.background = new JPanel();
        this.commandConsole = new JTextArea();
        this.execute = new JButton();
        this.colors = new JButton();
        this.theme = new JButton();
        this.characters = new JButton();
        this.instructions = new JButton();
        this.trash = new JButton();
    }

    private void initComponents() {

        initGui();

        initBackground();

        initCanvas();

        initButtons();

        initCommandConsole();

        initCharacter();

        this.setVisible(true);
    }

    private void initGui(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initBackground(){
        this.background.setBackground(new Color(204,204,204,255));
        this.background.setLayout(null);
        this.getContentPane().add(this.background);
    }

    private void initCommandConsole(){
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
                120,
                20,
                this.getWidth()-180,
                this.getHeight()-210
        );
        Point p = new Point(this.canvas.getWidth() / 2, this.canvas.getHeight() / 2);
        ArrayList<Line> currentDraw = new ArrayList<>();
        Line line = new Line(p, p, Color.black);
        currentDraw.add(line);
        canvas.getDraws().add(currentDraw);
        background.add(canvas);
    }

    private void initButtons(){
        initThemeButton();
        initInstructionsButton();
        initColorsButton();
        initCharactersButton();
        initExecuteButton();
        initTrashButton();
    }

    private void initInstructionsButton(){
        this.instructions.setBounds(20,100,80,80);
        this.instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == instructions){

                }
            }
        });
        this.background.add(this.instructions);
    }

    private void initExecuteButton(){
        this.execute.setBackground(Color.green);
        this.execute.setBounds(
                this.canvas.getWidth() + this.canvas.getX() - 80,
                this.canvas.getHeight() + this.canvas.getY() + 35,
                60,
                60
        );
        this.background.add(this.execute);
    }

    private void initColorsButton(){
        this.colors.setBounds(20, 220, 80, 80);
        this.colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == colors){
                    JColorChooser colorChooser = new JColorChooser();
                    Color color = JColorChooser.showDialog(null, "Seleccione un color para el lapiz", Color.black);
                    canvas.getCharacter().setColor(color);
                }
            }
        });

        this.background.add(this.colors);
    }

    private void initCharactersButton(){
        this.characters.setBounds(20,340,80,80);
        JFrame frame = this;
        this.characters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == characters){
                    new CharacterChooser(frame);
                }
            }
        });
        this.background.add(this.characters);
    }

    private void initThemeButton(){
        this.theme.setBounds(this.getWidth() - 50, 25,42,42);
        this.theme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == theme)
                    changeTheme();
            }
        });
        this.background.add(this.theme);
    }

    private void initTrashButton(){
        this.trash.setBackground(Color.red);
        this.trash.setBounds(
                this.canvas.getX() - 100,
                this.canvas.getHeight() -this.canvas.getY() + 60,
                80,
                80
                );
        this.trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == trash)
                    commandConsole.setText("");
            }
        });
        System.out.println(trash.getBounds());
        this.background.add(this.trash);
    }

    private void initCharacter(){
        Character character = new Character(this.canvas.getWidth()/2 - 30, this.canvas.getHeight()/2 - 42);
        this.canvas.setCharacter(character);
    }

    private void changeTheme(){
        if(this.background.getBackground() == Color.white)
            setAppTheme(Color.black, customBorder,Color.DARK_GRAY,Color.white,new Font("Monospaced", 1, 12),Color.green);
        else
            setAppTheme(Color.white, defaultBorder,Color.pink,Color.gray,new Font("Monospaced", 1, 12),Color.DARK_GRAY);
    }

    private void setAppTheme(Color background, Border border, Color console, Color canvas, Font font, Color fontColor){
        this.background.setBackground(background);
        this.background.setBorder(border);
        this.canvas.setBorder(border);
        this.theme.setBorder(border);
        this.instructions.setBorder(border);
        this.colors.setBorder(border);
        this.characters.setBorder(border);
        this.execute.setBorder(border);
        this.characters.setBorder(border);
        this.commandConsole.setBorder(border);
        this.commandConsole.setBackground(console);
        this.canvas.setBackground(canvas);
        this.commandConsole.setFont(font);
        this.commandConsole.setForeground(fontColor);
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
