// scripted by Rashaad Lee Hue-Joseph - INFO 0201 - Final Assignment
// parent class
// since HardwareGoods.java and GardenGoods.java basically do the same thing, I have only commented on HardwareGoods.javas

import java.util.Scanner; // library to get user inputss

public class test{
    // instance fields
    protected String goods;


    public test(){ // default mutator

    }

    public test(String goods){
        this.goods = goods; // using this for better code
    }

    public void Goods(){  

        Scanner input = new Scanner(System.in);
        boolean confirm = true; // boolean data type to check if something is true or false

        do{ // do while loop to start the main
            Scanner input_data = new Scanner(System.in);
            System.out.print("State whether to add Garden Goods or Hardware Goods: ");
            goods = input.nextLine(); // storing the input into this variable
            System.out.println();

            if(confirm == true){ // if the goods statements are true then the do while loop will break else...
                if (goods.equals("Garden Goods")){

                    gardenMenu(input_data); // calling the Menu of Garden Goods, if the input is correct

                } else if(goods.equals("Hardware Goods")){

                    hardwareMenu(input_data); // calling the Menu of Hardware Goods, if the input is correct

                } else if (confirm != true){

                    System.out.println();

                }
                System.out.println("Error\nWrong input.\nPlease try either 'Hardware Goods' or 'Garden Goods' \n"); // ...else this is would display as an error message
            }
        
        } while (confirm == true);    
    }

    
    public void hardwareMenu(Scanner input){ // method for initializing the menu background

        Scanner input_data = new Scanner(System.in);
        int choice; // local
        mainmenu call = new mainmenu(); // initializing the mainmenu class
        HardwareGoods calling = new HardwareGoods(); // initializing the HardwareGoods class
        

        do{

            call.Menu1(); // calling the Menu screen
            System.out.print("Input: ");
            choice = input.nextInt(); 
            System.out.println();


            switch(choice){ // if the choice is one of the cases below, code will be called
                case 1:
                    calling.addToInventory(input_data); // calling the addToInventory from the HardwareGoods class
                    break;
                case 2:
                    calling.removeFromInventory(input_data); // calling the removeFromInventory from the HardwareGoods class
                    break;
                case 3:
                    calling.updateInventory(input_data); // calling the updateInventory from the HardwareGoods class
                    break;
                case 4:
                    calling.viewInventory(); // calling the viewInventory from the HardwareGoods class
                    break;
                case 5:
                    calling.itemsToOrder(); // calling the itemsToOrder from the HardwareGoods class
                    break;
                case 0: // if the user inputs 0, the code will end.
                    System.out.println("Have a nice day\nCreated by shaaaaaad.\n"); 
                    System.exit(0); // disables the code in the terminal
                    break;
                default: // default message
                    System.out.println("\nWrong input\nPlease try again\n");
                    break;
            }
        } while (choice != 0);
    }

    public void gardenMenu(Scanner input){ // method for initializing the menu background

        Scanner input_data = new Scanner(System.in);
        int choice; // local
        mainmenu call = new mainmenu(); // initializing the mainmenu class
        GardenGoods calling = new GardenGoods(); // initializing the GardenGoods class
        
        

        do{
            call.Menu2(); // calling the menu of Garden Goods from the mainmenu class
            System.out.print("Input: ");
            choice = input.nextInt();
            System.out.println();

        
            switch(choice){ // if the choice is one of the cases below, the case will be called.
                case 1:
                    calling.addToInventory(input_data); // calling the addToInventory from GardenGoods class
                    break;
                case 2:
                    calling.removeFromInventory(input_data); // calling the removeFromInventory from GardenGoods class
                    break;
                case 3:
                    calling.updateInventory(input_data); // calling the updateInventory from GardenGoods class
                    break;
                case 4:
                    calling.viewInventory(); // calling the viewInventory from GardenGoods class
                    break;
                case 5:
                    calling.itemsToOrder(); // calling the itemsToOrder from GardenGoods class
                    break;
                case 0: // if the user inputs 0, the code will end.
                    System.out.println("\n\nHave a nice day\nCreated by shaaaaaad.\n");
                    System.exit(0); // disables the code from the terminal
                    break;
                default: // default messages
                    System.out.println("\nWrong input\nPlease try again\n");
                    break;
            }
        } while (choice != 0);
    }
}