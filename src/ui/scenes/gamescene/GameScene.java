package ui.scenes.gamescene;

import config.GameConfig;
import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.events.KeyPressedEvent;
import game.Card;
import ui.scenes.BaseScene;
import ui.scenes.gamescene.board.Board;
import ui.scenes.gamescene.board.BoardListener;
import ui.scenes.gamescene.gameinfo.GameInfo;

import java.util.ArrayList;
import java.util.Collections;

public class GameScene extends BaseScene implements BoardListener {

    private Board board;
    private GameInfo bottomBar;
    private AudioClip cheerClip;
    private AudioClip backgroundMusic;
    private boolean backgroundMusicIsPlaying;

    public GameScene() {
        super();
        initMusic();
        initUI();
        initGame();
    }

    private void initMusic() {
        cheerClip = new AudioClip(GameConfig.PATH_TO_CHEER_CLIP);
        backgroundMusic = new AudioClip(GameConfig.PATH_TO_BACKGROUND_MUSIC);
        backgroundMusicIsPlaying = false;
    }

    private void initUI() {
        board = new Board(GameConfig.BOARD_X_MARGIN, 0, this);
        bottomBar = new GameInfo(0, GameConfig.WINDOW_HEIGHT - GameConfig.BOTTOM_BAR_HEIGHT, GameConfig.WINDOW_WIDTH, GameConfig.BOARD_HEIGHT, GameConfig.BOTTOM_BAR_COLOR);
        addElement(board);
        addElement(bottomBar);
    }

    private void initGame() {
        ArrayList<Card> stack = Card.createStack(GameConfig.DEFAULT_NUMBER_OF_PAIRS);
        Collections.shuffle(stack);
        board.setCards(stack);
        bottomBar.setCounter(0, stack.size() / 2);
    }

    private void toggleMusic() {
        backgroundMusicIsPlaying = !backgroundMusicIsPlaying;
        if (!backgroundMusicIsPlaying) {
            backgroundMusic.stop();
        } else {
            backgroundMusic.loop();
        }
    }

    @Override
    public void start() {
        super.start();
        toggleMusic();
    }

    @Override
    public void pause() {
        super.pause();
        toggleMusic();
    }

    @Override
    public void handleKeyPressed(int keyCode) {
        super.handleKeyPressed(keyCode);
        switch (keyCode) {
            case KeyPressedEvent.VK_N:
                initGame();
                break;
            case KeyPressedEvent.VK_M:
                toggleMusic();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPairDiscovered(int clearedPairs, int remainingPairs) {
        bottomBar.setCounter(clearedPairs, clearedPairs + remainingPairs);
    }

    @Override
    public void onBoardSolved() {
        cheerClip.play();
    }

}
