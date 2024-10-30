package general_programs;

import java.util.Arrays;

public class HashSearch {
    private int[] hashTable;
    private int tableSize;

    public HashSearch(int size) {
        tableSize = size;
        hashTable = new int[tableSize];
        Arrays.fill(hashTable, -1);  // Fill the hash table with -1 indicating empty slots
    }

    // Hash function to calculate index
    private int hashFunction(int element) {
        return element % tableSize;
    }

    // Insert elements into the hash table
    public void insert(int[] arr) {
        for (int element : arr) {
            int index = hashFunction(element);
            // Linear probing in case of collision
            while (hashTable[index] != -1) {
                index = (index + 1) % tableSize;
            }
            hashTable[index] = element;
        }
    }

    // Search for an element in the hash table
    public boolean search(int element) {
        int index = hashFunction(element);

        // Linear probing in case of collision
        while (hashTable[index] != -1) {
            if (hashTable[index] == element) {
                return true;  // Element found
            }
            index = (index + 1) % tableSize;
        }
        return false;  // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 290, 560, 2190, 9999};
        int searchElement = 560;  // Element to search for
        int tableSize = arr.length * 2;  // Choose a table size larger than the array size

        HashSearch hashSearch = new HashSearch(tableSize);

        // Insert elements into the hash table
        hashSearch.insert(arr);

        // Search for the element
        if (hashSearch.search(searchElement)) {
            System.out.println("Element " + searchElement + " is present in the array.");
        } else {
            System.out.println("Element " + searchElement + " is not present in the array.");
        }
    }
}

