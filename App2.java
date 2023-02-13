import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
import java.util.Random;
/**
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class App2 {
    private final static Logger log = Logger.getLogger(App2.class.getName());
    public static void main(String[] args) throws SecurityException, IOException {
        int[] mass = initArray(5);
        int[] sortedMass = sortBuble(mass);
        printArr("Unsorted massive:", mass);
        printArr("Sorted massive:", sortedMass);
    }

    public static int[] sortBuble(int[] mass) throws SecurityException, IOException{
        log.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("log.txt", true);
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter ();
        fh.setFormatter(sf);    

        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mass.length-1; i++) {
                if(mass[i] > mass[i+1]){
                    isSorted = false;
                    temp = mass[i];
                    mass[i] = mass[i+1];
                    mass[i+1] = temp;
                }
                log.info(Arrays.toString(mass));
            }
        }
        return mass;        
    }

    public static int[] initArray(int size) {
        int[] arr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(0, 30);
        }
        return arr;        
    }

    public static void printArr(String msg, int[] mass){
        System.out.println(msg);        
        System.out.println(Arrays.toString(mass));
    }
}