/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadoble.circulares;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-17
 */
public class ListasDoblesCirculares {
    Nodo inicio;
    ListasDoblesCirculares(){
        inicio = null;
    }
    
    public void insertarAlInicio(String nombre, int edad){
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        if(inicio == null){
            inicio = nuevo;
            nuevo.setAnterior(nuevo);
            nuevo.setSiguiente(nuevo);
        }
        else{
            
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(inicio.getAnterior());
            nuevo.getAnterior().setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }
    public void imprimir(){
        Nodo temporal = inicio;
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        else{
      
        do{
           JOptionPane.showMessageDialog(null, temporal.toString());
           temporal = temporal.getSiguiente();
        }
        while(temporal != inicio);
        }
    }
}
