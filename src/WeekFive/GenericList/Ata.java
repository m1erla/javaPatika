package WeekFive.GenericList;

public class Ata {
    public static void main(String[] args) {
        MyList<Integer> arrList = new MyList<>();
        System.out.println("-".repeat(15) + " Welcome to MyList Table " + "-".repeat(15));
        System.out.println("-".repeat(45));
        System.out.println("Current List Status --> " + (arrList.isEmpty() ? "Empty" : "Full"));
        System.out.println("-".repeat(45));

        System.out.println("Number of elements of the array -->  "
                + arrList.size()
                + "\n" +
                "Number of capacity of the array --> "
                + arrList.getCapacity());

        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);

        System.out.println("-".repeat(45));
        System.out.println("\n" + "Number of elements of the array -->  "
                + arrList.size() + "\n"+
                "Number of capacity of the array --> " +
                arrList.getCapacity());

        arrList.add(50);
        arrList.add(60);
        arrList.add(70);
        arrList.add(80);
        arrList.add(90);
        arrList.add(100);
        arrList.add(110);
        System.out.println("-".repeat(45));

        System.out.println("\n" + "Number of elements of the array -->  "
                + arrList.size() + "\n"+
                "Number of capacity of the array --> " +
                arrList.getCapacity());
        System.out.println("-".repeat(45));
        System.out.println(
                "\n2.index of value --> " + arrList.get(2));

        arrList.remove(2);
        arrList.add(40);
        arrList.set(0, 100);

        System.out.println("2.index of value --> " + arrList.get(2));
        System.out.println("[" + arrList.toString() + "]");
        System.out.println("-".repeat(45));

        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        arrList.add(20);
        arrList.add(50);
        arrList.add(60);
        arrList.add(70);
        System.out.println("-".repeat(45));

        System.out.println("Current List Status --> " + (arrList.isEmpty() ? "Empty" : "Full"));
        System.out.println("-".repeat(45));

        // Returns the first index found
        System.out.println("Index --> " + arrList.indexOf(20));
        System.out.println("-".repeat(45));

        // If it can not found then returns -1
        System.out.println("Index --> " + arrList.indexOf(100));
        System.out.println("-".repeat(45));

        // Returns the last index found
        System.out.println("Index --> " + arrList.lastIndexOf(20));
        System.out.println("-".repeat(45));

        // Returns the array of a Object[]
        Object[] array = arrList.toArray();
        System.out.println("First element of Object array --> " + array[0]);
        System.out.println("-".repeat(45));

        // Created a sub list of list data type
        MyList<Integer> subList = arrList.subList(0 , 3);
        System.out.println("[" + subList.toString() + "]");
        System.out.println("-".repeat(45));

        // Questioned if my value is in the list
        System.out.println("20 value of my list --> " + arrList.contains(20));
        System.out.println("120 value of my list --> " + arrList.contains(120));
        System.out.println("-".repeat(45));

        // Empties the list completely and reverts it to its default size
        arrList.clear();
        System.out.println(arrList.toString());



    }
}
