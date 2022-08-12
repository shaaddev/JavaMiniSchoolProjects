// scripted by Rashaad Lee Hue-Joseph - INFO 0201 - Assignment 3 - Exceptions

// inheritance method
// parent class

public class ConversionBase{
    // instance fields
    int original_base;
    int new_base;
    String number_converted; 
    int num_converted;

    public ConversionBase(){ // default constructor

    }

    public ConversionBase(int original_base, int new_base, String number_converted, int num_converted){ // mutator constructor
        this.original_base = original_base;
        this.new_base = new_base;
        this.number_converted = number_converted;
        this.num_converted = num_converted;
    }


    public void Menu(){ // calling the child class Conversion

        Conversion test = new Conversion();

        test.prompt();
    }

    public static void main(String[] args){
        ConversionBase calling = new ConversionBase();

        System.out.println();
        calling.Menu();
    }

}

// Tried many tests and got a java.lang.NullPointerException
// this was my only solution