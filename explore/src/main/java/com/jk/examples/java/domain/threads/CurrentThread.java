package com.jk.examples.java.domain.threads;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
@Component
public class CurrentThread {

    public CurrentThread() {
        log.info("In Constructor, Current thread name: {}, id: {}", Thread.currentThread().getName(), Thread.currentThread().getId());
    }

    public String getThreadName() {
        log.info("Thread name: {}", Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }

    public long getThreadId() {
        log.info("Got lock of current object in getThreadId ?: {}", Thread.holdsLock(this));
        log.info("Thread id: {}", Thread.currentThread().getId());
        return Thread.currentThread().getId();
    }

    public synchronized boolean need_object_lock_1() {
        log.info("Got lock of current object in need_object_lock_1 ?: {}", Thread.holdsLock(this));
        return Thread.holdsLock(this);
    }

    public synchronized boolean need_object_lock_2() {
        log.info("Got lock of current object in need_object_lock_2 ?: {}", Thread.holdsLock(this));
        return Thread.holdsLock(this);
    }

    public boolean holds_lock() {
        return Thread.holdsLock(this);
    }



}
