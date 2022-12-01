import java.util.*;
import java.io.*;

public class Day1 {

    public static long helper() {

        long curr_max = 0;
        long final_max = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.length() == 0) {
                    if (pq.size() <= 2) {
                        pq.add(curr_max);
                    } else if (curr_max > pq.peek()) {
                        pq.poll();
                        pq.add(curr_max);

                    }
                    curr_max = 0;
                } else {
                    long t = Long.parseLong(data);
                    curr_max += t;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (long a : pq)
            final_max += a;

        return final_max;
    }

    public static void main(String[] args) {

        long ans = helper();

        System.out.println(ans);

    }

}