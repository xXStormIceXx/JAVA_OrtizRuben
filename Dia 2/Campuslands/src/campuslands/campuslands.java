/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuslands;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rubenortiz
 */
public class campuslands {
    private List<Camper> campers;
    private Scanner scanner;
    public campuslands(){
        campers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addCamper(){
        Camper camper = new Camper();
        System.out.print("Ingrese la identificación del nuevo camper: ");
        camper.setIdentificacion(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Ingrese los nombres del nuevo camper: ");
        camper.setNombres(scanner.nextLine());
        System.out.print("Ingrese los apellidos del nuevo camper: ");
        camper.setApellidos(scanner.nextLine());
        System.out.print("Ingrese la direccion del nuevo camper: ");
        camper.setDireccion(scanner.nextLine());
        System.out.print("Ingrese el acudiente del nuevo camper: ");
        camper.setAcudiente(scanner.nextLine());
        System.out.print("Ingrese el numero de celular del nuevo camper: ");
        camper.setNumeroCelular(scanner.nextInt());
        scanner.nextLine(); 
        System.out.print("Ingrese el numero fijo del nuevo camper: ");
        camper.setNumeroFijo(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Ingrese el estado del nuevo camper: ");
        camper.setEstado(scanner.nextLine());
        System.out.print("Ingrese el riesgo actual del nuevo camper: ");
        camper.setRiesgo(scanner.nextLine());
        campers.add(camper);
        System.out.println("Camper agregado exitosamente.");
    }
    
    private Camper findCamperById(int identificacion){
        for(Camper camper : campers){
            if(camper.getIdentificacion() == identificacion){
                return camper;
            }
        } return null;
    }
    
    public void deleteCamper() {
    System.out.print("Ingrese identificación del camper a eliminar: ");
    int identificacion = scanner.nextInt();
    Camper camper = findCamperById(identificacion);

    if (camper == null) {
        System.out.println("Camper no encontrado.");
    } else {
        campers.remove(camper);
        System.out.println("Camper eliminado exitosamente.");
        }
    }
    
    public void viewCamper(){
        if(campers.isEmpty()){
            System.out.println("No hay ningún camper registrado");
        } else {
            for (Camper camper : campers){
                System.out.println(camper);
            }
        }
    }
    
public void updateCamper() {
    System.out.print("Ingrese identificación del camper a actualizar: ");
    int identificacion = scanner.nextInt();
    scanner.nextLine(); // Clear the buffer
    Camper camper = findCamperById(identificacion);

    if (camper == null) {
        System.out.println("Camper no encontrado.");
    } else {
        System.out.print("Ingrese nuevos nombres (actual: " + camper.getNombres() + "): ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese nuevos apellidos (actual: " + camper.getApellidos() + "): ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese nueva dirección (actual: " + camper.getDireccion() + "): ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese nuevo acudiente (actual: " + camper.getAcudiente() + "): ");
        String acudiente = scanner.nextLine();
        System.out.print("Ingrese nuevo teléfono celular (actual: " + camper.getNumeroCelular() + "): ");
        int numeroCelular = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Ingrese nuevo teléfono fijo (actual: " + camper.getNumeroFijo() + "): ");
        int numeroFijo = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Ingrese nuevo estado (actual: " + camper.getEstado() + "): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese nuevo riesgo (actual: " + camper.getRiesgo() + "): ");
        String riesgo = scanner.nextLine();

        camper.setNombres(nombres);
        camper.setApellidos(apellidos);
        camper.setDireccion(direccion);
        camper.setAcudiente(acudiente);
        camper.setNumeroCelular(numeroCelular);
        camper.setNumeroFijo(numeroFijo);
        camper.setEstado(estado);
        camper.setRiesgo(riesgo);

        System.out.println("Camper actualizado exitosamente!!!.");
    }
}
    
    public static void main(String[] args) {
            campuslands dia1 = new campuslands();
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("***************************");
                System.out.println("*********   Menu  *********");
                System.out.println("***************************");
                System.out.println("|1. Agregar Camper        |");
                System.out.println("|2. Ver Campers           |");
                System.out.println("|3. Actualizar Camper     |");
                System.out.println("|4. Eliminar Camper       |");
                System.out.println("|5. Salir                 |");
                System.out.print("|Seleccione una opción:   |");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer
                
                switch (opcion) {
                    case 1:
                        dia1.addCamper();
                        break;
                    case 2:
                        dia1.viewCamper();
                        break;
                    case 3:
                        dia1.updateCamper();
                        break;
                    case 4:
                        dia1.deleteCamper();
                        break;
                    case 5:
                        System.out.println("**********************");
                        System.out.println("***   gracias xD   ***");
                        System.out.println("**********************");
                        break;
                    default:
                        System.out.println("Opción Inválida. Intente Nuevamente.");
                }
            } while (opcion != 5);
        }
    }