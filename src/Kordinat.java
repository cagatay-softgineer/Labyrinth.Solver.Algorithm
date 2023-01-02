public class Kordinat {
    int x;
    int y;
    Kordinat parent;

    public Kordinat(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public Kordinat(int x, int y, Kordinat parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Kordinat getParent() {
        return parent;
    }
}
