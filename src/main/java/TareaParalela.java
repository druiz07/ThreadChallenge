
    // public class TareaParalela extends  Thread
    // {
    //     @Override
    //     public void run() {        
        
    //             for (int i = 0; i < 5; i++) {
    //                 System.out.println("Tarea Thread ejecutándose: " + i+ Thread.currentThread().getName());
                  
    //             }
           
    //     }
        
    // }
    public class TareaParalela implements  Runnable
    {
        private int id;  
        TareaParalela(int id)
        {
            this.id=id;
        }
        @Override
        public void run() {        
        
            System.out.println("Tarea numero  " + this.id + "  Ejecutandose en hilo  "+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }         
        }
        
    }

