/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestgameever;

/**
 *
 * @author roman
 */
public class Weapon extends Item {
    
    private int damage;
    
    public Weapon( String name, String desc, float val, int damage ){
        super( name, desc, val );
        this.damage = damage;
    }
    
    public void Attack(){
        System.out.println("Attacking");
    }
    
}
