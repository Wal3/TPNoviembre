package tp.walter.abm.uno;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Uno {
    private static Map<String,Mascota> mascotas = new HashMap<String,Mascota>();

    private Uno() {
    }

    public static void run(Scanner scan) {
        boolean bk = false;
        while(true) {
            System.out.println("Inserte el numero de una de las siguientes opciones:");
            System.out.println("1. Alta de Mascota");
            System.out.println("2. Baja de Mascota");
            System.out.println("3. Modificar Mascota existente");
            System.out.println("4. Saludar Mascota");
            System.out.println("5. Alimentar Mascota");
            System.out.println("0. Salir");
            int input;
            if(scan.hasNextInt()) {
                input = scan.nextInt();
            } else {
                continue;
            }
            scan.nextLine();
            switch(input) {
                case 1:
                    Uno.alta(scan);
                    break;
                case 2:
                    Uno.baja(scan);
                    break;
                case 3:
                    Uno.modifica(scan);
                    break;
                case 4:
                    Uno.saluda(scan);
                    break;
                case 5:
                    Uno.alimenta(scan);
                    break;
                case 0:
                    bk = true;
            }
            System.out.println("Continuar...");
            if(scan.hasNextLine()) scan.nextLine();
            if(bk) break;
        }
    }

    public static void alta(Scanner scan) {
        String nombre;
        String owner;
        String tipo;
        Mascota mascota = null;

        while(true) {
            System.out.print("Nombre: ");
            if(scan.hasNextLine()) {
                nombre = scan.nextLine();
                if(Uno.mascotas.containsKey(nombre)) {
                    System.out.println("Ya existe");
                    continue;
                }
                break;
            }
        }
        while(true) {
            System.out.print("Owner: ");
            if(scan.hasNextLine()) {
                owner = scan.nextLine();
                break;
            }
        }
        while(true) {
            System.out.print("Tipo: ");
            if(scan.hasNextLine()) {
                tipo = scan.nextLine();
                switch(tipo) {
                    case "Gato":
                        mascota = new Gato(nombre, owner);
                        break;
                    case "Perro": 
                        mascota = new Perro(nombre, owner);
                        break;
                    case "Pez":
                        mascota = new Pez(nombre, owner);
                        break;
                    case "Pajarito":
                        boolean canta = false;
                        while(true) {
                            System.out.print("Canta? (true/false): ");
                            if(scan.hasNextBoolean()) {
                                canta = scan.nextBoolean();
                                scan.nextLine();
                                break;
                            }
                        }
                        if(canta) {
                            String canto;
                            while(true) {
                                System.out.print("Como canta?: ");
                                if(scan.hasNextLine()) {
                                    canto = scan.nextLine();
                                    break;
                                }
                            }
                            mascota = new Pajarito(nombre, owner, canto);
                        } else {
                            mascota = new Pajarito(nombre, owner);
                        }
                }
                if(mascota != null) {
                    break;
                }
            }
        }
        Uno.mascotas.put(nombre, mascota);
    }

    public static void baja(Scanner scan) {
        String nombre;
        while(true) {
            System.out.print("Nombre: ");
            if(scan.hasNextLine()) {
                nombre = scan.nextLine();
                break;
            }
        }
        if(Uno.mascotas.containsKey(nombre)) {
            Uno.mascotas.remove(nombre);
            System.out.println("La mascota " + nombre + " fue bajada exitosamente!");
        } else {
            System.out.println("La mascota " + nombre + " no existe");
        }
    }

    public static void modifica(Scanner scan) {
        boolean bk = false;
        boolean cantor = false;
        Mascota mascota;
        while(true) {
            System.out.print("Nombre: ");
            if(scan.hasNextLine()) {
                String nombre;
                nombre = scan.nextLine();
                if(Uno.mascotas.containsKey(nombre)) {
                    mascota = Uno.mascotas.get(nombre);
                    break;
                }
            }
        }
        if(mascota instanceof Pajarito && ((Pajarito) mascota).isCantor()) cantor = true;
        while(true) {
            System.out.println("Inserte el numero de una de las siguientes opciones:");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar owner");
            if(cantor) {
                System.out.println("3. Modificar canto");
            }
            System.out.println("0. Salir");

            int input;
            if(scan.hasNextInt()) {
                input = scan.nextInt();
            } else {
                continue;
            }
            scan.nextLine();
            switch(input) {
                case 1:
                    String nombre;
                    while(true) {
                        System.out.print("Nuevo nombre: ");
                        if(scan.hasNextLine()) {
                            nombre = scan.nextLine();
                            if(Uno.mascotas.containsKey(nombre)) {
                                System.out.println("Ya existe");
                                continue;
                            }
                            break;
                        }
                    }
                    mascotas.remove(mascota.getNombre());
                    mascota.setNombre(nombre);
                    mascotas.put(nombre, mascota);
                    break;
                case 2:
                    String owner;
                    while(true) {
                        System.out.print("Nuevo duenio: ");
                        if(scan.hasNextLine()) {
                            owner = scan.nextLine();
                            break;
                        }
                    }
                    mascota.setOwner(owner);
                    mascotas.put(mascota.getNombre(), mascota);
                    break;
                case 3:
                    if(!cantor) break;
                    String canto;
                    while(true) {
                        System.out.print("Nuevo canto: ");
                        if(scan.hasNextLine()) {
                            canto = scan.nextLine();
                            break;
                        }
                    }
                    mascota.setSaludo(canto);
                    mascotas.put(mascota.getNombre(), mascota);
                    break;
                case 0:
                    bk = true;
            }
            if(bk) break;
        }
    }

    public static void saluda(Scanner scan) {
        Mascota mascota;
        String owner;
        while(true) {
            System.out.print("Nombre: ");
            if(scan.hasNextLine()) {
                String nombre;
                nombre = scan.nextLine();
                if(Uno.mascotas.containsKey(nombre)) {
                    mascota = Uno.mascotas.get(nombre);
                    break;
                }
            }
        }
        while(true) {
            System.out.print("Owner: ");
            if(scan.hasNextLine()) {
                owner = scan.nextLine();
                break;
            }
        }
        try {
            System.out.println(mascota.saludar(owner));
            mascotas.put(mascota.getNombre(), mascota);
        } catch (Mortis e) {
            mascotas.remove(mascota.getNombre());
            System.out.println(mascota.getNombre() + " murio equisde");
        }
    }

    public static void alimenta(Scanner scan) {
        Mascota mascota;
        while(true) {
            System.out.print("Nombre: ");
            if(scan.hasNextLine()) {
                String nombre;
                nombre = scan.nextLine();
                if(Uno.mascotas.containsKey(nombre)) {
                    mascota = Uno.mascotas.get(nombre);
                    break;
                }
            }
        }
        mascota.alimentar();
        mascotas.put(mascota.getNombre(), mascota);
    }
}
