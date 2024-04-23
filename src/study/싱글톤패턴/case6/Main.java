package study.싱글톤패턴.case6;

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

        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        Singleton singleton3 = Singleton.INSTANCE;

        if (singleton1 == singleton2) {
            System.out.println("same");
        }

        if (singleton1 == singleton3) {
            System.out.println("same");
        }

        if (singleton2 == singleton3) {
            System.out.println("same");
        }
    }

    static class ThreadEx implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.INSTANCE;
            System.out.println("instance = " + System.identityHashCode(instance));
        }
    }
}
