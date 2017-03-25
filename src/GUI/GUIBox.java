/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIBox {
    private double current = 0;
    private int voltage = 0;
    private int temp = 0;
    private double force = 0;

    public GUIBox(){

    }
    /**
     * returns the double
     * @return creates the currentreader
     */
    public double getCurrent(){return current;}
    /**
     * returns the int
     * @return creates the voltagereader
     */
    public int getVoltage(){return voltage;}
    /**
     * returns the int
     * @return creates the tempreader
     */
    public int getTemp() {return temp;}
    /**
     * returns the double
     * @return creates the forcereader
     */
    public double getForce() {return force;}
}
