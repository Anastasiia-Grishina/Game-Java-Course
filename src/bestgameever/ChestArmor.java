package bestgameever;

public class ChestArmor extends Armor {
    // detailed constructor
    public ChestArmor( String name, int weight, int defence, int extraBonus ){
        super(name, weight, defence, extraBonus);
    }

    public void use(Stats stats){
<<<<<<< HEAD
        System.out.println(" You will wield Chest Armor ;) ");
        System.out.println(" You will wield Chest Armor ;) ");
        System.out.println("here in chest armor");
        if (stats.isChestArmor()){
            unwield(stats);
        }
        else{
            wield(stats);
        }
    }

    // when a user uses the armor for the next time,
    // he/she changes the state of "wearing an armor"
    public void wield(Stats stats){
        stats.setChestArmor(true);
        stats.setBonus(stats.getBonus() + super.getExtraBonus());
        stats.setDefence(stats.getDefence() + super.getExtraDefence());
        System.out.print("You have wielded the Chest Armor : " + super.getName() );
=======
        System.out.print("You have wielded the Armor :)" );            
>>>>>>> master
>>>>>>> origin/Jose
    }

   public void unwield(Stats stats){
       stats.setChestArmor(false);
<<<<<<< HEAD
       stats.setBonus(stats.getBonus() - super.getExtraBonus());
       stats.setDefence(stats.getDefence() - super.getExtraDefence());
       System.out.print("You have wielded the Chest Armor : " + super.getName() );
=======
<<<<<<< HEAD
       stats.setBonus(stats.getBonus() - super.getExtraBonus());
       stats.setDefence(stats.getDefence() - super.getExtraDefence());
       System.out.print("You have wielded the Chest Armor : " + super.getName() );
=======
       System.out.print("You have unwielded the armor :( ");
>>>>>>> master
>>>>>>> origin/Jose
   }
}
