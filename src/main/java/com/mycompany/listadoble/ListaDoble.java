/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadoble;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-17
 */
public class ListaDoble {
    Nodo inicio;
    ListaDoble(){
        inicio = null;
    }

    public void insertarFinal(String nombre, int edad){
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        if(inicio == null){
            inicio = nuevo;
        }
        else{
            Nodo temporal = inicio;
            while(temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
            nuevo.setAnterior(temporal);
        }
    }
    
    public void imprimir(){
        Nodo temporal = inicio;
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        while(temporal != null){
            JOptionPane.showMessageDialog(null, temporal.toString()); 
            temporal = temporal.getSiguiente();
        }
    }
    
    public void buscar(int posicion){
        Nodo temporal = inicio;
        int contador = 1;
        boolean valor = false;
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        
        while(temporal != null){
            if(contador == posicion){
                if(contador == 1){
                    JOptionPane.showMessageDialog(null, "La persona es la primera en lista y no hay nadie detras");
                   if(temporal.getSiguiente() != null){
                       JOptionPane.showMessageDialog(null, "Persona delante: "+temporal.getSiguiente().toString());
                   } 
                    return;
                }
                JOptionPane.showMessageDialog(null, "Persona atras: "+temporal.getAnterior().toString());
                JOptionPane.showMessageDialog(null, "Persona delante: "+temporal.getSiguiente().toString());
                valor = true;
            }
            contador++;
            temporal = temporal.getSiguiente();
            if(temporal.getSiguiente() == null){
                JOptionPane.showMessageDialog(null, "La persona es la ultima en la lista");
                JOptionPane.showMessageDialog(null, "Persona atras: "+temporal.getAnterior().toString());
                return;
            }
        }
        if(!valor){
            JOptionPane.showMessageDialog(null, "La posicion no existe dentro de la lista");
        }
    }
    
    public void mayorDeEdad(){
        Nodo temporal = inicio;
        int contador = 1;
        while(temporal != null){
           if(temporal.getEdad()>=18){
               JOptionPane.showMessageDialog(null, "La persona "+temporal.getNombre() +"es mayor de edad y esta en la posicion "+contador);
           }
           contador++;
            temporal = temporal.getSiguiente();
        }
    }
    
    public void eliminarMenoresDeEdad(){
        Nodo temporal = inicio;
        while(temporal != null){
           if(temporal.getEdad()<18){
               if(temporal.getAnterior() != null){
                   temporal.getAnterior().setSiguiente(temporal.getSiguiente());
               }
               else{
                   inicio = temporal.getSiguiente();
               }
               
               if(temporal.getSiguiente() != null){
                   temporal.getSiguiente().setAnterior(temporal.getAnterior());
                   return;
               }
               else{
                   JOptionPane.showMessageDialog(null, "La lista ha quedado vacia");
               }
           }
            temporal = temporal.getSiguiente();
        }
    }
    
    
}
