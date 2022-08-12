// scripted by Rashaad Lee Hue-Joseph - INFO 0201 - Final Assignment
// 

import java.util.Scanner; // library to get inputs
import java.util.ArrayList; // library to use ArrayLists
import java.util.InputMismatchException; // library to use this Exception

public class HardwareGoods{
    // instance fields
    protected int reorderLev;
    protected ArrayList<String> hardwareGoods;
    protected ArrayList<Integer> hardwareGoodsID;
    protected ArrayList<Integer> hardwareGoodsReorder;
    protected String name;
    protected int id;
    protected int reorder;



    public HardwareGoods(){ // default constructor
        reorderLev = 10; // determing the reorder level for this inventory
        hardwareGoods = new ArrayList<>(); // initializing the arraylists, if you don't then the terminal will tell you that the array is null
        hardwareGoodsID = new ArrayList<>(); // ^
        hardwareGoodsReorder = new ArrayList<>(); // ^

    }

    public HardwareGoods(int reorderLev, String name, int id, int reorder){ // mutator constructor
        this.reorderLev = reorderLev; // using the this() for better code
        this.id = id;
        this.name = name;
        this.reorder = reorder;
    }

    public void addToInventory(Scanner input){ // method to add to inventory

        Scanner input_data = new Scanner(System.in); // initializing the input function

        System.out.println("------------------------------\n");


        try{
            System.out.print("Enter the Unique ID: ");
            id = input.nextInt(); // storing the input in the integer
            System.out.println();

            System.out.print("Enter the Hardware Good: ");
            name = input_data.nextLine(); // storing the input in the String // also nextLine reads however long the String is, for example, if it were to be .next(), only one word would be recognized
            System.out.println();

            System.out.print("Enter the reorder level: ");
            reorder = input.nextInt(); // storing the input in the Integer
            System.out.println();

            hardwareGoodsID.add(id); // adding the user input's to the arraylist
            hardwareGoods.add(name); // adding the user input's to the arraylist
            hardwareGoodsReorder.add(reorder); // adding the user input's to the arraylist

            System.out.println("Successfully entered.");

        } catch (InputMismatchException e){ // if the user decides to input letters within the int, this message will pop up
            System.out.println("\nCannot add characteer to the ID or Reorder Level.\nPlease try again.\n");
        }
        input.nextLine(); // clears buffer and continues like normal

        System.out.println("\n------------------------------\n");



    }

    public void removeFromInventory(Scanner input){ // method to remove from inventory

        System.out.println("------------------------------");


        System.out.print("Enter the Hardware Good ID: ");
        id = input.nextInt(); 
        System.out.println();

        int size = hardwareGoodsID.size(); // getting the size of the arraylist and putting it into a local int variable

        try{
            for (int i = 0; i < size; i++){
                if (hardwareGoodsID.get(i) == id){ // if the id is found within the arraylist, the code below will work
                    hardwareGoodsID.remove(i); // this is how to remove an index from said arraylist.
                    hardwareGoods.remove(i); // ^
                    hardwareGoodsReorder.remove(i); // ^
                    System.out.println("Successfully deleted.");
                } 
            }
            System.out.println("ID not found.\nPlease try again.\n"); // if id is not found, this message will pop up.
        } catch (Exception e){ // the exception here is, "IndexOutOfBoundsException", at first it seemed like a problem but it was just a small bug.
            System.out.println();
        }

        System.out.print("------------------------------\n");



    }

    public void updateInventory(Scanner input){

        System.out.println("------------------------------\n");
        Scanner input_data = new Scanner(System.in);
        int new_id; // local variable
        String new_name; // local variable
        int new_reorder; // local variable

        try{
            System.out.print("Enter ID to update: ");
            id = input.nextInt();
            System.out.println();

            int i;
            int size = hardwareGoodsID.size(); 

            System.out.print("Enter new ID: ");
            new_id = input.nextInt(); // new id will be placed into this variable
            System.out.println();

            System.out.print("Enter new Garden Good: ");
            new_name = input_data.nextLine(); // new name will be replaced into this variable
            System.out.println();

            System.out.print("Enter new Reorder Level: ");
            new_reorder = input.nextInt(); // new reorder level will be replaced into this variable
            System.out.println();


            for (i = 0; i < size; i++){
                if (hardwareGoodsID.get(i) == id){ // if id is found, the code below will work
                    hardwareGoodsID.set(i, new_id); // in order to update arraylists, we use the arraylist.set() method. i = index, new_id = variable
                    hardwareGoods.set(i, new_name); // ^
                    hardwareGoodsReorder.set(i, new_reorder); // ^
                    System.out.println("Successfully Updated.\n");
                }
            }    
        } catch (InputMismatchException e){ // if the user inputs letters for id or reorder, this error message will pop up
            System.out.println("\nCannot add characters to the ID or Reorder Level.\nPlease try again.\n");
        }
        input.nextLine(); // clears buffer and acts normal
        System.out.println("------------------------------\n");

    }

    public void viewInventory(){ // method to view the Inventory

        System.out.println("------------------------------\n");

        int size = hardwareGoodsID.size();

        System.out.printf("%s %13s %24s", "Unique ID", "Name", "Reorder Level\n\n"); // we can use the C/C++ string placements for a cleaner output
        for (int i = 0; i < size; i++){
            System.out.printf("%d %18s %22d\n\n", hardwareGoodsID.get(i), hardwareGoods.get(i), hardwareGoodsReorder.get(i));
            // depending on the size of the arraylist, all the data inputted will be outputted in a table format/
        }

        System.out.println("------------------------------\n");

    }

    public void itemsToOrder(){ // method to view Items to Order

        System.out.println("------------------------------\n");

        int size = hardwareGoodsID.size();

        System.out.println("Items to Order\n");
        System.out.printf("%s %13s %24s\n\n", "Unique ID", "Name", "Reorder Level");
        for (int i = 0; i < size; i++){
            if (hardwareGoodsReorder.get(i) <= reorderLev){ // the Hardware Goods reorderLev = 10, if the reorder from the good is less or equal to it, then it will display here
                System.out.printf("%d %18s %22d\n\n", hardwareGoodsID.get(i), hardwareGoods.get(i), hardwareGoodsReorder.get(i));
            }
        }   

        System.out.println("------------------------------\n");


    }

}