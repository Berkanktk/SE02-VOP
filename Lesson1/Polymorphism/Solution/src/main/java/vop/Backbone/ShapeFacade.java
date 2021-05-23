/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.Backbone;

import vop.Figures.Circle;
import vop.Ellipse;
import vop.Figures.Rectangle;
import vop.Figures.Square;

public class ShapeFacade {

    //Singleton Stuff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }

    //---------------------------

    public enum SHAPES{CIRCLE, ELLIPSE, RECTANGLE, SQUERE};

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        ShapeInterface currentShape = null;
        switch (shape) {
            case CIRCLE:
                currentShape = new Circle(parametre[0]);
                break;
            case ELLIPSE:
                currentShape = new Ellipse(parametre[0], parametre[1]);
                break;
            case SQUERE:
                currentShape = new Square(parametre[0]);
                break;
            case RECTANGLE:
                currentShape = new Rectangle(parametre[0], parametre[1]);
                break;
            default:    return "Unknown Shape";
        }
        return currentShape.toString();
    }
}
