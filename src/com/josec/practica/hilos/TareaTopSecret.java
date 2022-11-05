package com.josec.practica.hilos;

import java.util.concurrent.ThreadLocalRandom;

public class TareaTopSecret implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Hola soy el proceso: " + Thread.currentThread());
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000,3000));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
/*    // vamos a ponernos a dormir un numero random entre 1 y 3
    public synchronized void tarea() {
        try {
            System.out.println("Hola soy el proceso " + Thread.);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
        // dormidos el hilo una cantidad random de tiempo
    }*/
