import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class day5 {

    public static String helper() {

        HashMap<Integer, LinkedList<Character>> hm = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            hm.put(i, new LinkedList<>());
        }

        String ans = "";
        int input = 9, curr = 1;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                if (curr <= input) {

                    int st = 1;
                    // System.out.println(data);
                    int inc = 0;
                    for (int i = 0; i < data.length(); i++) {
                        char ch = data.charAt(i);

                        if ('A' <= ch && ch <= 'Z') {

                            LinkedList<Character> temp = hm.get(st);

                            // System.out.println(ch);
                            temp.addFirst(ch);

                        }

                        if (inc == 3) {
                            inc = 0;
                            st++;
                        } else {
                            inc++;
                        }
                    }

                    curr++;
                } else if (curr == input + 1) {
                    curr++;
                } else {

                    String[] ins = data.split(" ");
                    int nst = Integer.parseInt(ins[1]);
                    int rst = Integer.parseInt(ins[3]);
                    int ast = Integer.parseInt(ins[5]);
                    System.out.println(nst + " " + rst + " " + ast);
                    LinkedList<Character> rem = hm.get(rst);
                    LinkedList<Character> add = hm.get(ast);
                    for (int i = 0; i < nst; i++) {
                        char t = rem.removeLast();
                        add.addLast(t);
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(hm.get(i).getLast());
        }

        return sb.toString();
    }

    public static String helper2() {

        HashMap<Integer, LinkedList<Character>> hm = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            hm.put(i, new LinkedList<>());
        }

        String ans = "";
        int input = 9, curr = 1;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                if (curr <= input) {

                    int st = 1;
                    // System.out.println(data);
                    int inc = 0;
                    for (int i = 0; i < data.length(); i++) {
                        char ch = data.charAt(i);

                        if ('A' <= ch && ch <= 'Z') {

                            LinkedList<Character> temp = hm.get(st);

                            // System.out.println(ch);
                            temp.addFirst(ch);

                        }

                        if (inc == 3) {
                            inc = 0;
                            st++;
                        } else {
                            inc++;
                        }
                    }

                    curr++;
                } else if (curr == input + 1) {
                    curr++;
                } else {

                    String[] ins = data.split(" ");
                    int ncr = Integer.parseInt(ins[1]);
                    int rst = Integer.parseInt(ins[3]);
                    int ast = Integer.parseInt(ins[5]);
                    System.out.println(ncr + " " + rst + " " + ast);
                    LinkedList<Character> rem = hm.get(rst);
                    LinkedList<Character> add = hm.get(ast);
                    Stack<Character> st = new Stack<>();
                    for (int i = 0; i < ncr; i++) {
                        st.add(rem.removeLast());
                    }
                    while (st.size() > 0) {
                        add.addLast(st.pop());
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(hm.get(i).getLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String ans = helper2();

        System.out.println(ans.length() + " " + ans);
    }

}
