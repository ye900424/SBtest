package thread.ContextSwitchTest;

/**
 * Author     :Administrator
 * Time       :16:21
 * Project    :CMSM
 * Package    :thread.ContextSwitchTest
 */
public class CpuTest {
    public static void main(String[] args) {
//        Thread thread = new Thread(new MyWork());
//        thread.start();

        printCallStatck();

    }


    public static void printCallStatck() {
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+"/t");
                System.out.print(stackElements[i].getFileName()+"/t");
                System.out.print(stackElements[i].getLineNumber()+"/t");
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
            }
        }
    }
}

class MyWork implements Runnable {

    @Override
    public void run() {
        while(true){
            System.out.println("Thread name="+System.currentTimeMillis());
        }
    }
}
