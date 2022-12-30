import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CozumAlgoritmasi {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Kordinat> solve(Labirent labirent) {
        LinkedList<Kordinat> nextToVisit = new LinkedList<>();
        Kordinat start = labirent.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            Kordinat cur = nextToVisit.remove();

            if (!labirent.isValidLocation(cur.getX(), cur.getY()) || labirent.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            if (labirent.isWall(cur.getX(), cur.getY())) {
                labirent.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if (labirent.isExit(cur.getX(), cur.getY())) {
                return backtrackPath(cur);
            }

            for (int[] direction : DIRECTIONS) {
                Kordinat kordinat = new Kordinat(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(kordinat);
                labirent.setVisited(cur.getX(), cur.getY(), true);
            }
        }
        return Collections.emptyList();
    }

    private List<Kordinat> backtrackPath(Kordinat cur) {
        List<Kordinat> path = new ArrayList<>();
        Kordinat iter = cur;

        while (iter != null) {
            path.add(iter);
            iter = iter.kontrol;
        }

        return path;
    }
}