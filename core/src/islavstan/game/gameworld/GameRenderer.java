package islavstan.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    public static int HEIGHT = 408;
    public static int WIDTH = 272;
    private ShapeRenderer shapeRenderer;//будет рисовать формы и линии для нас

    public GameRenderer(GameWorld myWorld) {
        this.myWorld = myWorld;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, WIDTH/2, HEIGHT/2);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");
     /*
         * 1. Мы рисуем черный задний фон, чтобы избавится от моргания и следов от передвигающихся объектов
         */

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * 2. Мы отрисовываем однотонный квадрат
         */

        // Говорим shapeRenderer начинать отрисовывать формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Выбираем RGB Color 87, 109, 120, не прозрачный
        shapeRenderer.setColor(255 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1);

        // Отрисовываем квадрат из myWorld (Используем ShapeType.Filled)
        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);

        // говорим shapeRenderer прекратить отрисовку
        // Мы ДОЛЖНЫ каждый раз это делать
        shapeRenderer.end();

        /*
         * 3. Мы отрисовываем рамку для квадрата
         */

        // Говорим shapeRenderer нарисовать рамку следующей формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        // Выбираем цвет RGB Color 255, 109, 120, не прозрачный
        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Отрисовываем квадрат из myWorld (Using ShapeType.Line)
        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);

        shapeRenderer.end();
    }
}

