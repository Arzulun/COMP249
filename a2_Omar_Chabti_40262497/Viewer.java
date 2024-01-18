// -----------------------------------------------------
// Assignment 2
// Question: part 3 (partially)
// Written by: Omar Chabti 40262497
// -----------------------------------------------------

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Viewer implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Book[][] bookArrays;
    private int currentArrayIndex;
    private int currentObjectIndex;

    static String[] genreFileNames = {
        "Cartoons_Comics_Books.csv.txt",
        "Hobbies_Collectibles_Books.csv.txt",
        "Movies_TV.csv.txt",
        "Music_Radio_Books.csv.txt",
        "Nostalgia_Eclectic_Books.csv.txt",
        "Old_Time_Radio.csv.txt",
        "Sports_Sports_Memorabilia.csv.txt",
        "Trains_Planes_Automobiles.csv.txt" };


    public Viewer() {
        // Initialize the book arrays and set the initial indices
        bookArrays = new Book[8][];
        currentArrayIndex = 0;
        currentObjectIndex = 0;

        // Load Book arrays from binary files
        loadBookArrays();
    }

    public void displayMainMenu() {
        System.out.println("-------------------------------");
        System.out.println("Main Menu");
        System.out.println("-------------------------------");
        System.out.println("v View the selected file");
        System.out.println("s Select a file to view");
        System.out.println("x Exit");
        System.out.println("-------------------------------");
    }
        
    public void loadBookArrays() {
        try {
            for (int i = 0; i < bookArrays.length; i++) {
                String fileName =genreFileNames[i] + ".ser";
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    bookArrays[i] = (Book[]) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    public void viewSelectedFile() {
        displayCurrentObject();
        Scanner kb = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.print("Enter your choice (+n or -n to navigate, 0 to exit): ");
            int choice = kb.nextInt();
            kb.nextLine(); // Consume newline

            if (choice == 0) {
                exit = true;
            } else {
                navigate(choice);
                displayCurrentObject();
            }
        }


    }

    public void selectFile(String[] binaryFileNames) {
        Scanner kb = new Scanner(System.in);

        System.out.println("-------------------------------");
        System.out.println("File Sub-Menu");
        System.out.println("-------------------------------");

        for (int i = 0; i < binaryFileNames.length; i++) {
            System.out.println((i + 1) + " " + binaryFileNames[i] + " (" + (bookArrays[i] != null ? bookArrays[i].length : 0) + " records)");
        }

        System.out.println(9 + " Exit");
        System.out.println("-------------------------------");

        System.out.print("Enter Your Choice: ");
        int choice = kb.nextInt();
        kb.nextLine(); // Consume newline

        if (choice > 0 && choice <= binaryFileNames.length) {
            currentArrayIndex = choice - 1;
            currentObjectIndex = 0;
            System.out.println("Selected file: " + binaryFileNames[currentArrayIndex]);
        } else if (choice == binaryFileNames.length + 1) {
            // Exit
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

    
    }

    public void displayCurrentObject() {
        if (bookArrays[currentArrayIndex] != null && currentObjectIndex >= 0 && currentObjectIndex < bookArrays[currentArrayIndex].length) {
            Book currentBook = bookArrays[currentArrayIndex][currentObjectIndex];
            System.out.println("Viewing: " + currentBook.toString());
        } else {
            System.out.println("No records to display.");
        }
    }

    public void navigate(int n) {
        int newIndex = currentObjectIndex + n;

        if (bookArrays[currentArrayIndex] != null) {
            if (newIndex >= 0 && newIndex < bookArrays[currentArrayIndex].length) {
                currentObjectIndex = newIndex;
            } else if (newIndex < 0) {
                System.out.println("BOF has been reached.");
                currentObjectIndex = 0;
            } else {
                System.out.println("EOF has been reached.");
                currentObjectIndex = bookArrays[currentArrayIndex].length - 1;
            }
        }
    }    
}

