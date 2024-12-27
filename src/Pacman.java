import java.util.Objects;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;

public class Pacman {
    private int x;
    private int y;
    private int nextX;
    private int nextY;
    private int score;
    private int nextDirection;
    private int lives;
    private int points;

    public Pacman(int x, int y, int nextX, int nextY, int score, int nextDirection, int lives, int points) {
        this.x = x;
        this.y = y;
        this.nextX = nextX;
        this.nextY = nextY;
        this.score = score;
        this.nextDirection = nextDirection;
        this.lives = lives;
        this.points = points;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public int getNextDirection() {
        return nextDirection;
    }

    public void setX(int a) {
        x = a;
    }

    public void setY(int a) {
        y = a;
    }

    public void setNextX(int a) {
        nextX = a;
    }

    public void setNextY(int a) {
        nextY = a;
    }

    public void setScore(int a) {
        score = a;
    }

    public void setNextDirection(int a) {
        nextDirection = a;
    }

    public void loseLife() {
        lives--;
    }

    public void addPoints(int p) {
        points += p;
    }

    public void move(Map map, Food smallFood, Food bigFood) {
        if (Keyboard.isKeyPressed(Keyboard.Key.UP) && map.getTile(nextY - 1, nextX) != 'X' && !(nextY == 17 && nextX == 0 || nextY == 17 && nextX == map.getW() - 1)) {
            nextDirection = 0;
            nextX = x;
            nextY = y;
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.DOWN) && map.getTile(nextY + 1, nextX) != 'X' && !(nextY == 17 && nextX == 0 || nextY == 17 && nextX == map.getW() - 1)) {
            nextDirection = 1;
            nextX = x;
            nextY = y;
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.LEFT) && (map.getTile(nextY, nextX - 1) != 'X')) {
            nextDirection = 2;
            nextX = x;
            nextY = y;
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.RIGHT) && (map.getTile(nextY, nextX + 1) != 'X')) {
            nextDirection = 3;
            nextX = x;
            nextY = y;
        }

        score++;
        if (score >= 150) {
            switch (nextDirection) {
                case 0:
                    if (map.getTile(nextY - 1, nextX) != 'X' && nextY - 1 >= 0)
                        nextY--;
                    break;
                case 1:
                    if (map.getTile(nextY + 1, nextX) != 'X' && nextY + 1 <= 35)
                        nextY++;
                    break;
                case 2:
                    if (nextY == 17 && nextX == 1)
                        nextX = map.getW() - 2;
                    else if (map.getTile(nextY, nextX - 1) != 'X' && nextX - 1 >= 0)
                        nextX--;
                    break;
                case 3:
                    if (nextY == 17 && nextX == map.getW() - 2)
                        nextX = 1;
                    else if (map.getTile(nextY, nextX + 1) != 'X' && nextX + 1 <= 35)
                        nextX++;
                    break;
            }
            score = 0;
        }


        if ((map.getTile(nextY, nextX) == ' ' || map.getTile(nextY, nextX) == smallFood.getType() || map.getTile(nextY, nextX) == bigFood.getType()) && nextY != 0 && nextX != 0) {
            if (map.getTile(nextY, nextX) == smallFood.getType()) {
                addPoints(smallFood.getPoint());
                smallFood.decreaseCount();
            }
            if (map.getTile(nextY, nextX) == bigFood.getType()) {
                addPoints(bigFood.getPoint());
                bigFood.decreaseCount();
            }

            map.setTile(y, x, ' ');
            map.setTile(nextY, nextX, 'P');
            x = nextX;
            y = nextY;
        }
    }
}
