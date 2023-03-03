package q2249;

import java.util.HashSet;
import java.util.Set;

public class CountLattice {
  public static int countLatticePoints(int[][] circles) {
    int count = 0;
    Set<String> visitedLattice = new HashSet<>();
    for (int[] circle : circles) {
      int x = circle[0];
      int y = circle[1];
      int r = circle[2];
      for (int i = x - r; i <= x + r; i++) {
        for (int j = y - r; i <= y + r; j++) {
          if (isWithinCircle(i, j, x, y, r) && visitedLattice.add(i + " " + j)) {
            count++;

          }
        }
      }
    }

    return count;

  }

  public static boolean isWithinCircle(int x, int y, int cx, int cy, int r) {
    int dx = x - cx;
    int dy = y - cy;
    return dx * dx + dy * dy <= r * r;
  }

}
