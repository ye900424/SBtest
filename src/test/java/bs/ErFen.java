package bs;

/**
 * 实现一个针对读多写少场景的有序容器, 可以一个一个的插入元素,
 * 可以改变这个容器内容的, 只有这一个方法, 要求任何时候这个容器都是有序的
 * 比如一次插入 [5, 3, 3, 1], 我希望顺序是 [1, 3, 3, 5], 容器的容量限制为固定大小
 * 要求: 不借助任何其他有能排序特性的第三方容器
 *
 * @author C.A.O
 * @date 2020/1/9
 */
public class ErFen {

    public static void main(String[] args) {
        MyContainer myContainer = new MyContainer();

        myContainer.add1(3);
        myContainer.add1(2);
        myContainer.add1(1);
        myContainer.add1(5);
        myContainer.add1(4);
        myContainer.add1(7);
        myContainer.add1(9);

        myContainer.print();


//        System.out.println(myContainer.findIndex(myContainer.getArray(), 3, 0, 6));


    }


    static class MyContainer {
        int[] array = new int[100];
        int modCount = 0;
        void add1(int ele){
            int idx = 0;
            for(int i = modCount;i>0;i--){
                if(ele > array[i-1]){
                    idx = i;
                    break;
                }else{
                    array[i] = array[i-1];
                }
            }

            array[idx] = ele;
            modCount ++;
        }

        void add(int ele) {
            int idx = 0;

            if (modCount == 0) {
                array[0] = ele;
            } else {
                idx = findIndex(array,ele,0,modCount-1);



                for (int i = modCount; i > idx; i--) {
                    array[i] = array[i - 1];
                }

                array[idx] = ele;
            }

            // 容器里面插入的数量
            modCount++;
        }

        // 二分查找
        public int findIndex(int[] array, int ele, int min, int max) {
            if (ele < array[min]) {
                return min;
            }
            if (ele > array[max]) {
                return max + 1;
            }
            if (min > max) {
                return min;
            }

            int middle = (min + max) / 2;

            if (ele < middle) {
                return findIndex(array, ele, min, middle - 1);
            } else if (ele > middle) {
                return findIndex(array, ele, middle + 1, max);
            } else {
                return middle;
            }

        }


        public void print() {
            for (int i : array) {
                System.out.println(i);

            }
        }

        public int[] getArray() {
            return array;
        }

    }
}
