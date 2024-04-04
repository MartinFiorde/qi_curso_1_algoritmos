package com.module_2_sort;

import lombok.extern.slf4j.Slf4j;

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
        int[] sortedArrayTeacher = bubbleSortV1(originalArray);
    }

    private static int[] bubbleSortV1(int[] array) {
        int[] sortedArray;

        //printArray(sortedArray, "Array ordenado v.1");
    return new int[]{1};
    }

    private static int[] bubbleSortCourseSolution(int[] array) {
        return new int[]{1};//TODO
    }

    private static int[] generateArray(int size) {
        int[] array;
        if (size == 0) {
            array = new int[]{9,8,7,6,5,4,3,2,1,0};
        } else {
            array = new int[size];
            for (int i = 0; i < size; i++) {
                double value = (Math.random()*100);
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
