
package bestgameever;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int size;
    private int maxSize;
    private int currentWeight;
    private int maxWeight;

    public Inventory() {
        items = new ArrayList<>();
        this.maxSize = 100;
        this.maxWeight = 100;
        this.size = 0;
        this.currentWeight = 0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem( Item a ){
        // change the size of the list and the sum weight
        if (( this.currentWeight + a.getWeight() < this.maxWeight)&
                (this.size < this.maxSize)){
            this.size           += 1;
            this.currentWeight  += a.getWeight();
            items.add( a );
        if ( this.size > this.maxSize) {
              System.out.println("\n\n Your inventory is full");
            }
        }
        else{
            System.out.println("\n\nYour do not have space in your Inventory.");
            System.out.println("Current weight: " + this.currentWeight +
                    "\nItem weight: " + a.getWeight() +
                    "\nMax possible weight " + this.maxWeight);
            System.out.println("Items in Inventory: " + this.size +
                    " out of " + this.maxSize + ".\n\n");
        }
    }

    public void useItem( int num, Stats stats ){
        // receive a pointer to a chosen item of the list
        Item item = items.get(num);

        // pass the player`s statistics to useItem function
        item.use(stats);
        // if you eat food or drink potion, remove them from the list
        if ((item instanceof Food)||(item instanceof Potion)){
            items.remove(num);
            this.currentWeight  -=item.getWeight();
            this.size           -=1;
        }
    }

    public void deleteItem( int num ){
        items.remove(num);
    }

    public void showInventory() {
        // n - item index in a list
        int n = 0;
        // print the variables from item level here
        System.out.println("Inventory weight: " + this.currentWeight);
        System.out.println("Inventory size: " + this.size);
        // a loop of printing items with the help of override functions
        // (see inside every item realization)
        // BUT override function to_String does not allow to use "super"
        for( Item i : items ){
            System.out.println  ( "Item:" + n++ );
            System.out.println(i.getName() + "\n" + i +
                                "\nWeight: " + i.getWeight() + "\n");
        }
    }
    
    public int getSize() {
        return size;
    }

}
