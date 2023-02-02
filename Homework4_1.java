package Java_Homeworks.Homework4_2023_2;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Homework4_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner inpScan = new Scanner(System.in);
        System.out.println("Enter the lenght of the list");
        int l = inpScan.nextInt();
        LinkedList<Integer> liLst = new LinkedList<Integer>();

        for (int i = 0; i < l; i++) {
            liLst.add(rand.nextInt(l + 1) + 1); // Making a list of prime random(1,l) numbers with lenght = l
        }
        System.out.println(liLst);
        System.out.println(rvrs(liLst));
    }

    public static LinkedList<Integer> rvrs(LinkedList<Integer> lst) {
        for(int i = 1; i < lst.size(); i++){
            lst.addFirst(lst.remove(i)); 
        }
        return lst;
    }
}