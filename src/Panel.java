import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Panel extends JPanel implements Runnable, KeyListener {


    static final int HEIGTH = 30;
    static final int WIDTH = 40;
    static final int SIZE_CELL = 20;

    Snake snake;
    private Directions direction;
    boolean pause = false;


    public Panel() {

        direction = Directions.DOWN;
        addKeyListener(this);
        setFocusable(true);
        snake = new Snake(5, 5, 5);
        (new Thread(this)).start();


    }



    public void paint(Graphics g) {


        g.setColor(Color.blue);
        g.fillRect(0, 0, WIDTH * SIZE_CELL, HEIGTH * SIZE_CELL);

        g.setColor(Color.GRAY);
        for (int i = 1; i < WIDTH; i++) {
            g.drawLine(SIZE_CELL * i, 0, SIZE_CELL * i, HEIGTH * SIZE_CELL);
        }
        for (int i = 1; i < HEIGTH; i++) {
            g.drawLine(0, SIZE_CELL * i, SIZE_CELL * WIDTH, SIZE_CELL * i);
        }

        g.setColor(Color.BLACK);

        for (Point p : snake.food
                ) {
            g.fillOval(p.x * SIZE_CELL, p.y * SIZE_CELL, SIZE_CELL, SIZE_CELL);
        }

        g.setColor(Color.gray);
        for (Point p : snake.snake
                ) {
            g.fillRect(p.x * SIZE_CELL, p.y * SIZE_CELL, SIZE_CELL, SIZE_CELL);
        }

    }

    public static void panelGame() {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH * SIZE_CELL, HEIGTH * SIZE_CELL + 28));

        frame.setLocationRelativeTo(null);
        frame.add(new Panel());

        frame.setVisible(true);
    }

    @Override
    public void run() {

        while (!snake.eatTail() && !snake.granic() && !pause) {
            try {

                snake.moveSnake(direction);
                Thread.sleep(150);
                repaint();


            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT && direction != Directions.LEFT) {
            direction = Directions.RIGHT;
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT && direction != Directions.RIGHT) {
            direction = Directions.LEFT;
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_UP && direction != Directions.DOWN) {
            direction = Directions.UP;
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && direction != Directions.UP) {
            direction = Directions.DOWN;
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_P && pause == false) {
            pause = true;

        }else if (e.getExtendedKeyCode() == KeyEvent.VK_P && pause == true){
            pause = false;
            (new Thread(this)).start();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
