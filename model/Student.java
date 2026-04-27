package model;

public class Student {
   private int id;
   private String name;
   private String grades;

   public Student(int id, String name, String grades) {
      this.id = id;
      this.name = name;
      this.grades = grades;
   }

   public int getid() {
      return id;
   }

   public String getname() {
      return name;
   }

   public String getgrades() {
      return grades;
   }

   public String toString() {
      return "ID: " + id + " | NAME: " + name + " | GRADES: " +grades;
   }
}
