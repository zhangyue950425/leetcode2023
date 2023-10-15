package spring.event;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executor;

@Component("applicationEventMulticaster")
public class MyMulticaster extends SimpleApplicationEventMulticaster {

    @Override
    protected Executor getTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Override
    protected ErrorHandler getErrorHandler() {
        return t -> System.out.println("出错了：" + t.getMessage());
    }
}
