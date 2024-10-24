public class Main {
    public static void main(String[] args) {
        String archivoEntrada = "credit_s om.csv"; // Nombre del archivo CSV de entrada
        String archivoSalida = "frecuencia_palabras.csv"; // Nombre del archivo CSV de salida

        // Crear instancia de ContadorPalabras
        ContadorPalabras contador = new ContadorPalabras(archivoEntrada, archivoSalida);

        // Ejecutar el conteo de palabras y guardar el resultado
        contador.contarYGuardarFrecuencia();
    }
}
