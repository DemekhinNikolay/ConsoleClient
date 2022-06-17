package roulette;

import java.util.Scanner;

public class ConsoleClient {
    public static void main(String[] args) {
        IRouletteServer server = new RouletteServerImpl();
        Scanner scan = new Scanner(System.in);

        while (server.getBalance() > 0) {
            System.out.println("Choose a bet type or a team: black - 1 | red - 2 | number - 3 | even - 4 |\n" +
                    " odd - 5 | from 1 to 18 - 6 | from 19 to 36 - 7 | help - 8 | exit - 9");
            server.choiceBet(scan.nextInt());
            System.out.println("Select the bet amount: Your balance is $" + server.getBalance());
            server.choiceSum(scan.nextInt());
            if (server.getBet() == 3) {
                System.out.println("select a number from 0 - 36");
                server.choiceNumber(scan.nextInt());

            }
            server.betting();
        }

    }
}