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

                int finalBetNumber = betNumber;
                double finalAmount = amount;
                String finalBetInput = betInput;
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                
                                int randomBall;
                                double amountWon = 0;
                                randomBall = (int) (Math.random() * (36 - 1));

                                if (finalBetNumber != 0) {
                                    if (randomBall == finalBetNumber) {
                                        amountWon = 36 * finalAmount;
                                    }

                                }

                                if (finalBetInput != null) {
                                    if (finalBetInput.equalsIgnoreCase("EVEN") & randomBall% 2 == 0) {
                                        amountWon = 2 * finalAmount;
                                    } else if (finalBetInput.equalsIgnoreCase("ODD") & !(randomBall % 2 == 0)) {
                                        amountWon = 2 * finalAmount;
                                    }
                                }

                                String outcome;
                                int isBigger = Double.compare(amountWon, finalAmount);
                                if (isBigger > 0){
                                    outcome = "WIN";
                                } else {
                                    outcome = "LOSE";
                                }

                                String finalBet;
                                if (finalBetInput == null){
                                    finalBet = String.valueOf(finalBetNumber);
                                } else {
                                    finalBet = finalBetInput;
                                }

                                System.out.println("number: " + randomBall + "\n" + "Player      "+"bet "+ "outcome " + "winnings " + "\n" + s +"     "+finalBet +" "+  outcome +" "+ amountWon);


                            }
                        },
                        5000
                );


            }


        } while (repeat);

    }

}
