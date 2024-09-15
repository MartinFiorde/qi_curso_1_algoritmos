package primagenalgorithms.small_scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogFilter {
    public static void main(String[] args) {
        String inputFilePath = "C:/Users/Martin F - PC Desk/Desktop/2024-07-25 11-30 us007qi.log"; // Cambia esto con la ruta de tu archivo
        String outputFilePath = "C:/Users/Martin F - PC Desk/Desktop/2024-07-25 11-30 us007qi - FILTERED AGRO-0002.log"; // Cambia esto con la ruta de tu archivo filtrado

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("AGRO-0002")) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Log filtrado y guardado en: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
