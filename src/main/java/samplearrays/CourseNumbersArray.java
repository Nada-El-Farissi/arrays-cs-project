package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        //add a new course using the method defined after
        int[] updatedCourses=addCourse(3000,registeredCourses);
        //displaying the courses
        displayCourses(updatedCourses);
        System.out.println("Is course 3000 in the updated list of courses? "+checkForCourse(3000, updatedCourses));
    }
    public static int[] addCourse(int courseNumber,int[] registeredCourses){
        int[] updatedCourses=new int[registeredCourses.length+1];
        for (int i=0; i<registeredCourses.length; i++){
            updatedCourses[i]=registeredCourses[i];
        }
        updatedCourses[registeredCourses.length]=courseNumber;
        return updatedCourses;
    }

    public static void displayCourses(int[] registeredCourses){
        for (int i=0;i<registeredCourses.length;i++){
            System.out.println(registeredCourses[i]+" ");
        }
    }

    public static boolean checkForCourse(int courseNumber, int[] registeredCourses){
        for (int i=0;i<registeredCourses.length;i++){
            if (registeredCourses[i]==courseNumber){
                return true;
            }
        }
        return false;
    }
}
