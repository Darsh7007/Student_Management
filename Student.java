import java.util.ArrayList;
import java.util.Scanner;
public class Student{
        private static ArrayList<StudentRecord> list = new ArrayList<>();
        private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
          showMenu();
    }

    private static void showMenu(){
        int choice = 0;
        do{
         System.out.println();
         System.out.println("Student management System");
         System.out.println();
         System.out.println("choice 1: add student ");
         System.out.println("choice 2: search student");
         System.out.println("choice 3: update student");
         System.out.println("Choice 4: remove Student ");
         System.out.println("choice 5: view all student");
         System.out.println("choice 6: Exit");
         System.out.println();
         System.out.println();
         System.out.println();

         choice= sc.nextInt();

         switch(choice){
            case 1:
                 addStudent();
                 break;
            case  2:
                searchStud();
                 break;
            case 3:
                 updateStud();
                 break;
            case 4:
                 removeStud();
                 break;
            case 5:
                viewAllStud();
                break;
            case 6:
                System.out.println("Thank you For Using Student Management System");
                break;
            default :
                 System.out.println("Invalid choice");                
         }
        }while(choice !=6);
}

private static void addStudent(){
    
      
     int id=readInt("Enter student id");
     if(findStudById(id) != null){
        System.out.println("Student with entered id is already existed");
        return;
     }
     String name=readRequiredString("Enter Name Of Student:");
     int age=readInt("Enter Age OF Student:");
     Double grade=readGrade("Grade Of Student:");
     String course=readRequiredString("Lis Of Course Student Enrolled for:");

       list.add(new StudentRecord( id, name, age,course, grade));

    
}

private static void searchStud(){
   
     int id = readInt("Enter Student Id To Search");
     if(findStudById(id)== null){
        System.out.println("Invalid Student Id");
     }
        for(StudentRecord stud:list){
           if(stud.getid() == id){
            System.out.println(stud);
           }
        }
    
}
private static void viewAllStud(){
    System.out.println("--Student List--");
    if(list.isEmpty()){
        System.out.println("No Student Available");
    }
    for(StudentRecord student:list){
        System.out.println(student);
    }
}
private static void  updateStud(){
    int id = readInt("ID Of Student whose Info you want to update:");
    StudentRecord found = findStudById(id);
    if(found == null){
        System.out.println(" Student Not available");
        return;
    }
  found.setName(readRequiredString("Update Name"));
  found.setAge(readInt("update Age:"));
  found.setCourse(readRequiredString("Update Course"));
  found.setgrade(readGrade("Update grade"));
}

private static void removeStud(){
   int id=readInt("ID of student want to be deleted");
   StudentRecord student = findStudById(id);
   if(student==null){
    System.out.println("Student Not Found");
    return;
   }
   list.remove(student);
}
private static StudentRecord findStudById(int id ){
        for(StudentRecord student:list){
          if(student.getid()==id){
            return student;
          }
        }
        return null;
}
private static int readInt(String prompt){
    while(true){
        try{
             System.out.print(prompt +":");
             return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Enter valid Number");
        }
    }
}
private static Double readGrade(String prompt){
    while(true)
        try{
             System.out.print(prompt +":");
             Double grade = Double.parseDouble(sc.nextLine());
             if(grade>=0.0 && grade<=100.0){
                return grade;
             }else {
            System.out.println("Enter valid age");
             }
        }   
        catch(NumberFormatException e){
            System.out.println("Enter valid age");
        }
    
}
private static String readRequiredString(String prompt){
    while(true){
        System.out.print(prompt+":");
         String name = sc.nextLine();
         if(!name.trim().isEmpty()){
            return name;
         }
         System.out.println("This field can not be empty");
      
    }
}

    static class StudentRecord{
        private int id;private String name;private String course;private int age;private double grade;

        StudentRecord(int id,String name,int age,String course,Double grade){
               this.id= id;
               this.name= name;
               this.age= age;
               this.course= course;
               this.grade= grade;
        }
        public int getid(){
          return id;
        }
        public  void setName(String name){
            this.name=name;
        }
        public String getName(){
            return name;
        }
        void setAge(int age){
            this.age=age;
        }
        public int getAge(){
            return age;
        }
        void setCourse(String course){
        this.course=course;
       }
       public String getCourse(){
        return course;
       }
       void setgrade(double grade){
        this.grade=grade;
       }
       public Double getGrade(){
        return grade;
       }
       public String toString(){
            return "Student{ id"+id+",Name :" +name +",Course :"+course+",Grade :"+grade+"Age :"+ age+'}';
       }
    }
}
