package com.josec.practica.hilos;
import com.josec.listaDoble.ListaEnlazada;
import com.josec.listaDoble.Nodo;
import java.util.ArrayList;

public class Maquina {
    // Declarate the variables
    private final int PROCESADORES = 16;
    private final int RAM = 100;
    private int procesadoresRestantes;
    private int memoriaRestante;
    private ListaEnlazada lista = new ListaEnlazada();
    private int nProcesos;
    private int ramAsiganda;
    private int prioridad;

    private int i = 1;
    private int cProcesos = 1;

    private int [] memoria = {10,20,30,40,50};

    public Maquina() throws InterruptedException{
        //ahora vamos a obetner un numeros entre 2 y 20
        nProcesos = (int) (Math.random() * 20) + 2;
        System.out.println("Se han creado " + nProcesos + " Procesos");
        /*for(; i <= nProcesos; i++){
            //Thread i = new Thread();
            ramAsiganda = (int) (Math.random() * 5);
            prioridad = (int) (Math.random() * 3);

            lista.agregarInicio(cProcesos, memoria[ramAsiganda], prioridad);
            cProcesos ++;
        }*/

        while(cProcesos <= nProcesos){
            ramAsiganda = (int) (Math.random() * 5);
            prioridad = (int) (Math.random() * 3);
            lista.agregarInicio(cProcesos, memoria[ramAsiganda], prioridad);
            //lista.mostrarLista();
            cProcesos ++;
        }

        lista.mostrarLista();
        System.out.println();
        System.out.println();
        lista.ordenarLista(cProcesos);
        lista.mostrarLista();

    }
    // vamos a ponernos a dormir un numero random entre 1 y 3
    public synchronized void tareaTopSecreta(){

    }

    public int getnProcesos() {return nProcesos;}

    public int getRamAsiganda() {return ramAsiganda;}
}
