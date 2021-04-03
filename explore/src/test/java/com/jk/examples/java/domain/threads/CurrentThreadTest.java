package com.jk.examples.java.domain.threads;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Configuration
@ComponentScan(basePackageClasses = CurrentThread.class)
class CurrentThreadTestContext {

}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentThreadTestContext.class)
@Slf4j
public class CurrentThreadTest {

    @Autowired
    private CurrentThread currentThread;

    @Test
    public void nameAndId() {
        Assertions.assertNotNull(currentThread.getThreadName());
        Assertions.assertNotNull(currentThread.getThreadId());
    }

    @Test
    public void lock() {
        Assertions.assertTrue(currentThread.need_object_lock_1());
        Assertions.assertTrue(currentThread.need_object_lock_2());
        Assertions.assertFalse(currentThread.holds_lock());
    }

    @Test
    public void staticMethods() {
        log.info("Threads count is {}", Thread.activeCount());
        Assertions.assertFalse( 0 == Thread.activeCount());
        Thread.dumpStack();
    }
}
