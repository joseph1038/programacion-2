/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;
/**
 *
 * @author estudiante
 */
public class Taller {

    public void Ejercicio1() {
        // Pedir nombre y apellido usando JOptionPane
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");

        // Validar que no estén vacíos y eliminar espacios extra
        if (nombre != null) nombre = nombre.trim();
        if (apellido != null) apellido = apellido.trim();

        if (nombre != null && apellido != null && !nombre.isEmpty() && !apellido.isEmpty()) {
            char inicialNombre = nombre.charAt(0);
            char inicialApellido = apellido.charAt(0);
//el charAt(0) es para optener primera letra
            // Mostrar el resultado en un cuadro de diálogo
            JOptionPane.showMessageDialog(
                null,
                nombre + " " + apellido + ": " + inicialNombre + "." + apellido
            );
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre y apellido.");
        }
    }   
    
    public void Ejercicio2(){
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");

        // El topUpperCase es para convertir en mayuscula y el toLowercase lo convierte en minuscula
        if (nombre != null && apellido != null) {

            String nombreMinuscula = nombre.toLowerCase();
            String apellidoMayuscula = apellido.toUpperCase();
//
            JOptionPane.showMessageDialog(null,
                    "Nombre en minúscula: " + nombreMinuscula +
                    "\nApellido en mayúscula: " + apellidoMayuscula);

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }
        
        
    
    public void Ejercicio3(){
        
        // Pedir texto al usuario
        String texto = JOptionPane.showInputDialog("Ingrese una cadena de texto:");

        // Convertir a minúsculas
        texto = texto.toLowerCase();

        // Arreglo para contar letras
        int[] contador = new int[26];

        // Recorrer el texto
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                // se le coloca el - a por que el char tiene un valor numerico interno. Usamos letra - 'a' para convertir la letra en un índice de 0 a 25, que corresponde a las posiciones de tu arreglo de contadores.
                contador[letra - 'a']++;
            }
        }

        // Crear resultado
        String resultado = "Frecuencia de letras:\n";
// 26 es el numero Avecedario estandar 
        for (int i = 0; i < 26; i++) {
            if (contador[i] > 0) {
                char letra = (char) (i + 'a');
                resultado += letra + ": " + contador[i] + "\n";
            }
        }

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    public void Ejercicio4(){
        
        // Solicitar número al usuario
        String numeroStr = JOptionPane.showInputDialog("Ingrese un número:");

        // Validar que el usuario no haya cancelado
        if (numeroStr == null || numeroStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o número vacío.");
            return;
        }

        int suma = 0;

        // Recorrer cada carácter del número y el for es para revisar cada letra
        for (int i = 0; i < numeroStr.length(); i++) {
            char c = numeroStr.charAt(i);

            // Verificar que sea un dígito
            if (Character.isDigit(c)) {
                suma += Character.getNumericValue(c);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Ingrese solo dígitos.");
                return;
            }
        }

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, 
                "Número ingresado: " + numeroStr + 
                "\nLa suma de sus dígitos es: " + suma);
    }

    public void Ejercicio5(){
        
         String contraseña;
        boolean valida;

        do {
            // Pedir contraseña
            contraseña = JOptionPane.showInputDialog("Ingrese una contraseña:\n" +
                    "- Mínimo 8 caracteres\n" +
                    "- Al menos 1 número\n" +
                    "- Al menos 1 letra");

            // Verificar si el usuario canceló
            if (contraseña == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            // Validar contraseña
            valida = validarContraseña(contraseña);

            if (!valida) {
                JOptionPane.showMessageDialog(null, 
                        "Contraseña inválida.\n" +
                        "Debe tener al menos 8 caracteres, al menos una letra y un número.");
            }

        } while (!valida);

        // Mensaje final si es válida
        JOptionPane.showMessageDialog(null, "¡Contraseña aceptada!");
    }

    // Función para validar la contraseña
    public static boolean validarContraseña(String pass) {
        if (pass.length() < 8) {
            return false;
        }

        boolean tieneLetra = false;
        boolean tieneNumero = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isLetter(c)) {
                tieneLetra = true;
            }
            if (Character.isDigit(c)) {
                tieneNumero = true;
            }
        }

        return tieneLetra && tieneNumero;
    }

    public void Ejercicio6()  {

    

        // Solicitar texto al usuario
        String texto = JOptionPane.showInputDialog("Ingrese un texto:");

        // Reemplazo de caracteres: cambiar 'a' por 'o'
        String resultado = texto.replace('a', 'o');

        // Mostrar resultados en ventanas emergentes
        JOptionPane.showMessageDialog(null, "Texto original: " + texto);
        JOptionPane.showMessageDialog(null, "Texto modificado: " + resultado);
    }
    
    public void Ejercicio7(){
       String cadena=JOptionPane.showInputDialog("ingrese una cadena de texto");
       String nuevaCadena = "";
       for (int J = 0; J < cadena.length(); J++){
        char c = cadena.charAt(J);

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {

            nuevaCadena += "*";
        } else {
            nuevaCadena += c;
        }
    }
       JOptionPane.showMessageDialog(null, "Resultado: " + nuevaCadena);
    }
    
    public void Ejercicio8(){
    String cadena = JOptionPane.showInputDialog(null, "Contraseña valida");                                  
    String Resultado = cadena.replaceAll("[aeiouAEIOU]", "*");        
    JOptionPane.showMessageDialog(null, "Resultado" + Resultado);      
}
    
    public void Ejercicio9(){
        String[] nombres={"ana","carlos","luis","pedro","santiago"};
        ArrayList<String> lista= new ArrayList<>(Arrays.asList(nombres));
        System.out.print(lista);
        //eliminar nombres que contengan menos de 5 caracteres
        lista.removeIf(item -> item.length() <= 4);
        System.out.println(lista);
        //ordenar
        System.out.println("****************** Lista ordenada******************************");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println("****************** Lista ordenada ascendente******************************");
        Collections.sort(lista, Collections.reverseOrder());
        System.out.println(lista);
        }
     public void Ejercicio10() {

    int[][] matriz = new int[3][3];

    // Llenar matriz con valores aleatorios (1 a 100)
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            matriz[i][j] = (int)(Math.random() * 100);
        }
    }

    // Mostrar matriz
    System.out.println("Matriz:");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(matriz[i][j] + "\t");
        }
        System.out.println();
    }

    // Suma de filas
    System.out.println("\nSuma de filas:");
    for (int i = 0; i < 3; i++) {
        int sumaFila = 0;
        for (int j = 0; j < 3; j++) {
            sumaFila += matriz[i][j];
        }
        System.out.println("Fila " + (i + 1) + ": " + sumaFila);
    }

    // Suma de columnas
    System.out.println("\nSuma de columnas:");
    for (int j = 0; j < 3; j++) {
        int sumaColumna = 0;
        for (int i = 0; i < 3; i++) {
            sumaColumna += matriz[i][j];
        }
        System.out.println("Columna " + (j + 1) + ": " + sumaColumna);
    }
}
    
}
            
    
        
       



    

