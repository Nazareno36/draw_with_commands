import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    public Canvas(int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

    }
}
