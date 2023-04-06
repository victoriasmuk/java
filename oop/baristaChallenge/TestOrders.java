public class TestOrders {
    public static void main(String[] args) {

        Item item1 = new Item("latte", 5);
        Item item2 = new Item("coffee", 2.5);
        Item item3 = new Item("capuccino", 3.5);
        Item item4 = new Item("mocha", 5.5);

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Victoria");
        Order order4 = new Order("Kristina");
        Order order5 = new Order("Megan");

        order1.addItem(item1);
        order1.addItem(item1);

        order2.addItem(item2);
        order2.addItem(item2);

        order3.addItem(item3);
        order3.addItem(item3);

        order4.addItem(item4);
        order4.addItem(item4);

        order5.addItem(item1);
        order5.addItem(item1);

        System.out.println(order1.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());

        System.out.println(order2.getStatusMessage());
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order3.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}