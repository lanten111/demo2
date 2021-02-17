/*
created by mumakhado on 2021/02/17
*/

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class consoleRoulette {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("/home/makahdo/Documents/Input_file.txt");

        ArrayList<String> nameList = (ArrayList<String>) Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        boolean repeat;
        do {
            repeat = true;
            for (String s : nameList) {

                String betInput = null;
                int betNumber = 0;
                double amount = 0.0;
//                int randomBall = 0;
//                double amountWon;
                Scanner scanner = new Scanner(System.in);

                System.out.println(s);
                while (!scanner.hasNextInt()) {
                    betInput = scanner.next();
                    if (!(betInput.equalsIgnoreCase("EVEN") || betInput.equalsIgnoreCase("ODD"))) {
                        betNumber = Integer.getInteger(betInput);
                    } else break;

                }

                while (scanner.hasNextInt()) {
                    betNumber = scanner.nextInt();
                    if (betNumber > 36 || betNumber < 1) {
                        System.out.println("Bet number must be between 36 and 1, EVEN or ODD");
                    } else {
                        break;
                    }
                }

                amount = scanner.nextDouble();


            }


        } while (repeat);

    }

}
