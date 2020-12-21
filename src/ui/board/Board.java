package ui.board;

import config.GameConfig;
import de.ur.mi.oop.colors.Color;
import game.Card;
import ui.UIElement;

import java.util.ArrayList;

public class Board extends UIElement implements GameConfig, CardViewListener {

    private ArrayList<CardView> cardViews;
    private ArrayList<CardView> revealedCardViews;
    private BoardListener listener;

    public Board(int x, int y, int width, int height, Color backgroundColor, BoardListener listener) {
        super(x, y, width, height, backgroundColor);
        cardViews = new ArrayList<>();
        revealedCardViews = new ArrayList<>();
        this.listener = listener;
    }

    public void setCards(ArrayList<Card> cards) {
        cardViews.clear();
        revealedCardViews.clear();
        int startX = getXPosition() + BOARD_PADDING + CARD_VIEW_MARGIN / 2;
        int startY = getYPosition() + BOARD_PADDING;
        int cardsPerRowAndColumn = (int) Math.sqrt(cards.size());
        for (int x = 0; x < cardsPerRowAndColumn; x++) {
            for (int y = 0; y < cardsPerRowAndColumn; y++) {
                int currentStackPosition = (x * cardsPerRowAndColumn) + y;
                Card currentCard = cards.get(currentStackPosition);
                int cardXPosition = startX + (x * (CARD_VIEW_SIZE + CARD_VIEW_MARGIN));
                int cardYPosition = startY + (y * (CARD_VIEW_SIZE + CARD_VIEW_MARGIN));
                CardView cardView = new CardView(cardXPosition, cardYPosition, currentCard, this);
                cardViews.add(cardView);
            }
        }
    }

    private void revealCard(CardView view) {
        revealedCardViews.add(view);
        if (revealedCardViews.size() == 2) {
            CardView firstCardView = revealedCardViews.get(0);
            CardView secondCardView = revealedCardViews.get(1);
            if (firstCardView.getPairID() == secondCardView.getPairID()) {
                revealedCardViews.get(0).clear();
                revealedCardViews.get(1).clear();
                listener.onPairDiscovered(cardViews.size() / 2 - getNumberOfRemainingPairs(), getNumberOfRemainingPairs());
                if (getNumberOfRemainingPairs() == 0) {
                    listener.onBoardSolved();
                }
            }
        }
    }

    private void clearCurrentlyRevealedCards() {
        revealedCardViews.get(0).toggle();
        revealedCardViews.get(1).toggle();
        revealedCardViews.clear();
    }

    public int getNumberOfRemainingPairs() {
        int numberOfUnclearedCards = 0;
        for (CardView cardView : cardViews) {
            if (!cardView.isCleared()) {
                numberOfUnclearedCards++;
            }
        }
        return numberOfUnclearedCards / 2;
    }

    @Override
    public void handleMouseClick(int x, int y) {
        for (CardView cardView : cardViews) {
            cardView.handleMouseClick(x, y);
        }
    }

    @Override
    public void draw() {
        super.draw();
        for (CardView cardView : cardViews) {
            cardView.draw();
        }
    }

    @Override
    public void onCardViewClicked(CardView view) {
        view.toggle();
    }

    @Override
    public void onCardViewRevealed(CardView view) {
        if (revealedCardViews.size() == 2) {
            clearCurrentlyRevealedCards();
        }
        revealCard(view);
    }

}
