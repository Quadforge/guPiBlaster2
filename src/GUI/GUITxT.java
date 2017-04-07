/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUITxT {
    /**
     * creates the variables to be used in GUIPanels
     */
    private double current = 0;
    private int voltage = 0;
    private int temp = 0;
    private double force = 0;

    public GUITxT(){
        /**
         * Place code here
         */
        currentcode();
        voltagecode();
        tempcode();
        forcecode();
    }
    public void currentcode(){
        /**
         * Place code here
         */
    }
    public void voltagecode(){
        /**
         * Place code here
         */
    }
    public void tempcode(){
        /**
         * Place code here
         */
    }
    public void forcecode(){
        /**
         * Place code here
         */
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
