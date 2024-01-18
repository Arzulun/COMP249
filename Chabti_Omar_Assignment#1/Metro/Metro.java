//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package Metro;
import RailwayTransport.Train;

public class Metro extends Train {
    
    protected int numStops;
    private long serialNum;
    private static long counter = 25000;


    public Metro(){
        this.numStops= 2;
        this.serialNum = counter;
        counter++;
    }

    public Metro(int numWheels, double maxSpeed, int numVehicles, String StartStation, String DestiStation, int numStops){
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;
        this.numVehicles = numVehicles;
        this.StartStation = StartStation;
        this.DestiStation = DestiStation;
        this.numStops = numStops;
        this.serialNum = counter;
        counter++;
    }

    public int getnumStops(){
        return this.numStops;
    }
    public long getNextSerialNumber(){
        return (counter + 1);
    }

    public long getserialNum(){
        return this.serialNum;
    }

    public void SetnumStops(int num){
        this.numStops = num;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nNumber of Wheels : " + this.numWheels + "\nMax Speed: " + this.maxSpeed
         + "\nNumber of vehicles: " + this.numVehicles + "\nStart Station: " + this.StartStation + "\nFinal Station: " + this.DestiStation
         + "\nNumber of Stops: " + this.numStops + "\n";
        
    }

    public Metro(Metro otherMetro){
        this.numWheels = otherMetro.numWheels;
        this.maxSpeed = otherMetro.maxSpeed;   
        this.numVehicles = otherMetro.numVehicles;
        this.StartStation = otherMetro.StartStation;
        this.DestiStation = otherMetro.DestiStation;
        this.numStops = otherMetro.numStops;
        this.serialNum = counter;
        counter++;     
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof Metro))
			return false;
		else
		{
			Metro v = (Metro)x;
			return (this.getnumWheels() == v.getnumWheels()
            && this.getmaxSpeed() == v.getmaxSpeed()
            && this.getnumVehicles() == v.getnumVehicles()
            && this.getStartStation() == v.getStartStation()
            && this.DestiStation == v.getDestistation())
            && this.numStops == v.getnumStops();
		}


    }
}
