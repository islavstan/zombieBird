package islavstan.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import islavstan.game.gameworld.GameRenderer;
import islavstan.game.gameworld.GameWorld;
import islavstan.game.zbHelpers.InputHandler;


public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;


    public GameScreen(){
        float screenWidth = Gdx.graphics.getWidth();//получить ширину экрана
        float screenHeight = Gdx.graphics.getHeight();//получить высоту экрана
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);//узнаем середину экрана

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {//Float delta это количество секунд которое прошло после последнего запуска метода render.
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
