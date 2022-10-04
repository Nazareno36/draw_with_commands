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

    private JDialog instructionsDialog;
    private Border defaultBorder = BorderFactory.createEtchedBorder(0, new Color(0, 128, 105), new Color(0, 128, 105));

    
    public UserInterface(int width, int height){
        this.setSize(width,height);
        createComponents();
        initComponents();
        setAppTheme(Color.white, defaultBorder, new Color(0, 128, 105), this.canvas.getBackground(), 
                    new Font("Monospaced", 1, 12), new Color(255, 254, 255));
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
        this.instructionsDialog = new JDialog(this,false);
    }

    private void initComponents() {

        initGui();

        initBackground();

        initCanvas();

        initCommandConsole();

        initButtons();

        initCharacter();

        initInstructionsDialog();

        this.setVisible(true);
    }

    private void initGui(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initBackground(){
        this.background.setBounds(0,0,this.getWidth(),this.getHeight());
        this.background.setLayout(null);
        this.getContentPane().add(this.background);
    }

    private void initInstructionsDialog(){
        this.instructionsDialog.setUndecorated(true);
        this.instructionsDialog.setBounds(
                (int)(this.getWidth() * 0.25),
                (int)(this.getHeight() * 0.15),
                (int)(this.getWidth() * 0.5),
                (int)(this.getHeight() * 0.7)
        );
        
        JPanel background_instructions = new JPanel();
        background_instructions.setBounds(
                (int)(this.getWidth() * 0.25),
                (int)(this.getHeight() * 0.15),
                (int)(this.getWidth() * 0.5),
                (int)(this.getHeight() * 0.7)
        );
        background_instructions.setBackground(Color.white);
        background_instructions.setLayout(null);
        background_instructions.setBorder(defaultBorder);
        JButton ok = new JButton("ok");
        ok.setBorder(defaultBorder);
        ok.setBackground(new Color(0, 128, 105));
        ok.setBounds(
                background_instructions.getWidth()/2 -(int)(background_instructions.getWidth()*0.05),
                (int)(background_instructions.getHeight() * 0.9),
                (int)(background_instructions.getWidth() * 0.15),
                (int)(background_instructions.getWidth() * 0.05)
        );
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ok){
                    instructionsDialog.setVisible(false);
                    instructionsDialog.setEnabled(false);
                }
            }
        });

        JTextArea txtArea = new JTextArea();
        txtArea.setBounds(
                (int)(background_instructions.getWidth() * 0.1),
                (int)(background_instructions.getHeight() * 0.1),
                (int)(background_instructions.getWidth() * 0.8),
                (int)(background_instructions.getHeight() * 0.72)
        );
        txtArea.setEditable(false);
        txtArea.setRows(10);
        txtArea.setBorder(defaultBorder);
        txtArea.setText("\t\t           Instrucciones\t\t\n\n" +
                "Para Interactuar con el personaje y dibujar en pantalla necesitaras introducir\nlos siguientes comandos en el cuadro de texto bajo el lienzo y luego presionar enter:\n\n\n" +
                "ad n = El personaje avanza n pasos y dibuja una linea\n\n" +
                "iz = El personaje gira hacia la izquierda\n\n" +
                "de = El personaje gira hacia la derecha\n\n" +
                "cv = Cambia la velocidad del personaje\n\n" +
                "cl = Borra todo el lapiz en la pantalla\n\n" +
                "rs = Reinicia el personaje y el dibujo\n\n" +
                "lv = Levanta el lapiz para dejar de dibujar\n\n" +
                "po = Pone el lapiz en el lienzo\n\n" +
                "tp x y = Teletransporta al personaje a las coordenadas x,y");
        background_instructions.add(ok);
        background_instructions.add(txtArea);
        this.instructionsDialog.add(background_instructions);
        this.instructionsDialog.setVisible(true);
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
        this.instructions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon wallpaper = new ImageIcon("src/Icons/instructions.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.instructions.getWidth(),
                    this.instructions.getHeight(), Image.SCALE_DEFAULT));
        this.instructions.setIcon(icon);
        this.instructions.setBackground(this.background.getBackground());
        
        this.instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == instructions){
                    instructionsDialog.setVisible(true);
                    instructionsDialog.setEnabled(true);
                }
            }
        });
        this.background.add(this.instructions);
    }

    private void initExecuteButton(){
        this.execute.setBounds(
                (int)(this.canvas.getWidth() * 0.95) + this.canvas.getX(),
                (int)(this.getHeight() * 0.78),
                (int)(this.canvas.getWidth() * 0.05),
                (int)(this.canvas.getWidth() * 0.05)
        );
        ImageIcon wallpaper = new ImageIcon("src/Icons/execute.png");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.execute.getWidth(),
                this.execute.getHeight(), Image.SCALE_DEFAULT));
        this.characters.setBackground(this.background.getBackground());
        this.execute.setIcon(icon);
        this.execute.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.background.add(this.execute);
    }

    private void initColorsButton(){
        this.colors.setBounds(
                (int)(this.getWidth() * 0.015625),
                this.canvas.getY() + (int)(this.canvas.getHeight() * 0.5) - (int)(this.getWidth() * 0.0625)/2,
                (int)(this.getWidth() * 0.0625),
                (int)(this.getWidth() * 0.0625)
        );
        this.colors.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon wallpaper = new ImageIcon("src/Icons/palette_color.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.colors.getWidth(),
                    this.colors.getHeight(), Image.SCALE_DEFAULT));
        this.colors.setIcon(icon);
        this.colors.setBackground(this.background.getBackground());
        
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
        this.characters.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon wallpaper = new ImageIcon("src/Icons/character.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.characters.getWidth(),
                    this.characters.getHeight(), Image.SCALE_DEFAULT));
        this.characters.setIcon(icon);
        this.characters.setBackground(this.background.getBackground());
        
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
        this.theme.setBounds(
                (int)(this.getWidth() * 0.9609375),
                (int)(this.getHeight() * 0.034722222),
                (int)(this.getWidth() * 0.0328125),
                (int)((this.getWidth() * 0.0328125) * 0.75)
        );
        this.theme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.theme.setBackground(Color.white);
        ImageIcon wallpaper = new ImageIcon("src/Icons/light_mode.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.theme.getWidth(),
                    this.theme.getHeight(), Image.SCALE_DEFAULT));
        this.theme.setIcon(icon);
        
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
                (int)(this.getHeight() * 0.78),
                (int)(this.canvas.getWidth() * 0.05),
                (int)(this.canvas.getWidth() * 0.05)
        );
        this.trash.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon wallpaper = new ImageIcon("src/Icons/trash.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.trash.getWidth(),
                    this.trash.getHeight(), Image.SCALE_DEFAULT));
        this.trash.setIcon(icon);
        
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
        if(this.background.getBackground() == Color.white){
            setAppTheme(new Color(17, 30, 39), BorderFactory.createEtchedBorder(0, new Color(8, 186, 162), new Color(8, 186, 162))
                    ,new Color(32, 45, 54), this.canvas.getBackground(), new Font("Monospaced", 1, 12),new Color(167, 175, 177));
            ImageIcon wallpaper = new ImageIcon("src/Icons/dark_mode.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.theme.getWidth(),
                    this.theme.getHeight(), Image.SCALE_DEFAULT));
            this.theme.setIcon(icon);
            this.theme.setBackground(new Color(17, 30, 39));
            
        }else{
            setAppTheme(Color.white, defaultBorder, new Color(0, 128, 105), this.canvas.getBackground(), 
                    new Font("Monospaced", 1, 12), new Color(255, 254, 255));
            ImageIcon wallpaper = new ImageIcon("src/Icons/light_mode.png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(this.theme.getWidth(),
                    this.theme.getHeight(), Image.SCALE_DEFAULT));
            this.theme.setIcon(icon);
            this.theme.setBackground(Color.white);
        }
        this.setVisible(true);
    }

    private void setAppTheme(Color background, Border border, Color console, Color canvas, Font font, Color fontColor){
        this.background.setBackground(background);
        this.background.setBorder(border);
        this.instructionsDialog.getComponent(0).setBackground(background);
        this.canvas.setBorder(border);
        this.theme.setBorder(border);
        this.instructions.setBorder(border);
        this.colors.setBorder(border);
        this.characters.setBorder(border);
        this.execute.setBackground(background);
        this.execute.setBorder(border);
        this.characters.setBorder(border);
        this.commandConsole.setBorder(border);
        this.commandConsole.setBackground(console);
        this.canvas.setBackground(canvas);
        this.commandConsole.setFont(font);
        this.commandConsole.setForeground(fontColor);
        this.instructions.setBackground(background);
        this.characters.setBackground(background);
        this.colors.setBackground(background);
        this.trash.setBackground(background);
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
