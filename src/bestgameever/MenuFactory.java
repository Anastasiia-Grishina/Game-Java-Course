package bestgameever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MenuFactory {
    private static MenuFactory menuFactory;

    // private constructor
    private MenuFactory(){};

    // initialization + gettting instance/pointer to the class
    public static MenuFactory getInstance(){
        if (menuFactory == null){
            menuFactory = new MenuFactory();
            return (menuFactory);
        }
        else{
            return (menuFactory);
        }
    }
    
    // different menus - printing only
    
    public static void printMenu(){
        System.out.println( "\nChoose option you would like to do:" );
        System.out.println( "\t1) Create a player" );
        System.out.println( "\t2) Print a player" );
        System.out.println( "\t3) Delete a player" );
        System.out.println( "\t4) Play with items" );        
        System.out.println( "\t0) Quit" );
    }
    
    public static void printPlayWithItemsMenu(){
        System.out.println("\nChoose option you would like to do:");
        System.out.println( "\t1) Add an item" );
        System.out.println( "\t2) Delete an item" );
        System.out.println( "\t3) Show your items" );
        System.out.println( "\t4) Use an item" ); 
        System.out.println( "\t0) Back to player menu");
    }

    public static void printItemsMenu(){
        System.out.println("\nChoose your new item: ");
        System.out.println( "\t1) Armor" );
        System.out.println( "\t2) Potion" );
        System.out.println( "\t3) Food" );
        System.out.println( "\t4) Book" );
        System.out.println( "\t0) Back to play with items menu");
    }
    
    public static void printArmorMenu(){
            System.out.println("\nChoose your armor type: ");
            System.out.println("\t1) Chest armor");
            System.out.println("\t2) Helmet");
    }
    
    // function to get an integer number from a user
    public static int getChoice(){
        // line to read
        String line;
        // two additional variables
        Scanner scan;
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
        
        // actual choice to return
        int choice;
        
        // do until an answer is integer
        while( true ){
            System.out.print( "Choice: " );
            try {
                // read and chack if it is integer
                line = reader.readLine();
                scan = new Scanner( line );
                choice = scan.nextInt();
                //Scanner scans only until it encounters space so second check
                //is needed for cases like "123 asd"
                if( !scan.hasNext())
                    break;
            } catch (IOException ex) {
                // exception: could not read
                System.err.println( "Error in reading input!" );
                choice = 0;
            } catch (Exception ex ){
                // excepion: not integer
                System.err.println( "Error in input!" );
            }
        }        
        return choice;
    }
    
    // function requires to get an integer from a user console
    // which is between 0 and "max"
    // choice string = tells a user what he/she is choosing
    public static int enterNum(String choiceString, int max){
        String line;
        Scanner scan;
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
        // num = required integer
        int num;
        do{
            System.out.println(choiceString);
            System.out.print( "This parameter should be between 0 and " + 
                    max + ": " );
            try {
                line = reader.readLine();
                scan = new Scanner( line );
                // check if the input is integer
                // if not assign num = -1 to pass the next if-statement corectly
                num = scan.hasNextInt() ? scan.nextInt() : -1;
                // check if num is within the range [0; max]
                if( num < 0 || num > max )
                    System.out.println( "Incorrect input." );
                else
                    break;
            } catch (IOException ex) {
                System.err.println( "Error in reading input!" );
            }            
        } while( true );
        return (num);       
    }
    
    
    public static Player createPlayer() {
        // auxiliary string variable
        String line;
        // future characteristics of a player
        String race;
        int currentHealth;
        int wisdom;
        int strength;
        // auxiliary vars
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
        
        //Technically same as while-loop but the condition is evaluated at end.
        do{
            System.out.print( "\nChoose race: elf, ork, dwarf, human: " );
            try {
                line            = reader.readLine();
                // create a list of predefined races
                Set racesList   = new HashSet<String>();
                racesList.add ("elf");
                racesList.add ("ork");
                racesList.add ("dwarf");
                racesList.add ("human");

                // check if input race is in the list
                if ( racesList.contains( line.toLowerCase() ) ){
                    race = line.toLowerCase();
                    break;
                }
                else{
                    System.out.println("Wrong race choice! Please, try again");                                    
                }
            } catch (IOException ex) {
                System.err.println( "Error in reading input!" );
            }
        } while( true );
        String choiceString;

        // parameters should be within an interval [0; 10?]
        choiceString    = "\nChoose wisdom.";
        wisdom          = enterNum(choiceString, 10);

        choiceString    = "\nChoose current health.";
        currentHealth   = enterNum(choiceString, 10);

        choiceString    = "\nChoose strength.";
        strength        = enterNum(choiceString, 10);
        return new Player( race, wisdom, strength, currentHealth );
    }

    public static Item createItem(){
        // choose from the menu
        printItemsMenu();
        int choice      = getChoice();
          
        // future item
        Item newItem    = null;
        int weight      = 0;    
        
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
        switch ( choice ){
            // 1 = armor
            case 1:
                weight          = enterNum( "\nChoose weight: ", 24);
                int defence     = enterNum( "\nChoose defence: ", 10);
                int extraBonus  = enterNum( "\nChoose extra bonus: ", 10);
                
                // choose between chest armor and helmet
                printArmorMenu();
                
                int armorChoice = 0;
                while (0==armorChoice){
                    armorChoice = getChoice();
                    if ((armorChoice!=1)&(armorChoice!=2)){
                        armorChoice = 0;
                    }
                }
                
                // assign item name according to user choice
                String name = (armorChoice == 1)? "Chest armor": "Helmet";
                // create a corresponding type of armor
                newItem     = (armorChoice == 1)? new ChestArmor(name, weight, 
                                defence, extraBonus): new Helmet(name, weight, 
                                defence, extraBonus);
                // it writes "added", but truly the item is only created, not added yet
                System.out.println( "You have added " + name + " to your stock.");
                break;
            // 2 = portion
            case 2:
                // default name
                name        = "Potion";
                // user can assign anouther name
                System.out.println("\nChoose type of potion (any string): ");
                try{
                    name    = reader.readLine();
                } catch (IOException ex) {
                System.err.println( "Error in reading input!" );
                }
                
                weight              = enterNum( "\nChoose weight: ", 24);
                int extraHealth     = enterNum( "\nChoose health points "
                        + "by potion type: ", 10);
                int extraStrength   = enterNum( "\nChoose strength points"
                        + " by potion type: ", 10);
                int extraWisdom     = enterNum( "\nChoose wisdom points "
                        + "by potion type: ", 10);
                
                // create an item
                newItem             = new Potion( name, weight, extraHealth, 
                        extraStrength, extraWisdom);
                System.out.println( "You have added " + name + " to your stock.");
                break;
            // 3 = food
            case 3:
                // default name
                name            = "Food";
                // another name if needed
                System.out.println("\nChoose type of food (any string): ");
                try{
                    name        = reader.readLine();
                } catch (IOException ex) {
                System.err.println( "Error in reading input!" );
                }  
                
                weight          = enterNum( "\nChoose weight: ", 24);
                extraHealth     = enterNum( "\nChoose health points "
                        + "by food type: ", 10);
                extraStrength   = enterNum( "\nChoose strength points "
                        + "by food type: ", 10);
                
                newItem         = new Food(name, weight, extraHealth, 
                        extraStrength);
                break;
            // 4 = book
            case 4:
                name            = "Book";
                
                System.out.println("\nChoose type of book (any string): ");
                try{
                    name = reader.readLine();
                } catch (IOException ex) {
                System.err.println( "Error in reading input!" );
                }  
                weight          = enterNum( "\nChoose weight: ", 24);
                extraWisdom     = enterNum( "\nChoose wisdom points "
                        + "by book type: ", 10);
                newItem         = new Book( name, weight, extraWisdom );
                break;
            case 0:
                break;
            default:
                System.err.println( "Wrong choice!\n" );
        }
        return newItem;
    }
}