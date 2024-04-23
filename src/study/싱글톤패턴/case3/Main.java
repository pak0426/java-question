package study.싱글톤패턴.case3;

class Main{
    public static void main(String[] args) {
        ThreadEx threadEx1 = new ThreadEx();
        ThreadEx threadEx2 = new ThreadEx();
        ThreadEx threadEx3 = new ThreadEx();
        ThreadEx threadEx4 = new ThreadEx();
        ThreadEx threadEx5 = new ThreadEx();

        Thread thread1 = new Thread(threadEx1);
        Thread thread2 = new Thread(threadEx2);
        Thread thread3 = new Thread(threadEx3);
        Thread thread4 = new Thread(threadEx4);
        Thread thread5 = new Thread(threadEx5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    static class ThreadEx implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance();
            System.out.println("instance = " + instance);
        }
    }
}
