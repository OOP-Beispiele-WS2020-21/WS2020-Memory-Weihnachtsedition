package ui.bottomBar;

import config.GameConfig;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;
import ui.UIElement;

public class BottomBar extends UIElement implements GameConfig {

    private static final String CONTROLS_HELP_TEXT = "[M]: Musik an- und ausschalten | [N]: Spiel neustarten";
    private static final String REVEALED_PAIRS_PREFIX = "Aufgedeckte Paare: ";
    private Label controlsTextView;
    private Label revealedPairsTextView;
    private Rectangle background;

    public BottomBar(int x, int y, int width, int height, Color backgroundColor) {
        super(x, y, width, height, backgroundColor);
        initTextViews(x, y);
        background = new Rectangle(x, y, width, height, backgroundColor);
    }

    private void initTextViews(int x, int y) {
        controlsTextView =  new Label(0, 0, CONTROLS_HELP_TEXT);
        controlsTextView.setFont(LABEL_FONT_NAME);
        controlsTextView.setFontSize(LABEL_FONT_SIZE);
        controlsTextView.setColor(LABEL_FONT_COLOR);
        controlsTextView.setXPos(x + BOTTOM_BAR_PADDING);
        controlsTextView.setYPos(y + BOTTOM_BAR_PADDING);
        revealedPairsTextView = new Label(0, 0, REVEALED_PAIRS_PREFIX + "0/0");
        revealedPairsTextView.setFont(LABEL_FONT_NAME);
        revealedPairsTextView.setFontSize(LABEL_FONT_SIZE);
        revealedPairsTextView.setColor(LABEL_FONT_COLOR);
        revealedPairsTextView.setXPos(WINDOW_WIDTH - revealedPairsTextView.getWidthEstimate() - BOTTOM_BAR_PADDING);
        revealedPairsTextView.setYPos(y + (BOTTOM_BAR_HEIGHT - revealedPairsTextView.getHeightEstimate()));
    }

    public void setCounter(int clearedPairs, int totalPairs) {
        revealedPairsTextView.setText(REVEALED_PAIRS_PREFIX + clearedPairs + "/" + totalPairs);
    }

    @Override
    public void draw() {
        super.draw();
        background.draw();
        controlsTextView.draw();
        revealedPairsTextView.draw();
    }
}