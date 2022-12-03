import java.io.*;
import java.util.*;

public class day3 {

    public static int helper1() {

        int ans = 0;
        int count = 1;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                System.out.println(count++);

                String data = myReader.nextLine();

                int len = data.length();
                // System.out.println(data);
                HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

                // StringBuilder sb = new StringBuilder(data);

                char[] arr = data.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    if (hm.containsKey(arr[i])) {
                        hm.get(arr[i]).add(i + 1);
                    } else {

                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(i + 1);
                        hm.put(arr[i], al);
                    }
                }

                for (char ch : hm.keySet()) {
                    ArrayList<Integer> temp = hm.get(ch);

                    if (temp.size() >= 2) {
                        int f = temp.get(0);
                        int s = temp.get(temp.size() - 1);

                        if (f <= len / 2 && s > len / 2) {
                            int val = 0;
                            if ('a' <= ch && ch <= 'z') {
                                val = ch - 'a' + 1;
                            } else {
                                val = ch - 'A' + 1 + 26;
                            }

                            ans += val;
                        }
                    }
                }

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return ans;
    }

    public static int helper2() {

        int ans = 0;
        int c = 0;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int[] map = new int[53];

                for (int i = 0; i < 3; i++) {
                    int[] temp = new int[53];
                    String data = myReader.nextLine();

                    char[] items = data.toCharArray();

                    for (int j = 0; j < items.length; j++) {
                        char ch = items[j];
                        int index = 0;
                        if ('a' <= ch && ch <= 'z') {
                            index = ch - 'a' + 1;
                        } else {
                            index = ch - 'A' + 1 + 26;
                        }

                        if (temp[index] == 0) {
                            temp[index] = 1;
                            map[index] += 1;
                        }

                    }

                }

                for (int i = 0; i < map.length; i++) {
                    if (map[i] == 3) {
                        ans += i;
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return ans;
    }

    public static void main(String[] args) {
        // helper1();
        int ans = helper2();

        System.out.println(ans);

    }

}