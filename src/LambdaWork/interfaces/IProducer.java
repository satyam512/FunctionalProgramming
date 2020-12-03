package LambdaWork.interfaces;

@FunctionalInterface
public interface IProducer<T> {
    T produce();
}
