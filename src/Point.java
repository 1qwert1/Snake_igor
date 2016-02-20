

import javax.swing.*;
public class Point {

    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point move(Directions direction) {
        if (direction == Directions.RIGHT) {
            x++;
        }else if (direction == Directions.LEFT){
            x--;
        }else if (direction == Directions.UP){
            y--;
        }else if (direction == Directions.DOWN){
            y++;
        }
        return new Point(x, y);
    }


    public boolean equals(Point o) {


        if (x != o.x) return false;
        return y == o.y;

    }



    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
