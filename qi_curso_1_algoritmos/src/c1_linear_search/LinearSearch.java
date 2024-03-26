package c1_linear_search;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        String[] array = generateArray();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("("+Arrays.asList(array).size()+") "+Arrays.asList(array).toString());
        System.out.print("Ingresa la palabra a buscar: ");
        String palabraABuscar = scanner.nextLine();

        int indiceEncontrado = linealSearch(array, palabraABuscar);

        if (indiceEncontrado != -1) {
            System.out.println("La palabra '" + palabraABuscar + "' fue encontrada en el índice " + indiceEncontrado);
        } else {
            System.out.println("La palabra '" + palabraABuscar + "' no fue encontrada en el array.");
        }

        scanner.close();
    }

    public static int linealSearch(String[] array, String elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elemento)) {
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
