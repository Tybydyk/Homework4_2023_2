package Java_Homeworks.Homework4_2023_2;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Stack;
/*
 * К калькулятору из предыдущего дз добавить логирование.
 */
public class Homework4_3 {
    public static void main(String[] args) throws MalformedURLException, IOException {

        FileWriter wrtr1 = new FileWriter("HW2_4_log.txt", false);
        Date date = new Date();
        wrtr1.write(date.toString()); // Recorded the date in the header
        wrtr1.close();
        FileWriter wrtr2 = new FileWriter("HW2_4_log.txt", true); // Opened file for adding logs

        Scanner inpScan = new Scanner(System.in);
        String yOrN = "y";
        System.out.println("This is a simple calculator\n");
        Stack<String> stk = new Stack<String>();
        int a;
        int b;

        while (!yOrN.equalsIgnoreCase("n")) {
            if(yOrN.equalsIgnoreCase("u")){
                stk.pop();
                stk.pop();
                a = Integer.parseInt(stk.pop());
                wrtr2.write("\nUndo");
                System.out.printf("The action and the second number were canceled.\na = %d\n",a);
            }
            else {
                System.out.println("Enter an integer first number a: ");
                a = Integer.parseInt(inpScan.nextLine());
            }  
            System.out.println("What action will we perform? (Enter +, -, *, / )");
            // String tmp = inpScan.nextLine();// не понял почему, но в tmp записывается пробел или перевод строки
            String act = inpScan.nextLine();
            char ch_act = act.charAt(0);
            System.out.println("Enter an integer second number b: ");
            b = Integer.parseInt(inpScan.nextLine());

            double result = 0;
            if (ch_act == '+')
                result = a + b;
            if (ch_act == '-')
                result = a - b;
            if (ch_act == '*')
                result = a * b;
            if (ch_act == '/')
                result = (double) a / b;

            StringBuilder resultString = new StringBuilder();
            resultString.append(a).append(" ").append(act).append(" ").append(b).append(" = ").append(result);
            System.out.println(resultString);
            wrtr2.write("\n" + resultString.toString());

            stk.add(String.valueOf(a));
            stk.add(act);
            stk.add(String.valueOf(b));

            System.out.println("Do You want want to undo(u) the last step\nor  or will you count further? (u/y/n) :");
            yOrN = inpScan.nextLine();
        }
        inpScan.close();
        wrtr2.write("\n" + date.toString());
        wrtr2.close();
    }
}