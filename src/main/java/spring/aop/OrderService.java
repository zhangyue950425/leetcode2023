package spring.aop;

public interface OrderService {

    Order createOrder(String username, String product);

    Order queryOrder(String username);
}
