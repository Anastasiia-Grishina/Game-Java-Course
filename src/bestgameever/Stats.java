/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestgameever;

/**
 *
 * @author aagri
 */
public class Stats {
    int currentHealth;
    int maxHealth;
    int strength;
    int wisdom;
    int bonus;
    boolean helmet;
    boolean chestArmor;
    
    public Stats( int currentHealth, int strength, int wisdom){
        this.currentHealth  = currentHealth;
        this.maxHealth      = 10;
        this.strength       = strength;
        this.wisdom         = wisdom;
        this.bonus          = 0;
        this.helmet         = false;    // false when a player is not wearing it
        this.chestArmor     = false;
    }

    // when a player is printed, this function is used
    @Override
    public String toString(){
        String s = "Wisdom: " + this.wisdom + "\nStrength: " + 
                this.strength + "\nCurrent health: " + 
                this.currentHealth + " out of maximum " +
                this.maxHealth + "\nBonuses: " + this.bonus;
        
        s       += (this.helmet) ? "\nHelmet is on" : "\nHelmet is off.";
        s       += (this.chestArmor) ? "\nChest armor is on" : 
                "\nChest armor is off.";
        
        return s;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHelath() {
        return maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public boolean isHelmet() {
        return helmet;
    }

    public boolean isChestArmor() {
        return chestArmor;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public void setChestArmor(boolean chestArmor) {
        this.chestArmor = chestArmor;
    }
    
    
}
