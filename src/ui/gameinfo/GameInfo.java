package ui.gameinfo;

import config.GameConfig;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;
import ui.UIElement;

public class GameInfo extends UIElement {

    private static final String CONTROLS_HELP_TEXT = "[M]: Musik an- und ausschalten | [N]: Spiel neustarten";
    private static final String REVEALED_PAIRS_PREFIX = "Aufgedeckte Paare: ";
    private Label controlsTextView;
    private Label revealedPairsTextView;
    private Rectangle background;

    public GameInfo(int x, int y, int width, int height, Color backgroundColor) {
        initTextViews(x, y);
        background = new Rectangle(x, y, width, height, backgroundColor);
    }

    private void initTextViews(int x, int y) {
        controlsTextView =  new Label(0, 0, CONTROLS_HELP_TEXT);
        controlsTextView.setFont(GameConfig.LABEL_FONT_NAME);
        controlsTextView.setFontSize(GameConfig.LABEL_FONT_SIZE);
        controlsTextView.setColor(GameConfig.LABEL_FONT_COLOR);
        controlsTextView.setXPos(x + GameConfig.BOTTOM_BAR_PADDING);
        controlsTextView.setYPos(y + GameConfig.BOTTOM_BAR_PADDING);
        revealedPairsTextView = new Label(0, 0, REVEALED_PAIRS_PREFIX + "0/0");
        revealedPairsTextView.setFont(GameConfig.LABEL_FONT_NAME);
        revealedPairsTextView.setFontSize(GameConfig.LABEL_FONT_SIZE);
        revealedPairsTextView.setColor(GameConfig.LABEL_FONT_COLOR);
        revealedPairsTextView.setXPos(GameConfig.WINDOW_WIDTH - revealedPairsTextView.getWidthEstimate() - GameConfig.BOTTOM_BAR_PADDING);
        revealedPairsTextView.setYPos(y + (GameConfig.BOTTOM_BAR_HEIGHT - revealedPairsTextView.getHeightEstimate()));
    }

    public void setCounter(int clearedPairs, int totalPairs) {
        revealedPairsTextView.setText(REVEALED_PAIRS_PREFIX + clearedPairs + "/" + totalPairs);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        background.draw();
        controlsTextView.draw();
        revealedPairsTextView.draw();
    }

    @Override
    public void handleMouseClick(int x, int y) {
    }

    @Override
    public void handleKeyPressed(int keyCode) {
    }
}