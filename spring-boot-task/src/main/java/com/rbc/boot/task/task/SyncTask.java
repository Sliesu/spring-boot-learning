package com.rbc.boot.task.task;

import org.springframework.stereotype.Component;

// Update date: 2024/5/6
// Description: SyncTask, 同步任务比较
@Component
public class SyncTask extends AbstractTask {

    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();

    }

    @Override
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
