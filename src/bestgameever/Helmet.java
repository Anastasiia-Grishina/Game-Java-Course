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
        System.out.println(" You will wield Helmet ;) ");

        if (stats.isHelmet()){
            unwield(stats);
        }
        else{
            wield(stats);
        }
    }

    public void wield(Stats stats){
        stats.setHelmet(true);
        stats.setBonus( stats.getBonus() + super.getExtraBonus());
        stats.setDefence(stats.getDefence() + super.getExtraDefence());
        System.out.print("You have wielded the Helmet :" + super.getName() );           
    }

   public void unwield(Stats stats){
       stats.setHelmet(false);
       stats.setBonus( stats.getBonus() - super.getExtraBonus());
       stats.setDefence(stats.getDefence() - super.getExtraDefence());
       System.out.print( "You have unwielded the Helmet :" + super.getName());
       System.out.print( "You have unwielded the armor :( " );
   }
}
