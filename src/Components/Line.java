package Components;

import java.awt.Color;
import java.awt.Point;

public class Line {
    private Point point1;
    private Point point2;
    private Color color;

    public Line() {
    }

    public Line(Point point1, Point point2, Color color) {
        this.point1 = point1;
        this.point2 = point2;
        this.color = color;
    }

    /**
     * @return the point1
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * @param point1 the point1 to set
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    /**
     * @return the point2
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * @param point2 the point2 to set
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    
    
}
