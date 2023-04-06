import java.util.*;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        return sum;
    }
    double getOrderTotal(double[] prices) {
        double orderTotal = 0;
        for (int i = 0; i < prices.length; i++) {
            orderTotal += prices[i];
        }
        return orderTotal;
    }
    void displayMenu(ArrayList<String> menuItems) {
        for (int i =0; i < menuItems.size(); i++) {
            String item = menuItems.get(i);
            System.out.println(i + " " + item);
        }
    }
    void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        String greeting = "Hello, " + userName + "!";
        System.out.println(greeting);
        System.out.println("There are " + customers.size() + " people in front of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}