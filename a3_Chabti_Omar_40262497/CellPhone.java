// -----------------------------------------------------
// Assignment 3
// Question: CellPhone class and all it's needed methods
// Written by: Omar Chabti 40262497
// -----------------------------------------------------
import java.util.Scanner;

//This is just the CellPhone class with it's constructors and methods the same way we've been doing it all semester

public class CellPhone {

    private long serialNum;
    private static long counter = 1000;
    private String brand;
    private int year;
    private double price;


    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public CellPhone(CellPhone c, long serialNum){
        this.serialNum = serialNum;
        this.brand = c.brand;
        this.year = c.year;
        this.price = c.price;

    }

    public CellPhone clone(){
        Scanner k = new Scanner(System.in);

        System.out.print("Please enter a new serial number: ");
        long a = k.nextLong();

        CellPhone c = new CellPhone(this, a);
        
        return c;
    }

    public String toString() {
        return "[ " + serialNum + ": " + brand + " " + price + "$ " + year + "] --->";
    }

    public boolean equals(CellPhone c){
        return(this.brand == c.brand && this.year == c.year &&
        this.price == c.price);
    }
    
    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public static long getCounter() {
        return counter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}