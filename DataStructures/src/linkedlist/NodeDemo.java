package linkedlist;

import java.util.*;

//import com.google.common.collect.Lists;

/**
 * 朗致笔试题
 * Copyright (c) 2023 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author reshui
 * @date 2023/4/5 21:15
 */
public class NodeDemo<T> {

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>();
        node.setData(1);
        node.generateTree(5);

        Node searchA = node.search(20);
        Node searchB = node.search(2);

        searchB.find(searchA);
        System.out.println(node);
    }

}


class Node<T> {

    private Node<T> parent;
    private Node<T> rightChild;
    private Node<T> leftChild;
    private T data;

    public Node() {
    }

    public Node(Node<T> parent, Node<T> rightChild, Node<T> leftChild) {
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    /**
     * 生成树节点
     *
     * @param level
     */
    public void generateTree(int level) {
        if (level == 1) {
            return;
        }
        Node<Integer> left = new Node<>();
        left.setData((Integer) this.data * 2);
        left.setParent((Node<Integer>) this);
        this.setLeftChild((Node<T>) left);
        left.generateTree(level - 1);

        Node<Integer> right = new Node<>();
        right.setData((Integer) this.data * 2 + 1);
        right.setParent((Node<Integer>) this);
        this.setRightChild((Node<T>) right);
        right.generateTree(level - 1);


    }

    public Node search(T data) {
        if (this.getData() == data || data.equals(this.getData())) {
            return this;
        }

        if (this.leftChild != null) {
            Node leftSearch = this.leftChild.search(data);
            Node rightSearch = this.rightChild.search(data);
            return leftSearch == null ? rightSearch : leftSearch;
        }

        return null;
    }

    public void find(Node<T> b) {
        Set<Node<T>> nodeSet = b.toRoot();

        //找到公共祖先
        Node<T> corParent = this;
        while (corParent != null) {
            if (nodeSet.contains(corParent)) {
                break;
            } else {
                corParent = corParent.parent;
            }
        }

        List<Node<T>> thisToCoNode = new ArrayList<>();
        List<Node<T>> targetToCoNode = new ArrayList<>();

        Node<T> temp = this;
        while (temp != corParent) {
            thisToCoNode.add(temp);
            temp = temp.parent;
        }
        thisToCoNode.add(corParent);

        temp = b;
        while (temp != corParent) {
            targetToCoNode.add(temp);
            temp = temp.parent;
        }

//        List<Node<T>> reverse = Lists.reverse(targetToCoNode);
        List<Node<T>> reverse = new ArrayList<>();
        reverse.addAll(targetToCoNode);
        Collections.reverse(reverse);

        thisToCoNode.addAll(reverse);

        thisToCoNode.forEach(e -> {
            System.out.print(e.getData() + "->");
        });
        System.out.println();
    }


    private Set<Node<T>> toRoot() {
        Set<Node<T>> list = new HashSet<>();
        list.add(this);
        Node<T> temp = this.parent;
        while (temp != null) {
            list.add(temp);
            temp = temp.parent;
        }
        return list;
    }


    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
