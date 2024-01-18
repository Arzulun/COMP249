//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package Boats;

import Part2.Vehicles;

public class Ferry extends Vehicles{
    protected double maxSpeed;
    protected double maxLoad;
    private long serialNum;
    private static long counter = 70000;
    
    public Ferry(){
        this.maxSpeed = 150;
        this.maxLoad = 500;
        this.serialNum = counter;
        counter++;
    }

    public Ferry(double maxSpeed, double maxLoad){
        this.maxSpeed = maxSpeed;
        this.maxLoad = maxLoad;
        this.serialNum = counter;
        counter++;
    }

    public double getmaxSpeed(){
        return this.maxSpeed;
    }

    public double getmaxload(){
        return this.maxLoad;
    }

    public long getNextSerialNumber(){
        return (counter+1);
    }

    public long getserialNum(){
        return this.serialNum;
    }

    public void setmaxSpeed(double num){
        this.maxSpeed = num;
    }

    public void setMaxLoad(double num){
        this.maxLoad = num;
    }

    public String toString(){
        return "\nFerry Serial Number: " + this.serialNum + "\nMax Speed: " + this.maxSpeed + "\nMax load: " + this.maxLoad
        + "\n";
    }

    public Ferry(Ferry other){
        this.maxSpeed = other.maxSpeed;
        this.maxLoad = other.maxLoad;
        this.serialNum = counter;
        counter++;
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof Ferry))
			return false;
		else
		{
			Ferry v = (Ferry)x;
			return (this.getmaxSpeed() == v.getmaxSpeed() 
            && this.getmaxload() == v.getmaxload());
		}

    }
}
