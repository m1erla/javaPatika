package WeekSix;

public class OrderMatic implements Runnable{
    private int orderNo ;
    public OrderMatic(){
            this.orderNo = 0;
    }




    public int getOrderNo(){
        return orderNo;

    }

    public void setOrderNo(int orderNo){
        this.orderNo = orderNo;
    }


    @Override
    public synchronized void run() {
        try {
            // a little delay to see race condition!
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        this.orderNo++;
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " orderNo: " + this.orderNo );

    }
}
