package roulette;

public interface IRouletteServer {

    int getBalance();
    void choiceBet(int bet);
    int getBet();
    void choiceSum (int sum);
    void choiceNumber (int number);
    void betting ();

}
