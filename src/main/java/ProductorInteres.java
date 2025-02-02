
public class ProductorInteres implements Runnable {
    private BankAccount account;
    private double interes;
    private long tiempoEspera;


    public ProductorInteres(BankAccount account,  double interes, long tiempoEspera) {
        this.account = account;
        this.interes = interes;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
        try {
            while (true) {
              
                    account.addInterest(interes);
                    Thread.sleep(tiempoEspera); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

