import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");

            //Extension de la clase runnable
            // TareaParalela prueba = new TareaParalela();
            // Thread hilo= new Thread(prueba);
            // hilo.start();


            //Uso de executor para automatizar la creacion de hilos
            ExecutorService executor = Executors.newFixedThreadPool(3);
             // Crear y enviar 5 tareas para ejecutar
            for (int i = 0; i < 5; i++) {
                Runnable tarea = new TareaParalela(i);
                executor.submit(tarea); // Enviar tarea al Executor
            }
            executor.shutdown(); //Cerrar el executor





            //Hilo tal cual
            // TareaParalela prueba = new TareaParalela();
            // prueba.start
            



    }
}



