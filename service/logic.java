package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

public class logic {
   private List<Student> list = new ArrayList();
   private Map<Integer, Student> map = new HashMap();

   public logic() {
   }

   public boolean addStudent(int var1, String var2, String var3) {
      if (this.map.containsKey(var1)) {
         return false;
      } else {
         Student var4 = new Student(var1, var2, var3);
         this.list.add(var4);
         this.map.put(var1, var4);
         return true;
      }
   }

   public Student searchStudent(int var1) {
      return (Student)this.map.get(var1);
   }

   public boolean deleteStudent(int var1) {
      Student var2 = (Student)this.map.remove(var1);
      if (var2 == null) {
         return false;
      } else {
         this.list.remove(var2);
         return true;
      }
   }

   public void displayall() {
      if (this.list.isEmpty()) {
         System.out.println("NO DATA AVAILABLE.");
      } else {
         for(Student var2 : this.list) {
            System.out.println("-----------------");
            System.out.println(var2);
         }
      }

   }
}
