package ybh.ai.springai.task;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class InMemoryTaskProcessor {
    private final ExecutorService executorService;

    public InMemoryTaskProcessor(final ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void submit(final Runnable task) {
        executorService.submit(task);
    }
}
