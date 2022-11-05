package com.josec.listaDoble;

public class Nodo {
    public int ram;
    public int procesos;
    public int procesadores;
    public int prioridad;
    Nodo siguiente;


    //  Constructor para insertar al final
    public Nodo(int procesos, int ram, int procesadores, int prioridad){
        this.ram = ram;
        this.procesos = procesos;
        this.prioridad = prioridad;
        this.procesadores = procesadores;
        this.siguiente = null;
    }

    //  Cuando ya tenemos nodos
    public Nodo(int procesos, int ram, int procesadores, int prioridad, Nodo siguiente) {
        this.ram = ram;
        this.procesos = procesos;
        this.prioridad = prioridad;
        this.procesadores = procesadores;
        this.siguiente = siguiente;

    }

    public int getPrioridad() {
        return prioridad;
    }
}