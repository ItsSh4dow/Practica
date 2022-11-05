package com.josec.practica.hilos;
import com.josec.listaDoble.ListaEnlazada;

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

    private int procesadores;

    private int cProcesos = 1;

    private int [] memoria = {10,20,30,40,50};

    public Maquina() throws InterruptedException{
        //ahora vamos a obetner un numeros entre 2 y 20
        nProcesos = (int) (Math.random() * 20) + 2;
        System.out.println("Se han creado " + nProcesos + " Procesos");
        // creamos los procesos
        while(cProcesos <= nProcesos){
            ramAsiganda = (int) (Math.random() * 5);
            prioridad = (int) (Math.random() * 3);
            procesadores = (int) (Math.random() * 8) +1;
            lista.agregarInicio(cProcesos, memoria[ramAsiganda], procesadores, prioridad);
            cProcesos ++;
        }
        // ordenamos
        lista.bubbleSort();
        // creamos los hilos
        creationThreads(cProcesos);
    }

    public void creationThreads(int stop) throws InterruptedException{
        for (int i = 1; i<= stop; i++){
            new Thread(new TareaTopSecret());
        }
    }

    boolean recusos;
    public synchronized void asignar(){
        while(recusos){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getnProcesos() {return nProcesos;}

    public int getRamAsiganda() {return ramAsiganda;}


}
