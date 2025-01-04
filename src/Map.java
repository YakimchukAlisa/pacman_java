import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Map {
    private int H;
    private int W;
    private List<String> maze;

    public Map(int H, int W) {
        this.H = H;
        this.W = W;
        this.maze = new ArrayList<>(H); // Инициализируем с нужной вместимостью
    }

    public int getH() {
        return H;
    }

    public int getW() {
        return W;
    }

    public char getTile(int y, int x) {
        return maze.get(y).charAt(x);
    }

    public void setTile(int y, int x, char tile) {
        StringBuilder row = new StringBuilder(maze.get(y));
        row.setCharAt(x, tile);
        maze.set(y, row.toString());
    }



    public void createMap() {
        String[] tempMaze = {
                "                              ",
                "                              ",
                "                              ",
                " XXXXXXXXXXXXXXXXXXXXXXXXXXXX ",
                " XooooooooooooXXooooooooooooX ",
                " XoXXXXoXXXXXoXXoXXXXXoXXXXoX ",
                " XOXXXXoXXXXXoXXoXXXXXoXXXXOX ",
                " XoXXXXoXXXXXoXXoXXXXXoXXXXoX ",
                " XooooooooooooooooooooooooooX ",
                " XoXXXXoXXoXXXXXXXXoXXoXXXXoX ",
                " XoXXXXoXXoXXXXXXXXoXXoXXXXoX ",
                " XooooooXXooooXXooooXXooooooX ",
                " XXXXXXoXXXXX XX XXXXXoXXXXXX ",
                "      XoXXXXX XX XXXXXoX      ",
                "      XoXX          XXoX      ",
                "      XoXX XXXXXXXX XXoX      ",
                " XXXXXXoXX X      X XXoXXXXXX ",
                "       o   X      X   o       ",
                " XXXXXXoXX X      X XXoXXXXXX ",
                "      XoXX XXXXXXXX XXoX      ",
                "      XoXX          XXoX      ",
                "      XoXX XXXXXXXX XXoX      ",
                " XXXXXXoXX XXXXXXXX XXoXXXXXX ",
                " XooooooooooooXXooooooooooooX ",
                " XoXXXXoXXXXXoXXoXXXXXoXXXXoX ",
                " XoXXXXoXXXXXoXXoXXXXXoXXXXoX ",
                " XOooXXooooooooooooooooXXooOX ",
                " XXXoXXoXXoXXXXXXXXoXXoXXoXXX ",
                " XXXoXXoXXoXXXXXXXXoXXoXXoXXX ",
                " XooooooXXooooXXooooXXooooooX ",
                " XoXXXXXXXXXXoXXoXXXXXXXXXXoX ",
                " XoXXXXXXXXXXoXXoXXXXXXXXXXoX ",
                " XooooooooooooooooooooooooooX ",
                " XXXXXXXXXXXXXXXXXXXXXXXXXXXX ",
                "                              ",
        };

        this.maze.clear();
        for (String row : tempMaze) {
            this.maze.add(row);
        }


    }
    public void mazePaint(GameSettings settings, RenderWindow window, Food smallFood, Food bigFood) {
        // Вместо RectangleShape и CircleShape используйте соответствующие классы SFML
        RectangleShape square = new RectangleShape(new Vector2f(settings.getGridSize(), settings.getGridSize()));
        square.setFillColor(settings.getSquareColor());

        CircleShape smallCircle = new CircleShape(3);
        smallCircle.setFillColor(settings.getSmallCircleColor());

        CircleShape bigCircle = new CircleShape(6);
        bigCircle.setFillColor(settings.getBigCircleColor());

        RectangleShape pacman = new RectangleShape(new Vector2f(settings.getGridSize(), settings.getGridSize()));
        pacman.setFillColor(settings.getPacmanColor());


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                char tile = maze.get(i).charAt(j);

                if (tile == 'X') {
                    square.setPosition(j * settings.getGridSize(), i * settings.getGridSize());
                    window.draw(square);
                } else if (tile == smallFood.getType()) {
                    smallCircle.setPosition(j * settings.getGridSize() + 8.5f, i * settings.getGridSize() + 8.5f);
                    window.draw(smallCircle);
                } else if (tile == bigFood.getType()) {
                    bigCircle.setPosition(j * settings.getGridSize() + 5.5f, i * settings.getGridSize() + 5.5f);
                    window.draw(bigCircle);
                } else if (tile == 'P') { // Обратите внимание на изменение имени переменной!
                    pacman.setPosition(j * settings.getGridSize(), i * settings.getGridSize());
                    window.draw(pacman);
                }
            }
        }
    }
    }