package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private int price;

    public Product(int id,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "price = "+price+" name= "+name+" id= "+id;

    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.price,o.price);
    }
}

class SortProductByPrice{
    public static void main(String[] args) {
        List<Product>products=new ArrayList<>();
        products.add(new Product(1,"Iphone",45000));
        products.add(new Product(2,"Samsung",100000));
        products.add(new Product(3,"MI",25000));
        products.add(new Product(4,"Vivo",19000));
        products.add(new Product(5,"One+",50000));
        products.add(new Product(6,"Nothing",35000));
        products.add(new Product(7,"Oppo",10000));
        products.add(new Product(8,"Moto",36000));

        Collections.sort(products);
        System.out.println("Product is sorted by proce");
        for(Product product:products){
            System.out.println(product);
        }
    }
}
