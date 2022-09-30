import javax.swing.*;

public class App extends JFrame {

    private Canvas canvas;
    public App(){
        initComponents();
    }

    private void initComponents(){
        this.canvas = new Canvas(800,600);
        this.add(canvas);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
