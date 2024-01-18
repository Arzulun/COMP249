//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package Planes;

import Part2.Vehicles;

public class Aircraft extends Vehicles{
    protected double price;
    protected double maxElevation;
    private long serialNum;
    private static long counter = 0;

    public Aircraft(){
        this.price = 10000;
        this.maxElevation = 10000;
        this.serialNum = counter;
        counter++;
    }

    public Aircraft(double price, double maxElevation){
        this.price = price;
        this.maxElevation = maxElevation;
        this.serialNum = counter;
        counter++;
    }

    public double getPrice(){
        return this.price;
    }

    public double getmaxElevation(){
        return this.maxElevation;
    }

    public long getNextSerialNumber(){
        return (counter+1);
    }

    public long getserialNum(){
        return this.serialNum;
    }
    
    public void setPrice(double num){
        this.price = num;
    }

    public void setMaxElevation(double num){
        this.maxElevation = num;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nPrice: " + this.price + "$" + "\nMaximum Elevation: " + this.maxElevation 
        + "m\n";
    }

    public Aircraft(Aircraft otherAircraft){
        this.price = otherAircraft.price;
        this.maxElevation = otherAircraft.maxElevation;
        this.serialNum = counter;
        counter++;
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof Aircraft))
            return false;

        else  
        {
            Aircraft v = (Aircraft) x;
            return (this.getPrice() == v.getPrice()
            && this.getmaxElevation() == v.getmaxElevation());
        }

    }
}