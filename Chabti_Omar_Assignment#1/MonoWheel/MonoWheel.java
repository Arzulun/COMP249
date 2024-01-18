//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package MonoWheel;
import WheeledTransportation.WheeledTransportation;


public class MonoWheel extends WheeledTransportation {
    
    protected double maxWeight;
    private long serialNum;
    private static long counter = 55000;

    public MonoWheel(){
        this.maxWeight = 10000;
        this.serialNum = counter;
        counter++;
    }

    public MonoWheel(int numWheels, double maxSpeed, double maxWeight){
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;   
        this.maxWeight = maxWeight;
        this.serialNum= counter;
        counter++; 
    }

    public double getMaxWeight(){
        return this.maxWeight;
    }

    public long getNextSerialNumber(){
        return (counter + 1);
    }

    public long getserialNum(){
        return this.serialNum;
    }

    public void setMaxWeight(double num){
        this.maxWeight = num;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nNumber of Wheels : " + this.numWheels + "\nMax Speed: " + this.maxSpeed
                + "\nMax Weight: " + this.maxWeight + "\n";
    }

    public MonoWheel(MonoWheel other){
        this.numWheels = other.numWheels;
        this.maxSpeed = other.maxSpeed;   
        this.maxWeight = other.maxWeight;
        this.serialNum = counter;
        counter++;     
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof MonoWheel))
			return false;
		else
		{
			MonoWheel v = (MonoWheel)x;
			return (this.getnumWheels() == v.getnumWheels() 
            && this.getmaxSpeed() == v.getmaxSpeed())
            && this.getMaxWeight() == v.getMaxWeight();
		}

    }
}
