package com.leet.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

        /* Stack */
        Stack<Integer> stack = new Stack<>();//push, pop, peek, empty, seach 지원
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println(stack.peek());
        } //1, 2, 3, 4, 5 출력
        stack.pop();
        System.out.println("Pop()");
        System.out.println(stack.peek());    //4출력
        System.out.println(stack.search(3));    //2출력
        System.out.println(stack.empty());    //false출력

        /* Queue */
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    ArrayDeque arrayDeque = new ArrayDeque();
}
