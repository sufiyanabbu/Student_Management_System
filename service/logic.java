package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

public class logic {
   private List<Student> list = new ArrayList<>();
   private Map<Integer, Student> map = new HashMap<>();

   public logic() {
   }

   public boolean addStudent(int id, String name, String grades) {
      if (map.containsKey(id)) {
         return false;
      } else {
         Student student = new Student(id, name, grades);
         list.add(student);
         map.put(id, student);
         return true;
      }
   }

   public Student searchStudent(int id) {
      return map.get(id);
   }

   public boolean deleteStudent(int id) {
      Student s = map.remove(id);
      if (s == null) {
         return false;
      } else {
         list.remove(s);
         return true;
      }
   }

   public void displayall() {
      if (this.list.isEmpty()) {
         System.out.println("NO DATA AVAILABLE.");
      } else {
         for(Student std : this.list) {
            System.out.println("-----------------");
            System.out.println(std);
         }
      }

   }
}
