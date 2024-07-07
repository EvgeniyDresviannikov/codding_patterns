package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Pair2 {
    int index;
    List<NestedInteger> list;

    public Pair2(List<NestedInteger> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}


class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    Stack<Pair2> stack;

    // NestedIterator constructor inializes the stack using the given nestedList list
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        stack = new Stack<>();

        stack.push(new Pair2(nestedList));

    }

    // hasNext() will return True if there are still some integers in the
    // stack (that has nested_list elements) and, otherwise, will return False.
    public boolean hasNext() {

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Pair2 inner = stack.peek();
                if (inner.getIndex() < inner.list.size()) {
                    return true;
                } else {
                    stack.pop();
                }
            }
        }
        return false;
    }

    // Check if there is still an integer in the stack
    public Integer next() {
        Pair2 inner = stack.peek();

        NestedInteger next = inner.getList().get(inner.getIndex());
        if (next.isInteger()) {
            inner.setIndex(inner.getIndex()+1);
            return next.getFile();
        } else {
            List<NestedInteger> list = next.getList();
            while(true) {
                stack.push(new Pair2(list));
                if (list.get(0).isInteger()) {
                    stack.peek().setIndex(1);
                    return list.get(0).getFile();
                } else {
                    list = list.get(0).getList();
                }
            }
        }
    }

    // ------ Please don't change the following function ----------
    // flattenList function is used for testing porpuses.
    // Your code will be tested using this function
    public static List<Integer> flattenList(NestedIterator obj){
        List<Integer> result = new ArrayList<Integer>();

        while (obj.hasNext()) {
            result.add(obj.next());
        }
        return result;
    }
}



class NestedInteger {
    List<NestedInteger> list;
    int file;

    // Constructor initializes an empty nested list.
    public NestedInteger(){
        this.list = new ArrayList<NestedInteger>();
    }

    // Constructor initializes a single file.
    public NestedInteger(int value){
        this.file = value;
    }
    // @return true if this NestedInteger holds an integer value.
    public boolean isInteger() {
        return isFile();
    }


    // @return true if this NestedDirectories holds a single file, rather than a nested list.
    public boolean isFile(){
        if(this.file != 0)
            return true;
        return false;
    }

    // @return the single file that this NestedDirectories holds, if it holds a single file
    // Return null if this NestedDirectories holds a nested list
    public int getFile(){
        return this.file;
    }

    // Set this NestedDirectories to hold a single file.
    public void setFile(int value){
        this.list = null;
        this.file =  value;
    }

    // Set this NestedDirectories to hold a nested list and adds a nested file to it.
    public void add(NestedInteger ni){
        if (this.file != 0){
            this.list = new ArrayList<NestedInteger>();
            this.list.add(new NestedInteger( this.file));
            this.file = 0;
        }
        this.list.add(ni);
    }

    // @return the nested list that this NestedDirectories holds, if it holds a nested list
    // Return null if this NestedDirectories holds a single file
    public List<NestedInteger> getList(){
        return this.list;
    }
}