package cn.jcomm.test.designpattern.observer._Observer;// Broken - invokes alien method from synchronized block! - Page 265

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) { super(set); }

    private final List<SetObserver<E>> observers = 
        new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer) {
//        synchronized(observers) {
            observers.add(observer);
//        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
//        synchronized(observers) {
            return observers.remove(observer);
//        }
    }

    // This method is the culprit
    private void notifyElementAdded(E element) throws ExecutionException, InterruptedException {
        synchronized(observers) {
            for (SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    }

    // Alien method moved outside of synchronized block - open calls - Page 268
//  private void notifyElementAdded(E element) {
//      List<SetObserver<E>> snapshot = null;
//      synchronized(observers) {
//          snapshot = new ArrayList<SetObserver<E>>(observers);
//      }
//      for (SetObserver<E> observer : snapshot)
//          observer.added(this, element);
//  }


    //  Thread-safe observable set with CopyOnWriteArrayList - Page 269
//
//  private final List<SetObserver<E>> observers = 
//      new CopyOnWriteArrayList<SetObserver<E>>();
//  
//  public void addObserver(SetObserver<E> observer) {
//      observers.add(observer);
//  }
//  public boolean removeObserver(SetObserver<E> observer) {
//      return observers.remove(observer);
//  }
//  private void notifyElementAdded(E element) {
//      for (SetObserver<E> observer : observers)
//          observer.added(this, element);
//  }

    @Override public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            try {
                notifyElementAdded(element);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return added;
    }

    @Override public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);  // calls notifyElementAdded
        return result;
    }
}
