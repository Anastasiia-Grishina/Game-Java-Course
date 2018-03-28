package bestgameever;

public class Food extends Item {
    int extraHealth;
    int extraStrength;
    
    // default constructor
    Food(){
        super("food", 0);
        this.extraHealth = 0;
        this.extraStrength = 0;
    }
    
    // detailed constructor
    Food(String name, int weight, int extraHealth, int extraStrength){
        super(name, weight);
        this.extraHealth = extraHealth;
        this.extraStrength = extraStrength;
    } 
    
    // use and change stats
    public void use(Stats stats){
        stats.currentHealth += extraHealth;
        stats.strength += extraStrength;
        if ( stats.currentHealth > stats.maxHealth ){
            stats.currentHealth = stats.maxHealth;
        } 
        System.out.println("You have eaten "+ super.getName() +
                "\nYour current health is " + stats.currentHealth +
                "\nYour strength is " + stats.strength);
    }
    
    @Override
    public String toString(){
        String s = "Health bonus: " + this.extraHealth + 
                "\nStrength bonus: " + this.extraStrength;
        return s;
    }
}
