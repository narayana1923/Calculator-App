import java.util.*;
class GroceryList {
    int price1;
    String quantity1;
    GroceryList(String q, int p) {
        price1 = p;
        quantity1 = q;
    }
}

public class Grocery {
    public static void main(String args[]){
        String name,quantity;
        int price,budget;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter your Budget: ");
        budget=scan.nextInt();
        int option=2;
        HashMap<String,GroceryList> h=new HashMap<String,GroceryList>();
        do{
            System.out.print("1. Add an item\n2. Exit\nEnter your choice: ");
            option=scan.nextInt();
            scan.nextLine();
            if(option==1){
                System.out.print("Enter product: ");
                name=scan.nextLine();
                System.out.print("Enter quantity: ");
                quantity=scan.nextLine();
                System.out.print("Enter price: ");
                price=scan.nextInt();
                if(price<=budget){
                    if(h.containsKey(name)){
                        GroceryList gl=h.get(name);
                        budget=budget-price+gl.price1;
                        gl.quantity1=quantity;
                        gl.price1=price;
                    }else{
                        h.put(name,new GroceryList(quantity,price));
                        budget-=price;
                    }
                    System.out.println("\nAmount left: "+budget);
                }else{
                    System.out.println("\nCan't buy the product\n");
                }
            }
            else if(option==2){
                for(Map.Entry m:h.entrySet()){
                    if(budget>=((GroceryList)m.getValue()).price1){
                        System.out.println("\nAmount left can buy you "+m.getKey());
                        break;
                    }
                }
            }
            else System.out.println("Enter a valid option!!");
        }while(option!=2);
        System.out.println("Grocery List is: ");
        System.out.println(String.format("%-15s%-15s%-15s","Product","Quantity","Price"));
        for(Map.Entry m:h.entrySet()){
            System.out.println(String.format("%-15s%-15s%-15s",m.getKey(),((GroceryList)m.getValue()).quantity1,((GroceryList)m.getValue()).price1));
        }
    }
}