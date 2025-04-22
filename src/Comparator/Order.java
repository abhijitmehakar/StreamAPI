package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private long amount;

    public Order(int id, String customerName, long amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }
    public long getAmount(){
        return amount;
    }
    public void setAmount(long amount){
        this.amount=amount;
    }
    @Override
    public String toString(){
        return "Id= "+id+" CustomerName= "+customerName+" Amount= "+amount;
    }
}
class SortOrderByName implements Comparator<Order>{


    @Override
    public int compare(Order o1, Order o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getCustomerName(),o2.getCustomerName());
    }
}
class OrderMain{
    public static void main(String[] args) {
        List<Order>orders=new ArrayList<>();
        orders.add(new Order(1,"Satish Kumar",52000));
        orders.add(new Order(2,"Gitesh Rawat",25000));
        orders.add(new Order(3,"Nish Thakur",69000));
        orders.add(new Order(4,"Gaurav Das",7844));
        orders.add(new Order(5,"Vir Sheravat",6599));
        orders.add(new Order(6,"Amol Pande",52000));

        Collections.sort(orders,new SortOrderByName());
        System.out.println("Order sort by customer name Alphabetically");

        for (Order order:orders){
            System.out.println(order);
        }
    }
}