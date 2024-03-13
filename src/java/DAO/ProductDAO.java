/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Model.Car;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author toden
 */
public class ProductDAO extends DAO {
    public ProductDAO(){
        super();
    }
    
    public static List<Car> getAllProduct(){
        String sql = "select * from Cars";
        List<Car> ProductList = new ArrayList<Car>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String manufacter = rs.getString(3);
                double price = rs.getDouble(4);
                int realeasedyear = rs.getInt(5);   
                
                Car p = new Car(Id, name, manufacter, price, realeasedyear);
                
                ProductList.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ProductList;
    }
    
    public static Car getProductById(int id){
        String sql = "select * from Cars where CarID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String manufacter = rs.getString(3);
                double price = rs.getDouble(4);
                int realeasedyear = rs.getInt(5);   
                
                Car p = new Car(Id, name, manufacter, price, realeasedyear);
                
                return p; 
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static Car getProductByName(String name){
        String sql = "select * from Cars where CarName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int Id = rs.getInt(1);
                String manufacter = rs.getString(3);
                double price = rs.getDouble(4);
                int realeasedyear = rs.getInt(5);   
                
                Car p = new Car(Id, name, manufacter, price, realeasedyear);
                
                return p; 
            }
        } catch (Exception e) {
        }
        return null;
    }
    
   
    public static List<Car> UpdateProductById(int id, String name, String manufacter, double price, int year){
        List<Car> products = new ArrayList();
        String sql = "update Cars set CarName = ?, Manufacturer = ?, Price = ?, ReleasedYear = ? where CarID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, manufacter);
            ps.setDouble(3, price);
            ps.setInt(4, year);
            ps.setInt(5, id);
            ps.executeUpdate();
            products = getAllProduct();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    
    public static List<Car> DeleteProductById(int id){
        List<Car> products = new ArrayList();
        String sql = "delete from Cars where CarID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);;
            ps.executeUpdate();
            products = getAllProduct();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    
    
    public static List<Car> addProduct(String name, String manufacter, double price, int year){
        String sql = "insert into Cars(CarName, Manufacturer, Price, ReleasedYear) values(?,?,?,?)";
        List<Car> products = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, manufacter);
            ps.setDouble(3, price);
            ps.setInt(4, year);
            ps.executeUpdate();
            products = getAllProduct();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    
   
    
    public static void main(String[] args){
        try{
            new DAO();
            List<Car> p = getAllProduct();
            System.out.println("Ket noi thanh cong");
            for(Car pr : p){
                System.out.println(pr.getCarName());
            }
        } catch(Exception e){
            System.out.println("Ket noi that bai"+e.getLocalizedMessage());
        }
    }
}
