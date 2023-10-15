package spring.event;



public class MySecondEvent {

    private String msg;

    public MySecondEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
