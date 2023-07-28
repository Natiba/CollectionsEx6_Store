package Service;

import Entity.Store;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class StoreService {

    //Entre <> Primer termino, digo que tipo de dato es la llave, segundo termino tipo de dato que es el OBJETO a guardar
    private HashMap<String , Store> newMap; // Creo EL MAPA
    private Scanner sc; // Creo el Scanner para utilizar en toda mi clase

    public StoreService() {

        this.newMap = new HashMap<>(); // Creo el espacio en memoria del MAPA
        this.sc = new Scanner(System.in).useDelimiter("\n");// Cuando se invoca la clase, habilita el flujo de datos

    }

    public void menu() {

        int opcionMenu = 0;

        do {

            String model1 = "Que desea hacer? Ingrese opción, por favor \n\n";
            String model2 = "MENU: \n";
            String model3 = "1. Crear producto \n";
            String model4 = !(newMap.size() > 0) ? "" : "2. Mostrar productos \n" + "3. Modificar Producto/Precio \n" + "4. Eliminar un producto \n";
            String model5 = "5. Salir \n";

            System.out.println(model1 + model2 + model3 + model4 + model5);

            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1:
                    create();
                    break;
                case 2:
                    if (!(newMap.size() > 0)) {
                        System.out.println("Ingrese una opción correcta, por favor (1 ó 5) \n");

                    } else {
                        show();
                    }
                    break;
                case 3:
                    if (!(newMap.size() > 0)) {
                        System.out.println("Ingrese una opción correcta, por favor (1 ó 5) \n");

                    } else {
                        modify();
                    }
                    break;
                case 4:
                    if (!(newMap.size() > 0)) {
                        System.out.println("Ingrese una opción correcta, por favor (1 ó 5) \n");

                    } else {
                        delete();
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    if (!(newMap.size() > 0)) {
                        System.out.println("Ingrese una opción correcta, por favor (1 ó 5) \n");
                    } else {
                        System.out.println("Ingrese una opción correcta, por favor (1 al 5) \n");
                    }

            }

        } while (opcionMenu > 0 && opcionMenu < 6);

    }

    public void create() {

        Store objectStore = new Store ();
        // idKey = objectStore.getId();
        
        String prodEnter;
        Integer priceEnter;
        String optionCreate;
        //int newKey = 0;  // Esto lo usaba para generar una key unica

        do {

            System.out.println("Ingrese nombre del producto, por favor ");
            prodEnter = sc.next();
            System.out.println("");
            System.out.println("Ingrese precio del producto, por favor ");
            priceEnter = sc.nextInt();
            System.out.println("");
            
            String uuid = uuid();
            
            //newKey += 1; // Esto lo usaba para generar una key unica

            // De este modo agrego elementos a un mapa. Observar que el primer termino se corresponde a la KEY
            //newMap.put(newKey, new Store(prodEnter, priceEnter));
            newMap.put(uuid, new Store(prodEnter, priceEnter));

            System.out.println("Desea agregar más productos? (S/N)");
            optionCreate = sc.next();
            System.out.println("");

        } while (optionCreate.equalsIgnoreCase("S"));

    }
    
    // UUID.randomUUID(); // Genera un UUID (Universally Unique Identifier) 
    
    public static final String uuid() {
    String result = java.util.UUID.randomUUID().toString();

    result.replaceAll("-", "");
    result.substring(0, 32);

    return result;
}

    public void show() {

         for (Map.Entry<String, Store> entry : newMap.entrySet()) {
             System.out.println("product (key): " + entry.getKey() + " // price (value): " + entry.getValue() + "\n");
        }
        }



    public void modify() {

        String modifyProd;
        Integer modifyOption;

        do {

            System.out.println("Sobre qué producto desea hacer modificaciones?");
            modifyProd = sc.next();

            System.out.println("Que desea modificar? \n"
                    + "1. Nombre del producto"
                    + "2. Precio del producto");
            modifyOption = sc.nextInt();

        } while (true);

    }

    public void delete() {

        System.out.println("Qué producto desea eliminar?");
        String prodRemove = sc.next();

        newMap.remove(prodRemove);

//        for (Map.Entry<String, Integer> entry : prodsList.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            
//        }
        System.out.println("El producto '" + prodRemove + "' ha sido eliminado de la lista \n");

    }

}

//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos productos que  
//venderemos y el precio que tendrán. Además, se necesita que la aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio, eliminar un producto y 
//mostrar los productos que tenemos con su precio (Utilizar Hashmap). 
//El HashMap tendrá de llave el nombre del producto y de valor el precio. 
//Realizar un menú para lograr todas las acciones previamente mencionadas.
