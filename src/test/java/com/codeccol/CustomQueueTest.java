package com.codeccol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {
    CustomQueue customQueue;

    @BeforeEach
    public void prepareCustomQueue() {
         this.customQueue = new CustomQueue();
    }

    @Test
    public void checkIfUserCanEnqueueAString() throws QueueEmptyException {
        customQueue.enqueue("string", 1);
        assertEquals("string", customQueue.peek());

    }

    @Test
    public void getCustomQueueSize(){
        customQueue.enqueue("string", 1);
        customQueue.enqueue("string", 2);
        customQueue.enqueue("string", 3);
        assertEquals(3, customQueue.queueSize());
    }

    @Test
    public void checkIfUserCanDequeueAString() throws QueueEmptyException {
        customQueue.enqueue("string", 1);
        //customQueue.enqueue("string2", 2);
        customQueue.enqueue("string3", 2);
        assertEquals("string3", customQueue.dequeue());
        assertEquals(1, customQueue.queueSize());

    }

    @Test
    public void checkIfUserCanPeekAString() throws QueueEmptyException {
        customQueue.enqueue("string", 1);
        customQueue.enqueue("string2", 2);
        assertEquals("string2", customQueue.peek());
        assertEquals(2, customQueue.queueSize());
    }

    @Test
    public void checkIfIsEmpty() throws QueueEmptyException {
        assertTrue(customQueue.isEmpty());

    }

    @Test
    public void checkIfIsNotEmpty() throws QueueEmptyException {
        customQueue.enqueue("string", 1);
        assertFalse(customQueue.isEmpty());

    }

    @Test
    public void throwsQueueEmptyExceptionWhenUserTriesToDequeue() {
        assertThrows(QueueEmptyException.class, ()-> customQueue.dequeue());
    }

    @Test
    public void throwsQueueEmptyExceptionWhenUserTriesToPeek() {
        assertThrows(QueueEmptyException.class, ()-> customQueue.peek());
    }

}