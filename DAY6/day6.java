import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class day6 {

    public static int helper() {

        int f = 0, s = 0;

        HashSet<Character> hs = new HashSet<>();

        int dis_char = 14; // 4

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                while (f < data.length()) {
                    if (hs.size() == dis_char) {
                        return f;
                    }

                    char ch = data.charAt(f);

                    if (hs.contains(ch)) {
                        hs.remove(data.charAt(s));
                        s++;
                    } else {
                        hs.add(ch);
                        f++;
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return f;

    }

    public static void main(String[] args) {

        int ans = helper();

        System.out.println(ans);

    }

}
