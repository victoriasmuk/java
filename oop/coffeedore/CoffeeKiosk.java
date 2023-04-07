import java.util.*;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // Constructor - no params, initializes items and orders to empty arrays.
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // Methods
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }
    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- " + item.getPrice());
        }
    }
    public void newOrder() {
        // Ask user to print name & save
        System.out.println("Please enter customer name for new order:");
        String userName = System.console().readLine();

        // create new order for customer
        Order newOrder = new Order(userName);
        // display menu for customer
        displayMenu();

        // Ask user to select an item to order
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            int selectedItem = Integer.parseInt(itemNumber);
            if (selectedItem < this.menu.size()) {
                Item menuItem = menu.get(selectedItem);
                newOrder.addMenuItem(menuItem);
            } else {
                System.out.println("Please select an item listed on the menu.");
            }

            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index to order another item, or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        newOrder.display();
        this.orders.add(newOrder);

    }
}