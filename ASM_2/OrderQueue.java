package ASM_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderQueue implements Iterable<Order> {
    private Queue<Order> orderQueue = new Queue<>();

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public Order processOrder() {
        if (orderQueue.isEmpty()) return null;
        return orderQueue.poll();
    }

    public Order searchOrder(int orderID) {
        for (Order order : orderQueue) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }
    public class OrderIDGenerator {
        private static int currentID = 1; // Bắt đầu từ 1

        public static synchronized int getNextOrderID() {
            return currentID++;
        }
    }
    public void displayOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }

        System.out.println("Orders in the queue:");
        for (Order order : orderQueue) {
            order.showOrderInfor();
            System.out.println();
        }
    }


    @Override
    public Iterator<Order> iterator() {
        return new Iterator<Order>() {
            private Iterator<Order> it = orderQueue.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Order next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }
}
