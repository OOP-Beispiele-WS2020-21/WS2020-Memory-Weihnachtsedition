import config.GameConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import ui.scenes.BaseScene;
import ui.scenes.GameScene;
import ui.scenes.StartScene;
import ui.scenes.StartSceneListener;

public class MemoryApp extends GraphicsApp implements GameConfig, StartSceneListener {


    private GameScene gameScene;
    private StartScene startScene;
    private BaseScene currentScene;

    @Override
    public void initialize() {
        setFrameRate(30);
        setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        initScenes();
    }

    private void initScenes() {
        gameScene = new GameScene();
        startScene = new StartScene(this);
        currentScene = startScene;
    }

    @Override
    public void draw() {
        currentScene.update();
        currentScene.draw();
    }

    @Override
    public void onMenuClosed() {
        currentScene = gameScene;
        currentScene.start();
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        currentScene.handleMouseClick(event.getXPos(), event.getYPos());
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        currentScene.handleKeyPressed(event.getKeyCode());
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
