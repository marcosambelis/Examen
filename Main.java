import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cocina cocina = new Cocina();
        int contadorOrden = 1;

        System.out.println("=========================================");
        System.out.println("         JACK PIZZA PLACE               ");
        System.out.println("=========================================");

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear orden y mandar a cocina");
            System.out.println("2. Cocinar siguiente orden");
            System.out.println("3. Ver órdenes pendientes en cocina");
            System.out.println("4. Demostración de sobrecarga (Overloading)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (!cocina.hayEspacio()) {
                        System.out.println("❌ No se pueden recibir más pedidos. La cocina está llena (5/5).");
                        break;
                    }

                    System.out.print("\nIngrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();

                    System.out.println("\nSeleccione tipo de masa:");
                    System.out.println("1. Artesanal");
                    System.out.println("2. Clásica");
                    System.out.println("3. Delgada");
                    System.out.print("Opción: ");
                    int opcMasa = scanner.nextInt();
                    TipoMasa masa = TipoMasa.CLASICA;
                    if (opcMasa == 1) {
                        masa = TipoMasa.ARTESANAL;
                    } else if (opcMasa == 3) {
                        masa = TipoMasa.DELGADA;
                    }

                    System.out.println("\nSeleccione tipo de salsa:");
                    System.out.println("1. Normal");
                    System.out.println("2. Picante");
                    System.out.println("3. BBQ");
                    System.out.print("Opción: ");
                    int opcSalsa = scanner.nextInt();
                    TipoSalsa salsa = TipoSalsa.NORMAL;
                    if (opcSalsa == 2) {
                        salsa = TipoSalsa.PICANTE;
                    } else if (opcSalsa == 3) {
                        salsa = TipoSalsa.BBQ;
                    }

                    Pizza nuevaPizza = new Pizza(masa, salsa);

                    int opcTopping = -1;
                    while (opcTopping != 0) {
                        System.out.println("\n--- Agregar Toppings ---");
                        System.out.println("1. Pepperoni");
                        System.out.println("2. Carne");
                        System.out.println("3. Jamón");
                        System.out.println("4. Piña");
                        System.out.println("5. Aceitunas");
                        System.out.println("6. Chile Pimiento");
                        System.out.println("0. Terminar ingredientes");
                        System.out.print("Opción: ");
                        opcTopping = scanner.nextInt();

                        TipoTopping toppingElegido = null;
                        switch (opcTopping) {
                            case 1:
                                toppingElegido = TipoTopping.PEPPERONI;
                                break;
                            case 2:
                                toppingElegido = TipoTopping.CARNE;
                                break;
                            case 3:
                                toppingElegido = TipoTopping.JAMON;
                                break;
                            case 4:
                                toppingElegido = TipoTopping.PINA;
                                break;
                            case 5:
                                toppingElegido = TipoTopping.ACEITUNAS;
                                break;
                            case 6:
                                toppingElegido = TipoTopping.CHILE_PIMIENTO;
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                        if (toppingElegido != null) {
                            System.out.print("¿Cuántas porciones de este ingrediente?: ");
                            int porciones = scanner.nextInt();

                            if (porciones > 1) {
                                nuevaPizza.agregarTopping(toppingElegido, porciones);
                            } else {
                                nuevaPizza.agregarTopping(toppingElegido);
                            }
                            System.out.println("-> Ingrediente agregado!");
                        }
                    }

                    Orden orden = new Orden(contadorOrden, nombreCliente, nuevaPizza);
                    contadorOrden++;

                    orden.mostrarResumen();
                    cocina.recibirOrden(orden);
                    break;

                case 2:
                    cocina.cocinarSiguienteOrden();
                    break;

                case 3:
                    cocina.mostrarOrdenes();
                    break;

                case 4:
                    System.out.println("\n--- DEMOSTRACIÓN DE SOBRECARGA EN PIZZA ---");
                    Pizza pizzaEjemplo = new Pizza(TipoMasa.ARTESANAL, TipoSalsa.NORMAL);

                    System.out.println("1. agregarTopping(topping):");
                    pizzaEjemplo.agregarTopping(TipoTopping.PEPPERONI);

                    System.out.println("2. agregarTopping(topping, cantidad):");
                    pizzaEjemplo.agregarTopping(TipoTopping.JAMON, 2);

                    System.out.println("3. agregarTopping(arreglo):");
                    TipoTopping[] varios = { TipoTopping.CARNE, TipoTopping.ACEITUNAS };
                    pizzaEjemplo.agregarTopping(varios);

                    System.out.print("Resultado final: ");
                    pizzaEjemplo.mostrarPizza();
                    break;

                case 0:
                    System.out.println("\n¡Gracias por visitar Jack Pizza Place!");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
