package roulette;

import java.util.Scanner;

public class ConsoleClient {
    public static void main(String[] args) {
        RouletteServerImpl Implement = new RouletteServerImpl();
        Scanner scan= new Scanner(System.in);

        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("Choose a bet type or a team: black - 1 | red - 2 | number - 3 | even - 4 |\n" +
                    " odd - 5 | from 1 to 18 - 6 | from 19 to 36 - 7 | help - 8 | exit - 9");

            int menu = scan.nextInt();


            if (menu == Implement.black) {
                Implement.betBlack();
            } else if (menu == Implement.red) {
                Implement.betRed();
            } else if (menu == Implement.number) {
                Implement.betNumber();
            }else if (menu == Implement.even) {
                Implement.betEven();
            }else if (menu == Implement.odd) {
                Implement.betOdd();
            }else if (menu == Implement.from1to18) {
                Implement.betFrom1to18();
            }else if (menu == Implement.from19to36) {
                Implement.betFrom19to36();
            }else if (menu == Implement.help) {
                Implement.help();
            }else if (menu == Implement.exit) {
                Implement.exit();
            }
        }
    }
}