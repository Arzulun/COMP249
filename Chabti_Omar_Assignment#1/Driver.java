//-------------------------------------
// Assignemnt 1
// Question: Part 1
// Written by: Omar Chabti 40262497
//------------------------------------

import Boats.Ferry;
import Metro.Metro;
import MonoWheel.MonoWheel;
import Planes.Aircraft;
import Planes.WWIIAirplane;
import RailwayTransport.Train;
import RailwayTransport.Tram;
import WheeledTransportation.WheeledTransportation;

public class Driver {
    
public static void findLeastAndMostExpensiveAircraft(Object[] aircrafts){
    Aircraft mostExpensive = null;
    Aircraft leastExpensive = null;

        for (Object obj : aircrafts){
            if (obj instanceof Aircraft){
                Aircraft aircraft = (Aircraft) obj;

                if (leastExpensive == null || aircraft.getPrice() < leastExpensive.getPrice()){
                    leastExpensive = aircraft;
                }

                if (mostExpensive == null || aircraft.getPrice() > mostExpensive.getPrice()){
                    mostExpensive = aircraft;
                }

            }
        }

        if (leastExpensive != null && mostExpensive != null){
            System.out.println("Least Expensive Aircraft:");
            System.err.println(leastExpensive);

            System.out.println("Most Expensive Aircraft");
            System.out.println(mostExpensive);
        }else {
            System.out.println("There are no aircrafts in this array.");
        }
}
public static void main(String[] args){

    WheeledTransportation Autobot = new WheeledTransportation(4, 400);

    WheeledTransportation Decepticon = new WheeledTransportation(Autobot);
    Decepticon.setmaxSpeed(450);

    System.out.println("Autobot:");
    System.out.println(Autobot);

    System.out.println("Decepticon:");
    System.out.println(Decepticon);

    System.out.println("Autobot equals Decepticon:");
    System.out.println(Autobot.equals(Decepticon));

    WheeledTransportation Thomas = new Train(16, 700, 10, "Ottawa", "Montreal");
    Train Percy = new Train((Train)Thomas);

    System.out.println("Percy:");
    System.out.println(Percy);

    System.out.println("Thomas:");
    System.out.println(Thomas);

    System.out.println("Thomas equals Percy:");
    System.out.println(Thomas.equals(Percy));

    System.out.println("Percy equals Autobot");
    System.out.println(Percy.equals(Autobot));

    System.out.print("Next train serial number: ");
    System.out.println(Thomas.getNextSerialNumber());

    Metro STMO = new Metro(24, 450, 20, "Montmorency", "Cote Vertu", 30);
    Metro STMB = new Metro(STMO);

    STMB.setStartStation("Snowdon");
    STMB.setDestistation("Saint Michel");
    STMB.SetnumStops(11);

    System.out.println("STMO: ");
    System.out.println(STMO);

    System.out.println("STMB: ");
    System.out.println(STMB);

    MonoWheel UNI = new MonoWheel(1, 150, 120);
    WheeledTransportation Cycle = new MonoWheel(UNI);

    System.out.print("UNI equals Cycle:" );
    System.out.println(UNI.equals(Cycle));

    System.out.print("Cycle equals UNI:");
    System.out.println(Cycle.equals(UNI));

    Ferry Titanic = new Ferry(400, 15000);
    Ferry Gate = new Ferry();

    System.out.println("Titanic:");
    System.out.println(Titanic);

    System.out.println("Gate:");
    System.out.println(Gate);

    Aircraft Batwing = new Aircraft(10000, 9000);
    Aircraft Helicarier = new Aircraft();
    Helicarier.setMaxElevation(8000);
    Helicarier.setPrice(98000);

    System.out.println("Hellicarier:");
    System.out.println(Helicarier);

    System.out.println("Batwing: ");
    System.out.println(Batwing);

    System.out.println("Next Aircraft serial number : " + Batwing.getNextSerialNumber());
    Aircraft tester = new Aircraft();

    WWIIAirplane P1 = new WWIIAirplane(9500, 600, true);
    WWIIAirplane P2 = new WWIIAirplane(P1);

    Aircraft P3 = new WWIIAirplane();

    System.out.println("P1: ");
    System.out.println(P1);

    System.out.println("P2:");
    System.out.println(P2);

    System.out.println("P3: ");
    System.out.println(P3);

    System.out.println("Tester: ");
    System.out.println(tester);

    System.out.println("P3 equals tester: "); 
    System.out.println(P3.equals(tester));

    System.out.println("Tester equals p3: ");
    System.out.println(tester.equals(P3));

// ---------------------------------------------------------------------------------------------------------------------------------------

Object[] mixList1 = new Object[17];

    mixList1[1]= new WheeledTransportation();
    mixList1[2] = new Train();
    mixList1[3] = new Tram();
    mixList1[4] = new Metro();
    mixList1[5] = new MonoWheel();
    mixList1[6] = new Ferry();
    mixList1[7] = new Aircraft(7000, 5700);
    mixList1[8] = new WWIIAirplane(5, 8000, false); // least expensive
    mixList1[9] = new Train();
    mixList1[10] = new Ferry();
    mixList1[11] = new Aircraft(9000, 5400); // most expensive
    mixList1[12] = new Metro();
    mixList1[13] = new WWIIAirplane(700, 5800, true);
    mixList1[14] = new Aircraft(10, 100);
    mixList1    [15]= new Tram();
    mixList1[16] = new Aircraft(5500, 900);


System.out.println("Most and Least expensive aircrafts in List 1:");    
findLeastAndMostExpensiveAircraft(mixList1);

Object[] mixList2 = new Object[16];

    mixList2[1]= new WheeledTransportation();
    mixList2[2] = new Train();
    mixList2[3] = new Tram();
    mixList2[4] = new Metro();
    mixList2[5] = new MonoWheel();
    mixList2[6] = new Ferry();
    mixList2[7] = new Tram();
    mixList2[8] = new Metro();
    mixList2[9] = new MonoWheel();
    mixList2[10]= new WheeledTransportation();
    mixList2[11] = new Train();
    mixList2[12]= new WheeledTransportation();
    mixList2[13] = new Train();
    mixList2[14] = new Tram();
    mixList2[15] = new Metro();

System.out.println("Most and Least expensive Aircrafts in list 2: ");
    findLeastAndMostExpensiveAircraft(mixList2);
}


}
