package bestgameever;

import java.util.ArrayList;

public class Player {
    private String race;
    private Inventory inventory;
    private Stats stats;

    // constructor
    Player( String race, int wisdom, int strength, int currentHealth){
        stats = new Stats( currentHealth, strength, wisdom );
        this.race = race;
        inventory = new Inventory();
    }
    
   public void addItem( Item a ){
        inventory.addItem(a);
    }

    public void useItem( int num ){
        inventory.useItem( num, this.stats );
    }

    public void deleteItem( int num ){
        inventory.deleteItem( num );
    }

    public void showInventory(){
        inventory.showInventory();
    }

    public void printPlayer(){
        System.out.println("Player\nRace: " + this.race);
        System.out.println(this.stats);
        inventory.showInventory();
        // tell a user if there are no items in a list
        if (this.inventory.getItems().isEmpty()){
            System.out.println("No items in stock.");
        }
    }

    public Inventory getInventory(){
        return inventory;
    }


}
