package org.wsws.apartment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    /**
     * AI 日志异步记录专用线程池
     * 
     * 参数说明：
     * - corePoolSize = 2：日常 AI 调用并发不高，2个线程足够处理
     * - maxPoolSize = 5：高峰期临时扩容上限
     * - queueCapacity = 100：缓冲队列，防止瞬时流量冲垮系统
     * - rejectedExecutionHandler = CallerRunsPolicy：
     *   选择此策略的原因是：日志记录是辅助功能，不能因为线程池满了就丢弃日志或抛异常。
     *   当队列满时，让调用者线程（即处理用户请求的线程）自己执行日志入库，
     *   虽然会稍微拖慢本次请求的响应速度，但保证了日志不丢失。
     */
    @Bean(name = "aiLogExecutor")
    public Executor aiLogExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("ai-log-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}