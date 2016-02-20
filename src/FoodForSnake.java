
public class FoodForSnake extends Point {

    public FoodForSnake(int x, int y) {
        super(x, y);
    }


    public FoodForSnake() {
        x = (int) (Math.random() * Panel.WIDTH);
        y = (int) (Math.random() * Panel.HEIGTH);
    }
}
