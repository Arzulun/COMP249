//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

package RailwayTransport;
import WheeledTransportation.WheeledTransportation;


public class Train extends WheeledTransportation {
    protected int numVehicles;
    protected String StartStation;
    protected String DestiStation;
    private long serialNum;
    private static long counter = 10000;

    public Train(){
        this.numVehicles=0;
        this.StartStation = "Undefined start";
        this.DestiStation = "Undefined finish";
        this.serialNum = counter;
        counter++;
    }

    public Train(int numWheels, double maxSpeed, int numVehicles, String StartStation, String DestiStation){
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;
        this.numVehicles = numVehicles;
        this.StartStation = StartStation;
        this.DestiStation = DestiStation;
        this.serialNum = counter;
        counter++;
    }

    public String toString(){
        return "\nSerial Number: " + this.serialNum + "\nNumber of Wheels : " + this.numWheels + "\nMax Speed: " + this.maxSpeed
        + "\nNumber of vehicles: " + this.numVehicles + "\nStart Station: " + this.StartStation + "\nFinal Station: " + this.DestiStation
        + "\n";
    }

    public Train(Train otherTrain){
        this.numWheels = otherTrain.numWheels;
        this.maxSpeed = otherTrain.maxSpeed;   
        this.numVehicles = otherTrain.numVehicles;
        this.StartStation = otherTrain.StartStation;
        this.DestiStation = otherTrain.DestiStation;
        this.serialNum = counter;
        counter++;     
    }

    public long getNextSerialNumber(){
        return (counter+1);
    }

    public int getnumVehicles(){
        return this.numVehicles;
    } 

    public String getStartStation(){
        return this.StartStation;
    }

    public String getDestistation(){
        return this.DestiStation;
    }

    public long getserialNum(){
        return this.serialNum;
    }

    public void setnumVehicles(int num){
        this.numVehicles = num;
    }

    public void setStartStation(String start){
        this.StartStation = start;
    }

    public void setDestistation(String finish){
        this.DestiStation = finish;
    }

    public boolean equals(Object x){
        if (x == null || this == null || !(x instanceof Train))
			return false;
		else
		{
			Train v = (Train)x;
			return (this.getnumWheels() == v.getnumWheels()
            && this.getmaxSpeed() == v.getmaxSpeed()
            && this.getnumVehicles() == v.getnumVehicles()
            && this.getStartStation() == v.getStartStation()
            && this.DestiStation == v.getDestistation());
		}


    }


}
