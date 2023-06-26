package WeekFive.GenericList;

public class MyList<T> {
    private T[] list;
    private T[] tempArray;
    private int capacity;
    private int sizeCount = 0;
    private int index = 0;
    public MyList(){
       this.capacity = 10;
       this.list = (T[]) new Object[this.capacity];
    }
    public MyList(int capacity){
      this.capacity = capacity;
        this.list = (T[]) new Object[capacity];

    }

    // That method return to a list of given array as a string
    public String toString(){
        String str = "";
        for (int i = 0; i < size(); i++){
            if (getList()[i] instanceof Integer){
                T number = getList()[i];
                str = str + (Integer) number + " " ;
            } else if (getList()[i] instanceof String) {
                str = str + getList()[i] + " ";
            }
        }
        return str;
    }
    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int size(){
        return this.sizeCount;
    }
    public void setSize(){
        int count = 0;
        for (int i = 0; i < this.list.length; i++){
            if (this.list[i] != null){
                count++;
            }
        }
        this.sizeCount = count;
    }
    public void add(T data){
       if (this.size() < this.capacity){
           list[this.sizeCount] = data;
           this.setSize();
       }else{
           doubleCapacity();
           this.increaseCapacity();
           this.add(data);
       }

    }
    // Getter Setter Methods
    public int getSizeCount(){
        return sizeCount;
    }
    public void setSizeCount(int sizeCount){
        this.sizeCount = sizeCount;
    }
    public void doubleCapacity(){
        setCapacity(this.getCapacity() * 2);
    }

    public T[] getList() {
        return this.list;
    }

    public void setList(Object[] list) {
        this.list = (T[]) list;
    }
    public int getIndex(){
        return this.index;
    }
    // Value of an index
    public T get(int index){
        if (getList()[index] == null){
            return null;
        }
        return getList()[index];
    }
    // Remove a value
    public void remove(int index){
        if (getList()[index] != null){
            getList()[index] = null;
            for (int i = index + 1; i <= size(); i++){
                getList()[i - 1] = getList()[i];
            }
        }
        else{
            System.out.println("null");
        }
    }
    public void set(int index, T data){
        if (getList()[index] ==null){
            System.out.println("Null");
        }
        getList()[index] = data;
    }
    // A way to find index of value
    public int indexOf(T data){
        for (int i = 0; i < size(); i++){
            if (data.equals(list[i])) return i;
        }
        return -1;
    }
    // A way to find last index of value
    public int lastIndexOf(T data){
        for (int i = size() - 1; i >= 0; i--){
            if (data.equals(list[i])) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public Object[] toArray(){
        Object[] refArray = new Object[getCapacity()];
    for (int i = 0; i < this.getCapacity(); i++){
        refArray[i] = this.get(i);
    }
    return refArray;
    }

    public void clear(){
        this.list = (T[]) new Object[this.capacity];
        this.index = 0;
    }
    public MyList<T> subList(int start, int finish){
        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++){
            subList.add(this.getList()[i]);
        }
        return subList;
    }
   public void increaseCapacity(){
        this.tempArray = (T[]) new Object[this.capacity];
        for (int i = 0; i< this.list.length; i++){
            this.tempArray[i] = this.list[i];
        }
        this.list = this.tempArray;
   }
   public boolean contains(T data){
        for (int i = 0; i < this.list.length; i++){
            if (data == this.list[i]){
                return true;
            }
        }
       return false;
   }
}
