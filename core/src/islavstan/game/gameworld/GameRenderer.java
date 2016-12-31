package islavstan.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import islavstan.game.gameobjects.Bird;
import islavstan.game.zbHelpers.AssetLoader;


public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    public static int HEIGHT = 408;
    public static int WIDTH = 272;
    private ShapeRenderer shapeRenderer;//будет рисовать формы и линии для нас
    private SpriteBatch batcher;
    private int midPointY;
    private int gameHeight;
    public GameRenderer(GameWorld myWorld, int gameHeight, int midPointY) {
        this.myWorld = myWorld;
        // слово this ссылается на экземляр текущего класса
        // мы задаем значения параметрам класса
        // полченные из GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime) {//Этот аргумент необходим, чтобы определить какой фрейм из анимации
        // птички нам следует отобразить. Объект Animation будет использовать это значение
        // (и ранее заданное значение для длины кадра) чтобы определить какую область текстуры показать.

        // мы уберем это из цикла далее, для улучшения производительности
        Bird bird = myWorld.getBird();

        // Заполним задний фон одним цветом
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Стартуем ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Отрисуем Background цвет
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Отрисуем Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Отрисуем Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        // Заканчиваем ShapeRenderer
        shapeRenderer.end();

        // Стартуем SpriteBatch
        batcher.begin();
        // Отменим прозрачность
        // Это хорошо для производительности, когда отрисовываем картинки без прозрачности
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // Птичке нужна прозрачность, поэтому включаем ее
        batcher.enableBlending();

        // Отрисуем птичку на ее координатах. Получим Animation объект из AssetLoader
        // Передадим runTime переменную чтобы получить текущий кадр.
        batcher.draw((TextureRegion) AssetLoader.birdAnimation.getKeyFrame(runTime),bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        // Заканчиваем SpriteBatch
        batcher.end();

    }
}



