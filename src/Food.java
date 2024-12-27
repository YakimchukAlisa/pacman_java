public class Food {
    private int count;
    private int point;
    private char type;

    public Food(int count, int point, char type) {
        this.count = count;
        this.point = point;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public int getPoint() {
        return point;
    }

    public char getType() {
        return type;
    }

    public void decreaseCount() {
        count--;
    }
}