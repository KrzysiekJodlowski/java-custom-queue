package com.codeccol;


import java.util.Optional;

public class CustomQueue {

private Node head;
    private Node tail;

    public CustomQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(String value, int priority) {
        Node newNode = new Node(value, priority);

        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node current = this.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    public String peek() throws QueueEmptyException {  // error handling when q empty
        if (this.head == null) {
            throw new QueueEmptyException("Can't peek from empty queue");
        }
        return this.tail.getValue();
    }

    public String dequeue() throws QueueEmptyException {   // error handling when q empty
        String tailString = null;

        if (this.head == null) {
            throw new QueueEmptyException("Can't dequeue from empty queue");
        } else if (this.head.getNextNode() == null) {
            tailString = this.head.getValue();
            this.head = null;
        } else if (this.head.getNextNode().getNextNode() == null) {
            Node secondNode = this.head.getNextNode();
            tailString = secondNode.getValue();
            this.head.setNextNode(null);
        } else {
            Node current = this.head;

            while (current.getNextNode().getNextNode() != null) {
                current = current.getNextNode();
            }
            tailString = current.getNextNode().getValue();
            current.setNextNode(null);
        }
        return tailString;
    }

    public int queueSize() {
        if (this.head == null) {
            return 0;
        }
        int queueSize = 1;
        Node current = this.head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
            queueSize++;
        }
        return queueSize;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }
}
