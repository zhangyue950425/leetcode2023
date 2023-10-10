package designpattern.chain;

public abstract class RuleHandler {
    // 后继节点
    protected RuleHandler successor;
    public abstract void apply(Context context);

    public RuleHandler getSuccessor() {
        return successor;
    }

    public void setSuccessor(RuleHandler successor) {
        this.successor = successor;
    }
}
