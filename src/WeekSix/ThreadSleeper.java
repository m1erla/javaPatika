package WeekSix;

public class ThreadSleeper {
    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
