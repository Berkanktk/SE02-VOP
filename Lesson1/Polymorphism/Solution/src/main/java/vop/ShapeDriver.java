package vop;

import vop.Backbone.ShapeInterface;
import vop.Figures.Circle;
import vop.Figures.Rectangle;
import vop.Figures.Square;

import java.util.ArrayList;
import java.util.List;

public class ShapeDriver {

    public static void main(String[] args) {
        List<ShapeInterface> list = new ArrayList<>();
        list.add(new Circle(3.4));
        list.add(new Rectangle(3.4, 4.4));
        list.add(new Ellipse(3.4, 2.7));
        list.add(new Square(3.4));
        
        System.out.println("Shapes: " + list);
    }
}
