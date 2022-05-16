package ar.ave.developer;

import ar.ave.developer.scanner.models.Producto;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Init {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        /*
        Scanner scanner = new Scanner(System.in);
        
        Field[] campos = Producto.class.getDeclaredFields();
        for(Field campo: campos){
            System.out.println(campo);
        }
        
        System.out.println("-------------------------------------------------");
        
        
        Method[] metodos = Producto.class.getMethods();
        for(Method metodo: metodos){
            System.out.println(metodo);
        }
        */
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el número de elementos a almacenar");
        int numeroDeElementos = scanner.nextInt();
        scanner.nextLine();

        Producto[] productos = new Producto[numeroDeElementos];

        for (int i = 0; i < productos.length; i++) {

            Producto producto = new Producto();
            Field[] campos = producto.getClass().getDeclaredFields();

            for (Field campo : campos) {
                System.out.println("Valor de " + campo.getName() + ":");
                campo.setAccessible(true);
                if (campo.getType().equals(String.class)) {
                    campo.set(producto, scanner.nextLine());
                } else if (campo.getType().equals(Integer.TYPE)) {
                    campo.set(producto, scanner.nextInt());
                    scanner.nextLine();
                }
            }

            productos[i] = producto;
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Los Elementos Ingresados son:");

        for (Producto producto : productos) {
            System.out.println(producto);
        }        
    }
}
