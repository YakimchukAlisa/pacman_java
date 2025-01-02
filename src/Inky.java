import org.jsfml.graphics.RenderWindow;

public class Inky extends Ghost {

    public Inky() {
    }
    public Inky(int x, int y, int score, int direction, int lastDirection) {
        super(x, y, score, direction, lastDirection);
    }

    public void inkyMove(Pacman pacman, Map map, Ghost blinky, GameSettings settings, RenderWindow window) {
        int a = pacman.getX();
        int b = pacman.getY();

        switch (pacman.getNextDirection()) {
            case 0:
                b = b - 2;
                break;
            case 1:
                b = b + 2;
                break;
            case 2:
                a = a - 2;
                break;
            case 3:
                a = a + 2;
                break;
        }

        a = blinky.getX() + 2 * (a - blinky.getX());
        b = blinky.getY() + 2 * (b - blinky.getY());

        move(map, a, b);
        ghostDraw(settings.getInkyColor(), window, settings);
    }
}