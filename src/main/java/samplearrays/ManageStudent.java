package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int indexOfOldest=0;
        for (int i=0;i<students.length;i++){
            if (students[i].getAge()>students[indexOfOldest].getAge()){
                indexOfOldest=i;
            }
        }
        Student oldest=students[indexOfOldest];
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for (int i=0;i<students.length;i++){
            if (students[i].getAge()>=18){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length==0){
            return Double.NaN;
        }
        int sum=0;
        for (int i=0;i<students.length;i++){
            sum+=students[i].getGrade();
        }
        double avg=(double) sum/students.length;//casting bc both sum and length are int
        return avg;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (int i=0;i<students.length;i++){
            if (students[i].getName().equals(name)){
                return students[i];
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for (int j=0;j<students.length - 1;j++){
            for (int i = 0; i < students.length - 1; i++) {
                if (students[i].getGrade() < students[i + 1].getGrade()) {//descending order
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                }
            }
        }

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (int i=0; i < students.length; i++) {
            if (students[i].getGrade()>=15){
                System.out.println(students[i].getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (int i=0; i < students.length; i++) {
            if (students[i].getId()==id){
                students[i].setGrade(newGrade);
                return true;//when found
            }
        }
        return false;//if not found
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i=0; i < students.length; i++){
            for (int j=i+1; j < students.length; j++){
                if (students[i].getName().equals(students[j].getName())){
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents=new Student[students.length+1];
        for (int i=0; i < students.length; i++){
            newStudents[i]=students[i];
        }
        newStudents[students.length]=newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students=new Student[5];
        students[0]=new Student(1, "Nada");
        students[1]=new Student(2, "Salma",19);
        students[2]=new Student(3, "Malak", 20, 17);
        students[3]=new Student( 4,"Adam",20,14);
        students[4]=new Student(5, "Rayane",  20,15);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        //first let's give to students who don't have an age, an age
        students[0].setAge(20);
        System.out.println(findOldest(students));

        // 3) Count adults
        System.out.println(countAdults( students));



        // 4) Average grade
        //first let's give to students who don't have a grade, a grade
        students[0].setGrade(19);
        students[1].setGrade(12);

        System.out.println(averageGrade(students));


        // 5) Find by name
        System.out.println(findStudentByName(students, "Adam"));
        System.out.println(findStudentByName(students, "Malak"));



        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc( students);
        for (Student s : students) System.out.println(s);


        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        // function
        boolean updated=updateGrade(students,4, 16);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        System.out.println(hasDuplicateNames( students));

        // 10) Append new student
        Student dina = new Student(6, "Dina", 19, 16);
        Student[] arr=appendStudent(students, dina);
        for (Student s : arr) System.out.println(s);

        //question11:
        Student[][] school = new Student[2][3];
        //classroom1
        school[0][0] = new Student(1, "Nada", 20, 17);
        school[0][1] = new Student(2, "Salma", 19, 15);
        school[0][2] = new Student(3, "Malak", 20, 18);
        //classroom2
        school[1][0] = new Student(4, "Adam", 20, 14);
        school[1][1] = new Student(5, "Rayane", 20, 16);
        school[1][2] = new Student(6, "Sara", 19, 19);

        //Printing the names of all students class by class
        for (int i = 0; i < school.length; i++) {//number of classes
            System.out.println("Class " + (i + 1) + ":");
            for (int j = 0; j < school[i].length; j++) {//the students in each class
                System.out.println(school[i][j].getName());
            }
        }
        //Finding the top student in each class
        for (int i = 0; i < school.length; i++) {//looping through the classes
            Student topStudent = school[i][0]; //we take a default student for now and see if any have a better grade than him
            for (int j = 1; j < school[i].length; j++) {
                if (school[i][j].getGrade() > topStudent.getGrade()) {
                    topStudent = school[i][j];
                }
            }
            System.out.println("The top student in the class " +(i+1)+" is: "+topStudent.getName());

        }
    }
}

