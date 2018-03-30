package bestgameever;

public class ChestArmor extends Armor {
    // detailed constructor
    public ChestArmor( String name, int weight, int defence, int extraBonus ){
        super(name, weight, defence, extraBonus);
    }

    public void use(Stats stats){
        System.out.println("here in chest armor");
        if (stats.chestArmor){
            unwield(stats);
        }
        else{
            wield(stats);
        }
    }

    // when a user uses the armor for the next time,
    // he/she changes the state of "wearing an armor"
    public void wield(Stats stats){
        stats.chestArmor = true;
        stats.defence += super.getDefence();
        stats.bonus += super.getExtraBonus();
        System.out.print("You have wielded the " + super.getName() );
    }

   public void unwield(Stats stats){
       stats.chestArmor = false;
       stats.defence -= super.getDefence();
       stats.bonus -= super.getExtraBonus();
       System.out.print("You have unwielded the armor " + super.getName() );
   }
}
