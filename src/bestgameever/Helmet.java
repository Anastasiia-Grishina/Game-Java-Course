/*
package bestgameever;


public class Helmet extends Armor {
    private int strength;


}
*/
package bestgameever;

/**
 *
 * @author Usuario
 */
public class Helmet extends Armor {
    // detailed constructor
    public Helmet( String name, int weight, int defence, int extraBonus ){
        super(name, weight, defence, extraBonus);
    }

    // when a user uses the armor for the next time,
    // he/she changes the state of "wearing an armor"
    public void use(Stats stats){
        if (stats.chestArmor){
            unwield(stats);
        }
        else{
            wield(stats);
        }
    }

    public void wield(Stats stats){
        stats.helmet = true;
        stats.defence += super.getDefence();
        stats.bonus += super.getExtraBonus();
        System.out.print("You have wielded the " + super.getName() );
    }

   public void unwield(Stats stats){
       stats.helmet = false;
       stats.defence -= super.getDefence();
       stats.bonus -= super.getExtraBonus();
       System.out.print("You have unwielded the " + super.getName() );
   }
}
