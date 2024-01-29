package com.example.springdatawthboot.facade.exec;

import java.util.concurrent.Executor;

@FunctionalInterface
public interface TaskExecutor extends Executor {
    @Override
    void execute(Runnable command);
}
