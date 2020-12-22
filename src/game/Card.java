package game;

import config.GameConfig;

import java.io.File;
import java.util.ArrayList;

public class Card {

    private final int pairID;
    private final String imagePath;
    private boolean isRevealed;
    private boolean isCleared;

    public Card(int pairID, String imagePath) {
        this.pairID = pairID;
        this.imagePath = imagePath;
        this.isRevealed = false;
        this.isCleared = false;
    }

    public int getPairID() {
        return pairID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public void toggle() {
        if(isCleared) {
            return;
        }
        isRevealed = !isRevealed;
    }

    public void clear() {
        isCleared = true;
    }

    public static ArrayList<Card> createStack(int numberOfPairs) {
        ArrayList<Card> cards = new ArrayList<>();
        String[] imagePaths = getImagePaths();
        for(int i = 0; i < numberOfPairs; i++ ) {
            cards.add(new Card(i, imagePaths[i]));
            cards.add(new Card(i, imagePaths[i]));
        }
        return cards;
    }

    private static String[] getImagePaths() {
        File[] files = new File(GameConfig.PATH_TO_IMAGE_FILES).listFiles();
        String[] imagePaths = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            imagePaths[i] = files[i].getAbsolutePath();
        }
        return imagePaths;
    }
}
