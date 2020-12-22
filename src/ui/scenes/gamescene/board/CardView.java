package ui.scenes.gamescene.board;

import config.GameConfig;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Rectangle;
import game.Card;

public class CardView {

    private Card card;
    private Rectangle cardBackground;
    private Image cardImage;
    private CardViewListener listener;

    public CardView(int x, int y, Card card, CardViewListener listener) {
        this.card = card;
        this.listener = listener;
        cardBackground = createCardBackground(x, y);
        cardImage = createCardImage(x, y);
    }

    private Rectangle createCardBackground(int x, int y) {
        Rectangle rect = new Rectangle(x, y, GameConfig.CARD_VIEW_SIZE, GameConfig.CARD_VIEW_SIZE, GameConfig.CARD_BACKGROUND_COLOR);
        rect.setBorderColor(GameConfig.CARD_BORDER_COLOR);
        rect.setBorderWeight(GameConfig.CARD_BORDER_WEIGHT);
        return rect;
    }

    private Image createCardImage(int x, int y) {
        int imageXPosition = x + GameConfig.CARD_VIEW_SIZE/2 - GameConfig.CARD_IMAGE_SIZE/2;
        int imageYPosition = y + GameConfig.CARD_VIEW_SIZE/2 - GameConfig.CARD_IMAGE_SIZE/2;
        return new Image(imageXPosition, imageYPosition, card.getImagePath());
    }

    public void toggle() {
        if(card.isCleared()) {
            return;
        }
        card.toggle();
        if(card.isRevealed()) {
            cardBackground.setColor(GameConfig.CARD_FOREGROUND_COLOR);
            listener.onCardViewRevealed(this);
        } else {
            cardBackground.setColor(GameConfig.CARD_BACKGROUND_COLOR);
        }
    }

    public void clear() {
        card.clear();
        cardBackground.setColor(GameConfig.CARD_CLEARED_COLOR);
    }

    public int getPairID() {
        return card.getPairID();
    }

    public boolean isCleared() {
        return card.isCleared();
    }

    public void handleMouseClick(int x, int y) {
        if(card.isRevealed() || card.isCleared()) {
            return;
        }
        if(cardBackground.hitTest(x, y)) {
            listener.onCardViewClicked(this);
        }
    }

    public void draw() {
        cardBackground.draw();
        if(card.isRevealed()) {
            cardImage.draw();
        }
    }

}
