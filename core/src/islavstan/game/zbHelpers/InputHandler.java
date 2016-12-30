package islavstan.game.zbHelpers;

import com.badlogic.gdx.InputProcessor;

import islavstan.game.gameobjects.Bird;

/**
 * Created by islav on 31.12.2016.
 */
//будет рагировать на различного рода входных действий, единственное за что мы должны беспокоиться это touch (касание)
public class InputHandler implements InputProcessor {
    private Bird myBird;

    public InputHandler(Bird bird) {
        myBird = bird;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myBird.onClick();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
