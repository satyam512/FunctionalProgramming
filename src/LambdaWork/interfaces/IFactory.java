package LambdaWork.interfaces;

@FunctionalInterface
public interface IFactory<T> {
    T create();
}
