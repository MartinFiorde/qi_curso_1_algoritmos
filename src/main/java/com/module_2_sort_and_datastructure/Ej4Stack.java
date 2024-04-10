package com.module_2_sort_and_datastructure;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ej4Stack {

    public static void main(String[] args) {
        StackCourseImplementation<String> stackV1 = new StackV1<>();
        testFunctionality(stackV1);
        StackCourseImplementation<String> stackTeacherExample = new StackTeacherExample<>();
        testFunctionality(stackTeacherExample);
    }

    private static void testFunctionality(StackCourseImplementation<String> queue) {
        log.info(queue.toString());

        queue.push("Alpha");
        queue.push("Bravo");
        queue.push("Charlie");
        queue.push("Delta");
        queue.push("Echo");
        log.info("Length: " + queue.getLength());
        log.info(queue.toString());

        String item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        item = queue.peek();
        log.info(item);
        log.info(queue.toString());

        item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        item = queue.pop();
        log.info(item);
        log.info(queue.toString());

        queue.push("Alpha2");
        log.info(queue.toString());

        queue.push("Bravo2");
        log.info(queue.toString());

        queue.push("Charlie2");
        log.info(queue.toString());
    }
}

@Slf4j
class StackV1<T> implements StackCourseImplementation<T> {

    @Getter
    private int length;
    private Node<T> tail;

    public StackV1() {
        length = 0;
        tail = null;
    }

    public void push(T item) {
        length++;
        tail = new Node<>(item, tail);
    }

    public T pop() {
        if (length == 0) {
            log.info("Queue vacia");
            return null;
        }
        length--;
        Node<T> popNode = tail;//bookkeeping
        T value = popNode.value;
        tail = popNode.previous;

        popNode.value = null;//bookkeeping
        popNode.previous = null;//bookkeeping

        return value;
    }

    public T peek() {
        return tail != null ? tail.value : null;
    }

    private static class Node<T> {
        T value;
        Node<T> previous;

        Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n").append("length: ").append(getLength()).append(" - tail: ").append(tail != null ? tail.value : "null").append("\n");
        Node<T> node = tail;
        for (int i = 0; i < length; i++) {
            if (node != null) {
                string
                        .append("[ i: ").append(i)
                        .append(" - value: ").append(node.value)
                        .append(" - previous: ").append(node.previous == null ? "null" : node.previous.value)
                        .append("] - \n");
                node = node.previous;
            }
        }
        return string.toString();
    }
}

@Slf4j
class StackTeacherExample<T> implements StackCourseImplementation<T> {

    @Getter
    private int length;
    private Node<T> head;

    public StackTeacherExample() {
        length = 0;
        head = null;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>();
        newNode.value = item;
        length++;
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.previous = this.head;
        this.head = newNode;
    }

    public T pop() {
        this.length = Math.max(0, this.length - 1);
        if (this.length == 0) {
            Node<T> popNode = this.head;
            this.head = null;
            return popNode != null ? popNode.value : null;
        }
        Node<T> popNode = this.head;
        this.head = popNode.previous;
        return popNode.value;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    private static class Node<T> {
        T value;
        Node<T> previous;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n").append("length: ").append(getLength()).append(" - tail: ").append(head != null ? head.value : "null").append("\n");
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            if (node != null) {
                string
                        .append("[ i: ").append(i)
                        .append(" - value: ").append(node.value)
                        .append(" - previous: ").append(node.previous == null ? "null" : node.previous.value)
                        .append("] - \n");
                node = node.previous;
            }
        }
        return string.toString();
    }
}

interface StackCourseImplementation<T> {
    int getLength();

    void push(T item);

    T pop();

    T peek();
}