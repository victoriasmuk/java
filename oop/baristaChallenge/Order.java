import java.util.*;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
        public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // GETTERS & SETTERS
    public String getName(){
        return this.name;
    }
    public boolean getReady(){
        return this.ready;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
    
    // ORDER METHODS
        
    public void addItem(Item item){
        items.add(item);
    }
    public String getStatusMessage() {
        if (!this.ready){
            return "Thank you for waiting. Your order will be ready soon.";
        }
        return "Your order is ready.";
    }
    public double getOrderTotal() {
        double total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }
    public void display(){
        System.out.println("Customer name: " + this.name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }
}
