package App;

import Components.Canvas;
import Components.UserInterface;

import java.awt.*;

public class App {

    private UserInterface gui;

    public App(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        System.out.println(screenSize.width);
        System.out.println(screenSize.height);
        this.gui = new UserInterface(screenSize.width, screenSize.height);
    }





    public static void main(String[] args) {
        new App();
    }

}
