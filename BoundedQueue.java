import java.lang.Iterable;

import java.util.Iterator;
import java.util.Queue;
import java.util.function.BiPredicate;

class BoundedQueue<E> implements Iterable<E> {
  private final BiPredicate<E, E> p; private final Queue<E> q; private int k;
  public BoundedQueue(final int k, final Queue<E> q, final BiPredicate<E, E> p) { this.q = q; this.k = k; this.p = p; }

  public void offer(final E e) {
    if (this.q.size() < k) this.q.offer(e);
    else if (this.p.test(this.q.peek(), e)) { this.q.poll(); this.q.offer(e); }
  }

  public Iterator<E> iterator() {
    return q.iterator();
  }
}
