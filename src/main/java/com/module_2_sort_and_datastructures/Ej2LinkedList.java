package com.module_2_sort_and_datastructures;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ej2LinkedList {
    public static void main(String[] args) {
        LinkedListCourseImplementation<String> list = new LinkedListV1<>();
        log.info(list.toString());

        list.append("Alpha");
        list.append("Bravo");
        list.append("Charlie");
        list.append("Delta");
        list.append("Echo");

        log.info("Length: " + list.getLength());
        log.info(list.toString());

        list.prepend("PreAlpha");
        log.info(list.toString());

        String item = list.remove("Alpha");
        log.info(item);
        log.info(list.toString());

        list.insertAt("PostEcho", 4);
        log.info(list.toString());

        item = list.removeAt(5);
        log.info(item);
        log.info(list.toString());

        item = list.get(list.getLength()/2);
        log.info(item);
        log.info(list.toString());
    }
}

@Slf4j
class LinkedListV1<T> implements LinkedListCourseImplementation<T> {

    @Getter
    private int length = 0;
    private Node<T> head;
    private Node<T> tail;

    private static final String TEXT_INTRO = "El elemento ";

    public T get(int index) {
        if (indexIsNotValid(index)) return null;
        Node<T> element = head;
        for (int i = 0; i < length; i++) {
            if (i == index) break;
            element = element.next;
        }
        log.info("Elemento " + element + " en el index " + index);
        return element.value;
    }

    private boolean indexIsNotValid(int index) {
        if (index < 0 || length <= index) {
            log.info("index no válido");
            return true;
        }
        return false;
    }

    public void append(T item) {
        Node<T> newTail = new Node<>(item, null, tail);
        if (length == 0) head = newTail;
        if (length != 0) tail.next = newTail;
        tail = newTail;
        length++;
    }

    public void prepend(T item) {
        Node<T> newHead = new Node<>(item, head, null);
        if (length != 0) head.previous = newHead;
        head = newHead;
        length++;
    }

    public void insertAt(T item, int index) {
        Node<T> previousIndex = head;
        int i = 0;
        for (; i < length; i++) {
            if (i == index) {
                Node<T> insertedNode = new Node<>(item, previousIndex.next, previousIndex);
                if (i != length - 1) previousIndex.next.previous = insertedNode;
                previousIndex.next = insertedNode;
                length++;

                log.info(TEXT_INTRO + insertedNode.value + " fue agregado en el index " + i);
                break;
            }
            previousIndex = previousIndex.next;
        }
    }

    public T remove(T item) {
        Node<T> deletedItem = head;
        int i = 0;
        for (; i < length; i++) {
            if (deletedItem.value.equals(item)) break;
            deletedItem = deletedItem.next;
        }

        if (itemDoNotExist(deletedItem)) return null;

        Node<T> previous = deletedItem.previous;
        Node<T> next = deletedItem.next;
        previous.next = next;
        next.previous = previous;
        length--;

        log.info(TEXT_INTRO + deletedItem.value + " contenido en el index " + i + " fue eliminado de la lista");
        return deletedItem.value;
    }

    private static <T> boolean itemDoNotExist(Node<T> deletedItem) {
        if (deletedItem == null) {
            log.info("elemento no encontrado en la lista");
            return true;
        }
        return false;
    }

    public T removeAt(int index) {
        if (indexIsNotValid(index)) return null;

        Node<T> deletedItem = head;
        int i = 0;
        for (; i < length; i++) {
            if (i == index) break;
            deletedItem = deletedItem.next;
        }

        Node<T> previous = deletedItem.previous;
        Node<T> next = deletedItem.next;
        previous.next = next;
        if (next != null) next.previous = previous;
        length--;

        log.info(TEXT_INTRO + deletedItem.value + " contenido en el index " + i + " fue eliminado de la lista");
        return deletedItem.value;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n");
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            if (node != null) {
                string.append("[ i: ").append(i).append(" - prev: ").append(node.previous == null ? "null" : node.previous.value).append(" - value: ").append(node.value).append(" - next: ").append(node.next == null ? "null" : node.next.value).append("] - ");
                node = node.next;
            }
            string.append("\n");
        }
        return string.toString();
    }
}

interface LinkedListCourseImplementation<T> {
    int getLength();

    void insertAt(T item, int index);

    T remove(T item);

    T removeAt(int index);

    void append(T item);

    void prepend(T item);

    T get(int index);
}
