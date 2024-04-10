package com.module_2_sort_and_datastructure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ej3Queue {

    public static void main(String[] args) {
        QueueCourseImplementation<String> queueV1 = new QueueV1<>();
        testFunctionality(queueV1);
    }

    private static void testFunctionality(QueueCourseImplementation<String> queue) {
        log.info(queue.toString());

        queue.enqueue("Alpha");
        queue.enqueue("Bravo");
        queue.enqueue("Charlie");
        queue.enqueue("Delta");
        queue.enqueue("Echo");
        log.info("Length: " + queue.getLength());
        log.info(queue.toString());

        String item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        item = queue.peek();
        log.info(item);
        log.info(queue.toString());

        item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        item = queue.dequeue();
        log.info(item);
        log.info(queue.toString());

        queue.enqueue("Alpha");
        log.info(queue.toString());

        queue.enqueue("Bravo");
        log.info(queue.toString());

        queue.enqueue("Charlie");
        log.info(queue.toString());
    }
}

@Slf4j
class QueueV1<T> implements QueueCourseImplementation<T> {

    @Getter
    private int length = 0;
    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T item) {
        Node<T> newTail = new Node<>(item, null);
        if (length == 0) {
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        length++;

    }

    public T dequeue() {
        if (length == 0) {
            log.info("Queue vacia");
            return null;
        }
        length--;
        T value = head.value;
        head = head.next;
        if (length == 0) tail = null;

        return value;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n").append("length: ").append(getLength()).append(" - head: ").append(head != null ? head.value : "null").append(" - tail: ").append(tail != null ? tail.value : "null").append("\n");
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            if (node != null) {
                string
                        .append("[ i: ").append(i)
                        .append(" - value: ").append(node.value)
                        .append(" - next: ").append(node.next == null ? "null" : node.next.value)
                        .append("] - \n");
                node = node.next;
            }
        }
        return string.toString();
    }
}

interface QueueCourseImplementation<T> {
    int getLength();

    void enqueue(T item);

    T dequeue();

    T peek();
}