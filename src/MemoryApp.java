import config.GameConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import game.Card;
import ui.board.Board;
import ui.board.BoardListener;
import ui.bottomBar.BottomBar;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryApp extends GraphicsApp implements GameConfig, BoardListener {

    private Board board;
    private BottomBar bottomBar;
    private AudioClip cheerClip;
    private AudioClip backgroundMusic;
    private boolean backgroundMusicIsPlaying;

    @Override
    public void initialize() {
        setFrameRate(30);
        setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        initMusic();
        initUI();
        initGame();
    }

    private void initMusic() {
        cheerClip = new AudioClip(PATH_TO_CHEER_CLIP);
        backgroundMusic = new AudioClip(PATH_TO_BACKGROUND_MUSIC);
        backgroundMusic.loop();
        backgroundMusicIsPlaying = true;
    }

    private void initUI() {
        board = new Board(GameConfig.BOARD_X_MARGIN, 0, WINDOW_WIDTH, BOARD_HEIGHT, Colors.TRANSPARENT, this);
        bottomBar = new BottomBar(0, WINDOW_HEIGHT - BOTTOM_BAR_HEIGHT, WINDOW_WIDTH, BOARD_HEIGHT, BOTTOM_BAR_COLOR);
    }

    private void initGame() {
        ArrayList<Card> stack = Card.createStack(DEFAULT_NUMBER_OF_PAIRS);
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
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        board.draw();
        bottomBar.draw();
    }

    @Override
    public void onPairDiscovered(int clearedPairs, int remainingPairs) {
        bottomBar.setCounter(clearedPairs, clearedPairs + remainingPairs);
    }

    @Override
    public void onBoardSolved() {
        cheerClip.play();
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        board.handleMouseClick(event.getXPos(), event.getYPos());
        bottomBar.handleMouseClick(event.getXPos(), event.getYPos());
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        switch (event.getKeyCode()) {
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

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
