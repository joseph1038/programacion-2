/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectozoo;

/**
 *
 * @author JOSEP
 */
public class Jaula {
    private String nombre;
    private Animal animal;

    public Jaula(String nombre) {
        this.nombre = nombre;
    }

    public void asignarAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getNombre() {
        return nombre;
    }

    public Animal getAnimal() {
        return animal;
    }
}
