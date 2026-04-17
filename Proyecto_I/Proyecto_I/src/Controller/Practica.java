/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CiudadDAO;
import Model.Ciudad;
import Model.Empleado;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Practica {

    public void ejercicio1() {

        CiudadDAO objCiudad = new CiudadDAO();
        List<Ciudad> listValle = new ArrayList<>();
        for (Ciudad itemCiudad : objCiudad.getAllCiudades()) {
            if ("LA UNIoN".equals(itemCiudad.getNomCiudad())) {
                System.out.println(itemCiudad.getIdCiudad() + " - " + itemCiudad.getNomCiudad() + " - " + itemCiudad.getObjDepto().getNomDepto());
            }
        }

    }

    public void ejercicio2() {
        List<Ciudad> listValle = new ArrayList<>();

        CiudadDAO objCiudad = new CiudadDAO();
        for (Ciudad itemCiudad : objCiudad.getAllCiudades()) {
            if ("1".equals(itemCiudad.getObjDepto().getIdDepto())) {
                listValle.add(itemCiudad);
            }

        }

    }

    public void ejercicio3() {
        CiudadDAO objCiudad = new CiudadDAO();
        List<Ciudad> listValle = new ArrayList<>();
        Ciudad mayor = new Ciudad();
        Ciudad menor = new Ciudad();
        for (Ciudad itemCiudad : objCiudad.getAllCiudades()) {
            if ("1".equals(itemCiudad.getObjDepto().getIdDepto())) {
                listValle.add(itemCiudad);
                if (mayor == null || itemCiudad.getHabitantes() > mayor.getHabitantes()) {
                    mayor = itemCiudad;
                }
                if (menor == null || itemCiudad.getHabitantes() < menor.getHabitantes()) {
                    menor = itemCiudad;
                }
            }
        }
        for (Ciudad itemCiudad : listValle) {
            System.out.println(itemCiudad.getIdCiudad() + "-" + itemCiudad.getNomCiudad() + "-" + itemCiudad.getObjDepto());
        }
        System.out.println("mayor habitantes : " + mayor.getNomCiudad() + "-" + mayor.getHabitantes());
        System.out.println("menor habitantes : " + menor.getNomCiudad() + "-" + menor.getHabitantes());
    }

    public void ejercicio4() {
        JOptionPane.showMessageDialog(
                null,
                "El archivo se guardó correctamente en el servidor.",
                "Operación Exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
        // Diálogo de Error
        JOptionPane.showMessageDialog(
                null,
                "No se pudo establecer la conexión con la base de datos.",
                "Error de Conexión",
                JOptionPane.ERROR_MESSAGE
        );
        // Diálogo de Advertencia
        JOptionPane.showMessageDialog(
                null,
                "Estás a punto de eliminar datos importantes. ¡Procede con cautela!",
                "Advertencia de Seguridad",
                JOptionPane.WARNING_MESSAGE);
    }

    public void ejercicio5() {
        String nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
        JOptionPane.showMessageDialog(null, "Hola " + nombre);
    }

    public void ejercicio6() {
        int respuesta = JOptionPane.showConfirmDialog(
                null, // El componente padre (null centra la ventana)
                "¿Deseas confirmar la operación?", // Mensaje
                "Confirmación Rápida", // Título
                JOptionPane.YES_NO_OPTION // Opciones: Solo Sí y No
        );
        // Evalúa la respuesta
        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("El usuario seleccionó SÍ.");
            // Lógica para ejecutar la acción
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.out.println("El usuario seleccionó NO.");
            // Lógica para cancelar la acción
        } else { // Incluye JOptionPane.CANCEL_OPTION y JOptionPane.CLOSED_OPTION
            System.out.println("El usuario canceló o cerró el diálogo.");
        }

    }

    public void ejercicio7() {
        Object[] opciones = {"Guardar", "No guardar", "Cancelar"};

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "¿Quieres guardar los cambios?",
                "Confirmar acción",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion == 0) {

            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente.");

        } else if (seleccion == 1) {

            JOptionPane.showMessageDialog(null, "No se guardaron los cambios.");

        } else if (seleccion == 2) {

            JOptionPane.showMessageDialog(null, "Operación cancelada.");

        } else {

            JOptionPane.showMessageDialog(null, "Cerraste el diálogo.");

        }

    }

    public void ejercicio8() {
        String texto = "Hola mundo";

    }

    public void ejercicio9() {
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(4000, "Juan");
        hash.put(1500, "Sergio");
        hash.put(3000, "Emmanuel");

        System.out.println(hash);
        hash.remove(1500);

        System.out.println(hash);

        if (hash.containsKey(3000)) {
            System.out.println("Contiene un indice de 3000 y su valor es:");
            System.out.println(hash.get(3000));
            //Cuando no contiene ese valor se usa else 
        } else {
            System.out.println("El hash no cintiene ese valor");
        }
    }

    public void ejercicio10() {
        HashMap<Integer, Empleado> listEmp = new HashMap<>();
        listEmp.put(1, new Empleado(1, "santiago", "ingenieria", 450000));
        listEmp.put(2, new Empleado(2, "joseph", "ingenieria", 2300000));
        listEmp.put(3, new Empleado(3, "fabio", "ingenieria", 350000));
        listEmp.put(4, new Empleado(4, "pepito", "ingenieria", 4300000));

        int id = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el ID del empleado:")
        );
        

        if (listEmp.containsKey(id)) {

        Empleado emp = listEmp.get(id);

        JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" + emp);

        String opcion = JOptionPane.showInputDialog("¿Desea modificar el salario? (si/no)");

        if (opcion != null && opcion.equalsIgnoreCase("si")) {

            int nuevoSalario = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese nuevo salario:")
            );

            emp.setSalario(nuevoSalario);

            JOptionPane.showMessageDialog(null, "Empleado actualizado:\n" + emp);

        } else {
            JOptionPane.showMessageDialog(null, "No se modificó el salario");
        }

    } else {
        JOptionPane.showMessageDialog(null, "Empleado no encontrado");
    }
    }

}
