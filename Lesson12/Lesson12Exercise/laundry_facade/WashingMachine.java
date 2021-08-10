
package laundry_facade;

import java.util.Map;

/**
 * VOP Eksamen F15
 * Kodeskelet til WashingMachine-klassen i opgave 3.
 * @author erso
 */
public class WashingMachine implements LaundryMachine{
    
    private Map<Integer, WashProgram> progMap;
    private String model;
    
    public WashingMachine(String model) {
         this.model = model;
   }
    
    public void addProgram(int code, String name, double  price){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    @Override
    public String getModel() {
        return model;
   }

    @Override
    public double getPrice(int prog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    @Override
    public String getProgName(int prog) {
        return "Vask i " + prog + " minutter";
   }

    @Override
    public String toString() {
        return getModel() + "\n" + progMap +"\n";
    }
}