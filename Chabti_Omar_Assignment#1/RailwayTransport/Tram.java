//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package RailwayTransport;
import Metro.Metro;

public class Tram extends Metro {

    protected int yearCreated;
    private long serialNum;
    private static long counter = 30000;

    public Tram(){
        this.yearCreated = 1950;
        this.serialNum = counter;
        counter++;
    }

    public Tram(int numWheels, double maxSpeed, int numVehicles, String StartStation, String DestiStation, int numStops, int yearCreated){
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;
        this.numVehicles = numVehicles;
        this.StartStation = StartStation;
        this.DestiStation = DestiStation;
        this.numStops = numStops;
        this.serialNum = counter;
        counter++;
    }

    public int getYearCreated(){
        return this.yearCreated;
    }

    public long getNextSerialNumber(){
        return (counter +1);
    }

    public long getserialNum(){
        return this.serialNum;
    }
    
    public void setYearCreated(int num){
        this.yearCreated = num;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nNumber of Wheels : " + this.numWheels + "\nMax Speed: " + this.maxSpeed
         + "\nNumber of vehicles: " + this.numVehicles + "\nStart Station: " + this.StartStation + "\nFinal Station: " + this.DestiStation
         + "\nNumber of Stops: " + this.numStops + "\nYear Creater: " + this.yearCreated + "\n";
        
    }

    public Tram(Tram otherTram){
        this.numWheels = otherTram.numWheels;
        this.maxSpeed = otherTram.maxSpeed;   
        this.numVehicles = otherTram.numVehicles;
        this.StartStation = otherTram.StartStation;
        this.DestiStation = otherTram.DestiStation;
        this.numStops = otherTram.numStops;
        this.yearCreated = otherTram.yearCreated;
        this.serialNum = counter;
        counter++;     
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof Tram))
			return false;
		else
		{
			Tram v = (Tram)x;
			return (this.getnumWheels() == v.getnumWheels()
            && this.getmaxSpeed() == v.getmaxSpeed()
            && this.getnumVehicles() == v.getnumVehicles()
            && this.getStartStation() == v.getStartStation()
            && this.DestiStation == v.getDestistation())
            && this.numStops == v.getnumStops()
            && this.yearCreated == v.getYearCreated();
		}
    }

    


}
