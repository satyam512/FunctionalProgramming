package Playground.interfaces;

@FunctionalInterface
public interface FunctionalGeneric<T, R> {
    R execute(T t);
}
