package com.codeccol;


public class CustomQueue {

    private Node head;
    private Node tail;  // redundant?

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

    public String peek() throws QueueEmptyException {
        if (this.head == null) {
            throw new QueueEmptyException("Can't peek from empty queue");
        }
        return this.head.getValue();
    }

    public String dequeue() throws QueueEmptyException {

        if (this.head == null) {
            throw new QueueEmptyException("Can't dequeue from empty queue");
        }
        String tailString = this.head.getValue();

        if (this.head.getNextNode() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNextNode();
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
