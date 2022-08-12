// scripted by Rashaad Lee Hue-Joseph - 16-11-21

// child class


import java.util.Scanner;
import java.util.InputMismatchException;

class Conversion extends ConversionBase {

    // child class (Conversion) of parent class (ConversionBase)
    Conversion(){
        super();
        // this super acts like a constructor method
    }

    Conversion(int original_base, int new_base, String number_converted, int num_converted){
        super(original_base, new_base, number_converted, num_converted);
        // this super acts like a constructor method
    }

    // Note: Anytime you are converting to Decimal, you can use an easy trick by using the Integer.parseInt() function
    // Another Note: toBinaryString(), toHexString(), toOctalString() are all helpful when using these conversions

    public void subOriginalBase(Scanner input){ // improvisation

        System.out.print("Enter the original base here: ");
        original_base = input.nextInt();
        System.out.println();

    }

    public void subNewBase(Scanner input){ // improvisation

        System.out.print("Enter the new base here: ");
        new_base = input.nextInt();
        System.out.println();

    }

    public void menuOption(Scanner input){ // improvisation

        boolean confirm = true; // bool data type
        do{
            try{
                // submenuOption(input);   
                if (confirm == true){ // this asks the user to enter the input and if the values are not correct, it loop until it is
                    subOriginalBase(input);
                    if (original_base < 2 || original_base > 16){
                        System.out.println("Input must be a Base Number (2, 8, 10, 16)\n");
                        do{
                            subOriginalBase(input);
                        } while (original_base < 2 || original_base > 16);
                    }

                    subNewBase(input);
                    if (new_base < 2 || new_base > 16){
                        System.out.println("Input must be a Base number (2, 8, 10, 16)\n");
                        do{
                            subNewBase(input);
                        } while (new_base < 2 || new_base > 16);
                    }

                    if (original_base == 10){
                        System.out.print("Enter the number to be converted here: ");
                        num_converted = input.nextInt();
            
                        System.out.println();
                    } else {
                        System.out.print("Enter the number to be converted here: ");
                        number_converted = input.next();
            
                        System.out.println();
                    }
                }
            } catch (InputMismatchException e){ // NOTE: even though this exception is here, only the bases that support letters will still work. For example-- Hexadecimal
                System.out.println("\nInput must be a Base number");
            }
            // input.nextLine();
            input.nextLine(); // clears the buffer from the try-catch statement
        } while (confirm != true);
       

    }

    public void BinaryToDecimal(){ // 2 to 10

        int decimal = Integer.parseInt(number_converted, original_base);

        System.out.println("Answer is: " + decimal);
        
    }

    public void DecimalToBinary(){ // 10 to 2

        int binary[] = new int[8];
        int index = 0;
        int decimal = num_converted;

        while (decimal > 0)
        {
            binary[index++] = decimal % new_base;
            decimal = decimal / new_base;
        }
        System.out.print("Answer is: ");
        for (int i = index - 1; i >= 0; i--){
            System.out.print(binary[i]);
        }
        
        System.out.println();
        
    }

    public void DecimalToOctal(){ // 10 to 8

        int decimal = num_converted;
        int remainder;
        String octal = "";
        char octals[] = {'0', '1', '2','3', '4' ,'5', '6', '7'};

        while (decimal > 0 ){
            remainder = decimal % new_base;
            octal = octals[remainder] + octal;
            decimal = decimal / new_base;
        }
        System.out.println("Answer is: " + octal);
        System.out.println();

    }

    public void OctalToDecimal(){ // 8 to 10

        int decimal = Integer.parseInt(number_converted, original_base);

        System.out.println("Answer is: " + decimal);
    }

    public void BinaryToOctal(){ // 2 to 8

        int decimal = Integer.parseInt(number_converted, original_base);
        String octalNumber = Integer.toOctalString(decimal);

        System.out.println("Answer is: " + octalNumber);
    }

    public void BinaryToHexadecimal(){ // 2 to 16

        int decimal = Integer.parseInt(number_converted, original_base);
        String HexNumber = Integer.toHexString(decimal);

        System.out.println("Answer is: " + HexNumber);
    }

    public void OctalToBinary(){ // 8 to 2

        int decimal = Integer.parseInt(number_converted, original_base);
        String binaryNumber = Integer.toBinaryString(decimal);

        System.out.println("Answer is: " + binaryNumber);
    }

    public void OctalToHexadecimal(){ // 8 to 16

        int decimal = Integer.parseInt(number_converted, original_base);
        String hexNumber = Integer.toHexString(decimal);

        System.out.println("Answer is: " + hexNumber);
    }

    public void DecimalToHexadecimal(){ // 10 to 16

        int decimal = num_converted;
        int remainder;
        String hex = "";
        char hexa[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (decimal > 0 ){
            remainder = decimal % new_base;
            hex = hexa[remainder] + hex;
            decimal = decimal / new_base;
        }
        System.out.println("Answer is: " + hex);
        System.out.println();
    }

    public void HexadecimalToBinary(){ // 16 to 2

        int decimal = Integer.parseInt(number_converted, original_base);
        String binary = Integer.toBinaryString(decimal);

        System.out.println("Answer is: " + binary);
        System.out.println();
    }

    public void HexadecimalToOctal(){ // 16 to 8

        int decimal = Integer.parseInt(number_converted, original_base);
        String octal = Integer.toOctalString(decimal);

        System.out.println("Answer is: " + octal);
    }

    public void HexadecimalToDecimal(){ // 16 to 10

        int decimal = Integer.parseInt(number_converted, original_base);

        System.out.println("Answer is: " + decimal); 
    }

    // Note: Anytime you are converting to Decimal, you can use an easy trick by using the Integer.parseInt() function
    // Another Note: toBinaryString(), toHexString(), toOctalString() are all helpful when using these conversions


    public void prompt(){

        char option = '\0';
        do{
            Scanner input = new Scanner(System.in);
            menuOption(input);

            if (original_base == 2 && new_base == 10) { // 2 to 10 if statement

                BinaryToDecimal(); 

            } else if (original_base == 10 && new_base == 2){ // 10 to 2 if statement

                DecimalToBinary();

            } else if (original_base == 10 && new_base == 8){ // 10 to 8 if statement

                DecimalToOctal();

            } else if (original_base == 8 && new_base == 10){ // 8 to 10 if statement

                OctalToDecimal();

            } else if (original_base == 16 && new_base == 10){ // 16 to 10 if statement

                HexadecimalToDecimal();

            } else if (original_base == 10 && new_base == 16){ // 10 to 16 if statement

                DecimalToHexadecimal();

            } else if (original_base == 16 && new_base == 2){ // 16 to 2 if statement

                HexadecimalToBinary();

            } else if (original_base == 16 && new_base == 8){ // 16 to 8 if statement

                HexadecimalToOctal();

            } else if (original_base == 2 && new_base == 8){ // 2 to 8 if statement

                BinaryToOctal();

            } else if (original_base == 2 && new_base == 16){ // 2 to 16 if statement

                BinaryToHexadecimal();

            } else if (original_base == 8 && new_base == 2){ // 8 to 2 if statement

                OctalToBinary();

            } else if (original_base == 8 && new_base == 16){ // 8 to 16 if statement

                OctalToHexadecimal();

            } else if ((original_base <= 3 || original_base >= 7) || (original_base == 9) || (original_base <= 11 || original_base >= 15)) {
                System.out.println("Please try again");
                System.out.println();
            } else if ((new_base <= 3 || new_base >= 7) || (new_base == 9) || (new_base <= 11 || new_base >= 15)){
                System.out.println("Please try again");
                System.out.println();
            } else {
                System.out.println(); // new line
            }

            System.out.print("Do you want to do another conversion? (Y/N): ");
            option = input.next().charAt(0); // Scanner input for char variables
            System.out.println();
            if (option == 'N'|| option == 'n'){ // if N or n, the program will end 
                System.out.println("\n\nCreated by R.L.H");
                System.exit(0);
            }
        } while (option != 'N' || option != 'n');
    }

}