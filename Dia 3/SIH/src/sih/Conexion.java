/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sih;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author rubenortiz
 */
public class Conexion {
    private Connection con;
    private Scanner scanner;
    public Conexion(){
        scanner = new Scanner(System.in);
    }
    
    public Connection establecerConexion() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("Archivo config.properties no encontrado");
            }

            props.load(input);

            String url = props.getProperty("Url");
            String user = props.getProperty("Usuario");
            String password = props.getProperty("Contrasena");

            if (url == null || user == null || password == null) {
                throw new IllegalStateException("Una o más propiedades de conexión no están definidas");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (IOException | ClassNotFoundException | SQLException | IllegalStateException e) {
            System.err.println("Error en la conexión :(, error: " + e);
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.toString());
        }
        return con;
    }
    
    public void VerHospitales(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        Connection con = cn.establecerConexion();
        PreparedStatement ps = null;
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_hospital, nombre, direccion FROM hospitales");
            while (rs.next()){
                System.out.println(rs.getInt("id_hospital") + " " + rs.getString("nombre") + " " + rs.getString("direccion"));
            }
        }catch (Exception e){    
            System.err.println("Error al ejecutar la consulta: " + e);
        }
    }
    
    public void InsertHospitales(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        Connection con = cn.establecerConexion();
        String nombreHospital;
        String direccionHospital;
        try {
            ps = con.prepareStatement("insert into hospitales (nombre, direccion) values (?,?)");
            System.out.println("Ingresa el nombre del hospital: ");
            nombreHospital = sc.nextLine();
            System.out.println("Ingresa la direccion del hospital: ");
            direccionHospital = sc.nextLine();
            ps.setString(1, nombreHospital);
            ps.setString(2, direccionHospital);
            ps.executeUpdate();
            System.out.println("Insercion realizada con éxito");
        } catch (Exception e){
            System.err.println("Error sl ejecutar la inserción: " + e);
        }
    }
    
    public void DeleteHospitales(){
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        Connection con = cn.establecerConexion();
        int idHospital;
        try {
            ps = con.prepareStatement("delete from hospitales where id_hospital = ?");
            System.out.println("Ingresa el id del hospital a eliminar: ");
            idHospital = sc.nextInt();
            ps.setInt(1, idHospital);
            ps.executeUpdate();
            System.out.println("Hospital eliminado con éxito");
        } catch(Exception e){
            System.err.println("Error sl eliminar los datos: " + e);            
        }

    }
    
    public void UpdateHospitales() {
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        Connection con = cn.establecerConexion();
        String nombreHospital;
        String direccionHospital;
        int idHospital;
    
        try {
            System.out.println("Ingresa el id del hospital que deseas actualizar: ");
            idHospital = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Ingresa el nuevo nombre del hospital: ");
            nombreHospital = sc.nextLine();
        
            System.out.println("Ingresa la nueva direccion del hospital: ");
            direccionHospital = sc.nextLine();
        
            ps = con.prepareStatement("UPDATE hospitales SET nombre = ?, direccion = ? WHERE id_hospital = ?");
            ps.setInt(3, idHospital);
            ps.setString(1, nombreHospital);
            ps.setString(2, direccionHospital);
        
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La actualización fue exitosa.");
            } else {
                System.out.println("No se encontró un hospital con el id proporcionado.");
            }   
        } catch (Exception e) {
            System.err.println("Error al actualizar los datos: " + e);
        }     
    }
    
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        Connection con = cn.establecerConexion();
        PreparedStatement ps = null;
        Statement st;
        ResultSet rs;
        int option;
        do {
            System.out.printf("Bienvenido Usuario%n¿Que deseas hacer el dia de hoy?%n");
            System.out.printf("1.Ver Hospitales Registrados%n2. Registrar Nuevo Hospital%n3. Actualizar Hospitales Registrados%n4. Eliminar Hospitales Registrados%n5. Salir%n");
            option = sc.nextInt();
            switch (option){
                case 1:
                    cn.VerHospitales();
                    break;
                case 2:
                    cn.InsertHospitales();
                    break;
                case 3:
                    cn.UpdateHospitales();
                    break;
                case 4:
                    cn.DeleteHospitales();
            }
        } while (option != 5);
        System.out.println("Hasta pronto Usuario");
    }
}
