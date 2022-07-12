package learning;


@FunctionalInterface
public interface ThriftAsyncCall {
    void invoke() throws Exception;
}
