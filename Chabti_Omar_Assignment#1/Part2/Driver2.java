//-------------------------------------
// Assignemnt 1
// Question: Part 2
// Written by: Omar Chabti 40262497
//------------------------------------

package Part2;
import Boats.Ferry;
import Metro.Metro;
import MonoWheel.MonoWheel;
import Planes.Aircraft;
import Planes.WWIIAirplane;
import RailwayTransport.Train;
import RailwayTransport.Tram;
import WheeledTransportation.WheeledTransportation;


public class Driver2 {
    
    public static Vehicles[] copyTheObjects(Vehicles[] array){
        
        Vehicles[] coppyArray = new Vehicles[array.length];

        for (int i= 0; i < coppyArray.length; i++){

            coppyArray[i] = new Vehicles(array[i]);
        }

        return coppyArray;

    }

    public static void displayArray(Vehicles[] array){
    

        for (int i = 0; i< array.length; i++) {

        System.out.println(i + ".   " + array[i]);

// I got the following error whenever I tried using the getClass() method so I opted to just display the object using the already written
// toString methods instead
//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "array[i]" is null
        }
    }

    public static void main(String[] args){

        Vehicles[] mixList3 = new Vehicles[17];

    mixList3[1]= new WheeledTransportation(4, 350);
    mixList3[2] = new Train(16, 500, 8, "Metrocity", "Starling");
    mixList3[3] = new Tram(20, 250, 5, "5th avenue", "10th avenue", 5, 1987);
    mixList3[4] = new Metro();
    mixList3[5] = new MonoWheel(1, 100, 80);
    mixList3[6] = new Ferry();
    mixList3[7] = new Aircraft(7000, 5700);
    mixList3[8] = new WWIIAirplane(5, 8000, false); 
    mixList3[9] = new Train();
    mixList3[10] = new Ferry(350, 8000);
    mixList3[11] = new Aircraft(9000, 5400);
    mixList3[12] = new Metro();
    mixList3[13] = new WWIIAirplane(700, 5800, true);
    mixList3[14] = new Aircraft(10, 100);
    mixList3[15]= new Tram();
    mixList3[16] = new Aircraft(5500, 900);


    Vehicles[] CopierList3 = copyTheObjects(mixList3);

    displayArray(mixList3);

    displayArray(CopierList3);




    }

    

}
