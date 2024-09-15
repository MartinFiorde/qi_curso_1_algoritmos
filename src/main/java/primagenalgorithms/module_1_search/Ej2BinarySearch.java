package primagenalgorithms.module_1_search;

import java.util.Scanner;
import java.util.logging.Logger;

public class Ej2BinarySearch {
    private static final Logger logger = Logger.getLogger(Ej2BinarySearch.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        int[] array = generateArray();
        logger.info("Ingresa el numero a buscar: ");
        int itemToFind = scanner.nextInt();
        int indexFound = binarySearch(array, 0, array.length, itemToFind);
        informResult(indexFound, itemToFind);

        int[] array2 = generateArrayWithNegativeNumbers();
        logger.info("Ingresa el numero a buscar: ");
        int itemToFind2 = scanner.nextInt();
        int indexFound2 = binarySearch2(array2, itemToFind2);
        informResult(indexFound2, itemToFind2);

        scanner.close();
    }

    private static void informResult(int indexFound, int itemToFind) {
        if (indexFound != -1) {
            logger.info(() -> String.format("El valor '%s' fue encontrado en el índice %d", itemToFind, indexFound));
        } else {
            logger.info(() -> String.format("El valor '%s' no fue encontrado en el array.", itemToFind));
        }
    }

    // personal solution
    private static int binarySearch(int[] array, int min, int max, int itemToFind) {
        int middle = min + (max - min) / 2;
        String msg = String.valueOf(middle);
        logger.info(msg);
        if (middle == min || middle == max) return -1;

        if (itemToFind < array[middle]) middle = binarySearch(array, min, middle, itemToFind);
        else if (array[middle] < itemToFind) middle = binarySearch(array, middle, max, itemToFind);

        return middle;
    }

    // course solution
    private static int binarySearch2(int[] array, int itemToFind) {
        int low = 0;
        int top = array.length - 1;
        do {
            int middle = low + (top - low) / 2;
            logger.info(() -> String.valueOf(middle));
            if (array[middle] == itemToFind) return middle;
            else if (array[middle] < itemToFind) low = middle + 1;
            else top = middle - 1;
        } while (low <= top);
        return -1;
    }

    private static void printArray(int[] array) {
        StringBuilder string = new StringBuilder();
        string.append("Contenido del array: ");
        for (int i = 0; i < array.length; i++) {
            string.append(array[i]);
            if (i < array.length - 1) {
                string.append(", ");
            }
        }
        logger.info(string::toString);
    }

    private static int[] generateArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i * 100;
        }
        printArray(array);
        return array;
    }

    private static int[] generateArrayWithNegativeNumbers() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = i * -100;
        }
        return array;
    }
}
