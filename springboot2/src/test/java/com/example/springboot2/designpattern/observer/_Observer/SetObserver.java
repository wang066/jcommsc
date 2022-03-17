package com.example.springboot2.designpattern.observer._Observer;// Set obeserver callback interface - Page 266

import java.util.concurrent.ExecutionException;

public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element) throws ExecutionException, InterruptedException;
}
