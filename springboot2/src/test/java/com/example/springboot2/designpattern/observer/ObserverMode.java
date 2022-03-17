package com.example.springboot2.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者
 */
interface Watcher {
    void update(String s);
}

/**
 * 被观察者
 */
interface Watched {
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str);

}

class Mouse implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}

class Cat implements Watched {

    List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        list.forEach(watcher -> watcher.update(str));
    }
}

public class ObserverMode {
    public static void main(String[] args) {
        Watched cat = new Cat();

        Watcher watcher1 = new Mouse();
        Watcher watcher2 = new Mouse();
        Watcher watcher3 = new Mouse();

        cat.addWatcher(watcher1);
        cat.addWatcher(watcher2);
        cat.addWatcher(watcher3);

        cat.notifyWatchers("开心");
    }

}