import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class JavaCollectionTest {

    public static void linkedlistTest(){
        // Create a LinkedList object that can contain Integer
        // Name the variable to list
    
        
        int x;
        for (int i=1; i<10; i+= 2){
            x = i;
            // Add keys to the LinkedList object (list)
            
        }
            
        // Check if 5 is contained in the list
        boolean check = false; // Fix this
        System.out.println("5 is in the list = "+check);
        
        // Check if 6 is contained in the list
        check = true; // Fix this
        System.out.println("6 is in the list = "+check);
        
        // Show all elements in the list
        // Fix all of these
        int e = 0;
        System.out.print(e + ", ");
        System.out.println();
    }
        
    public static void queueTest(){
        // Create a queue object that can contain String's
        // Name the varible to q
        
        String[] names = {"Abraham","Andrew","Benjamin","Claudia","Gabriel"};
        for (int i=0; i<names.length; i++){
            // Add names[i] to the queue object (q)
            
        }
            
        System.out.println("Top = "+ "Patiwet");        // Fix this
        System.out.println("1st Pop = " + "Patiwet");   // Fix this
        System.out.println("2nd Pop = " + "Patiwet");   // Fix this
        System.out.println("3rd Pop = " + "Patiwet");   // Fix this
    }
        
    public static void stackTest(){
        // Create a stack of object that can contain String's
        // Name the varible to s
        
        
        String[] names = {"Abraham","Andrew","Benjamin","Claudia","Gabriel"};
        for (int i=0; i<names.length; i++){
            // Push names[i] into the stack object (s)
            
        }
            
        System.out.println("Top = "+ "Patiwet");        // Fix this
        System.out.println("1st Pop = "+ "Patiwet");    // Fix this
        System.out.println("2nd Pop = "+ "Patiwet");    // Fix this
        System.out.println("3rd Pop = "+ "Patiwet");    // Fix this
    }
        
        
    public static void arrayOfListTest(){
        // This part is to create an array of LinkedList (each LinkedList contains String's)
        // This section is complete, no need to edit
        // Your task is to understand my code
        LinkedList<String>[] arr = new LinkedList[5];
        String[] names = {"Abraham","Andrew","Benjamin","Claudia","Gabriel"};
        for (int i=0; i<5; i++){
            LinkedList<String> list = new LinkedList();
            for (int j=0; j<=i; j++){
                list.add(names[j]);
            }
            arr[i] = list;
        }
        
        // Once you understand the above section, pls fix the following code to correct the results
        
        // Show all elements for each list
        for (int i=0; i<arr.length; i++){
            
            // Fix these lines
            System.out.print("arr["+i+"] = ");
            String s = "Patiwet";
            System.out.print(s + ", ");
            System.out.println("");
        }
            
        // Check if "Benjamin" is contained in any list
        for (int i=0; i<arr.length; i++){
            
            // Do something
            
            System.out.println("Benjamin is contained in arr["+i+"]? = " + false); // Fix this
        }
    }
}