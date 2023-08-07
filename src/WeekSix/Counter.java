package WeekSix;

public class Counter implements Runnable{
    private String name;
    private int id ;
    private boolean isRun = true;

    public Counter(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(this.name  + " is working now ");
        System.out.println("My Thread : " + threadName);

        int i = 0;
        while (isRun){

                ThreadSleeper.sleep(1000L * this.id);
                System.out.println(this.name + ":" + i++);

        }

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
   public void stop(){
        this.isRun = false;
   }
}
