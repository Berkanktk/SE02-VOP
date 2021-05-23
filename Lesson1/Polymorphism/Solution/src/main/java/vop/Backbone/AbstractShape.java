package vop.Backbone;

public abstract class AbstractShape implements ShapeInterface{

    @Override
    public String toString() {
        String result = String.format("\nJeg er en %1s med Areal%2$7.3f og Omkreds%3$7.3f",
                getClass().getSimpleName(), getArea(), getCircumference());
        return result;
    }
}
