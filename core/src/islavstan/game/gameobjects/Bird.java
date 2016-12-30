package islavstan.game.gameobjects;

import com.badlogic.gdx.math.Vector2;



public class Bird {

    private Vector2 position;//позиция
    private Vector2 velocity;//скорость
    private Vector2 acceleration;//ускорение

    private float rotation; // Для обработки поворота птицы
    private int width;
    private int height;


    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }
    public void update(float delta) {//будет запускать во время обновления GameWorld

        velocity.add(acceleration.cpy().scl(delta));// добавляем отмасштабированый вектор ускорения к вектору скорости

        if (velocity.y > 200) {
            velocity.y = 200;// ограничение по максимальной скорости
        }


        position.add(velocity.cpy().scl(delta));//добавляем обновленное смасштабированное значение скорости к позиции нашей птицы (так мы получем новую позицию).

       /* Что я подразумеваю под "отмасштабированый" в пунктах 1 и 3? Мы будем умножать наши ускорение и скорость
        на дельту, которая представляет из себя, сколько прошло времени, с прошлого раза, когда запускался метод
        update. Это эффект нормализации.*/

    }

    public void onClick() {//будет отрабатывать клики/касания по экрану
        velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

}