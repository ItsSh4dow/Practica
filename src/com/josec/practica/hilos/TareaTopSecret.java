package com.josec.practica.hilos;

public class TareaTopSecret implements Runnable{
    int [] times = {1,2,3};
    int time;
    int proceso;
    TareaTopSecret(int proceso){
        this.proceso = proceso;
    }
    @Override
    public void run() {
        time = (int) (Math.random() * 3);
        try{
            Thread.sleep((long) times[time] * 1000);
            System.out.println("Hola soy el proceso: " + proceso +"\nMe quedare dormido " + times[time] +" minutos");

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
