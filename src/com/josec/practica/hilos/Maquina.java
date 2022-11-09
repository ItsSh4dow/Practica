package com.josec.practica.hilos;
import com.josec.listaDoble.ListaEnlazada;
public class Maquina {
    // Declarate the variables
    private final int PROCESADORES = 16;
    private final int RAM = 100;
    private int procesadoresRestantes = 0;
    private int memoriaRestante = 0;
    private ListaEnlazada lista = new ListaEnlazada();
    private int nProcesos;
    private int ramAsiganda;
    private int prioridad;
    private int procesadores;

    private int cProcesos = 1;
    private int[] arrayOfProcess;
    private int[] arrayOfProcessors;
    private int[] arrayOfRams;
    private int[] memoria = {10, 20, 30, 40, 50};
    private int contador = 0;

    public Maquina() throws InterruptedException {
        // creamos procesos
        this.creationProcess();
        // ordenamos
        lista.bubbleSort();
        lista.mostrarLista();
        // creamos un array de procesos.
        arrayOfProcess = lista.getProcessArray();
        // creamos un array de las rams
        arrayOfRams = lista.getRamArray();
        arrayOfProcessors = lista.getProcessorsArray();
        // creamos los hilos
        //creationThreads(cProcesos);
        this.admistrador();
    }

    /*public void creationThreads(int stop) throws InterruptedException{
        for (int i = 0; i < nProcesos; i++){
            new Thread(new TareaTopSecret(arrayOfProcess[i])).start();
        }
    }*/
    public void creationProcess() {
        //ahora vamos a obetner un numeros entre 2 y 20
        nProcesos = (int) (Math.random() * 20) + 2;
        System.out.println("Se han creado " + nProcesos + " Procesos");
        // creamos los procesos
        while (cProcesos <= nProcesos) {
            ramAsiganda = (int) (Math.random() * 5);
            prioridad = (int) (Math.random() * 3);
            procesadores = (int) (Math.random() * 8) + 1;
            lista.agregarInicio(cProcesos, memoria[ramAsiganda], procesadores, prioridad);
            cProcesos++;
        }
    }

    boolean recusos = true;

    // creamos el administrador
    public synchronized void admistrador() throws InterruptedException {
        while (contador < nProcesos) {
            while (!recusos) {
                try {
                    System.out.println("Auch me he quedado sin recursos");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (recusos) {
                    procesadoresRestantes = PROCESADORES - arrayOfProcessors[contador]; // 16
                    memoriaRestante = RAM - arrayOfRams[contador]; // 100
                    if (procesadoresRestantes < arrayOfProcessors[contador] || memoriaRestante < arrayOfRams[contador])
                        recusos = false;
                    else{
                        new Thread(new TareaTopSecret(arrayOfProcess[contador])).start();
                        memoriaRestante += arrayOfRams[contador];
                        procesadoresRestantes += arrayOfProcessors[contador];
                        contador ++;
                    }
                }
            }
        }
    }
