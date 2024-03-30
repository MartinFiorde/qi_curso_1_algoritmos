package com.qi.curso_1_algoritmos.c2_binary_search;

import java.util.Scanner;
import java.util.logging.Logger;

public class BinarySearch {
    private static final Logger logger = Logger.getLogger(BinarySearch.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int[] array = generateArray();

        logger.info("Ingresa el numero a buscar: ");
        int itemToFind = scanner.nextInt();
        int indexFound = binarySearch(array, 0, array.length, itemToFind);
        //int indexFound = binarySearch2(array, itemToFind);
        informResult(indexFound, itemToFind);

        scanner.close();
    }

    private static void informResult(int indexFound, int itemToFind) {
        if (indexFound != -1) {
            String msg = String.format("El valor '%s' fue encontrado en el índice %d", itemToFind, indexFound);
            logger.info(msg);
        } else {
            String msg = String.format("El valor '%s' no fue encontrado en el array.", itemToFind);
            logger.info(msg);
        }
    }

    // personal solution
    private static int binarySearch(int[] array, int min, int max, int itemToFind) {
        int middle = min + (max - min) / 2;
        logger.info(String.valueOf(middle));
        if (middle == min || middle == max) return -1;

        if (itemToFind < array[middle]) middle = binarySearch(array, min, middle, itemToFind);
        else if (array[middle] < itemToFind) middle = binarySearch(array, middle, max, itemToFind);

        return middle;
    }

    // course solution
    private static int binarySearch2(int[] array, int itemToFind) {
        int low = 0;
        int top = array.length;
        do {
            int middle = low + (top - low) / 2;
            int value = array[middle];
            if (value == itemToFind) return middle;
            else if (value < itemToFind) low = middle + 1; //incluye valor minimo, excluye valor maximo
            else top = middle;
        } while (low < top); //no <=, porque el minimo se incluye, y el maximo se excluye. si fuera <= entraría en un estado roto
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
        String msg = string.toString();
        logger.info(msg);
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
