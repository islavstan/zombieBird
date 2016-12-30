package islavstan.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import islavstan.game.gameobjects.Bird;


public class GameWorld {
    private Bird bird;
    public GameWorld(int midPointY) {
       /* Значение по X должно быть 33 (это то место, где птичка остается на протяжении всего игрового времени).
        Ширина должна быть 17. Высота 12.*/
        //Y -значение равное 5 пикселям над вертикальной серединой экрана
       bird =new Bird(33, midPointY - 5, 17, 12);
    }
    public void update(float delta) {
        bird.update(delta);
    }
    public Bird getBird() {
        return bird;

    }


}
