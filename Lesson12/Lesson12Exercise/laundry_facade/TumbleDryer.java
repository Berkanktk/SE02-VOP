package laundry_facade;

/**
 * VOP eksamen F15 Kodeskelet til TumbleDryer-klassen i opg 3.
 *
 * @author erso
 */
public class TumbleDryer implements LaundryMachine, LaundryConstants {

    private double pricePerMinute;
    private String model;
    
    public TumbleDryer(String model) {
        this.model = model;
    }

    public void setPrice(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice(int prog) {
        double total = prog * pricePerMinute;
        return total;
    }

    @Override
    public String getProgName(int prog) {
        return "Tørring i " + prog + " minutter";
    }

    @Override
    public String toString() {
        return getModel() + " Minutpris: " + pricePerMinute + "\n";
    }
}
