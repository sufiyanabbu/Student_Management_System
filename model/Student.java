package model;

public class Student {
   private int id;
   private String name;
   private String grades;

   public Student(int var1, String var2, String var3) {
      this.id = var1;
      this.name = var2;
      this.grades = var3;
   }

   public int getid() {
      return this.id;
   }

   public String getname() {
      return this.name;
   }

   public String getgrades() {
      return this.grades;
   }

   public String toString() {
      return "ID: " + this.id + " | NAME: " + this.name + " | GRADES: " + this.grades;
   }
}
