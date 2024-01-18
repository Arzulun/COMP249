// -----------------------------------------------------
// Assignment 2
// Question: Part of all 3 parts
// Written by: Omar Chabti 40262497
// -----------------------------------------------------


public class er extends Exception{

    
    public  static class invalidISBN extends Exception{
    
        public invalidISBN(){
            super("Invalid ISBN");
        }

        public invalidISBN(String message){
            super(message);
        }
    }

    public static class BadIsbn10Exception extends Exception{
        public BadIsbn10Exception(){
            super("Bad ISBN-10");
        }
        public BadIsbn10Exception(String message){
            super(message);
        }
    }

    public static class BadIsbn13Exception extends Exception{
        public BadIsbn13Exception(){
            super("Bad ISBN-13");
        }
        public BadIsbn13Exception(String message){
            super(message);
        }
    }

    public static class BadPrice extends Exception{
        public BadPrice(){
            super("Bad Price");
        }
        public BadPrice(String message){
            super(message);
        }
    }

    public static class BadYear extends Exception{
        public BadYear(){
            super("Bad year");
        }
        public BadYear(String message){
            super(message);
        }
    }

    public static class TooManyFieldsException extends Exception {
        public TooManyFieldsException(String message) {
            super(message);
        }
        public TooManyFieldsException(){
            super("Too many fields");
        }
    }

    public static class TooFewFieldsException extends Exception {
        public TooFewFieldsException(String message) {
            super(message);
        }
        public TooFewFieldsException(){
            super("Too few fields");
        }
    }

    public static class MissingFieldException extends Exception {
        public MissingFieldException(String message) {
            super(message);
        }
        public MissingFieldException(){
            super("Missing field");
        }
    }

    public static class UnknownGenreException extends Exception {
        public UnknownGenreException(String message) {
            super(message);
        }
        public UnknownGenreException(){
            super("Unknown genre");
        }        
    }


}
