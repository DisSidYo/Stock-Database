import java.util.*;
public class WarehouseFrontEnd{
    static int ch = 0;
    static String id;
            static String name;
            static int q;
    
    public static void main(String args[])
    {
       
        
        System.out.println("Welcome to the warehouse!");
       
       loop();
       
    }
    public static void menu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Print current stock.");
        System.out.println("2. Add an item to the inventory.");
        System.out.println("3. Remove an item from the inventory.");
        System.out.println("4. Add stock to an item.");
        System.out.println("5. Sell an item.");
        System.out.println("6. Exit the system.");
        

    }
    public static void prompt(){
        System.out.print("Enter the number of your choice: ");

    }
    public static void loop()  {
         StockDatabase sd = new StockDatabase();
         
         Scanner sc = new Scanner(System.in);
          menu();
            prompt();
        
        do{
           
            ch=sc.nextInt();
            
            switch (ch)
            {
                case 1:
                
                System.out.print(sd.toString());
               
                menu();
                prompt();
                break;
                case 2:
                System.out.print("Enter new item id: ");
                id=sc.next();
                 System.out.print("Enter new item name: ");
                name=sc.next();
                 System.out.print("Enter initial quantity: ");
                q=sc.nextInt();
                Item i = new Item(id, name, q);
                try {
                sd.addItem(i);

                
                
                

               
                }
                catch (DuplicateItemIDException e){
                    System.err.println("An item with that ID already exists.");
                    
                }
                menu();
                    prompt();
                break;
                case 3:
               System.out.print("Enter item id: ");
                id=sc.next();
                
                sd.removeItem(id);
                menu();
                prompt();
                
                
                

                break;
                case 4:
                System.out.print("Enter item id: ");
                id=sc.next();
                
                 System.out.print("Enter additional quantity to add: ");
                q=sc.nextInt();
                
                try {
                sd.restock(id, q);

                
                
                

                menu();
                prompt();
                }
                catch (ItemNotFoundException e){
                    System.err.println("There is no item with that ID in the warehouse.");
                    menu();
                    prompt();
                }

                  catch (InvalidQuantityException e){
                    System.err.println("You cannot stock that quantity.");
                    menu();
                    prompt();
                }                
                break;
                case 5:
                 System.out.print("Enter item id: ");
                id=sc.next();
                
                 System.out.print("Enter quantity to sell: ");
                q=sc.nextInt();
                
                try {
                sd.sell(id, q);

                
                
                

                menu();
                prompt();
                }
                catch (ItemNotFoundException e){
                    System.err.println("There is no item with that ID in the warehouse.");
                    menu();
                    prompt();
                }

                  catch (InvalidQuantityException e){
                    System.err.println("You cannot sell that quantity.");
                    menu();
                    prompt();
                }                
                break;

               


                case 6:
                System.out.println("Bye!");
                System.exit(0);
                break;

                
            }
        }while(ch>=1 && ch<=6);
    }
    
}
