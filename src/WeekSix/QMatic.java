package WeekSix;

public class QMatic implements Runnable{
    private Object LOCK = new Object();
    private int orderNo;
    public QMatic(){
        this.orderNo = 0;
    }

    public int getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(int orderNo){
        this.orderNo = orderNo;
    }
    @Override
    public void run(){
        // a little delay to see race conditon!
        ThreadSleeper.sleep(50);
        synchronized (LOCK){
            this.orderNo++;
            StringBuilder builder = new StringBuilder();
            builder.append(Thread.currentThread().getName());
            builder.append(" thread got ");
            builder.append(this.orderNo);
            builder.append(" from Qmatic! ");
            System.out.println(builder.toString());
        }
    }
}
