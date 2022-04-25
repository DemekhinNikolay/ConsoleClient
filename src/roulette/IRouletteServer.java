package roulette;

public interface IRouletteServer {

    int betAmount();
    void numberChoice();
    void betBlack();
    void betRed();
    void betNumber();
    void betEven();
    void betOdd();
    void betFrom1to18();
    void betFrom19to36();
    void help();
    void exit();
}
