package Components;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterChooser extends JDialog{
    
    private JPanel background;
    private JScrollPane scroll;
    
    public CharacterChooser(Frame owner) {
        super(owner);
        this.background = new JPanel();
        initComponents();
    }
    
    private void initComponents(){
        initDialog();
        initBackground();
        initScroll();
        initCharactersButtons();
    }
    
    private void initDialog(){
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Selecciona el personaje");
        this.setBounds(180 / 2, 210 / 2, this.getOwner().getWidth() -180, this.getOwner().getHeight()-210);
        this.setVisible(true);
    }
    
    private void initScroll(){
        this.scroll = new JScrollPane(this.background);
        this.scroll.setBounds(0, 0, this.getOwner().getWidth() -180, this.getOwner().getHeight()-210);
        this.getContentPane().add(scroll);
    }
    
    private void initBackground(){
        this.background.setBackground(((UserInterface)this.getParent()).getbackground().getBackground());
    }
    
    private void initCharactersButtons(){
        File carpeta = new File("src/Sprites"); 
        File[] list = carpeta.listFiles();
        
        int x = 10;
        int y = 10;
        for (File file : list) {
            
            JButton button = new JButton();
            button.setBounds(x, y, 100, 100);
            String name = file.getName();
            button.setName(name);
            
            ImageIcon wallpaper = new ImageIcon("src/Sprites/"+ name +"/down_" + name + ".png");
            Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(button.getWidth(),
                    button.getHeight(), Image.SCALE_DEFAULT));
            button.setIcon(icon);
            
            JDialog dialog = this;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == button){
                        ((UserInterface)dialog.getOwner()).getCanvas().getCharacter().setName(button.getName());
                        ((UserInterface)dialog.getOwner()).getCanvas().repaint();
                        dispose();
                    }
                }
            });
            x += 150;
            if(x > 160) {
                y += 150;
                x = 10;
            }
            this.background.add(button);
        }
    }
}
