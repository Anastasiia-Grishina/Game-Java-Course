/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestgameever;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public abstract class Item {
<<<<<<< HEAD
    private String name;
    private int weight;
//    private String description;
//    private float value;
    
    // constructor
    public Item( String name, int weight ){
//( String name, String desc, float val ){
        this.name = name;
        this.weight = weight;
//        this.description = desc;
//        this.value = val;
=======
    public String name;
    public String description;
    public float value;
    
    public Item(String name, String desc, float val){
       this.name = name;
       this.description = desc;
       this.value = val;      
>>>>>>> 7420929050f36bf30af9d0e624d9df17382b3992
    }
    
    // this function is used inside inventory.useItem(num, stats)
    // the item is already called by its num in the list, only stats needed
    public void use (Stats stats){
        // if any function is not realized in a class which inherits item class:
        System.out.println("Function currently unavailable");
    };

<<<<<<< HEAD
    public int getWeight() {
        return weight;
    }

    public String getName() {return name;}

//    public String getDescription() { return description;}
//    public float getValue() { return value;}
    
    // just in case, if realizations of the class do not have override funciton
    @Override
    public String toString(){
    return "\n" + name;
    }
    
   
=======
    public String getName() { return name;}

    public String getDescription() {return description; }

    public float getValue() { return value; }
    
    public void examineItem(){
            System.out.println(name);
            System.out.println(description);
            System.out.println(value);
    }
    
    // Remember that when you print something with System.out.println() function, you are implicitly using 
    // toString() when you have parameters that are not String as an input. 
    @Override
    public String toString(){
       return "Item:\n" + name + "\n" + description + "\n" + value;
    }
    
    // I can ovverride in Armor. 
>>>>>>> 7420929050f36bf30af9d0e624d9df17382b3992
}
