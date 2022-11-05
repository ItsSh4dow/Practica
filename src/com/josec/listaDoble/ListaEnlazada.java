package com.josec.listaDoble;

public class ListaEnlazada {
    Nodo inicio, fin;

    public ListaEnlazada() { //  Si no tenemos nada, apunta hacia null
        this.inicio = null;
        this.fin = null;
    }
    public boolean isVacia() {
        return inicio == null;
    }

    public void agregarInicio(int procesos, int ram , int prioridad) {
        if (!isVacia()) {
            fin.siguiente = new Nodo(procesos, ram, prioridad);
            fin = fin.siguiente;
        } else {
            inicio = fin = new Nodo(procesos, ram, prioridad);
        }

    }
    //  Meotodo para mostrar los datos
    public void mostrarLista() {
        String datos = "";
        if(!isVacia()) {
            Nodo recorrer = inicio; // Que apunte para inicio
            while (recorrer != null) {
                datos = datos + (("[!] " + "Proceso [" + recorrer.procesos + "]" + " RAM asignada [" + recorrer.ram + "]" + " Prioridad [" + recorrer.prioridad + "]\n"));
                recorrer = recorrer.siguiente;
            }
            System.out.println(datos);
        }
    }
    // Metodo para ordenar una lista por bobblue sort
    public void ordenarLista(int size){
        Nodo recorrer1 = inicio; // si son 10 este es el 10 2
        Nodo recorrer2 = inicio.siguiente; // este es el 9 0
        Nodo aux;
        Nodo corre = inicio;
        int contador = 0;
        int [] prioridades = new int[size];
        int auxiliar = 0;

        // Creamos una copia de las prioridades del array
        while(corre != null){
            prioridades[contador] = corre.prioridad;
            contador ++;
            corre = corre.siguiente;
        }
        corre = inicio.siguiente;
        int j = 0;
        //Comprobamos que haya elementos en la lista
        if(!isVacia()){
            while(recorrer2 != null){
                while (recorrer1 != null){
                    if(prioridades[j] > prioridades[j+1]){ // 2 > 0
                        aux = recorrer1;
                        recorrer1 = recorrer2;
                        recorrer2 = aux;

                        auxiliar = prioridades[j]; // 2
                        prioridades[j] = prioridades[j+1]; // 2 == 0
                        prioridades[j] = auxiliar; // 0 = 2

                    }
                    recorrer1 = recorrer1.siguiente;
                    j++;
                }
                j = 1;
                recorrer2 = recorrer2.siguiente;
                recorrer1 = inicio.siguiente;
            }
        }
        else
            System.out.println("No se pudo ordenar porque no hay elementos");
    }


}
