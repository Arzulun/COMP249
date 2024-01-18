//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package Planes;

public class WWIIAirplane extends Aircraft{
    protected boolean TwinEngine;
    private long serialNum;
    private static long counter = 80000;

    public WWIIAirplane(){
        this.TwinEngine =  true;
        this.serialNum = counter;
        counter++;
    }

    public WWIIAirplane(double price, double maxElevation, boolean TwinEngine){
        this.price = price;
        this.maxElevation = maxElevation;
        this.TwinEngine = TwinEngine;
        this.serialNum = counter;
        counter++;
    }

    public boolean getTwinEngine(){
        return this.TwinEngine;
    }

    public long getNextSerialNumber(){
        return (counter + 1);
    }

    public long getserialNum(){
        return this.serialNum;
    }

    public void setTwinEngine(boolean val){
        this.TwinEngine = val;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nPrice: " + this.price + "$" + "\nMaximum Elevation: " + this.maxElevation 
        + "m" + "\nAiplane has a twin engine: " + this.TwinEngine+ "\n";
    }

    public WWIIAirplane(WWIIAirplane other){
        this.price = other.price;
        this.maxElevation = other.maxElevation;
        this.TwinEngine = other.TwinEngine;
        this.serialNum = counter;
        counter++;
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof WWIIAirplane))
        return false;

        else 
        {
            WWIIAirplane v = (WWIIAirplane) x;
            return (this.getPrice() == v.getPrice()
            && this.getmaxElevation() == v.getmaxElevation()
            && this.getTwinEngine() == v.getTwinEngine());
        }
    }

}
