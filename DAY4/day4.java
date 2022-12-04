import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {

    public static int helper1() {

        int ans = 0;
        int c = 0;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                c++;
                String data = myReader.nextLine();

                String[] pair = data.split(",");

                String[] fp = pair[0].split("-");

                String[] sp = pair[1].split("-");

                int fp1 = Integer.parseInt(fp[0]);
                int fp2 = Integer.parseInt(fp[1]);

                int sp1 = Integer.parseInt(sp[0]);
                int sp2 = Integer.parseInt(sp[1]);

                if (fp1 <= sp1) {
                    if (fp2 >= sp2) {
                        ans++;
                        continue;
                    }
                }
                if (sp1 <= fp1) {
                    if (sp2 >= fp2) {
                        ans++;
                        continue;
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(c);

        return ans;

    }

    public static int helper2() {

        int ans = 0;
        int c = 0;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                c++;
                String data = myReader.nextLine();

                String[] pair = data.split(",");

                String[] fp = pair[0].split("-");

                String[] sp = pair[1].split("-");

                int fp1 = Integer.parseInt(fp[0]);
                int fp2 = Integer.parseInt(fp[1]);

                int sp1 = Integer.parseInt(sp[0]);
                int sp2 = Integer.parseInt(sp[1]);

                if (fp1 <= sp1 && sp1 <= fp2) {
                    ans++;

                    continue;
                }
                if (sp1 <= fp1 && fp1 <= sp2) {

                    ans++;

                    continue;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // System.out.println(c);

        return ans;

    }

    public static void main(String[] args) {

        // helper1();

        int ans = helper2();

        System.out.println(ans);

    }
}
