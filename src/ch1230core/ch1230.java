package ch1230core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hanlaptop on 2017-03-16.
 */
public class ch1230 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Map temp = null;
        try {
            System.out.println("Enter a filename; ");
            temp = count(kbd.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 65; i < 91; i++)
            System.out.println("Numbers of " + (char) i + "\'s: " + temp.get((char) i));

    }


    public static Map<Character, Counter> count(String filename) throws FileNotFoundException {
        InputStream in = new FileInputStream(filename);
        Scanner scanner = new Scanner(in);
        Map<Character, Counter> map = new HashMap<>();

        for (int i = 65; i < 91; i++)
            map.put((char) i, new Counter());


        while (true) {
            try {
                String str = scanner.nextLine();
                str = str.toUpperCase();
                char[] arr = str.toCharArray();
                for (char ch : arr) {
                    Counter cnt = map.get(ch);
                    if (cnt == null)
                        continue;
                    cnt.increase();
                }

            } catch (Exception e) {
                break;
            }
        }
        return map;

    }

}


class Counter {
    int count;

    public Counter() {
        this.count = 0;
    }

    public void increase() {
        count++;
    }

    public String toString() {
        return "" + count;
    }

    //numbers of A is counted 1
}