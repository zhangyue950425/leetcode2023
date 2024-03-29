package designpattern.chain;

public class NewUserRuleHandler extends RuleHandler{
    @Override
    public void apply(Context context) {
        if (context.isNewUser()) {
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("该活动仅限新用户参与");
        }
    }
}
