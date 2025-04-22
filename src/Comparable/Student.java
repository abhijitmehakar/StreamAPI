package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private int rollno;
    private double marks;

    public Student(String name, int rollno, double marks) {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Rollno "+rollno+" Name "+name+" Marks "+marks;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.marks, o.marks);
    }
}
class main{
    public static void main(String[] args) {
        List<Student>students=new ArrayList<>();
        students.add(new Student("Abhijit",45,45.2));
        students.add(new Student("Rohit",54,56.89));
        students.add(new Student("Sai",12,78.5));
        students.add(new Student("Kishor",236,45.36));

        Collections.sort(students);

        System.out.println("Student sorted by roll no");
        for(Student student:students){
            System.out.println(student);
        }



        //This logic is stream logic
//      List<Student>sortedbyrollno= students.stream()
//                .sorted(Comparator.comparingInt(Student::getRollno))
//                .toList();
//        System.out.println("Sorted by rollno");
//      sortedbyrollno.forEach(System.out::println);




    }

}

