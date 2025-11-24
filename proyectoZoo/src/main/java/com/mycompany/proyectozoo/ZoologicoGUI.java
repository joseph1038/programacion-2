/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectozoo;

/**
 *
 * @author JOSEP
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ZoologicoGUI extends JFrame implements ActionListener {

    private JComboBox<String> animalesBox;
    private JTextField nombreAnimalField, edadAnimalField;
    private JTextArea outputArea;
    private ArrayList<Animal> animales = new ArrayList<>();
    private ArrayList<Jaula> jaulas = new ArrayList<>();

    public ZoologicoGUI() {
        super("Sistema del Zoológico");
        setLayout(new BorderLayout());

        // Panel superior para ingresar animales
        JPanel panelAnimal = new JPanel(new GridLayout(4, 2));

        panelAnimal.add(new JLabel("Tipo de Animal:"));
        animalesBox = new JComboBox<>(new String[]{"León", "Tigre", "Elefante"});
        panelAnimal.add(animalesBox);

        panelAnimal.add(new JLabel("Nombre del Animal:"));
        nombreAnimalField = new JTextField();
        panelAnimal.add(nombreAnimalField);

        panelAnimal.add(new JLabel("Edad:"));
        edadAnimalField = new JTextField();
        panelAnimal.add(edadAnimalField);

        JButton btnAgregar = new JButton("Agregar Animal");
        btnAgregar.addActionListener(this);
        panelAnimal.add(btnAgregar);

        add(panelAnimal, BorderLayout.NORTH);

        // Panel central para vista de datos
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Crear jaulas por defecto
        jaulas.add(new Jaula("Jaula 1"));
        jaulas.add(new Jaula("Jaula 2"));
        jaulas.add(new Jaula("Jaula 3"));

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipo = animalesBox.getSelectedItem().toString();
        String nombre = nombreAnimalField.getText();
        int edad = Integer.parseInt(edadAnimalField.getText());

        Animal animal;

        switch (tipo) {
            case "León":
                animal = new Leon(nombre, edad);
                break;
            case "Tigre":
                animal = new Tigre(nombre, edad);
                break;
            default:
                animal = new Elefante(nombre, edad);
        }

        animales.add(animal);

        // Asignar automaticamente
        for (Jaula j : jaulas) {
            if (j.getAnimal() == null) {
                j.asignarAnimal(animal);
                break;
            }
        }

        mostrarDatos();
    }

    private void mostrarDatos() {
        outputArea.setText("");
        outputArea.append("=== ANIMALES DEL ZOOLÓGICO ===\n");
        for (Animal a : animales) {
            outputArea.append(a.getTipo() + " - " + a.getNombre() + " (Edad: " + a.getEdad() + ")\n");
        }

        outputArea.append("\n=== JAULAS ===\n");
        for (Jaula j : jaulas) {
            outputArea.append(j.getNombre() + ": ");
            if (j.getAnimal() != null) {
                outputArea.append(j.getAnimal().getNombre() + " (" + j.getAnimal().getTipo() + ")\n");
            } else {
                outputArea.append("Vacía\n");
            }
        }
    }
}
