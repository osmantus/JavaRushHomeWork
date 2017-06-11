package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует

*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    private ArrayList<ArrayList<Node>> levels = new ArrayList<>();
    private Node root = new Node();
    private Node head = root;

    public Solution() {
        levels.add(new ArrayList<Node>()); // добавили уровень 0
        levels.get(0).add(root);
    }

    public static void main(String[] args) {
        List<String> list = new Solution();

        System.out.println("Add first 15 nodes");
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected List size is 15, actual is " + list.size());
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        //list.remove("5");
        //System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));

    }

    public String getParent(String value) {
        for (ArrayList<Node> level : levels) {
            for (Node node : level) {
                if (node.data != null && node.data.equals(value)) return node.parent.data;
            }
        }
        return null;
    }

    @Override
    public boolean add(String s) {
        Node newNode = new Node(s);

        if (head == root) {
            head = root.addChild(newNode);
            levels.add(1, new ArrayList<Node>());
            levels.get(1).add(head);
            return true;
        }

        try {
            head = head.parent.addChild(newNode);
        } catch (UnsupportedOperationException e) {
            int nextNodeIndex = levels.get(head.parent.level).indexOf(head.parent) + 1;
            try {
                head = levels.get(head.parent.level).get(nextNodeIndex).addChild(newNode);
            } catch (UnsupportedOperationException | IndexOutOfBoundsException e1) {
                levels.add(new ArrayList<Node>());
                head = levels.get(head.level).get(0).addChild(newNode);
            }
        }
        levels.get(head.level).add(head);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = findNode((String) o);
        if (current == null) return false;
        cutNode(current);
        removeEmptyNodes();
        return true;
    }

    private Node findNode(String data) {
        for (ArrayList<Node> level : levels) {
            for (Node node : level) {
                if (node.data != null && node.data.equals(data)) {
                    return node;
                }
            }
        }
        return null;
    }

    private Node cutNode(Node node) {
        Node parent = node.parent;

        if (node.child1 != null) cutNode(node.child1);
        if (node.child2 != null) cutNode(node.child2);

        if (parent.child1 == node) parent.child1 = null;
        else parent.child2 = null;

        node.parent = null;

        return parent;
    }

    private void removeEmptyNodes() {
        Iterator<ArrayList<Node>> levelIterator = levels.iterator();
        while (levelIterator.hasNext()) {
            ArrayList<Node> level = levelIterator.next();
            Iterator<Node> nodeIterator = level.iterator();
            while (nodeIterator.hasNext()) {
                Node node = nodeIterator.next();
                if (node != root && node.parent == null)
                    nodeIterator.remove();
            }
            if (level.size() == 0)
                levelIterator.remove();
        }

        if (head.parent == null) {
            if (levels.size() > 1) {
                ArrayList<Node> lastLevel = levels.get(levels.size() - 1);
                head = lastLevel.get(lastLevel.size() - 1);
            } else
                head = root;
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (ArrayList<Node> level : levels) {
            size += level.size();
        }
        return size - 1;
    }

    @Override
    public void clear() {
        if (root.child1 != null) cutNode(root.child1);
        if (root.child2 != null) cutNode(root.child2);
        removeEmptyNodes();
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    private static class Node {
        String data;
        Node parent;
        Node child1;
        Node child2;
        int level;

        Node() {
        }

        Node(String data) {
            this.data = data;
        }

        Node(String data, Node parent, Node child1, Node child2) {
            this.data = data;
            this.parent = parent;
            this.child1 = child1;
            this.child2 = child2;
        }

        Node addChild(Node node) {
            if (child1 != null && child2 != null)
                throw new UnsupportedOperationException("Cannot add new Node(" + node.data + ") to Node(" + this.data + ")");

            if (child1 == null) child1 = node;
            else child2 = node;
            node.parent = this;
            node.level = this.level + 1;
            return node;
        }
    }

    private class Itr implements Iterator<String> {
        Node cursor = root;
        Node last = null;
        int cursorIndexInCurLevel = 0;

        @Override
        public boolean hasNext() {
            return cursor != head;
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();

            ArrayList<Node> level = levels.get(cursor.level);

            if (cursorIndexInCurLevel < level.size() - 1) {
                cursor = level.get(++cursorIndexInCurLevel);
            } else {
                level = levels.get(cursor.level + 1);
                cursor = level.get(cursorIndexInCurLevel = 0);
            }

            return cursor.data;
        }

        @Override
        public void remove() {
            Node tmp = cursor;
            ArrayList<Node> level = levels.get(cursor.level);
            if (cursorIndexInCurLevel > 0) {
                cursor = level.get(--cursorIndexInCurLevel);
            } else {
                level = levels.get(cursor.level - 1);
                cursor = level.get(cursorIndexInCurLevel = level.size() - 1);
            }
            Solution.this.remove(tmp.data);
        }
    }
}
