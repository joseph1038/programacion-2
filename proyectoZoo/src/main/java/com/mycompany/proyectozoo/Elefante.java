/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectozoo;

/**
 *
 * @author JOSEP
 */
public class Elefante extends Animal {

    public Elefante(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String getTipo() {
        return "Elefante";
    }
}
