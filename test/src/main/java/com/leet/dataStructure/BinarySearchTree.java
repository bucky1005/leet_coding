package com.leet.dataStructure;

import java.util.Comparator;

public class BinarySearchTree<E> {

    private Node<E> root;	// 루트(최상단) 노드
    private int size;		// 요소(노드)의 개수

    private final Comparator<? super E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }
    /**
     * 전위 순회
     * (부모 노드 > 왼쪽 자식 노드 > 오른쪽 자식 노드)
     */
    public void preorder() {
        preorder(this.root);
    }

    public int size() {
        return this.size;
    }

    /**
     * BinarySearchTree가 비어있는지를 판단하는 메소드
     *
     * @return BinarySearchTree가 비어있을 경우 true, 아닐경우 false를 반환
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 해당 객체가 BinarySearchTree에 존재하는지를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    public boolean contains(Object o) {
        // comparator가 null 일경우 Comparable로 비교하도록 한다.
        if (comparator == null) {
            return containsUsingComparable(o);
        }
        return containsUsingComparator(o, comparator);
    }

    /**
     * Comparable을 이용한 객체 존재 여부를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    private boolean containsUsingComparable(Object o) {

        // 비교 가능한 변수로 만든다
        @SuppressWarnings("unchecked")
        Comparable<? super E> value = (Comparable<? super E>) o;

        Node<E> node = root;
        while (node != null) {
            int res = value.compareTo(node.value);
            if (res < 0) {
                node = node.left;
            } else if (res > 0) {
                node = node.right;
            }
            // res == 0 이라는 것은 같다는 의미로 true를 반환
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * Comparable을 이용한 객체 존재 여부를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @param comparator 사용자에 의해 BinarySearchTree에 지정 된 비교기
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    private boolean containsUsingComparator(Object o, Comparator<? super E> comparator) {
        @SuppressWarnings("unchecked")
        E value = (E) o;
        Node<E> node = root;
        while (node != null) {
            int res = comparator.compare(value, node.value);
            if (res < 0) {
                node = node.left;
            } else if (res > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * BinarySearchTree를 초기화 하는 메소드
     */
    public void clear() {
        size = 0;
        /*
         *  root를 끊어주면 하위 모든 노드들도 더이상
         *  참조할 수 없기 때문에 GC 처리 된다.
         */
        root = null;
    }

    public void preorder(Node<E> o) {
        // null이 아닐 떄 까지 재귀적으로 순회
        if(o != null) {
            System.out.print(o.value + " ");	// 부모 노드
            preorder(o.left);	// 왼쪽 자식 노드
            preorder(o.right);	// 오른쪽 자식 노드
        }
    }

    /**
     * 중위 순회
     * (왼쪽 자식 노드 > 부모 노드 > 오른쪽 자식 노드)
     */
    public void inorder() {
        inorder(this.root);
    }

    public void inorder(Node<E> o) {
        if(o != null) {
            inorder(o.left);	// 왼쪽 자식 노드
            System.out.print(o.value + " ");	// 부모 노드
            inorder(o.right);	// 오른쪽 자식 노드
        }
    }

    /**
     * 후위 순회
     * (왼쪽 자식 노드 > 오른쪽 자식 노드 > 부모 노드)
     */
    public void postorder() {
        postorder(this.root);
    }

    public void postorder(Node<E> o) {
        if(o != null) {
            postorder(o.left);	// 왼쪽 자식 노드
            postorder(o.right);	// 오른쪽 자식 노드
            System.out.print(o.value + " ");	// 부모 노드
        }
    }
}
