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
        this.background.setLayout(null);
        this.getContentPane().add(this.background);
    }

    private void initCommandConsole(){
        JScrollPane jsp = new JScrollPane(this.commandConsole);
        jsp.setBounds(
                this.canvas.getX() + (int)(this.canvas.getWidth() * 0.06),
                this.canvas.getY() + (int)(this.getHeight() * 0.723055556),
                (int)(this.canvas.getWidth() * 0.88),
                (int)(this.canvas.getHeight() * 0.2)
        );
        this.commandConsole.setBounds(jsp.getBounds());
        System.out.println(jsp.getHeight());
        this.background.add(jsp);
    }

    private void initCanvas(){
        canvas.setBounds(
                (int)(this.getWidth()* 0.09375),
                (int)(this.getHeight() * 0.027777778),
                (int)(this.getWidth() * 0.859375),
                (int)(this.getHeight() * 0.70)
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
        initCharactersButton();
        initColorsButton();
        initExecuteButton();
        initTrashButton();
    }

    private void initInstructionsButton(){
        this.instructions.setBounds(
                (int)(this.getWidth() * 0.015625),
                this.canvas.getY() + (int)(this.canvas.getHeight() *0.15),
                (int)(this.getWidth() * 0.0625),
                (int)(this.getWidth() * 0.0625)
        );
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
                (int)(this.canvas.getWidth() * 0.95) + this.canvas.getX(),
                this.commandConsole.getY() + (this.commandConsole.getHeight()/2 - (int)(this.canvas.getWidth()*0.05)/2),
                (int)(this.canvas.getWidth() * 0.05),
                (int)(this.canvas.getWidth() * 0.05)
        );
        this.background.add(this.execute);
    }

    private void initColorsButton(){
        this.colors.setBounds(
                (int)(this.getWidth() * 0.015625),
                this.canvas.getY() + (int)(this.canvas.getHeight() * 0.5) - (int)(this.getWidth() * 0.0625)/2,
                (int)(this.getWidth() * 0.0625),
                (int)(this.getWidth() * 0.0625)
        );
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
        this.characters.setBounds(
                (int)(this.getWidth() * 0.015625),
                this.canvas.getY() + (int)(this.canvas.getHeight() *0.85) - (int)(this.getWidth() * 0.0625),
                (int)(this.getWidth() * 0.0625),
                (int)(this.getWidth() * 0.0625)
        );

        this.characters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == characters){

                }
            }
        });
        this.background.add(this.characters);
    }

    private void initThemeButton(){
        this.theme.setBounds(
                (int)(this.getWidth() * 0.9609375),
                (int)(this.getHeight() * 0.034722222),
                (int)(this.getWidth() * 0.0328125),
                (int)(this.getWidth() * 0.0328125)
        );
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
                this.canvas.getX(),
                this.commandConsole.getY() + (this.commandConsole.getHeight()/2 - (int)(this.canvas.getWidth()*0.05)/2),
                (int)(this.canvas.getWidth() * 0.05),
                (int)(this.canvas.getWidth() * 0.05)
        );
        this.trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == trash)
                    commandConsole.setText("");
            }
        });
        this.background.add(this.trash);
    }

    private void initCharacter(){
        Character character = new Character(this.canvas.getWidth()/2 - 30, this.canvas.getHeight()/2 - 42);
        this.canvas.setCharacter(character);
    }

    private void changeTheme(){
        this.setVisible(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(this.background.getBackground() == Color.white)
            setAppTheme(Color.black, customBorder,Color.DARK_GRAY,Color.white,new Font("Monospaced", 1, 12),Color.green);
        else
            setAppTheme(Color.white, defaultBorder,Color.pink,Color.gray,new Font("Monospaced", 1, 12),Color.DARK_GRAY);
        this.setVisible(true);
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
