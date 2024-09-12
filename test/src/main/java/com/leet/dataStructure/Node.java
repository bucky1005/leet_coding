package com.leet.dataStructure;

class Node<E> {

    /*
     * hash와 key값은 변하지 않으므로
     * final로 선언해준다.
     */
    final int hash;
    final E key;
    Node<E> next;

    Node<E> nextLink;
    Node<E> prevLink;

    public Node(int hash, E key, Node<E> next) {
        this.hash = hash;
        this.key = key;
        this.next = next;

        this.nextLink = null;
        this.prevLink = null;
    }

}
