package spring;

public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "hello world";
    }
}
