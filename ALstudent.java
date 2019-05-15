package ALstudent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ALstudent
{
    public static void main(String args[]) {

        String filepath = "C:\\Users\\Bharath\\Documents\\arrayliststudentmaxmin.csv";
        ArrayList<String> linesRead = new ArrayList<String>();
        ArrayList<Student> records = new ArrayList<Student>();


        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //ArrayList<Integer> ageList = new ArrayList<Integer>();
        ArrayList<Double> marksList = new ArrayList<Double>();
        //using enhanced loop to st
        // ore details into objects
        Student sobj;
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (String s : linesRead) {
            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));
            records.add(sobj);
            ageList.add(sobj.getAge());
            marksList.add(sobj.getMarks());
        }

        System.out.println("\nThe size of List is  " + records.size() + "\n");

        System.out.println("Now printing Object Values");
        for (Student st : records) {
            System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
        }

        int maxage = Collections.max(ageList);
        System.out.println("Max age is : " + maxage);
        int minage = Collections.min(ageList);
        System.out.println("min age is : " + minage);

        double maxmarks = Collections.max(marksList);
        System.out.println("Max marks is : " + maxmarks);

        Student element;
        element = Collections.max(records, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Max marks is : " + element.getMarks());
        System.out.println("Student Details with Max Marks is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + "" + element.getMarks());

        System.out.println();

        element=Collections.max(records,Comparator.comparing(Student::getName));
        System.out.println("Alphabetically LastName : " + element.getName());
        System.out.println("Student Details with Max Marks is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());


        System.out.println();

        element=Collections.min(records,Comparator.comparing(Student::getName));
        System.out.println("Alphabetically FirsttName : " + element.getName());
        System.out.println("Student Details with Max Marks is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        element=Collections.max(records,Comparator.comparing(Student::getAge));
        System.out.println("Maximum age is : " + element.getAge());
        System.out.println("Student Details with Max Age is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();


        element=Collections.min(records,Comparator.comparing(Student::getAge));
        System.out.println("Maximum age is : " + element.getAge());
        System.out.println("Student Details with Min Age is : " + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());


    }
}



class Student {
    private int rollno;
    private String name;
    private int age;
    private double marks;

    Student(int rollno, String name, int age, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}




