package primagenalgorithms.module_2_sort_and_datastructures;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

@Slf4j
public class Ej1BubbleSort {
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private static final Logger logger = Logger.getLogger(Ej1BubbleSort.class.getName());

    public static void main(String[] args) {
        logger.info("Ingrese el tamaño del array aleatorio a generar, o cero (0) para cargar un array por defecto");
        int[] originalArray = generateArray(scanner.nextInt());

        int[] sortedArrayV1 = bubbleSortV1(originalArray);
        int[] sortedArrayTeacher = bubbleSortCourseSolution(originalArray);

        if (Arrays.equals(sortedArrayV1, sortedArrayTeacher)) logger.info("resultados coinciden");
    }

    private static int[] bubbleSortV1(int[] originalArray) {
        int[] sortedArray = new int[originalArray.length];
        System.arraycopy(originalArray, 0, sortedArray, 0, originalArray.length);

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j + 1];
                    sortedArray[j + 1] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }

        printArray(sortedArray, "Array ordenado v.1: ");
        return sortedArray;
    }

    private static int[] bubbleSortCourseSolution(int[] originalArray) {
        int[] sortedArray = new int[originalArray.length];
        System.arraycopy(originalArray, 0, sortedArray, 0, originalArray.length);

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j + 1];
                    sortedArray[j + 1] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }

        printArray(sortedArray, "Array ordenado v.teacher: ");
        return sortedArray;
    }

    private static int[] generateArray(int size) {
        int[] array;
        if (size == 0) {
            array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        } else {
            array = new int[size];
            for (int i = 0; i < size; i++) {
                double value = (Math.random() * 100);
                array[i] = (int) value;
            }
        }
        printArray(array, "Contenido del array: ");
        return array;
    }

    private static void printArray(int[] array, String description) {
        StringBuilder string = new StringBuilder();
        string.append(description);
        for (int i = 0; i < array.length; i++) {
            string.append(array[i]);
            if (i < array.length - 1) {
                string.append(", ");
            }
        }
        logger.info(string::toString);
    }
}
