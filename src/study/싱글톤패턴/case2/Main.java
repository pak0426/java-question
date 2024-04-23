package study.싱글톤패턴.case2;

class Main{
    public static void main(String[] args) {
        ThreadEx threadEx1 = new ThreadEx();
        ThreadEx threadEx2 = new ThreadEx();

        Thread thread1 = new Thread(threadEx1);
        Thread thread2 = new Thread(threadEx2);

        thread1.start();
        thread2.start();
    }

    static class ThreadEx implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance();
            System.out.println("instance = " + instance);
        }
    }
}
