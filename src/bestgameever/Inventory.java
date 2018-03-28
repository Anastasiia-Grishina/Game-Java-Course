
package bestgameever;


import java.util.ArrayList;

<<<<<<< HEAD
public class Inventory {
    private ArrayList<Item> items;
    private int size;
    private int maxSize;
    private int currentWeight;
    private int maxWeight;

    public Inventory() {
=======
/**
 *
 * @author José
 */
public class Inventory {
    private ArrayList<Item> items;
    
    public Inventory() { 
>>>>>>> 7420929050f36bf30af9d0e624d9df17382b3992
        items = new ArrayList<>();
        this.maxSize = 24;
        this.maxWeight = 24;
        this.size = 0;
        this.currentWeight = 0;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
<<<<<<< HEAD
    public void addItem( Item a ){
        // change the size of the list and the sum weight
        if ( this.currentWeight + a.getWeight() < this.maxWeight){
            this.size += 1;
            this.currentWeight += a.getWeight();
            items.add( a );
        }
        else{
            System.out.println("\n\nYour do not have space in your stock.");
            System.out.println("Current weight: " + this.currentWeight + 
                    "\nItem weight: " + a.getWeight() + 
                    "\nMax possible weight " + this.maxWeight);
            System.out.println("Items in stock: " + this.size + 
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
            this.currentWeight-=item.getWeight();
            this.size -=1;
        }
    }
    
    public void deleteItem( int num ){
        items.remove(num);
    }

    void showInventory() {
        // n - item index in a list
        int n = 0;
        // print the variables from item level here
        System.out.println("Inventory weight: " + this.currentWeight);
        System.out.println("Inventory size: " + this.size);
        // a loop of printing items with the help of override functions 
        // (see inside every item realization)
        // BUT override function to_String does not allow to use "super"
        for( Item i : items ){
            System.out.println( "Item:" + n++ );
            System.out.println(i.getName() + "\n" + i + 
                "\nWeight: " + i.getWeight() + "\n");
        }
=======
    public void addItem(Item x){
        items.add(x);
    }
    
    public void showInventory(){
            int n = 1;
            for( Item i : items ){
                System.out.println( "Item:" + n++ );
                System.out.println( i + "\n"); // This is the reason we use @override command in items class.
            }
>>>>>>> 7420929050f36bf30af9d0e624d9df17382b3992
    }

    public int getSize() {
        return size;
    }
    
 }

