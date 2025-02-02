
public class Consumidor implements Runnable {
    private BankAccount account;
    private double cantidadARetirar;
    private long tiempoEspera;


    public Consumidor(BankAccount account,  double cantidadARetirar, long tiempoEspera) {
        this.account = account;
        this.cantidadARetirar = cantidadARetirar;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
        try {
            while (true) {
              
                    account.withdraw(cantidadARetirar);
                    Thread.sleep(tiempoEspera); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

