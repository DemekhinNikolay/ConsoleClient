package roulette;

import java.util.List;
import java.util.stream.IntStream;

public class RouletteServerImpl implements IRouletteServer {


    private final List<String> colorArray = IntStream.range(0, 37).boxed()
            .map(x -> {
                if (x == 0) {
                    return x + " green";
                }
                if (x % 2 == 0) {
                    return x + " red";
                } else {
                    return x + " black";
                }
            }).toList();


    private int balance = 1000;
    private int bet;
    private int sum;
    private int number;


    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void choiceBet(int b) {
        bet = b;
    }

    @Override
    public int getBet() {
        return bet;
    }

    @Override
    public void choiceSum(int s) {
        sum = s;
    }

    @Override
    public void choiceNumber(int n) { //выбор номера
        number = n;
    }

    @Override
    public void betting() {

        int numberColor = (int) Math.floor(Math.random() * colorArray.size());
        System.out.println("You have fallen out " + colorArray.get(numberColor));
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
                    System.out.println("You win, your bank $" + balance);
                } else {
                    balance -= sum;
                    System.out.println("you lost, your bank $" + balance);
                }
            }
            case 3 -> {
                if (number == numberColor) {
                    balance += sum * 35;
                    System.out.println("You win, your bank $" + balance);
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
                }
            }
            case 4 -> {
                if (numberColor % 2 == 0) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance);
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
                }
            }
            case 5 -> {
                if (numberColor % 2 == 0) {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
                } else {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance);
                }
            }
            case 6 -> {
                if (numberColor <= 18) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance);
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
                }
            }
            case 7 -> {
                if (numberColor >= 19) {
                    balance += sum * 2;
                    System.out.println("You win, your bank $" + balance);
                } else {
                    balance -= sum;
                    System.out.println("You lost, your bank $" + balance);
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
                    The odd bet is calculated 2 to 1
                    When choosing information, it requires you to enter the amount,
                    you can enter any value, the amount will not be withdrawn.""");
        } else if (bet == 9) {
            System.out.println("Goodbye ");
            System.exit(0);
        }

    }
}