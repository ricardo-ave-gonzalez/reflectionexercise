package ar.ave.developer.scanner;

import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerGeneric<T> {
    //Clase para ser capturada
    Class<T> clase;
    T[] elementos;

    public void iniciar() {
        try {
            iniciarCaptura();
        } catch (Exception ex) {
            Logger.getLogger(ScannerGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iniciarCaptura() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite el número de elementos tipo " + clase.getSimpleName() + " a almacenar:");

        int numeroDeElementos = scanner.nextInt();
        scanner.nextLine();//Consumir el Enter que genera el número
        //Instancia una vector con N Elementos
        elementos = (T[]) java.lang.reflect.Array.newInstance(clase, numeroDeElementos);

        for (int i = 0; i < elementos.length; i++) {
            T elemento = clase.getDeclaredConstructor().newInstance();
            ///Capturar los Campos de la Clase
            Field[] campos = elemento.getClass().getDeclaredFields();
            for (Field campo : campos) {
                System.out.println("Digite el valor para " + campo.getName() + ":");
                //Verificación del Tipo de Dato que existe en el Campo
                if (campo.getClass().equals(String.class)) {
                    campo.set(i, scanner.nextLine());
                } else if (campo.getClass().equals(Long.class)) {
                    campo.set(i, scanner.nextLong());
                    scanner.nextLine();//Consumir el Enter que genera el número
                } else if (campo.getClass().equals(Integer.class)) {
                    campo.set(i, scanner.nextInt());
                    scanner.nextLine();
                }
            }
            ////
            elementos[i] = elemento;
        }
    }
    
    public T[] obtenerElementos() {
        return elementos;
    }
}
