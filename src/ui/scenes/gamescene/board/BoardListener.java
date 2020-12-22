package ui.scenes.gamescene.board;

public interface BoardListener {

    void onPairDiscovered(int clearedPairs, int remainingPairs);
    void onBoardSolved();
}
