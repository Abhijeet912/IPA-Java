import java.util.*;

public class Main{
    public static void main(String[] args){
    Course[] courses=new Course[4];
    Scanner sc=new Scanner(System.in);
    System.out.println("Start input");
    for(int i=0;i<4;i++){
        int id=sc.nextInt(); sc.nextLine();
        String cName=sc.nextLine();
        String cAdmin=sc.nextLine();
        int quiz=sc.nextInt(); sc.nextLine();
        int handson=sc.nextInt(); sc.nextLine();
        courses[i]=new Course(id,cName,cAdmin,quiz,handson);
    }
    
    //for 1st func.
    String givenCourseAdmin=sc.nextLine();
    int admin=sc.nextInt();
    
    
    int average=findAvgOfQuizByAdmin(courses,givenCourseAdmin);
    if(average==0){
        System.out.println("No course exits");
    }
    else{
        System.out.println(average);
    }
    
    ArrayList<Course> list=sortCourseByHandsOn(courses,admin);
    if(list.size()==0){
        System.out.println("No course with given attribute");
    }
    else{
        for(Course course:list){
            System.out.println(course.courseName);
        }
    }
    
    
    }
    public static int findAvgOfQuizByAdmin(Course[] courses,String givenCourseAdmin){
        int courseSum=0;
        int courseNum=0;
        for(Course course:courses){
            if(course.getCourseAdmin().equalsIgnoreCase(givenCourseAdmin)){
                courseSum+=course.getQuiz();
                courseNum++;

            }
        }
        return courseSum/courseNum;
    }
    public static ArrayList<Course> sortCourseByHandsOn(Course[] courses,int handson){
        ArrayList<Course> list=new ArrayList<>();
        for(Course course:courses){
            if(course.getHandson()<handson){
                list.add(course);
            }
        }
        list.sort((h1,h2)->Integer.compare(h1.handson,h2.handson));
        return list;
    }
}
class Course{
    int courseId;
    String courseName;
    String courseAdmin;
    int quiz;
    int handson;
    
    public Course(int courseId,String courseName,String courseAdmin,int quiz,int handson){
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.quiz=quiz;
        this.handson=handson;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public String getCourseAdmin(){
        return this.courseAdmin;
    }
    public int getHandson(){
        return this.handson;
    }
    public int getQuiz(){
        return this.quiz;
    }
}