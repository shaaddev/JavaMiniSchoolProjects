// scripted by Rashaad Lee Hue-Joseph - 10-09-21

import java.util.InputMismatchException; // if input doesn't equal data type, the try catch statement will be useful
import java.util.Scanner;   // input
import java.time.LocalDate; // represents a date
import java.time.Period;    // finds the duration between two times
import java.time.DateTimeException; // used to indicate a problem with calculating date-time

public class computeAge{
    // instance fields
    int year;   
    int month;
    int day;

    public computeAge(){ // defualt constructor

    }

    public computeAge(int year, int month, int day){ // mutator constructor
        this.year = year;  // this == can be used to invoke the current class constructor
        this.month = month; // ^^
        this.day = day; // ^^
    }

    public void year(Scanner input){

        int current_year = LocalDate.now().getYear(); // getting the current year to use with the if statement
        
        try{ // try catch statement used here to notify the user when the input is mismatched
            do{
                System.out.print("Enter the year you were born: ");
                year = input.nextInt();
                System.out.println();

                    if (year > current_year){
                        // System.out.println("Input must be no more than 1999\n");
                        System.out.println("Input cannot be passed the current year\n");
                    } else if (year < 1800){
                        System.out.println("input must be at least 1800\n");
                    } else {
                        // System.out.println();
                    }
                

            } while(year < 1800 || year > current_year); // || logical OR used here
        } catch (InputMismatchException e){
            System.out.println("\nInput was not an integer.\nProgram will end here.\nHave a nice day!\n");
            System.exit(0);
        }
    }

    public void month(Scanner month_input){
        
        try{ // try catch statement used here to notify the user that input must be an integer and must not be typed out
            do{
                System.out.print("Enter the month you were born(1-12): ");
                month = month_input.nextInt();
                System.out.println();

                if (month < 1 && month > 12){
                    System.out.println("Error\nPlease enter the correct month number.\n");
                } 

            } while(month < 1 || month > 12);   
        } catch (InputMismatchException e){
            System.out.println("\nInput must not be a string\nProgram will end here.\nHave a nice day!\n");
            System.exit(0);
        }
    }

    public void day(Scanner day_input){

        try{ // try catch statement used here to let the user know that the input must be between 1-31

            System.out.print("Enter the day you were born: ");
            day = day_input.nextInt();
            System.out.println();

        } catch (DateTimeException ex){
            System.out.println("This year is not a leap year or Day doesn't exist.\nProgram will end here.\nHave a nice day!");
            System.exit(0);
        }


    }

    public void prompt(){ // temporary main
        Scanner input = new Scanner(System.in);
        Scanner month_input = new Scanner(System.in);
        Scanner day_input = new Scanner(System.in);

        LocalDate currentDate = LocalDate.now(); // to find the current date, use function LocalDate.now() // to set specific date, use LocalDate.of(0, 0, 0)
        
        year(input);  // calling the method
        month(month_input); // ^^
        day(day_input); // ^^

        LocalDate birthDate = LocalDate.of(year, month, day);
        year = Period.between(birthDate, currentDate).getYears(); // getting the years between birthdate and current date
        month = Period.between(birthDate, currentDate).getMonths(); // getting the months between birthdate and current date
        day = Period.between(birthDate, currentDate).getDays(); // getting the days betweeen birthdate and current date


        System.out.println("Current date: " + currentDate);
        System.out.println("Date of birth: " + birthDate);
        System.out.println("You are " + year + " years, " + month + " months, and " + day + " days old\n\n");

    }

    public static void main(String[] args){
        computeAge test = new computeAge();

        System.out.println();
        test.prompt();
    }

}