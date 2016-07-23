import java.lang.Iterable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class LargestK {
  private static Iterable<Integer> getLargestK(final int k, final Iterable<Integer> xs) {
    final BoundedQueue<Integer> q = new BoundedQueue<>(k, new PriorityQueue<>(), (x, y) -> x - y < 0);
    for (final int x : xs) q.offer(x);
    return q;
  }

  public static void main(String[] args) {
    final List<Integer> xs = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 });
    Collections.shuffle(xs);
    for (final int x : getLargestK(7, xs))
      System.out.println(x);
  }
}
