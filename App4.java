import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
import java.util.Arrays;
//Реализуйте простой калькулятор, с консольным интерфейсом. К калькулятору добавить логирование.
public class App4 {
    public static void main(String[] args) throws SecurityException, IOException {

        Logger logger = Logger.getLogger(App4.class.getName());
        FileHandler fh = new FileHandler("log_app4.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setLevel(Level.INFO);


        Scanner scan = new Scanner(System.in);
        int result = 0; 
        System.out.println("(Пример пользования '10 + 3' )");
        System.out.println("Введите пример, который хотите решить: ");
        String[] userMsg = scan.nextLine().split(" ");
        logger.info(Arrays.toString(userMsg));
        
        if(userMsg[1].equals("+")){
            result = add(Integer.parseInt(userMsg[0]),Integer.parseInt(userMsg[2]));
        }if(userMsg[1].equals("-")){
            result = subtract(Integer.parseInt(userMsg[0]),Integer.parseInt(userMsg[2]));
        }if(userMsg[1].equals("*")){
            result = mult(Integer.parseInt(userMsg[0]),Integer.parseInt(userMsg[2]));
        }if(userMsg[1].equals("/")){
            result = division(Integer.parseInt(userMsg[0]),Integer.parseInt(userMsg[2]));
        }

        System.out.printf("Ответ: %s", result); 
               
    }

    public static int add(int a, int b) {
        return a + b;        
    }

    public static int subtract(int a, int b) {
        return a - b;        
    }

    public static int mult(int a, int b) {
        return a * b;        
    }

    public static int division(int a, int b) {
        return a / b;        
    }
    
}
