import classes.DynamicArray;
public class Main {
    public static void main(String[] args) {
        DynamicArray var1 = new DynamicArray(2);
        var1.pushBack(5);
        var1.popBack();
        var1.pushBack(1);
        var1.pushBack(5);
        var1.pushBack(5);
        var1.pushBack(5);
        var1.pushBack(1);
        var1.printStructure();
    }
    
}
