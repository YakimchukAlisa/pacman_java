import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Color;

public class Blinky extends Ghost {

    public Blinky() {
    }
    public Blinky(int x, int y, int score, int direction, int lastDirection) {
        super(x, y, score, direction, lastDirection);
    }

    public void blinkyMove(Pacman pacman, Map map, GameSettings settings, RenderWindow window) {
        move(map, pacman.getX(), pacman.getY());
        ghostDraw(settings.getBlinkyColor(), window, settings);
    }
}