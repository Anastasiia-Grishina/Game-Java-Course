package bestgameever;

public class Book extends Item {
    int extraWisdom;
    
    // default constructor
    public Book(){
        super("Book", 0);
    }
    
    // detailed constructor    
    public Book( String name, int weight, int extraWisdom ){
        super(name, weight);
        this.extraWisdom = extraWisdom; 
    }
    
    public void use(Stats stats){
        stats.wisdom += this.extraWisdom;
        System.out.println("You have read a book " + super.getName());
        System.out.println("Your current wisdom is " + stats.wisdom);
    }
    
    @Override
    public String toString(){
        String s = "Wisdom bonus: " + this.extraWisdom;
        return s;
    }
}
