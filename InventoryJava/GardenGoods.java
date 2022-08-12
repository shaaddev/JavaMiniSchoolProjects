// scripted by Rashaad Lee Hue-Joseph - INFO 0201 - Final Assignment

import java.util.Scanner; // library to get inputs
import java.util.ArrayList; // library to use ArrayLists
import java.util.InputMismatchException; // library to use this Exception

public class GardenGoods{
    // instance fields
    protected int reorderLev;
    protected ArrayList<String> gardenGoods;
    protected ArrayList<Integer> gardenGoodsID;
    protected ArrayList<Integer> gardenGoodsReorder;
    protected String name;
    protected int id;
    protected int Reorder;

    public GardenGoods(){ // default constructor
        reorderLev = 7; // determining the reorder level for this inventory
        gardenGoods = new ArrayList<>(); // initializing the arraylists, if you don't then the terminal will tell you that the array is null
        gardenGoodsID = new ArrayList<>(); // ^
        gardenGoodsReorder = new ArrayList<>(); // ^

    }

    public GardenGoods(int reorderLev, String name, int id, int Reorder){ // mutator constructor
        this.reorderLev = reorderLev; // using the this() for better code
        this.id = id;
        this.name = name;
        this.Reorder = Reorder;
    }

    public void addToInventory(Scanner input){ // method to add to Inventory

        Scanner input_data = new Scanner(System.in);

        System.out.println("------------------------------\n");


        try{
            System.out.print("Enter the Unique ID: ");
            id = input.nextInt(); //  
            System.out.println();

            System.out.print("Enter the Garden Good: ");
            name = input_data.nextLine(); //
            System.out.println();

            System.out.print("Enter the reorder level: ");
            Reorder = input.nextInt(); //
            System.out.println();

            gardenGoodsID.add(id); //
            gardenGoods.add(name);
            gardenGoodsReorder.add(Reorder);
        
            System.out.println("Successfully entered.");

        } catch (InputMismatchException e){ // 
            System.out.println("\nCannot add characters to the ID or Reorder Level.\nPlease try again.\n");
            
        }
        input.nextLine();
        System.out.println("\n------------------------------\n");

    }

    public void removeFromInventory(Scanner input){

        System.out.println("------------------------------");

        System.out.print("Enter the Garden Good ID: ");
        name = input.nextLine();
        System.out.println();

        int size = gardenGoodsID.size();
        int i;

        try{
            for (i = 0; i < size; i++){
                if (gardenGoodsID.get(i) == id){
                    gardenGoodsID.remove(i);
                    gardenGoods.remove(i);
                    gardenGoodsReorder.remove(i);
                    System.out.println("Successfully deleted.");
                } 
            }
            System.out.println("ID not found.\nPlease try again.\n");     
        } catch (Exception e){
            System.out.println();
        }

        System.out.println("------------------------------\n");


    }

    public void updateInventory(Scanner input){

        System.out.println("------------------------------\n");
        Scanner input_data = new Scanner(System.in);
        int new_id;
        String new_name;
        int new_reorder;

        try{
            System.out.print("Enter ID to update: ");
            id = input.nextInt();
            System.out.println();

            int i;
            int size = gardenGoodsID.size();

            System.out.print("Enter new ID: ");
            new_id = input.nextInt();
            System.out.println();

            System.out.print("Enter new Garden Good: ");
            new_name = input_data.nextLine();
            System.out.println();

            System.out.print("Enter new Reorder Level: ");
            new_reorder = input.nextInt();
            System.out.println();


            for (i = 0; i < size; i++){
                if (gardenGoodsID.get(i) == id){
                    gardenGoodsID.set(i, new_id);
                    gardenGoods.set(i, new_name);
                    gardenGoodsReorder.set(i, new_reorder);
                    System.out.println("Successfully Updated.\n");
                }
            }    
        } catch (InputMismatchException e){
            System.out.println("\nCannot add characters to the ID or Reorder Level.\nPlease try again.\n");
        }
        input.nextLine();
        System.out.println("------------------------------\n");

    }

    public void viewInventory(){

        System.out.println("------------------------------");

        int size = gardenGoodsID.size();

        System.out.println();
        System.out.printf("%s %13s %24s", "Unique ID", "Name", "Reorder Level\n\n");
        
        for (int i = 0; i < size; i++){
            System.out.printf("%d %18s %22d\n\n", gardenGoodsID.get(i), gardenGoods.get(i), gardenGoodsReorder.get(i));
        }   

        System.out.println("------------------------------\n");


    }

    public void itemsToOrder(){

        System.out.println("------------------------------\n");

        int size = gardenGoodsReorder.size();

        System.out.println("Items to Order\n");
        System.out.printf("%s %13s %24s\n\n", "Unique ID", "Name", "Reorder Level");
        for (int i = 0; i < size; i++){
            if (gardenGoodsReorder.get(i) <= reorderLev){
                System.out.printf("%d %18s %22d\n\n", gardenGoodsID.get(i), gardenGoods.get(i), gardenGoodsReorder.get(i));
            }
        }   

        System.out.println("------------------------------\n");


    }
    
} 