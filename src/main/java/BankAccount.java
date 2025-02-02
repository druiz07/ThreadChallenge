
import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private boolean msg=false;
    private ArrayList<Thread> waitingConsumers = new ArrayList<>(); //Garantizar el orden de los consumidores

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized  void withdraw(double amount) {
      
        try {
            waitingConsumers.add(Thread.currentThread());
            while (balance < amount || !waitingConsumers.get(0).equals(Thread.currentThread())) {
                        
               
                if(!msg){
                    System.out.println("No hay suficientes fondos. Esperando para retirar " + amount);
                    msg=true;
                }
               wait(); 
            }
            
            waitingConsumers.remove(0);
            msg=false;
            balance -= amount;
            System.out.println("Retiro exitoso de: " + amount + ". Balance restante: " + balance);
            notifyAll();  
                
                   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
       
    }
    public synchronized  void deposit(double amount) {
        try {
            if (amount>0) {
                balance += amount;
                notifyAll();  
                System.out.println("Deposito de: " + amount + ". Balance actual de : " + balance);
                
            }        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    public synchronized void addInterest(double interest)
    {

        try {
            if (interest>0) {
                balance =balance+((balance*interest)/100);
                notifyAll();  
                System.out.println("Se ha añadido un interes del "+ interest+ "% "+" Ahora el balance es de "+ balance+"\n");
                
            }        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
}
