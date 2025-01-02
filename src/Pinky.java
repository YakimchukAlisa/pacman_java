import org.jsfml.graphics.RenderWindow;


public class Pinky extends Ghost {

    public Pinky() {
    }
    public Pinky(int x, int y, int score, int direction, int lastDirection) {
        super(x, y, score, direction, lastDirection);
    }

    public void pinkyMove(Pacman pacman, Map map, GameSettings settings, RenderWindow window) {
        int a = pacman.getX();
        int b = pacman.getY();
        switch (pacman.getNextDirection()) {
            case 0:
                b = b - 4;
                break;
            case 1:
                b = b + 4;
                break;
            case 2:
                a = a - 4;
                break;
            case 3:
                a = a + 4;
                break;
        }
        move(map, a, b);
        ghostDraw(settings.getPinkyColor(), window, settings);
    }
}