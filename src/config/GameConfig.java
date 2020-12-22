package config;

import de.ur.mi.oop.colors.Color;

public abstract class GameConfig {

    // *******************************************************************************
    // *** Christmassy colors from https://www.schemecolor.com/christmas-carol.php ***
    // *******************************************************************************
    public static final Color FIRE_OPAL = new Color(235, 92, 95);
    public static final Color AMERICAN_PINK = new Color(250, 149, 148);
    public static final Color LINEN = new Color(251, 242, 234);
    public static final Color FLACESCENT = new Color(242, 229, 153);
    public static final Color ARYLIDE_YELLOW = new Color(236, 217, 105);
    public static final Color DARK_SEA_GREEN = new Color(153, 211, 136);
    // *******************************************************************************
    // ******************** Screen dimensions and background color *******************
    // *******************************************************************************
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 700;
    public static final Color BACKGROUND_COLOR = LINEN;
    public static final Color MENU_BACKGROUND_COLOR = FLACESCENT;
    // *******************************************************************************
    // ****************************** Background Music *******************************
    // *******************************************************************************
    public static final String PATH_TO_BACKGROUND_MUSIC = "data/assets/music/Dee-Yan-Key-Santas-Little-Helper.wav";
    public static final String PATH_TO_CHEER_CLIP = "data/assets/music/Johanneskristjansson-Cheer-Crowd.wav";
    // *******************************************************************************
    // ********************* Configuration for BottomBar Element *********************
    // *******************************************************************************
    public static final int BOTTOM_BAR_HEIGHT = 75;
    public static final int BOTTOM_BAR_PADDING = 25;
    public static final int LABEL_FONT_SIZE = 16;
    public static final Color BOTTOM_BAR_COLOR = FIRE_OPAL;
    public static final Color LABEL_FONT_COLOR = new Color(250, 250, 250);
    public static final Color LABEL_FONT_COLOR_FOR_MENU = new Color(30, 30, 30);
    public static final String LABEL_FONT_NAME = "Lucida Sans Typewriter";
    // *******************************************************************************
    // *********************** Configuration for Board Element ***********************
    // *******************************************************************************
    public static final  int BOARD_HEIGHT = WINDOW_HEIGHT - BOTTOM_BAR_HEIGHT;
    public static final int BOARD_X_MARGIN = 25;
    public static final int BOARD_PADDING = 25;
    // *******************************************************************************
    // ********************* Configuration for all Card Elements *********************
    // *******************************************************************************
    public static final int DEFAULT_NUMBER_OF_PAIRS = 8;
    public static final int CARD_IMAGE_SIZE = 64;
    public static final int CARD_BORDER_WEIGHT = 2;
    public static final int CARD_VIEW_SIZE = 125;
    public static final int CARD_VIEW_MARGIN = 25;
    public static final Color CARD_BACKGROUND_COLOR = DARK_SEA_GREEN;
    public static final Color CARD_FOREGROUND_COLOR = new Color(250, 250, 250);
    public static final Color CARD_CLEARED_COLOR = new Color(200, 200, 200);
    public static final Color CARD_BORDER_COLOR = new Color(220, 220, 220);
    public static final String PATH_TO_IMAGE_FILES = "data/assets/cards";
    // *******************************************************************************
}