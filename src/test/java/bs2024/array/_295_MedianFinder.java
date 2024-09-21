package bs2024.array;

import java.util.PriorityQueue;

public class _295_MedianFinder {
    public static void main(String[] args) {
        _295_MedianFinder instance = new _295_MedianFinder();
        instance.addNum(1);
        instance.addNum(2);
        System.out.println(instance.findMedian());
        instance.addNum(3);
        System.out.println(instance.findMedian());
    }

    PriorityQueue<Integer> queueLeft ;
    PriorityQueue<Integer> queueRight ;
    public _295_MedianFinder() {
        queueLeft = new PriorityQueue<>((o1, o2)-> o2-o1);
        queueRight = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(queueLeft.isEmpty()){
            queueLeft.add(num);
        }else if(queueLeft.peek() > num){
            queueLeft.add(num);
        }else{
            queueRight.add(num);
        }

        balance();
    }

    public double findMedian() {
        int sizeL = queueLeft.size();
        int sizeR = queueRight.size();
        if(sizeL == sizeR){
            return (queueLeft.peek() + queueRight.peek())/2.0D;
        }else if(sizeL > sizeR){
            return  queueLeft.peek()/1.0D;
        }else{
            return  queueRight.peek()/1.0D;
        }
    }

    public void balance(){
        int sizeL = queueLeft.size();
        int sizeR = queueRight.size();
        if(sizeL - sizeR == 2){
            queueRight.add(queueLeft.remove());
        }else if(sizeL - sizeR == -2){
            queueLeft.add(queueRight.remove());
        }
    }
}
