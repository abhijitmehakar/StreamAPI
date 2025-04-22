package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee  {
    private int id;
    private String  name;
    private long salary;

    public Employee(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary ;
    }
}

 class SortBySalary implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Long.compare(o2.getSalary(), o1.getSalary());
    }
}
class SortSalaryByComparator{
    public static void main(String[] args) {
        List<Employee>employees=new ArrayList<>();
        employees.add(new Employee(1,"Rohit",45600));
        employees.add(new Employee(2,"Dhoni",40322));
        employees.add(new Employee(3,"Virat",100000));
        employees.add(new Employee(4,"Ajinkya",55600));
        employees.add(new Employee(5,"Rahul",45600));

     Collections.sort(employees,new SortBySalary());

        System.out.println("StreamAPI.Employee sort by Salary");
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}