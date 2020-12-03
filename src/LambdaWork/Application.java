package LambdaWork;

import LambdaWork.interfaces.IConfigurator;
import LambdaWork.interfaces.IFactory;
import LambdaWork.interfaces.IProducer;

public class Application {

    public static void main(String[] args) {

        // Higher order functions
//        IProducer<Double> producer = ()->100*Math.random();
//        IConfigurator<Double, Integer> configurator = randomDouble -> randomDouble.intValue();

        IFactory<Integer> factory = createFactory(()->100*Math.random() , Double::intValue);

        for(int i=0;i<10;i++)
            System.out.println("Go " + factory.create());
    }

    private static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}
