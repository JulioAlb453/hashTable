import org.json.JSONObject;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Hashtable<Integer, Business> hashtable = new Hashtable<>();
        ArrayList<ListaEnlazada> repetidos = new ArrayList<>();
        CustomHashTable hashDivcion = new CustomHashTable(10);


        do {
            System.out.println("");
            System.out.println("presione la opcion 1 para cargar datos");
            System.out.println("presione la opcion 2 para insertar datos");
            System.out.println("presione la opcion 3 para buscar datos por id (hashTable simple)");
            System.out.println("presione la opcion 4 para ingresar  datos por id (hashTable division)");
            System.out.println("presione la opcion 5 para visualizar  datos por id (hashTable division)");
            System.out.println("presione la opcion 6 para buscar datos por id (hashTable division)");
            System.out.println("presione la opcion 7 para buscar datos repetidos por id (hashTable division)");
            System.out.print("Opcion: ");
            System.out.println("");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    cargarDatos(hashtable);
                    break;

                case 2:
                    insertarDatos(hashtable, repetidos);
                    break;

                case 3:
                    visualidarDatos(hashtable, repetidos);
                    break;

                case 4:
                    insertarDatosHashDivide(hashDivcion);
                    break;
                case 5:
                    visualidarDatosHashDidive(hashDivcion);
                    break;
                case 6:
                    visualidarDatosDuplicadosHashDidive(hashDivcion);
                    break;
            }
        } while (opcion != 6);

    }

    public static void cargarDatos(Hashtable<Integer, Business> hashtable) {
        Business business;
        String filePath = "src/yelp_academic_dataset_tip.json";
        int id = 1;
        System.out.println("Cargando datos ....");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = new JSONObject(line);

                // Ejemplo de cómo acceder a los campos del objeto JSON
                String userId = jsonObject.getString("user_id");
                String businessId = jsonObject.getString("business_id");
                String text = jsonObject.getString("text");
                String date = jsonObject.getString("date");
                int complimentCount = jsonObject.getInt("compliment_count");
                business = new Business(userId, businessId, text, date, complimentCount);

                hashtable.put(id, business);
                id++;
                // Aquí puedes hacer cualquier procesamiento adicional con los datos
            }
            System.out.println("Carga exitosa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void visualidarDatos(Hashtable<Integer, Business> hashtable, ArrayList<ListaEnlazada> repetidos) {
        int id = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el id a buscar");
        id = sc.nextInt();
        boolean encontrado = false;


        if (hashtable.containsKey(id)) {
            Business business = hashtable.get(id);

            for (ListaEnlazada repetido : repetidos) {
                if (Objects.equals(business, repetido.getValorAnterior())) {

                    System.out.println("Elemento repetido encontrado:");
                    System.out.println("Valor anterior: " + repetido.getValorAnterior() + "   " + " Valor nuevo: " + repetido.getNuevoValor());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println(hashtable.get(id).toString());
            }
        } else {
            System.out.println("No existe el id a buscar");
        }
    }

    public static void insertarDatos(Hashtable<Integer, Business> hashtable, ArrayList<ListaEnlazada> repetidos) {
        int id = 0;
        Scanner sc = new Scanner(System.in);
        Business nuevoValor = new Business();
        System.out.println("Insertando datos...: ");

        System.out.println("Inserta UserId: ");
        String insertar = sc.nextLine();
        int insertar1 = 0;
        nuevoValor.setUser_id(insertar);

        System.out.println("Inserta BussineId: ");
        insertar = sc.nextLine();
        nuevoValor.setBusiness_id(insertar);

        System.out.println("Inserta text: ");
        insertar = sc.nextLine();
        nuevoValor.setText(insertar);

        System.out.println("Inserta date: ");
        insertar = sc.nextLine();
        nuevoValor.setDate(insertar);

        System.out.println("Inserta complimentCount: ");
        insertar1 = sc.nextInt();
        nuevoValor.setComplimentCount(insertar1);

        System.out.println("Inserta id del hash: ");
        insertar1 = sc.nextInt();
        id = insertar1;

        // Verificar si los nuevos valores están repetidos

        Business valorAnterior = hashtable.get(id);
        if (valorAnterior == null) {
            // Si no se encontró un elemento repetido, insertar el nuevo elemento
            hashtable.put(id, nuevoValor);
            System.out.println("Elemento insertado correctamente.");
        } else {
            ListaEnlazada linkedList = new ListaEnlazada(valorAnterior, nuevoValor);
            repetidos.add(linkedList);
        }
    }

    public static void insertarDatosHashDivide(CustomHashTable customHashTable) {
        int id = 0;
        Scanner sc = new Scanner(System.in);
        Business nuevoValor = new Business();
        System.out.println("Insertando datos...: ");

        System.out.println("Inserta UserId: ");
        String insertar = sc.nextLine();
        int insertar1 = 0;
        nuevoValor.setUser_id(insertar);

        System.out.println("Inserta BussineId: ");
        insertar = sc.nextLine();
        nuevoValor.setBusiness_id(insertar);

        System.out.println("Inserta text: ");
        insertar = sc.nextLine();
        nuevoValor.setText(insertar);

        System.out.println("Inserta date: ");
        insertar = sc.nextLine();
        nuevoValor.setDate(insertar);

        System.out.println("Inserta complimentCount: ");
        insertar1 = sc.nextInt();
        nuevoValor.setComplimentCount(insertar1);

        System.out.println("Inserta id del hash: ");
        insertar1 = sc.nextInt();
        id = insertar1;

        // Verificar si los nuevos valores están repetidos

        customHashTable.insert(id, nuevoValor);

//        if (valorAnterior == null) {
//            // Si no se encontró un elemento repetido, insertar el nuevo elemento
//            hashtable.put(id, nuevoValor);
//            System.out.println("Elemento insertado correctamente.");
//        } else {
//            ListaEnlazada linkedList = new ListaEnlazada(valorAnterior, nuevoValor);
//            repetidos.add(linkedList);
//        }
    }

    public static void visualidarDatosHashDidive(CustomHashTable customHashTable){
        customHashTable.printAll();
    }
    public static void visualidarDatosDuplicadosHashDidive(CustomHashTable customHashTable){
        customHashTable.printDuplicates();
    }
}

