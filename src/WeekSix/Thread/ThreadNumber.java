package WeekSix.Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadNumber implements Runnable{
    private static List<Integer> evenNumber = new ArrayList<>();
    private static List<Integer> oddNumber = new ArrayList<>();

    private static List<Integer> thread1 = new ArrayList<>();
    private static List<Integer> thread2 = new ArrayList<>();
    private static List<Integer> thread3 = new ArrayList<>();
    private static List<Integer> thread4 = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();

    @Override
    public void run(){
        if(Thread.currentThread().getName().equals("Thread-0")){
            for(Integer number : thread1){
                append(number);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-1")){
            for(Integer number : thread2){
                append(number);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-2")){
            for(Integer number : thread3){
                append(number);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-3")){
            for(Integer number : thread4){
                append(number);
            }
        }
    }
    public static void setNumbers() throws InterruptedException{
        for(int i = 0; i<10000; i++){
            numbers.add(i);
        }
        for(int i = 0; i<numbers.size(); i++){
            if(i < numbers.size() /4 ){
                thread1.add(i);
            }
            else if(i < numbers.size() / 2){
                thread2.add(i);
            }
            else if(i < numbers.size() * 3/4 ){
                thread3.add(i);
            }
            else{
                thread4.add(i);
            }
        }
        ThreadNumber threadNumber = new ThreadNumber();

        Thread t1 = new Thread(threadNumber);
        Thread t2 = new Thread(threadNumber);
        Thread t3 = new Thread(threadNumber);
        Thread t4 = new Thread(threadNumber);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

        System.out.println("-".repeat(35));
        System.out.println("Even Number : " + ThreadNumber.evenNumber.size());
        System.out.println("Odd Number : " + ThreadNumber.oddNumber.size());
    }



    synchronized void append(int number){
        if(number % 2 == 0){
            System.out.println(Thread.currentThread().getName() + " -> " + number);
            evenNumber.add(number);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " -> " + number);
            oddNumber.add(number);
        }
   }
}
