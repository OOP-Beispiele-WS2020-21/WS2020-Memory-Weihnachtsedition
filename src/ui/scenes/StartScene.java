package ui.scenes;

import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class StartScene extends BaseScene {

    private Rectangle background;
    private Label titleLabel;
    private Label infoLabel;
    private StartSceneListener listener;

    public StartScene(StartSceneListener listener) {
        this.listener = listener;
        background = new Rectangle(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, MENU_BACKGROUND_COLOR);
        titleLabel = new Label(0, 0, "Weihnachts-Memory");
        titleLabel.setFont(LABEL_FONT_NAME);
        titleLabel.setFontSize(LABEL_FONT_SIZE*2);
        titleLabel.setColor(LABEL_FONT_COLOR_FOR_MENU);
        titleLabel.setXPos(WINDOW_WIDTH / 2 - titleLabel.getWidthEstimate() / 2);
        titleLabel.setYPos(WINDOW_HEIGHT / 2 - titleLabel.getHeightEstimate() / 2);
        infoLabel = new Label(0, 0, "Drücke ENTER um das Spiel zu starten!");
        infoLabel.setFont(LABEL_FONT_NAME);
        infoLabel.setFontSize(LABEL_FONT_SIZE);
        infoLabel.setColor(LABEL_FONT_COLOR_FOR_MENU);
        infoLabel.setXPos(WINDOW_WIDTH / 2 - infoLabel.getWidthEstimate() / 2);
        infoLabel.setYPos(WINDOW_HEIGHT / 2 + infoLabel.getHeightEstimate() / 2);
    }

    @Override
    public void draw() {
        super.draw();
        background.draw();
        titleLabel.draw();
        infoLabel.draw();
    }

    @Override
    public void handleKeyPressed(int keyCode) {
        super.handleKeyPressed(keyCode);
        if (keyCode == KeyPressedEvent.VK_ENTER) {
            listener.onMenuClosed();
        }
    }
}
