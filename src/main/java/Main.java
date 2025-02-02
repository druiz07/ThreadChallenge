import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");

        
            //Hilo tal cual
            // TareaParalela prueba = new TareaParalela();
            // prueba.start


            //Extension de la clase runnable
            // TareaParalela prueba = new TareaParalela();
            // Thread hilo= new Thread(prueba);
            // hilo.start();


            //Uso de executor para automatizar la creacion de hilos
            // ExecutorService executor = Executors.newFixedThreadPool(3);
            //  // Crear y enviar 5 tareas para ejecutar
            // for (int i = 0; i < 5; i++) {
            //     Runnable tarea = new TareaParalela(i);
            //     executor.submit(tarea); // Enviar tarea al Executor
            // }
            // executor.shutdown(); //Cerrar el executor


            
            // //Creacion de una cola concurrente con bloqueos

            // BlockingQueue<String> cola = new LinkedBlockingQueue<>();
        
            // Thread productor = new Thread(new Productor(cola));
            // Thread consumidor1 = new Thread(new Consumidor(cola));
            // Thread consumidor2 = new Thread(new Consumidor(cola));
            
            // // Iniciar los hilos
            // productor.start();
            // consumidor1.start();
            // consumidor2.start();
            
            // Crear cuenta bancaria con balance inicial de 1000
        BankAccount account = new BankAccount(1000);

        // Crear hilos productores y consumidores
        Thread clientDeposit1 = new Thread(new Productor( account, 150, 1000));  
        Thread clientDeposit2 = new Thread(new ProductorInteres( account, 5, 5000)); 
        Thread clientWithdrawer1 = new Thread(new Consumidor(account, 200, 2000)); 
        Thread clientWithdrawer2 = new Thread(new Consumidor(account ,700, 3000));  

        HashSet<Thread> clients=new HashSet<>();
        clients.add(clientWithdrawer2);
        clients.add(clientWithdrawer1);
        clients.add(clientDeposit1);
        clients.add(clientDeposit2);

        
        // Iniciar los hilos
        for (Thread indexThread : clients) {
            indexThread.start();  // Iniciamos los hilos
        }
        for(Thread indexThread: clients)
        {
            try {
                indexThread.join();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }


    }
}



