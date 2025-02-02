

public class Productor implements Runnable {
    private BankAccount account;
    private double cantidadADepositar;
    private long tiempoEspera;

    public Productor(BankAccount account, double cantidadADepositar, long tiempoEspera) {
     
        this.account = account;
        this.cantidadADepositar = cantidadADepositar;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
        try {
            while (true) {
                
                      
                account.deposit(cantidadADepositar);                         
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
