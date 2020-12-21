package config;

import de.ur.mi.oop.colors.Color;

public interface GameConfig {

    // *******************************************************************************
    // *** Christmassy colors from https://www.schemecolor.com/christmas-carol.php ***
    // *******************************************************************************
    Color FIRE_OPAL = new Color(235, 92, 95);
    Color AMERICAN_PINK = new Color(250, 149, 148);
    Color LINEN = new Color(251, 242, 234);
    Color FLACESCENT = new Color(242, 229, 153);
    Color ARYLIDE_YELLOW = new Color(236, 217, 105);
    Color DARK_SEA_GREEN = new Color(153, 211, 136);
    // *******************************************************************************
    // ******************** Screen dimensions and background color *******************
    // *******************************************************************************
    int WINDOW_WIDTH = 700;
    int WINDOW_HEIGHT = 700;
    Color BACKGROUND_COLOR = LINEN;
    // *******************************************************************************
    // ****************************** Background Music *******************************
    // *******************************************************************************
    String PATH_TO_BACKGROUND_MUSIC = "data/assets/music/Dee-Yan-Key-Santas-Little-Helper.wav";
    String PATH_TO_CHEER_CLIP = "data/assets/music/Johanneskristjansson-Cheer-Crowd.wav";
    // *******************************************************************************
    // ********************* Configuration for BottomBar Element *********************
    // *******************************************************************************
    int BOTTOM_BAR_HEIGHT = 75;
    int BOTTOM_BAR_PADDING = 25;
    int LABEL_FONT_SIZE = 16;
    Color BOTTOM_BAR_COLOR = FIRE_OPAL;
    Color LABEL_FONT_COLOR = new Color(250, 250, 250);
    String LABEL_FONT_NAME = "Lucida Sans Typewriter";
    // *******************************************************************************
    // *********************** Configuration for Board Element ***********************
    // *******************************************************************************
    int BOARD_HEIGHT = WINDOW_HEIGHT - BOTTOM_BAR_HEIGHT;
    int BOARD_X_MARGIN = 25;
    int BOARD_PADDING = 25;
    // *******************************************************************************
    // ********************* Configuration for all Card Elements *********************
    // *******************************************************************************
    int DEFAULT_NUMBER_OF_PAIRS = 8;
    int CARD_IMAGE_SIZE = 64;
    int CARD_BORDER_WEIGHT = 2;
    int CARD_VIEW_SIZE = 125;
    int CARD_VIEW_MARGIN = 25;
    Color CARD_BACKGROUND_COLOR = DARK_SEA_GREEN;
    Color CARD_FOREGROUND_COLOR = new Color(250, 250, 250);
    Color CARD_CLEARED_COLOR = new Color(200, 200, 200);
    Color CARD_BORDER_COLOR = new Color(220, 220, 220);
    String PATH_TO_IMAGE_FILES = "data/assets/cards";
    // *******************************************************************************
}