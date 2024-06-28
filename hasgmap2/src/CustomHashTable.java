import java.util.Hashtable;
import java.util.LinkedList;

public class CustomHashTable {
    private Hashtable<Integer, LinkedList<Business>> hashtable;
    private LinkedList<Business> duplicates;

    int tableSize;


    public CustomHashTable(int size) {
        this.tableSize = size;
        this.hashtable = new Hashtable<>(size);
    }

    public CustomHashTable() {
    }

    private int getHash(int key) {
        return key % tableSize;
    }

    public void insert(int key, Business business) {
        int hash = getHash(key);
        hashtable.putIfAbsent(hash, new LinkedList<>());

        // Verificar si los nuevos valores están repetidos
        for (Business b : hashtable.get(hash)) {
            if (b.getUser_id().equals(business.getUser_id()) &&
                    b.getBusiness_id().equals(business.getBusiness_id()) &&
                    b.getText().equals(business.getText()) &&
                    b.getDate().equals(business.getDate()) &&
                    b.getComplimentCount() == business.getComplimentCount()) {

                System.out.println("Elemento repetido encontrado:");
                System.out.println(b.toString());
                duplicates.add(business);
                return;
            }
        }

        // Si no se encontró un elemento repetido, insertar el nuevo elemento
        hashtable.get(hash).add(business);
        System.out.println("Elemento insertado correctamente.");
    }

    public LinkedList<Business> get(int key) {
        int hash = getHash(key);
        return hashtable.get(hash);
    }

    public void printAll() {
        for (int key : hashtable.keySet()) {
            System.out.println("Hash: " + key);
            for (Business business : hashtable.get(key)) {
                System.out.println(business);
            }
        }
    }

    public void printDuplicates() {
        System.out.println("Elementos duplicados:");
        if (duplicates != null) {
            for (Business business : duplicates) {
                System.out.println(business);
            }
        }
    }
}
