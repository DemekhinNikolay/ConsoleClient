package roulette;


import java.util.Scanner;

public class RouletteServerImpl implements IRouletteServer {

    String[] colorArray = {"green", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red",
            "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black",
            "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black",
            "red" };


    int black = 1;
    int red = 2;
    int number = 3;
    int even = 4;
    int odd = 5;
    int from1to18 = 6;
    int from19to36 = 7;
    int help = 8;
    int exit = 9;

    int bank = 100;
    int amount;
    int numberCh;

    @Override
    public int betAmount() { //BET AMOUNT
        Scanner scan= new Scanner(System.in);
        amount = scan.nextInt();
        return amount;
    }

    @Override
    public void numberChoice() { //NUMBER SELECTION
        Scanner scan= new Scanner(System.in);
        numberCh = scan.nextInt();
    }

    @Override
    public void betBlack() { // BET ON BLACK
        System.out.println("You chose black");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length); // random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if ((numberColor & 1) == 0) {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        } else {
            bank += amount * 2;
            System.out.println("You win, your bank is $ " + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betRed() { // BET ON RED
        System.out.println("You chose red");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if ((numberColor & 1) == 0) {
            bank += amount * 2;
            System.out.println("You win, your bank $" + bank );
        } else {
            bank -= amount;
            System.out.println("you lost, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betNumber() { //BET ON A NUMBER
        System.out.println("You chose a number");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        System.out.println("What number do you want to bet on from 0 - 36" );
        numberChoice();
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if (numberCh == numberColor) {
            bank += amount * 35;
            System.out.println("You win, your bank $" + bank );
        } else {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betEven() { // BET ON EVEN
        System.out.println("You chose an even number");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if (numberColor % 2 == 0) {
            bank += amount * 2;
            System.out.println("You win, your bank $" + bank );
        }else  {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betOdd() { // BET ON ODD
        System.out.println("You chose an odd number");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if (numberColor % 2 == 0) {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        }else  {
            bank += amount * 2;
            System.out.println("You win, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betFrom1to18() { // BET,FROM 1 TO 18
        System.out.println("You have chosen a bet from 1 to 18");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if (numberColor <= 18) {
            bank += amount * 2;
            System.out.println("You win, your bank $" + bank );
        } else {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void betFrom19to36() { // BET,FROM 19 TO 36
        System.out.println("You have chosen a bet from 19 to 36");
        System.out.println("Your bank " + bank + " $ set the bid amount ");// place a bet
        System.out.println("Your bet $" + betAmount() );
        int numberColor = (int) Math.floor(Math.random() * colorArray.length);// random (outputs the number and color in the format 23 -black\red)
        System.out.println("You have fallen out " + numberColor + " " + colorArray[numberColor]);
        if (numberColor >= 19) {
            bank += amount * 2;
            System.out.println("You win, your bank $" + bank );
        } else {
            bank -= amount;
            System.out.println("You lost, your bank $" + bank );
        }
        if (bank == 0) { //if the bank is 0
            System.out.println("You ran out of money, you lost :( ");
            System.exit(0);
        }else if (bank == 1000){ //if you win a lot
            System.out.println("You won a lot of money from us, goodbye");
            System.exit(0);
        }
    }

    @Override
    public void help() {
        System.out.println("""
                You are welcomed by the roulette game, you will be asked to choose the type of bet
                The bet on black is calculated 2 to 1
                The bet on red is calculated 2 to 1
                A bet on a number from 0-36 is calculated 35 to 1
                The bet on even is calculated 2 to 1
                The odd bet is calculated 2 to 1""");
    }

    @Override
    public void exit() {
        System.out.println("Goodbye ");
        System.exit(0);
    }

}