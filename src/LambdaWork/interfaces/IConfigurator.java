package LambdaWork.interfaces;

@FunctionalInterface
public interface IConfigurator<T,R> {
    R configure(T t);
}
