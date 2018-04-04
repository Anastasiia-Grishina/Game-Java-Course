
package bestgameever;
//hello world
public class BestGameEver {
    
    public static void main(String[] args) {
        // variable to read the menu choice
        int choice = 100;
        // future player pointer
        Player player = null;
        // string tellin what to choose now
        String choiceString;
        //additional class with menu functions
        MenuFactory menu = MenuFactory.getInstance();
        
        // do while a user does not want to stop (0=quit)
        while ( 0 != choice ){
            
            // starting menu deals with the player 
            // (create, print, delete, do sth with items)
            menu.printMenu();
            // read input in the form of integer
            choice = menu.getChoice();
            
            // choice cases
            switch ( choice ){
                // 1 = create player
                case 1 :
                    player = menu.createPlayer();     
                    // tell about an unsuccessful creation
                    System.out.println( player == null ? "Creation failed!\n" : 
                            "New player created!\n" );
                    break;
                // 2 = print a player
                case 2 : 
                    // do not print a player if it has not been created yet
                    if ( player == null ){
                        System.out.println("A player does not exist!\n");
                    }
                    else
                        // print existing player
                        player.printPlayer();
                    break;
                case 3 :
                    // delete an existing player and report about that
                    System.out.println( player == null ? "There is no player!\n" : 
                            "Player deleted\n" );
                    
                    // just delete once again to be on the safe side
                    player = null;
                    break;
                case 4 :
                    // 4 = play with items if a player exists
                    if ( player == null ){
                        System.out.println("A player does not exist\n");
                    }
                    else
                    {
                        // print items actions menu (add, delete, show, use 
                        menu.printPlayWithItemsMenu();
                        // use another choice variable not to lose 
                        // the previous choice of an upper level menu
                        int choicePlayItems = menu.getChoice();
                        // realize choices
                        switch ( choicePlayItems ){     
                            // 1 = add item
                            case 1 :
                                // ask which item to create
                                menu.printItemsMenu();
                                // create and add items
                                Item a = menu.createItem();
                                player.addItem(a);
                                break;
                            // 2 = delete an item
                            case 2 :
                                // show items first
                                System.out.println("Your items: ");
                                player.showInventory();
                                // remember current items list size
                                int currentSize = player.getInventory().getItems().size();
                                
                                // if items exist (size > 0), 
                                // choose number of an item from a list to delete
                                if (currentSize > 0){
                                    choiceString = "Choose item number to delete: ";
                                    // this number will be chosen out of 0..size-1 indices
                                    int num = menu.enterNum( choiceString, 
                                            currentSize-1);
                                    // delete
                                    player.deleteItem(num);
                                }
                                else{
                                    System.out.println("No items to delete!\n");
                                }
                                break;
                            // 3 = show items
                            case 3 :
                                player.showInventory();
                                break;
                            // 4 = use an item
                            case 4 :
                                // print a list of items to know their indices
                                System.out.println("Your items: ");
                                player.showInventory();
                                // remember the size
                                currentSize = player.getInventory().getSize();
                                // use an item if any items exist
                                if (currentSize > 0){
                                    // item is again chosen by its position in a list
                                    choiceString = "Choose item number to use";
                                    int num = menu.enterNum( choiceString,
                                            currentSize-1);
                                    player.useItem(num);
                                }
                                else{
                                    System.out.println("No items to use!\n");
                                }
                                break;
                            // 0 = quit the menu of playing with items
                            case 0:
                                break;
                            default:
                                System.err.println( "Wrong choice!\n" );  
                        }
                    }
                    break;
                // 0 = quit the game
                case 0:
                    break;
                default:
                    System.err.println( "Wrong choice!\n" );    
            }
        }
    }
    
    
    /*
        //1.2f - f means that the number is expressed as float (4bytes) instead of double (8bytes)
        Item a = new Weapon( "Axe", "Some description", 1.2f, 42 );
        //If we want to use a as weapon, we have to cast it
        Weapon b = (Weapon)a;
        Player p = new Player();
        //Weapon is also item, so addItem() can be used on it
        p.addItem(a);
        try {
            BufferedReader reader = new BufferedReader( new FileReader( "data/weapons.csv" ));
            String line[];
            String wholeLine;
            //Here we read the "nameline" away
            reader.readLine();
            while( true ){
                wholeLine = reader.readLine();
                if( wholeLine == null )
                       break;
                line = wholeLine.split( "," );
                p.addItem(  new Weapon( line[0], line[1], Float.valueOf( line[2] ), Integer.valueOf( line[3])));
            }
            p.printItems();
            p.getInventory().printItems();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BestGameEver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex ){
            System.out.println("asdsadds");
        }
        */
    /*
    public useItem( int num ){
        Item item = inventory.getItem( num );
        if( item != null ){
            if( item instanceof Weapon ){
                Weapon a = (Weapon)item;
                a.attack();
            } else if( item instanceof Armor ){
                Armor a = (Armor)item;
                a.equip();
            }
        }
    }
    */
}
