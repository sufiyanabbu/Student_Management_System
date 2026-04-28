package app;

import service.logic;
import java.util.*;
import model.Student;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        logic se = new logic();
        
        while(true){
            System.out.println("=====MENU=====");
        System.out.println("1. ADD STUDENT.");
        System.out.println("2. DISPLAY STUDENT.");
        System.out.println("3. DELETE STUDENT.");
        System.out.println("4. DISPLAY ALL STUDENTS.");
        System.out.println("5. EXIT.");
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
                int sid = sc.nextInt();
                Student d = se.searchStudent(sid);
                if(d!=null){
                    System.out.println(d);
                }
                else{
                    System.out.println("not found!");
                }
                break;
                case 3 : 
                System.out.print("ENTER ID TO DELETE INFO: ");
                int did=sc.nextInt();
                if(se.deleteStudent(did)){
                    System.out.println("Removed!");
                }
                else{
                    System.out.println("Not found");
                }
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