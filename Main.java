import java.util.*;
class Student{
    private int id;
    private String name;
    private String grades;
    public Student(int id,String name, String grades){
        this.id = id ;
        this.name=name;
        this.grades=grades;
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    } 
    public String getgrades(){
        return grades;
    }
    public String toString(){
        return "ID: "+id+"\nNAME: "+name+"\nGRADES: "+grades;
    }
}
class Studentservice{
    List<Student> list = new ArrayList<>();


    public boolean addStudent(int id, String name, String grades){
        if(isidExist(id)){
            return false;
        }
        list.add(new Student(id,name,grades));
        return true;
    }

public void searchstudent(int ser_id){
    if(list.isEmpty()){
        System.out.println("NO DATA AVAILABLE.");
    }
    else{
    boolean found = false;
    for(Student s: list){
        if(s.getid()==ser_id){
        System.out.println(s);
            found = true;
            break;
        }
    }
    if(!found){
        System.out.println("STUDENT DOES NOT EXIST.....");
    }
}
}


public void deletestudent(int del_id){
    boolean removed = false;
    for(int i=0;i<list.size();i++){
        if(list.get(i).getid()==del_id){
            list.remove(i);
            removed = true;
            break;
        }
    }
    if(!removed){
        System.out.println("INVALID ID....\nSTUDENT DOES NOT EXIST...");
    }
}

public void displayall(){
    if(list.isEmpty()){
        System.out.println("NO DATA AVAILABLE.");
    }else{
    for(Student s: list){
        System.out.println("-----------------");
        System.out.println(s);
    }
}
}

    private boolean isidExist(int id){
        for(Student s: list){
            if(s.getid()==id){
                return true;
            }
        }
        return false;
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Studentservice se = new Studentservice();
        System.out.println("=====MENU=====");
        System.out.println("1. ADD STUDENT.");
        System.out.println("2. DISPLAY STUDENT.");
        System.out.println("3. DELETE STUDENT.");
        System.out.println("4. DISPLAY ALL STUDENTS.");
        System.out.println("5. EXIT.");
        while(true){
            System.out.print("ENTER CHOICE: ");
            int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("ENTER ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("ENTER NAME: ");
                String name = sc.nextLine();

                System.out.print("ENTER GRADES: ");
                String grades = sc.nextLine();
                if(se.addStudent(id,name,grades)){
                    System.out.println("ADDED...");
                }
                else{
                    System.out.println("ID EXIST...");
                }
                
                break;
                case 2: 
                System.out.print("ENTER ID TO GET STUDENT INFO: ");
                int ser_id = sc.nextInt();
                se.searchstudent(ser_id);
                break;
                case 3 : 
                System.out.print("ENTER ID TO DELETE INFO: ");
                int del_id=sc.nextInt();
                se.deletestudent(del_id);
                System.out.println("INFO DELETED. ");
                break;
                case 4:
                    System.out.println("======STUDENTS INFORMATION======");
                    se.displayall();
                    break;
                    case 5:
                        System.out.println("EXITING....");
                        return ;
                    default :
                        System.out.println("INVALID CHOICE....");
        }
        }
    }
}