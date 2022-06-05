/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author diego
 */
public class Nodo {
    private int vertice;
    private Nodo siguiente;

    public Nodo(int vertice) {
        this.vertice = vertice;
        this.siguiente=null;
    }

    public Nodo() {
    }
   
    
    public int getVertice() {
        return vertice;
    }

    public void setVertice(int dato) {
        this.vertice = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
