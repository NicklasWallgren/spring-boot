package org.springframework.boot.autoconfigure.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class TaskExecutionVirtualThreadsCustomizerTest {

	private final TaskExecutionVirtualThreadsCustomizer customizer = new TaskExecutionVirtualThreadsCustomizer();

	@Test
	@EnabledForJreRange(min = JRE.JAVA_21)
	void shouldConfigureVirtualThreads() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = mock(ThreadPoolTaskExecutor.class);

		customizer.customize(threadPoolTaskExecutor);

		then(threadPoolTaskExecutor).should().setThreadFactory(any());
	}
}