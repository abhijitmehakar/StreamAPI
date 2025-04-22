package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPrblm {
    public static void main(String[] args) {
        List<Employee>employees1=new ArrayList<>();
        employees1.add(new Employee(1,"Rohit","Pune",36,"Male","DEV",2024,45000));
        employees1.add(new Employee(2,"Vikas","Bengluru",40,"Male","QA",2022,56000));
        employees1.add(new Employee(3,"Soniya","Mumbai",23,"Female","DEV",2019,60000));
        employees1.add(new Employee(4,"Vijay","Pune",63,"Male","BA",2025,25000));
        employees1.add(new Employee(5,"Nisha","Mumbai",45,"Female","BA",2022,32000));
        employees1.add(new Employee(6,"Vinayak","Bengluru",21,"Male","DEV",2021,36000));
        employees1.add(new Employee(7,"Vamika","Pune",36,"Female","QA",2020,40000));
        employees1.add(new Employee(8,"Nilesh","Mumbai",36,"Male","Analyst",2018,21500));
        employees1.add(new Employee(9,"Vivek","Pune",38,"Male","QA",2024,23000));
        employees1.add(new Employee(10,"Vilas","Bengluru",30,"Male","Analyst",2023,78000));
        employees1.add(new Employee(11,"vignesh","Pune",26,"Male","DEV",2024,45000));

        //1. find the employee from the specifc city and get the count by using stream
        employees1.stream()
                .filter(emp->emp.getCity().equals("Pune"))
                .forEach(System.out::println);

        long countofcity=employees1.stream()
                .filter(emp->emp.getCity().equals("Pune"))
                .count();
        System.out.println("The count of the city is "+countofcity);



//2.find all employee where salary is greater than perticular value

        employees1.stream()
                .filter(employee -> employee.getSalary()>50000)
                .forEach(System.out::println);

//3.Print All emp name with uppercase

        employees1.stream()
                .map(emp->emp.getName().toUpperCase())
                .forEach(System.out::println);

        //4.find the first employee which is department is HR if not present throw exception

      Employee emp=  employees1.stream()
                .filter(employee -> employee.getDepartment().equals("Analyst"))
                .findFirst()
                .orElseThrow();
        System.out.println(emp);

        //5.get the total salary on all employees from specefic department

        double empsalarysum =employees1.stream()
                .filter(employee -> employee.getDepartment().equals("DEV"))
                .mapToDouble(employee -> employee.getSalary())
                .sum();
        System.out.println(empsalarysum);

//6.check if all emp salary is greater than specific value

       boolean checksal= employees1.stream()
                .allMatch(employee -> employee.getSalary()>1000);
        System.out.println(checksal);

        //7. find the sum of salary of all employee and their avg

       double allempsal= employees1.stream()
                .mapToDouble(Employee::getSalary)//by using method refference
               .sum();
        System.out.println("Sum of All Employee Salary "+allempsal);

        double salavg = employees1.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                        .orElse(0.0);
        System.out.println("Avg salary of all emp is "+salavg);


        //8.get the map of employee name and their salary

       employees1.stream()
               .forEach(employee -> System.out.println(employee.getName()+"="+employee.getSalary()));

//print all employee details from highest to lowest salary
        employees1.stream()
                .sorted((emp1,emp2)-> (int) (emp2.getSalary()-emp1.getSalary()))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");

        //9.get the employee with highest salary

     double maxsal =  employees1.stream()
               .mapToDouble(Employee::getSalary)
               .max()
               .getAsDouble();

     employees1.stream()
             .filter(employeesal -> employeesal.getSalary()==maxsal)
             .forEach(System.out::println);

     //find second highest salary of employee

     double secondsal =    employees1.stream()
                .map(Employee::getSalary)
                .sorted((emp1,emp2)->emp2.compareTo(emp1))
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondsal);

        employees1.stream()
                .filter(employee -> employee.getSalary()==secondsal)
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");


//get the employee who earning above from avg salary

      double avg=  employees1.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

      employees1.stream()
              .filter(empavg->empavg.getSalary()>=avg)
              .forEach(System.out::println);
        System.out.println("------------------------------------------------------------");


      //get the employee with longest name

       Employee longname =  employees1.stream()
                .max(Comparator.comparing(employee -> employee.getName()))
                .get();
        System.out.println(longname);

        //grouping employee by depaertment wise

     Map<String,List<Employee>>deptemp=   employees1.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


        deptemp.forEach((dept, emps) -> {
            System.out.println("Department = " + dept);
            emps.forEach(empn -> System.out.println("  " + emp.getName() + " - " + emp.getSalary()));
        });

        // get the count of employee by department

      Map<String,Long>countofEmpByDept =   employees1.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

      countofEmpByDept.forEach((dept,count)->{
          System.out.println("Department ="+dept + " Count is "+count);
      });

      //sum of salary of employee by dempartment


    Map<String,Double>deptsal =    employees1.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)));

    deptsal.forEach((dept,sal)->{
        System.out.println("depertment ="+dept+" sumofsalry="+sal);
    });
        System.out.println("-----------------------------------------------------------------------------");
//get avg salary of employee per dept

     Map<String,Double>avgsalperdept =  employees1.stream()
              .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

avgsalperdept.forEach((dept,avgsal)->{
    System.out.println("Department ="+dept+" AvgSalary="+avgsal);
});


//check all employee is belong to specefic dept

      boolean checkemp=  employees1.stream()
                .anyMatch(employee -> employee.getDepartment().equals("DEV"));
        System.out.println(checkemp);


        //list all employee grouping by cities but belong to same department

      Map<String,List<Employee>> citydept = employees1.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
      citydept.forEach((dept,emplist)->{
          System.out.println(dept+" Department");
          emplist.stream()
                  .collect(Collectors.groupingBy(Employee::getCity))
                  .forEach((city,emps)->{
                      emps.forEach(System.out::println);
                  });
      });
//find the department with highest avg salary

        
    }
}
