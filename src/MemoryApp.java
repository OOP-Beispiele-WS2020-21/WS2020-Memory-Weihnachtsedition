import config.GameConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class MemoryApp extends GraphicsApp {

    @Override
    public void initialize() {
        setFrameRate(30);
        setCanvasSize(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(GameConfig.BACKGROUND_COLOR);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
