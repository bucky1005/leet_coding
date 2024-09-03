package com.leet.dataStructure;

import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.NoSuchElementException;

public class LinkedListQueue<E extends EngineExecutionContext> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>() {

        };

        // 비어있을 경우
        if(size == 0) {
            head = newNode;
        }
        // 그 외의 경우 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 한다.
        /**
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {

        // 삭제할 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        return null;
    }

    public E remove() {

        E element = poll();

        if(element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {

        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }
        return element();
    }

    public E element() {

        E element = peek();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {

        /**
         * head 데이터부터 x가 null이 될 때까지 value랑 x의 데이터(x.data)랑
         * 같은지를 비교하고 같을 경우 true를 반환한다.
         */

        return false;
    }

    public void clear() {

        for(Node<E> x = head; x != null; ) {

        }
        size = 0;
        head = tail = null;

    }

}
