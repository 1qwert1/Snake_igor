import java.util.LinkedList;


public class Snake {


    public LinkedList<Point> snake;
    public LinkedList<Point> food;


    public Snake(int x, int y, int size) {

        Point p = new Point(x, y);
        snake = new LinkedList<>();
        snake.add(p);
        for (int i = 0; i < size; i++) {

            snake.add(snake.getLast().move(Directions.RIGHT));


        }
        food = new LinkedList<>();

        Point pEat = new FoodForSnake();
        food.add(pEat);

    }

    public void moveSnake(Directions d) {
        snake.add(snake.getLast().move(d));
        if (snake.getLast().equals(food.getFirst())) {
            food.removeFirst();
            Point pEat2 = new FoodForSnake();
            food.add(pEat2);
            return;

        }

        snake.removeFirst();
    }

    public boolean eatTail() {
        for (int i = 0; i < snake.size() - 2; i++) {
            if (snake.get(i).equals(snake.getLast())) {
                return true;
            }

        }
        return false;
    }

    public boolean granic() {
        return (snake.getLast().x < 0 || snake.getLast().x > Panel.WIDTH - 1 || snake.getLast().y < 0
                || snake.getLast().y > Panel.HEIGTH - 1);
    }
}
