// -----------------------------------------------------
// Assignment 2
// Question: Most of all 3 parts
// Written by: Omar Chabti 40262497
// -----------------------------------------------------

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class filing {
    private static int lineNumber;
    private static String line;

   static String[] genreFileNames = {
        "Cartoons_Comics_Books.csv.txt",
        "Hobbies_Collectibles_Books.csv.txt",
        "Movies_TV.csv.txt",
        "Music_Radio_Books.csv.txt",
        "Nostalgia_Eclectic_Books.csv.txt",
        "Old_Time_Radio.csv.txt",
        "Sports_Sports_Memorabilia.csv.txt",
        "Trains_Planes_Automobiles.csv.txt" };

    public static void main(String[] args) {
        do_part1();
        do_part2();
        do_part3();
    }
 
    public static void do_part1(){
        String[] fileNames = readInputFileNames("part1_input_file_names.txt");

        if (fileNames != null){
      processCSVFiles(fileNames);
        }
    }

      public static String[] readInputFileNames(String fileName) {
        String[] fileNames = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read the number of file names (first line) since it's an integer
            int numFileNames = Integer.parseInt(br.readLine());
            fileNames = new String[numFileNames];

            // Read file names and store them in the array
            for (int i = 0; i < numFileNames; i++) {
                fileNames[i] = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileName + "\" not found");
            return null;
        } catch (IOException e) {
           writeErrorToFile("semantic_error_file.txt", "IO exception");
        } catch(NumberFormatException e){
            writeErrorToFile("syntax_error_file.txt", "Number format exception");
        }

        return fileNames;
    }

    private static boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }

    public static void processCSVFiles(String[] fileNames) {
        for (String fileName : fileNames) {

            if (!fileExists(fileName)) {
                writeErrorToFile ("semantic_error_file.txt","File \"" + fileName + "\" not found, skipping\n");
                continue; // Skip to the next file if the current one does not exist
            }

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                lineNumber = 0;

                while ((line = br.readLine()) != null) {
                    lineNumber++;

                    // Process the CSV line and validate
                 boolean isValid = validateCSVLine(line);

                    if (isValid){

                        String[] fields =  splitCSVLine(line);
                        String genre = fields[4];

                        switch (genre) {
                            case "CCB":
                                writeToFile("Cartoons_Comics_Books.csv.txt", line);
                                break;
                            case "HCB":
                                writeToFile("Hobbies_Collectibles_Books.csv.txt", line);
                                break;
                            case "MTV":
                                writeToFile("Movies_TV.csv.txt", line);
                                break;
                            case "MRB":
                                writeToFile("Music_Radio_Books.csv.txt", line);
                                break;
                            case "NEB":
                                writeToFile("Nostalgia_Eclectic_Books.csv.txt", line);
                                break;
                            case "OTR":
                                writeToFile("Old_Time_Radio.csv.txt", line);
                                break;
                            case "SSM":
                                writeToFile("Sports_Sports_Memorabilia.csv.txt", line);
                                break;
                            case "TPA":
                                writeToFile("Trains_Planes_Automobiles.csv.txt", line);
                                break;
                        }
                        
                    }
    
                }
            } catch (IOException e) {
                // Handle other IO exceptions
                writeErrorToFile("semantic_error_file.txt", e.getMessage());
            } catch (er.TooFewFieldsException | er.TooManyFieldsException | er.MissingFieldException | er.UnknownGenreException e) {
                handleSyntaxError(fileName, lineNumber, line, e.getMessage());                
            }catch (er.BadIsbn10Exception | er.BadIsbn13Exception | er.invalidISBN | er.BadPrice | er.BadYear e){
                handleSemanticError(fileName, lineNumber, fileName, e.getMessage());
            }
        }
    }
        public static void writeToFile(String fileName, String text) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                bw.write(text);
                bw.newLine();

            } catch (IOException e) {
                writeErrorToFile("semantic_error_file.txt", e.getMessage());
            }
        }

        public static void writeErrorToFile(String fileName, String error) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(error);
            bw.newLine();

        } catch (IOException e) {
            writeErrorToFile("semantic_error_file.txt", e.getMessage());
        }
    }

    public static boolean validateCSVLine(String line) throws er.TooManyFieldsException, er.TooFewFieldsException, er.MissingFieldException, er.UnknownGenreException,
    er.BadIsbn10Exception, er.BadIsbn13Exception, er.invalidISBN, er.BadPrice, er.BadYear{
        
        String[] fields = splitCSVLine(line);
        
        if (fields.length != 6) {
            if(fields.length <6){
            throw new er.TooFewFieldsException("too few fields"); 
            }else if(fields.length >6)
            throw new er.TooManyFieldsException();

            return false;
        }
    
        // Validate ISBN, price, and year
        if (!isValidPrice(fields[2]) || !isValidISBN(fields[3]) || !isValidGenre(fields[4]) || !isValidYear(fields[5])) {
            
            return false;
        }
    
        return true; 
    }

    

    private static String[] splitCSVLine(String line) {
        // This regex handles quoted fields containing commas
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static boolean isValidPrice(String p) throws er.BadPrice{
        
        try {
            double price = Double.parseDouble(p);
            if (price< 0.0){
                throw new er.BadPrice();
            }
            return (true);
        } catch (NumberFormatException e) {
            writeErrorToFile("semantic_error_file.txt", "Invalid Price, not a number");
            return false;
        }
    } 
    
    public static boolean isValidISBN(String isbn)throws er.BadIsbn10Exception, er.BadIsbn13Exception{
        try {
            if(isbn.length()==10){
                 int x1 = Character.getNumericValue(isbn.charAt(0));
                 int x2 = Character.getNumericValue(isbn.charAt(1));
                 int x3 = Character.getNumericValue(isbn.charAt(2));
                 int x4 = Character.getNumericValue(isbn.charAt(3));
                 int x5 = Character.getNumericValue(isbn.charAt(4));
                 int x6 = Character.getNumericValue(isbn.charAt(5));
                 int x7 = Character.getNumericValue(isbn.charAt(6));
                 int x8 = Character.getNumericValue(isbn.charAt(7));
                 int x9 = Character.getNumericValue(isbn.charAt(8));
                 int x10 = Character.getNumericValue(isbn.charAt(9));

                    long ISBN = (10*x1 + 9*x2 + 8*x3 + 7*x4 + 6*x5 + 5*x6 + 4*x7 + 3*x8 + 2*x9 + x10);
                    if (ISBN%11 != 0){
                       throw new er.BadIsbn10Exception();
                    }

                return (ISBN%11 ==0);

            }else if(isbn.length() == 13){
                int x1 = Character.getNumericValue(isbn.charAt(0));
                int x2 = Character.getNumericValue(isbn.charAt(1));
                int x3 = Character.getNumericValue(isbn.charAt(2));
                int x4 = Character.getNumericValue(isbn.charAt(3));
                int x5 = Character.getNumericValue(isbn.charAt(4));
                int x6 = Character.getNumericValue(isbn.charAt(5));
                int x7 = Character.getNumericValue(isbn.charAt(6));
                int x8 = Character.getNumericValue(isbn.charAt(7));
                int x9 = Character.getNumericValue(isbn.charAt(8));
                int x10 = Character.getNumericValue(isbn.charAt(9));
                int x11 = Character.getNumericValue(isbn.charAt(10));
                int x12 = Character.getNumericValue(isbn.charAt(11));
                int x13 = Character.getNumericValue(isbn.charAt(12));

                long ISBN =(x1 +3*x2 +x3 +3*x4 +x5 +3*x6 +x7 +3*x8 +x9 +3*x10 +x11 +3*x12 +x13);
                if (ISBN%10 != 0){
                       throw new er.BadIsbn13Exception();
                    }
            return (ISBN%10 == 0);
            } else{
                throw new er.invalidISBN();
            }

        } catch(NumberFormatException e){
            writeErrorToFile("syntax_error_file.txt", "Number format exception");
        } catch (Exception e) {
            writeErrorToFile("syntax_error_file.txt", e.getMessage());
        }
       
        return true;
    }

    public static boolean isValidGenre(String genre) throws er.UnknownGenreException{
        if ("CCB".equals(genre) || "HCB".equals(genre) || "MTV".equals(genre) || "MRB".equals(genre)
            || "NEB".equals(genre) || "OTR".equals(genre) || "SSM".equals(genre) || "TPA".equals(genre)) {
        return true;
    } else {
        throw new er.UnknownGenreException();
    }
}
   

    public static boolean isValidYear(String year)throws er.BadYear {
        if(Integer.parseInt(year) >= 1995 && Integer.parseInt(year)<= 2010)
        return true;
        else{
            throw new er.BadYear();
        }
    }

    public static void handleSyntaxError(String fileName, int lineNumber, String line, String errorMessage) {
        String error = "Syntax error in file: " + fileName + " at line " + lineNumber + "\n" +
                "====================\n" +
                "Error: " + errorMessage + "\n" +
                "Record: " + line +"\n";
        writeErrorToFile("syntax_error_file.txt", error);
    }
    public static void handleSemanticError(String fileName, int lineNumber, String line, String errorMessage) {
        String error = "Semantic error in file: " + fileName + " at line " + lineNumber + "\n" +
                "====================\n" +
                "Error: " + errorMessage + "\n" +
                "Record: " + line +"\n";
        writeErrorToFile("semantic_error_file.txt", error);
    }


//----------------------------------------------------------------------------------------------------------------------------------------------


public static void do_part2() {
        for (String fileName : genreFileNames) {    
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                Book[] books = new Book[1000];
                int bookIndex = 0;

                String line;
                int lineNumber = 0;

                while ((line = br.readLine()) != null) {
                    lineNumber++;

                    // Process the CSV line and validate semantically
                    try {
                        Book book = processCSVLineSemantically(line);
                        books[bookIndex++] = book;
                    } catch (er.BadIsbn10Exception | er.BadIsbn13Exception | er.invalidISBN | er.BadPrice | er.BadYear e) {
                        handleSemanticError(fileName, lineNumber, line, e.getMessage());
                    }
                }

                // Trim the array to the actual number of books
                Book[] trimmedBooks = Arrays.copyOfRange(books, 0, bookIndex);

                // Serialize the array of Book objects
                serializeBooks(trimmedBooks, fileName + ".ser");
            } catch (IOException e) {
                writeErrorToFile("semantic_error_file.txt", e.getMessage());
            }
        }
    }

    private static void serializeBooks(Book[] books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
        } catch (IOException e) {
            writeErrorToFile("semantic_error_file.txt", e.getMessage());
        }
    }


    private static Book processCSVLineSemantically(String line) throws er.BadIsbn10Exception, er.BadIsbn13Exception, er.invalidISBN,
     er.BadPrice, er.BadYear {

        String[] fields = splitCSVLine(line);
        String title = fields[0];
        String authors = fields[1];
        double price = Double.parseDouble(fields[2]);
        String isbn = fields[3];
        String genre = fields[4];
        int year = Integer.parseInt(fields[5]);

        return new Book(title, authors, price, isbn, genre, year);
    }


//----------------------------------------------------------------------------------------------------------------------------------------------

    public static void do_part3() {
        Scanner kb = new Scanner(System.in);
        Viewer viewer = new Viewer();
        while (true) {
            try {
                viewer.displayMainMenu();
                System.out.print("Enter Your Choice: ");
                char choice = kb.next().charAt(0);
                switch (Character.toUpperCase(choice)) {
                    case 'V':
                        viewer.viewSelectedFile();
                        break;
                    case 'S':
                        viewer.selectFile(genreFileNames);
                        break;
                    case 'X':
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Error reading input. Please try again.");
                kb.nextLine(); // Consume the remaining input to avoid an infinite loop
            }
        }
    }
    
}
