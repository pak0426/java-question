package study.싱글톤패턴.case1;

class Main{
    public static void main(String[] args) {
        ThreadEx threadEx1 = new ThreadEx();
        ThreadEx threadEx2 = new ThreadEx();

        Thread thread1 = new Thread(threadEx1);
        Thread thread2 = new Thread(threadEx2);

        thread1.start();
        thread2.start();

        /**
         * instance = study.싱글톤패턴.case1.Singleton@6c69f10
         * instance = study.싱글톤패턴.case1.Singleton@5e3577aa
         */
    }

    static class ThreadEx implements Runnable {
        @Override
        public void run() {
            Singleton instance = Singleton.getInstance();
            System.out.println("instance = " + instance);
        }
    }
}
