package roulette;


import java.util.List;

public class RouletteServerImpl implements IRouletteServer {

    List<String> colorArray = List.of("green", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red",
            "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black",
            "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black",
            "red");

    int balance = 1000;
    int sum;
    int bet;
    int number;

    @Override
    public void choiceBet (int b) { //выбор ставки
        bet = b;
    }

    @Override
    public void choiceSum (int s) { //выбор суммы
        sum = s;
    }

    @Override
    public void choiceNumber (int n) { //выбор номера
        number = n;
    }

    @Override
    public void betting () {

        int numberColor = (int) Math.floor(Math.random() * colorArray.size());
        System.out.println("You have fallen out " + numberColor + " " + colorArray.get(numberColor));
        switch (bet) {
            case 1 -> { //betBlack
                if ((numberColor & 1) == 0) {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
                } else {
                    balance += sum * 2;
                    System.out.println("You win, your bank is $ " + balance);
                }
            }
            case 2 -> { //betRed
                if ((numberColor & 1) == 0) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance );
                } else {
                    balance -= sum;
                    System.out.println("you lost, your bank $" + balance );
                }
            }
            case 3 -> {
                if (number == numberColor) {
                    balance += sum * 35;
                    System.out.println("You win, your bank $" + balance );
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance );
                }
            }
            case 4 -> {
                if (numberColor % 2 == 0) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance );
                }else  {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance );
                }
            }
            case 5 -> {
                if (numberColor % 2 == 0) {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance );
                }else  {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance );
                }
            }
            case 6 -> {
                if (numberColor <= 18) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance );
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance );
                }
            }
            case 7 -> {
                if (numberColor >= 19) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance );
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance );
                }
            }
        }

        if (bet == 8) {
            System.out.println("""
                You are welcomed by the roulette game, you will be asked to choose the type of bet
                The bet on black is calculated 2 to 1
                The bet on red is calculated 2 to 1
                A bet on a number from 0-36 is calculated 35 to 1
                The bet on even is calculated 2 to 1
                The odd bet is calculated 2 to 1""");
        }else if (bet == 9) {
            System.out.println("Goodbye ");
            System.exit(0);
        }

    }
}