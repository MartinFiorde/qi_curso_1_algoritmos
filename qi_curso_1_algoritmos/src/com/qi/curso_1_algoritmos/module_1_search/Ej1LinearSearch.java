package com.qi.curso_1_algoritmos.module_1_search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ej1LinearSearch {

    private static final Logger logger = Logger.getLogger(Ej1LinearSearch.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String[] array = generateArray();

        logger.info(() -> String.format("(%d) %s", Arrays.asList(array).size(), Arrays.asList(array)));
        logger.info("Ingresa la palabra a buscar: ");
        String wordToFind = scanner.nextLine();

        int indexFound = linealSearch(array, wordToFind);

        String msg2;
        if (indexFound != -1) {
            msg2 = "La palabra '" + wordToFind + "' fue encontrada en el índice " + indexFound;
        } else {
            msg2 = "La palabra '" + wordToFind + "' no fue encontrada en el array.";
        }
        logger.info(msg2);

        scanner.close();
    }

    public static int linealSearch(String[] array, String wordToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(wordToFind)) {
                return i;
            }
        }
        return -1;
    }
    
    private static String[] generateArray() {
        String[] firstPart = {"gato", "perro", "elefante", "león", "tigre",
                             "jirafa", "cebra", "loro", "serpiente", "rinoceronte"};
        String[] secondPart = {"ballena", "delfín", "tiburón", "pulpo", "medusa",
                             "águila", "búho", "colibrí", "pavo", "cisne"};
        
        String[] fullArray = new String[firstPart.length + secondPart.length];
        System.arraycopy(firstPart, 0, fullArray, 0, firstPart.length);
        System.arraycopy(secondPart, 0, fullArray, firstPart.length, secondPart.length);
        return fullArray;
    }
}
