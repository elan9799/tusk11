import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        MyLinledTree linkedTree = new MyLinledTree();
        linkedTree.add(5);
        linkedTree.add(6);
        linkedTree.add(4);
        linkedTree.add(4);
        linkedTree.add(0);
        linkedTree.add(12);
        linkedTree.add(33);
        linkedTree.add(32);
        linkedTree.add(212);
        linkedTree.add(2);
        linkedTree.add(15);
        linkedTree.add(63);
        linkedTree.add(17);
        linkedTree.add(39);
        linkedTree.add(55);
        System.out.println();
        linkedTree.find(linkedTree.root, 0);
        System.out.println();
        System.out.println(linkedTree.size);
        System.out.println();
        ArrayList<Integer> array = new ArrayList<>();
        linkedTree.show(linkedTree.root, array);
        System.out.println(array);

        linkedTree = linkedTree.refactor(linkedTree);

        ArrayList<Integer> array2 = new ArrayList<>();
        linkedTree.show(linkedTree.root, array2);
        System.out.println(array2);

    }
}
class LinkedTree {
    int value;
    LinkedTree leftSide;
    LinkedTree rightSide;

    public LinkedTree(int value) {
        this.value = value;
    }
}
class MyLinledTree {
    LinkedTree root;
    int size;

    public void add(int i) {
        LinkedTree current = new LinkedTree(i);
        LinkedTree tempRoot = root;
        if (root == null) {
            root = current;
            size++;
        } else {
            boolean flag = true;
            while (flag) {
                if (current.value > tempRoot.value && tempRoot.rightSide != null) {
                    tempRoot = tempRoot.rightSide;
                } else if (current.value < tempRoot.value && tempRoot.leftSide != null) {
                    tempRoot = tempRoot.leftSide;
                } else if (tempRoot.rightSide == null && current.value > tempRoot.value) {
                    tempRoot.rightSide = current;
                    flag = false;
                } else if (tempRoot.leftSide == null && current.value < tempRoot.value) {
                    tempRoot.leftSide = current;
                    flag = false;
                } else if (current.value == tempRoot.value) {
                    flag = false;
                    size--;
                }
            }

            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear(MyLinledTree linledTree) {
        linledTree.root = null;
        linledTree = new MyLinledTree();
        size = 0;
    }

    public MyLinledTree refactor(MyLinledTree linkedTree) {
        ArrayList array = new ArrayList();
        linkedTree.show(linkedTree.root, array);
        clear(linkedTree);

        rf(linkedTree, array);
        return linkedTree;
    }

    private void rf(MyLinledTree linledTree, ArrayList<Integer> array) {
        int middleElementId = array.size() / 2;
        int middleElement = array.get(middleElementId);

        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        if (array.size() > 1) {
            for (int i = 0; i < array.size(); i++) {
                if (i < middleElementId) {
                    leftArray.add(array.get(i));
                } else if (i > middleElementId) {
                    rightArray.add(array.get(i));
                }
            }
        }

        linledTree.add(middleElement);
        if (array.size() > 2) {
            rf(linledTree, leftArray);
            rf(linledTree, rightArray);
        }else {
            if (leftArray.size() == 1){
                linledTree.add(leftArray.get(0));
            }else if (rightArray.size() == 1){
                linledTree.add(rightArray.get(0));
            }
        }
    }
    public void show(LinkedTree current, List<Integer> list){
        if (current != null){
            list.add(current.value);
        }else {
            return;
        }
        if (current.leftSide != null){
            show(current.leftSide, list);
        }
        if (current.rightSide != null){
            show(current.rightSide, list);
        }
    }
    public void find (LinkedTree current, int i){
        if (current.value == i){
            System.out.println(current);
            System.out.println(i);
        }else if (current.leftSide != null){
            find(current.leftSide, i);
        }else if (current.rightSide != null){
            find(current.rightSide, i);
        }

    }
}