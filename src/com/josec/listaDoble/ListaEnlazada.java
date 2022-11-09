package com.josec.listaDoble;

public class ListaEnlazada {
    Nodo inicio, fin;
    int length = 0;
    public ListaEnlazada() { //  Si no tenemos nada, apunta hacia null
        this.inicio = null;
        this.fin = null;
    }
    public boolean isVacia() {
        return inicio == null;
    }

    public void agregarInicio(int procesos, int ram , int procesadores,int prioridad) {
        if (!isVacia()) {
            fin.siguiente = new Nodo(procesos, ram, procesadores, prioridad);
            fin = fin.siguiente;
            length ++;
        } else {
            inicio = fin = new Nodo(procesos, ram, procesadores, prioridad);
            length ++;
        }

    }
    //  Meotodo para mostrar los datos
    public void mostrarLista() {
        String datos = "";
        if(!isVacia()) {
            Nodo recorrer = inicio; // Que apunte para inicio
            while (recorrer != null) {
                datos = datos + (("[!] " + "Proceso [" + recorrer.procesos + "]" + " RAM asignada [" + recorrer.ram + "]"
                        + " Procesadores ["+recorrer.procesadores+"]"+ " Prioridad [" + recorrer.prioridad + "]\n"));
                recorrer = recorrer.siguiente;
            }
            System.out.println(datos);
        }
    }
    // Metodo para ordenar una lista por bobblue sort
    public void bubbleSort() {
        if (length > 1) {
            boolean cambio;
            do {
                Nodo actual = inicio;
                Nodo anterior = null;
                Nodo siguiente = inicio.siguiente;
                cambio = false;
                while ( siguiente != null ) {
                    if (actual.getPrioridad() > siguiente.getPrioridad()) {
                        cambio = true;
                        if ( anterior != null ) {
                            Nodo sig = siguiente.siguiente;
                            anterior.siguiente = siguiente;
                            siguiente.siguiente = actual;
                            actual.siguiente = sig;
                        } else {
                            Nodo sig = siguiente.siguiente;
                            inicio = siguiente;
                            siguiente.siguiente = actual;
                            actual.siguiente = sig;
                        }
                        anterior = siguiente;
                        siguiente = actual.siguiente;
                    } else {
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.siguiente;
                    }
                }
            } while( cambio );
        }
    }

    public int [] getProcessArray(){
        if (length >= 2){
            Nodo recorrer = inicio;
            int array [] = new int[length];
                for(int i = 0; recorrer != null; i++){
                    array[i] = recorrer.procesos;
                    recorrer = recorrer.siguiente;
            }
            return array;
        }
        return null;
    }

    public int [] getRamArray(){
        if (length >= 2){
            Nodo recorrer = inicio;
            int array [] = new int[length];
            for(int i = 0; recorrer != null; i++){
                array[i] = recorrer.ram;
                recorrer = recorrer.siguiente;
            }
            return array;
        }
        return null;
    }
    public int [] getProcessorsArray(){
        if (length >= 2){
            Nodo recorrer = inicio;
            int array [] = new int[length];
            for(int i = 0; recorrer != null; i++){
                array[i] = recorrer.procesadores;
                recorrer = recorrer.siguiente;
            }
            return array;
        }
        return null;
    }
}
