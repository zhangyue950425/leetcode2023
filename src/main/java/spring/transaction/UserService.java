package spring.transaction;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public void saveUser() {
        TransactionUtil.execute("insert into t values(?, ?, ?)", 40, 40, 40);
        //throw new RuntimeException();
    }
}
