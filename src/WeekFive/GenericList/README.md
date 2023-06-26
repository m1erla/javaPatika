Writing Our Own List Class


We are designing a class in Java where we hold data using the generic construct.

The purpose of the class is to keep a dynamic Array in it and dynamically retrieve the data type. For this, a generic class must be created.


NOTE : THE COLLECTION CLASS WILL NOT BE USED ! WE MUST CREATE OUR OWN LISTING CLASS.


Class features:


    The default size of the array in the class is 10 and the number of elements of the array should increase by 2 times as needed.


    The class must have two types of constructor methods


   - MyList() : If the empty constructor is used, the initial size of the array should be 10.


   -  MyList(int capacity) : The initial value of the array should be taken from the capacity parameter.


   -   size() : Returns the number of elements in the array.


  - getCapacity() : returns the capacity of the array.


   - add(T data) : It should be used to add an element to the array of the class. If there is not enough space in the array, the array size should be doubled.


Example

    
    public class Assign { 
    public static void main(String[] args) 
    { MyList<Integer> list = new MyList<>(); 
    System.out.println("Number of Elements in Array: " + list.size()); System.out.println("Capacity of directory: " 
    + list.getCapacity()); list.add(10);
    + list.add(20); list.add(30); list.add(40);
    + System.out.println("Number of Elements in Array: "
    + 
    + list.size()); System.out.println("Capacity of directory: "
    + 
    + list.getCapacity()); list.add(50); list.add(60); list.add(70);
    + list.add(80); list.add(90); list.add(100); list.add(110);
    + System.out.println("Number of Elements in Array: " +
    + list.size()); System.out.println("Capacity of directory: "
    + 
    + list.getCapacity()); }
    }

 output

    Capacity of Array : 10 Number of Elements in Array : 0
    Directory Capacity: 10
    Number of Elements in Array: 4
    Directory Capacity : 20
    Number of Elements in the Array: 11
    ------------------------------------------------------------------------------------------------------
    
  -  get(int index): returns the value at the given index. Returns null if invalid index is entered.


  -  remove(int index): should delete the data in the given index and shift the data after the deleted index to the left. Returns null if invalid index is entered.


  -  set(int index, T data) : should replace the data in the given index with a new one. Returns null if invalid index is entered.


  -  String toString() : A method that lists the elements in the array of the class.


Example


    public class Assign 
    { public static void main(String[] args)
    { MyList<Integer> list = new MyList<>(); list.add(10); 
    list.add(20); list.add(30); System.out.println("The value at index 2: " + 
    list.get(2)); list.remove(2); list.add(40); list.set(0, 100); System.out.println("The value at index 2: " + 
    list.get(2)); System.out.println(list.toString()); }
    }


output


    Value at 2nd index : 30 Value at 2nd index : 40
    [100,20,40]
    ------------------------------------------------------------------------------------------------------
   - int indexOf(T data) : Returns the index of the object given in the parameter in the list. Returns -1 if the object is not in the list.


   - int lastIndexOf(T data) : It tells the last index of the specified item in the list. Returns -1 if the object is not in the list.


   - boolean isEmpty() : Indicates whether the list is empty.


   - T[] toArray() : Converts the items in the list into an array in the same order.


   - clear() : Deletes all items in the list, making it an empty list.


   - MyList<T> sublist(int start,int finish) : Returns a list of the index range given in the parameter.


   - boolean contains(T data) : It tells whether the value given in the parameter is in the array.

Example


        public class Assign { public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));

        // Returns the first index found
        System.out.println("Index : " + list.indexOf(20));

        // Returns -1 if not found
        System.out.println("Index :" + list.indexOf(100));

        // Returns the last index found
        System.out.println("Index : " + list.lastIndexOf(20));

        // Returns the list as an Object[] array.
        Object[] array = list.toArray();
        System.out.println("First element of array Object :" + array[0]);

        // Created a sublist of list data type
        MyList<Integer> subList = list.subList(0, 3);
        System.out.println(subList.toString());

        // queried whether my value is in the list
        System.out.println("The value 20 in my list: " + list.contains(20));
        System.out.println("The value 120 in my list: " + list.contains(120));

        // Empties the list completely and returns it to its default size
        list.clear();
        System.out.println(list.toString());
        
    }
}


output


       List Status : Empty List Status : Full
       Index : 1
       Index :-1
       Index : 4
       First element of Object array :10
       [10,20,30,40]
       value 20 in my list : true
       value 120 in my list : false

  


