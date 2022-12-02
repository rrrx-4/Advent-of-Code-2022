import java.io.*;
import java.util.*;

public class day2 {

    public static int helper1() {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("A X", 4);
        hm.put("A Y", 8);
        hm.put("A Z", 3);

        hm.put("B X", 1);
        hm.put("B Y", 5);
        hm.put("B Z", 9);

        hm.put("C X", 7);
        hm.put("C Y", 2);
        hm.put("C Z", 6);

        ArrayList<Integer> arr = new ArrayList<>();

        int ans = 0;
        int c = 1;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                System.out.println(data);

                ans += hm.get(data);

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

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                char opp = data.charAt(0);
                char you = data.charAt(2);

                if (you == 'X') {
                    if (opp == 'A') {
                        ans += 3;
                    } else if (opp == 'B') {
                        ans += 1;
                    } else {
                        ans += 2;
                    }
                } else if (you == 'Y') {
                    if (opp == 'A') {
                        ans += 3 + 1;
                    } else if (opp == 'B') {
                        ans += 3 + 2;
                    } else {
                        ans += 3 + 3;
                    }
                } else {
                    if (opp == 'A') {
                        ans += 6 + 2;
                    } else if (opp == 'B') {
                        ans += 6 + 3;
                    } else {
                        ans += 6 + 1;
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