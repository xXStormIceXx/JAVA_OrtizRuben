/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campuslands;

/**
 *
 * @author rubenortiz
 */
public class Camper {
    private int identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String acudiente;
    private int Numero_Celular;
    private int Numero_Fijo;
    private String estado;
    private String riesgo;
    
    public Camper(){
        
    }
    
    public Camper(int identificacion, String nombres, String apellidos, String direccion, String acudiente, int Numero_celular, int Numero_Fijo, String estado, String riesgo){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.Numero_Celular = Numero_Celular;
        this.Numero_Fijo = Numero_Fijo;
        this.estado = estado;
        this.riesgo = riesgo;
    }
    
    public int getIdentificacion(){
        return identificacion;
    }

    public void setIdentificacion(int identificacion){
        this.identificacion = identificacion;
    }

    public String getNombres(){
        return nombres;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getAcudiente(){
        return acudiente;
    }

    public void setAcudiente(String acudiente){
        this.acudiente = acudiente;
    }

    public int getNumeroCelular(){
        return Numero_Celular;
    }

    public void setNumeroCelular(int Numero_Celular){
        this.Numero_Celular = Numero_Celular;
    }

    public int getNumeroFijo(){
        return Numero_Fijo;
    }

    public void setNumeroFijo(int Numero_Fijo){
        this.Numero_Fijo = Numero_Fijo;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getRiesgo(){
        return riesgo;
    }

    public void setRiesgo(String riesgo){
        this.riesgo = riesgo;
    }

    @Override
    public String toString(){
        return "\n Camper{" +
                "\n identificacion='" + identificacion + '\'' +
                ",\n nombres='" + nombres + '\'' +
                ",\n apellidos='" + apellidos + '\'' +
                ",\n direccion='" + direccion + '\'' +
                ",\n acudiente='" + acudiente + '\'' +
                ",\n telefonoCelular='" + Numero_Celular + '\'' +
                ",\n telefonoFijo='" + Numero_Fijo + '\'' +
                ",\n estado='" + estado + '\'' +
                ",\n riesgo='" + riesgo + '\'' +
                "\n }";           
    }
}