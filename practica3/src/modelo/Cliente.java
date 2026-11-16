/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author erlop
 */
public class Cliente implements Comparable<Cliente>{
    private int numero;
    private String nombre;
    private float puntos;
    private LocalDate fechaNacimiento;

    public Cliente(int numero, String nombre, float puntos, LocalDate fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.puntos = puntos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Ordena de menor a mayor
    public int compareTo(Cliente otro) {
        return Integer.compare(this.numero, otro.numero);
    }
    
    
}
