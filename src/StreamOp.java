

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamOp {




    public static void main(String[] args) {
        List<Employee>employees=new ArrayList<>();
        employees.add(new Employee(3, "Alice", "Delhi", 28, "Female", "HR", 2016, 45000.0));
        employees.add(new Employee(6, "Bob", "Mumbai", 32, "Male", "Finance", 2014, 60000.0));
        employees.add(new Employee(1, "Charlie", "Delhi", 25, "Male", "IT", 2018, 50000.0));
        employees.add(new Employee(4, "Diana", "Pune", 30, "Female", "Marketing", 2015, 55000.0));
        employees.add(new Employee(2, "Ethan", "Mumbai", 29, "Male", "Sales", 2017, 48000.0));
        employees.add(new Employee(5, "Fiona", "Pune", 26, "Female", "IT", 2019, 52000.0));



        Stream<Employee>empStream=employees.stream();

        List<String>empname =  empStream.map(emp->emp.getName()).toList();
        System.out.println(empname);

        //filter()
        //Employee Name,Age>28

        List<String>empage= employees.stream()
                .filter(emp->emp.getAge()>28)
                .map(emp->emp.getName())
                .toList();
        System.out.println(empage);

        //distinct--unique data
        //city name
        employees.stream()
                .map(emp->emp.getCity())
                .distinct()
                .forEach(System.out::println);



        //count()--gives count
        //get count of employees whose salary is greater than 20k

        long empsal= employees.stream()
                .filter(emp->emp.getSalary()>20000)
                .count();
        System.out.println(empsal);

        //limit()-set limit how much data you want
        //get first 3 employee object

        List<Employee>emplist= employees.stream()
                .limit(3)
                .toList();
        System.out.println(emplist);


        //skipp()--skipp record
        //skipp first two employee and print other emp

        List<Employee>except3emp= employees.stream()
                .skip(2)
                .toList();
        System.out.println(except3emp);

        //anymatch
        boolean agecheck=  employees.stream()
                .anyMatch(emp->emp.getAge()>25);
        System.out.println(agecheck);

        //allmatch
//check employees is joining is after 2010
        boolean allmatchage =employees.stream()
                .allMatch(emp->emp.getYearOfPassing()>2015);
        System.out.println(allmatchage);

        Employee emppp=employees.stream()
                .findAny().get();
        System.out.println(emppp);

        List<Integer>empsortbyid =employees.stream()
                .map(emp->emp.getId())
                .sorted()
                .toList();
        System.out.println(empsortbyid);

    }
}
