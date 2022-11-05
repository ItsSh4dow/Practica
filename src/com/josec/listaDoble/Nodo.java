package com.josec.listaDoble;

public class Nodo {
    public int ram;
    public int procesos;
    public int prioridad;
    public int size = 0;
    Nodo siguiente;


    //  Constructor para insertar al final
    public Nodo(int procesos, int ram, int prioridad){
        this.ram = ram;
        this.procesos = procesos;
        this.prioridad = prioridad;
        size++;
        this.siguiente = null;
    }

    //  Cuando ya tenemos nodos
    public Nodo(int procesos, int ram, int prioridad, Nodo siguiente) {
        this.ram = ram;
        this.procesos = procesos;
        this.prioridad = prioridad;
        this.siguiente = siguiente;
        size ++;
    }

    public int getPrioridad() {
        return prioridad;
    }
}