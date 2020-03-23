package bs;

import java.util.Arrays;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author C.A.O
 * @date 2020/2/4
 */
class Foo {

    public volatile String tag = "00";

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        tag = "10";
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true){
            if(tag.charAt(0) == '1'){
                printSecond.run();
                tag = "01";
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(true){
            if(tag.charAt(1) == '1'){
                printThird.run();
                tag = "00";
            }
        }
    }


    public static void main(String[] args) {
        Foo foo = new Foo();
        Integer[] arr = new Integer[3];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;

        Runnable first = ()->System.out.println("first");
        Runnable second = ()->System.out.println("second");
        Runnable third = ()->System.out.println("third");

        Arrays.asList(arr).forEach(i -> {
            if(i == 1){
                try {
                    foo.first(first);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(i == 2){
                try {
                    foo.second(second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(i == 3){
                try {
                    foo.third(third);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
