package Java_Homeworks.Homework4_2023_2;
/*
 Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class Homework4_2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner inpScan = new Scanner(System.in);
        System.out.println("Enter the lenght of the list");
        int l = inpScan.nextInt();
        System.out.println("Enter an element for testing methods");
        int el = inpScan.nextInt();
        LinkedList<Integer> liLst = new LinkedList<Integer>();

        for (int i = 0; i < l; i++) {
            liLst.add(rand.nextInt(50 + 1) + 1); // Making a list of prime random(1,50) numbers with lenght = l
        }
        System.out.println(liLst);
        System.out.printf("putting the element %d at the end of the queue:\n", el);
        System.out.println(enqueue(liLst,el));
        System.out.printf("returns the first element = %d from the queue and deletes it:\n", dequeue(liLst));
        System.out.println(liLst);
        System.out.printf("returns the first element = %d from the queue without removing:\n", first(liLst));
        System.out.println(liLst);
    }

    public static LinkedList<Integer> enqueue(LinkedList<Integer> lst, int el) {
        lst.addLast(el);
        return lst;
    }
    public static int dequeue(LinkedList<Integer> lst) {
        int firstElement = lst.remove(0);
        return firstElement;
    }
    public static int first(LinkedList<Integer> lst) {
        int firstElement = lst.get(0);
        return firstElement;
    }
}