package spring.event;


public class MyEvent {

    private String msg;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
