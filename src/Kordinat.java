public class Kordinat {
    int x;
    int y;
    Kordinat kontrol;

    public Kordinat(int x, int y) {
        this.x = x;
        this.y = y;
        this.kontrol = null;
    }

    public Kordinat(int x, int y, Kordinat parent) {
        this.x = x;
        this.y = y;
        this.kontrol = parent;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Kordinat getKontrol() {
        return kontrol;
    }
}
