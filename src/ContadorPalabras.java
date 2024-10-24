import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContadorPalabras {
    private String archivoEntrada;
    private String archivoSalida;

    public ContadorPalabras(String archivoEntrada, String archivoSalida) {
        this.archivoEntrada = archivoEntrada;
        this.archivoSalida = archivoSalida;
    }

    public void contarYGuardarFrecuencia() {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        // Leer el archivo CSV de entrada
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras, eliminando signos de puntuación y espacios
                String[] palabras = linea.toLowerCase().split("\\W+");

                // Contar la frecuencia de cada palabra
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

            // Guardar el resultado en un archivo CSV
            try (FileWriter fw = new FileWriter(archivoSalida)) {
                fw.write("Palabra,Frecuencia\n");
                for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
                    fw.write(entry.getKey() + "," + entry.getValue() + "\n");
                }
                System.out.println("Resultados guardados en " + archivoSalida);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
