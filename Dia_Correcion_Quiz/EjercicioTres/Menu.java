package EjercicioTres;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Armeria armeria;
    private Scanner scanner;
    private Map<String, Personaje> personajes;
    private Map<String, Arma> armas;

    public Menu() {
        armeria = new Armeria();
        scanner = new Scanner(System.in);
        personajes = new HashMap<>();
        armas = new HashMap<>();
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear un Héroe");
            System.out.println("2. Crear un Villano");
            System.out.println("3. Crear un arma");
            System.out.println("4. Asignar arma a un personaje");
            System.out.println("5. Blandir, Atacar y Soltar");
            System.out.println("6. Mostrar Datos Existentes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearPersonaje(true);
                    break;
                case 2:
                    crearPersonaje(false);
                    break;
                case 3:
                    crearArma();
                    break;
                case 4:
                    asignarArma();
                    break;
                case 5:
                    realizarAcciones();
                    break;
                case 6:
                    mostrarDatosExistentes();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearPersonaje(boolean esHeroe) {
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();

        if (personajes.containsKey(nombre)) {
            System.out.println("Ya existe un personaje con ese nombre.");
            return;
        }

        Personaje personaje;
        if (esHeroe) {
            personaje = new Heroe(nombre);
        } else {
            personaje = new Villano(nombre);
        }

        personajes.put(nombre, personaje);
        System.out.println((esHeroe ? "Héroe" : "Villano") + " " + nombre + " creado.");
    }

    private void crearArma() {
        System.out.print("Ingrese el tipo de herrero (Elfo/Enano): ");
        String tipoHerrero = scanner.nextLine();

        System.out.print("Ingrese el tipo de encantamiento (Fuego/Vorpal): ");
        String tipoEncantamiento = scanner.nextLine();

        Encantamiento encantamiento;
        if (tipoEncantamiento.equalsIgnoreCase("Fuego")) {
            encantamiento = new Fuego();
        } else if (tipoEncantamiento.equalsIgnoreCase("Vorpal")) {
            encantamiento = new Vorpal();
        } else {
            System.out.println("Encantamiento desconocido.");
            return;
        }

        Arma arma = armeria.crearArma(tipoHerrero, encantamiento);
        armas.put(arma.getClass().getSimpleName() + "-" + tipoEncantamiento, arma);
        System.out.println("Arma creada: " + arma.getClass().getSimpleName() + " con encantamiento " + tipoEncantamiento);
    }

    private void asignarArma() {
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();
        Personaje personaje = buscarPersonaje(nombre);

        if (personaje == null) {
            System.out.println("Personaje no encontrado.");
            return;
        }

        System.out.print("Ingrese el tipo de arma (Espada/Martillo): ");
        String tipoArma = scanner.nextLine();

        System.out.print("Ingrese el tipo de encantamiento (Fuego/Vorpal): ");
        String tipoEncantamiento = scanner.nextLine();

        Encantamiento encantamiento;
        if (tipoEncantamiento.equalsIgnoreCase("Fuego")) {
            encantamiento = new Fuego();
        } else if (tipoEncantamiento.equalsIgnoreCase("Vorpal")) {
            encantamiento = new Vorpal();
        } else {
            System.out.println("Encantamiento desconocido.");
            return;
        }

        Arma arma = armeria.crearArma("Elfo", encantamiento); // Aquí puedes ajustar el tipo de herrero si es necesario
        personaje.asignarArma(arma);
        System.out.println("Arma asignada a " + nombre);
    }

    private void realizarAcciones() {
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();
        Personaje personaje = buscarPersonaje(nombre);

        if (personaje == null) {
            System.out.println("Personaje no encontrado.");
            return;
        }

        System.out.println("1. Blandir");
        System.out.println("2. Atacar");
        System.out.println("3. Soltar");
        System.out.print("Seleccione una acción: ");
        int accion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (accion) {
            case 1:
                personaje.blandir();
                break;
            case 2:
                personaje.atacar();
                break;
            case 3:
                personaje.soltar();
                break;
            default:
                System.out.println("Acción no válida.");
        }
    }

    private void mostrarDatosExistentes() {
        System.out.println("\n--- DATOS EXISTENTES ---");

        // Mostrar personajes y sus armas
        System.out.println("\nPersonajes:");
        for (Personaje personaje : personajes.values()) {
            System.out.println(personaje.getNombre() + " - Arma: " + (personaje.getArma() != null ? personaje.getArma().getClass().getSimpleName() : "Ninguna"));
        }

        // Mostrar armas
        System.out.println("\nArmas:");
        for (Arma arma : armas.values()) {
            System.out.println(arma.getClass().getSimpleName() + " con encantamiento " + arma.getEncantamiento().getClass().getSimpleName());
        }
    }

    private Personaje buscarPersonaje(String nombre) {
        return personajes.get(nombre);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}
