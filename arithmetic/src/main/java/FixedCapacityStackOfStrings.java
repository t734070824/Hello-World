/**
 * @author 734070824@qq.com
 * @date 2024/4/2 15:07
 */
public class FixedCapacityStackOfStrings {

    private String[] elements;
    private int N;



    public FixedCapacityStackOfStrings(int capacity) {
        elements = new String[capacity];
        N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull() {
        return N == elements.length;
    }
    public int size() {


        return N;
    }

    public void push(String item) {
        elements[N++] = item;
    }

    public String pop() {
        return elements[--N];
    }
}
