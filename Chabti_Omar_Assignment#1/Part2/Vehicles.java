//-------------------------------------
// Assignemnt 1
// Question: Part 2
// Written by: Omar Chabti 40262497
//------------------------------------


package Part2;

public class Vehicles {
    protected long serialNum;
    private static int counter = 0;

    public Vehicles(){
        this.serialNum = counter;
        counter++;
    }
    
    public Vehicles(Vehicles otherVehicles){
        this.serialNum = counter;
        counter++;     
    }

    public long getserialNum(){
        return this.serialNum;
    }
    public String toString(){
        return "Class: Vehicles\nSerial Number: " + this.serialNum;
    }
    
}
