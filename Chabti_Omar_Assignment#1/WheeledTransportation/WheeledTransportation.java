//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package WheeledTransportation;

import Part2.Vehicles;

public class WheeledTransportation extends Vehicles{
    protected int numWheels;
    protected double maxSpeed;
    protected long serialNum;
    private static long counter = 0;

    public WheeledTransportation(){
        this.numWheels=0;
        this.maxSpeed=0;
        this.serialNum=counter;
        counter++;
    }

    public WheeledTransportation(int numWheels, double maxSpeed){
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;   
        this.serialNum = counter;
        counter++;         
    }
    
    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nNumber of Wheels : " + this.numWheels + "\nMax Speed: " + this.maxSpeed + "\n";
    }

    public WheeledTransportation(WheeledTransportation other){
        this.numWheels = other.numWheels;
        this.maxSpeed = other.maxSpeed;   
        this.serialNum = counter;
        counter++;     
    }
    
    public long getNextSerialNumber(){
        return (counter+1);
    }

    public int getnumWheels(){
        return this.numWheels;
    }

    public double getmaxSpeed(){
        return this.maxSpeed;
    }

    public long getSerialNumber(){
        return this.serialNum;
    }

    public void setnumWheels(int num){
        this.numWheels = num;
    }

    public void setmaxSpeed(double num){
        this.maxSpeed = num;
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof WheeledTransportation))
			return false;
		else
		{
			WheeledTransportation v = (WheeledTransportation)x;
			return (this.getnumWheels() == v.getnumWheels() 
            && this.getmaxSpeed() == v.getmaxSpeed());
		}

    }


}
