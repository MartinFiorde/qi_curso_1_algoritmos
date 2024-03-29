package com.qi.curso_1_algoritmos.c2_binary_search;

import java.util.Scanner;
import java.util.logging.Logger;

public class BinarySearch {
    private static final Logger logger = Logger.getLogger(BinarySearch.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int[] array = generateArray();
        printArray(array);

        logger.info("Ingresa el numero a buscar: ");
        int numberToFind = scanner.nextInt();

        int indexFound = binarySearch(array, numberToFind);

        if (indexFound != -1) {
            logger.info(String.format("El valor '%s' fue encontrado en el índice %d", numberToFind, indexFound));
        } else {
            logger.info(String.format("El valor '%s' no fue encontrado en el array.", numberToFind));
        }

        scanner.close();
    }

    private static int binarySearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
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
        logger.info(string.toString());
    }
    
    private static int[] generateArray() {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
        return array;
    }
}
