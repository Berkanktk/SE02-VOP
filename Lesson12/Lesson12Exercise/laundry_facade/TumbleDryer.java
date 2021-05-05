package laundry_facade;

/**
 * VOP eksamen F15 Kodeskelet til TumbleDryer-klassen i opg 3.
 *
 * @author erso
 */
public class TumbleDryer implements LaundryMachine
{

    private double pricePerMinute;
    private String model;
    
    public TumbleDryer(String model)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrice(double pricePerMinute)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModel()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPrice(int prog)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProgName(int prog)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString()
    {
        return getModel() + " Minutpris: " + pricePerMinute + "\n";
    }

}
