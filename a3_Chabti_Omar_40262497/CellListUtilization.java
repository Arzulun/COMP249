// -----------------------------------------------------
// Assignment 3
// Question: Driver with main method and testing
// Written by: Omar Chabti 40262497
// -----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CellListUtilization { 

    public static void main(String[] args) throws IOException {

        CellList list1 = new CellList();
        CellList list2 = new CellList();

          try (BufferedReader br = new BufferedReader(new FileReader("Cell_Info.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
               Scanner k = new Scanner(line);
               long tLong = k.nextLong();
               String tName = k.next();
               double tPrice = k.nextDouble();
               int tDate = k.nextInt();

                if(!list1.contains(tLong)){
               CellPhone temPhone = new CellPhone(tLong, tName, tDate, tPrice);
               list1.addToStart(temPhone);
                }else{
                    System.out.println("Phone with sn " + tLong + " already exists.");
                }
            }
            br.close();

            
          } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        list1.showContents();

        boolean more = true;
        Scanner KB = new Scanner(System.in);
        while(more){
            System.out.println();
            System.out.print("Enter a serial number that you'd like to search for: ");
            long sn = KB.nextLong();

            CellList.CellNode adress = list1.find(sn);

            if(!(adress==null))
            System.out.println("Found " + sn + " at " + adress);

            System.out.println("Would you like to search again?");
            String answer = KB.next();

            if(answer.equalsIgnoreCase("Yes")|| answer.equalsIgnoreCase("y")){
                continue;
            }else{
                more = false;
            }

        }
        
        

        CellPhone c1 = new CellPhone(1, "nokia", 2000, 100);
        CellPhone c2 = new CellPhone(2, "Apple", 2001, 20);
        CellPhone c3 = new CellPhone(3, "Samsung", 2003, 300);
        CellPhone c4 = new CellPhone(4, "L", 2004, 500);
        CellPhone c5 = new CellPhone(5, "K", 2005, 800);
        CellPhone c6 = new CellPhone(6, "o", 2006, 1250);

        list2.addToStart(c1);
        list2.addToStart(c2);
        list2.addToStart(c3);
        list2.addToStart(c4);
        list2.showContents();
        list2.insertAtIndex(c5, 3);
        System.out.println();
        System.out.println(list2.contains(4));
        list2.deleteFromIndex(2);
        System.out.println();
        list2.showContents();
        System.out.println();

        list2.deleteFromStart();
        list2.replaceAtIndex(c6, 2);
        System.out.println();
        list2.showContents();
        System.out.println();
        System.out.println(" Size: " + list2.getSize());

        CellList one = new CellList(list2);
     
        System.out.println("List 2 is:");
        list2.showContents();
        System.out.println();
        System.out.println("List one is:");
        one.showContents();
        System.out.println();
        System.out.println("Equal: " + one.equals(list2));

        System.out.println("Goodbye!");
    }

}