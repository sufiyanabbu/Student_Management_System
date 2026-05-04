package service;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import model.Student;
import java.sql.*;

public class logic {
   // private List<Student> list = new ArrayList<>();
   // private Map<Integer, Student> map = new HashMap<>();

  
public boolean addStudent(int id, String name, String grades){
    try{
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO students VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, grades);
        ps.executeUpdate();
        System.out.println("Inserted Sucessfully");
        con.close();
        return true;
    }
    catch(Exception e){
        e.printStackTrace();
        return false;
    }
}

   public Student searchStudent(int id){
    try{
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("grades")
            );
        }else{
            System.out.println("Not Found ");
        }
        con.close();
    } catch(Exception e){
        e.printStackTrace();
    }
    return null;
}
   

public boolean deleteStudent(int id){
    try{
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
        return true;
    }
    catch(Exception e){
        e.printStackTrace();
        return false;
    }
}
   public void displayAll(){
    try{
    Connection con = DBConnection.getConnection();
    String query = "SELECT * FROM students";
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();

    while(rs.next()){
        System.out.println(
            rs.getInt("id")+" | "+
            rs.getString("name")+" | "+
            rs.getString("grades")
            );
    }
    con.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
   }
}
