package org.springframework.boot.autoconfigure.task;

import org.springframework.boot.task.TaskExecutorCustomizer;
import org.springframework.core.Ordered;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;

/**
 * Adds a {@link ThreadFactory} which supports virtual threads.
 *
 * @author Nicklas Wallgren
 * @since 3.2.0
 */
public class TaskExecutionVirtualThreadsCustomizer implements TaskExecutorCustomizer, Ordered {

	static final int ORDER = 0;

	@Override
	public void customize(ThreadPoolTaskExecutor taskExecutor) {
		taskExecutor.setThreadFactory(Thread.ofVirtual().factory());
	}

	@Override
	public int getOrder() {
		return ORDER;
	}
}
