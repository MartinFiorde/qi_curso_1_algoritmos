package primagenalgorithms.module_1_search;

import java.util.Scanner;
import java.util.logging.Logger;

public class Ej3TwoCristalBallProblem {
    private static final Logger logger = Logger.getLogger(Ej3TwoCristalBallProblem.class.getName());
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        logger.info("ingrese la cantidad de posibles puntos de rotura a analizar");
        boolean[] array = generateArray(scanner.nextInt());

        int indexFoundV1 = twoBallsSearchV1(array);
        int indexFoundTeacher = twoBallsSearchTeacher(array);

        if (indexFoundV1==indexFoundTeacher) logger.info("resultados coinciden");
    }

    // personal solution
    private static int twoBallsSearchV1(boolean[] array) {
        logger.info("Se buscará el menor valor en el cual las bolas se rompen. Solo se pueden 'ver' booleanos true 2 veces como máximo");
        int jumpDistance = (int) Math.floor(Math.sqrt(array.length));
        int minBreakPoint = -1;
        int i = jumpDistance;

        for (; i < array.length; i += jumpDistance) {
            if (array[i]) {
                minBreakPoint = i;
                break;
            }
        }

        i -= jumpDistance;

        for (int j = i + 1; j < array.length && j < i + jumpDistance; j++) {
            if (array[j]) {
                minBreakPoint = j;
                break;
            }
        }

        informResult(minBreakPoint);
        return minBreakPoint;
    }

    // course solution
    private static int twoBallsSearchTeacher(boolean[] array) {
        logger.info("Se buscará el menor valor en el cual las bolas se rompen. Solo se pueden 'ver' booleanos true 2 veces como máximo");
        int jmpAmount = (int) Math.floor(Math.sqrt(array.length));
        int i = jmpAmount;

        for (; i < array.length; i += jmpAmount) {
            if (array[i]) {
                break;
            }
        }

        i -= jmpAmount;

        for (int j = i + 1; j < array.length && j <= i + jmpAmount; j++, i++) {
            if (array[i]) {
                informResult(i);
                return i;
            }
        }

        informResult(-1);
        return -1;
    }

    private static void informResult(int indexFound) {
        if (indexFound != -1) {
            logger.info(() -> String.format("El valor minimo en el que se rompe la bola fue encontrado en el índice %d", indexFound));
        } else {
            logger.info("No se pudo encontrar el valor minimo en el que se rompe la bola");
        }
    }

    private static void printArray(boolean[] array) {
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

    private static boolean[] generateArray(int size) {
        boolean[] array = new boolean[size];
        double random = Math.random()*size;
        for (int i = 0; i < size; i++) {
            array[i] = i >= (int) random;
        }
        logger.info(() -> "random: " + (int) random);
        printArray(array);
        return array;
    }
}
