package cn.jcomm.test.concurrency.a.a5;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 *
 */
public class DelayedTaskTest2 {

    static class Student implements Delayed, Runnable {

        String name;
        long submitTime;
        long workTime;

        public Student(String name, long submitTime) {
            super();
            this.name = name;
            workTime = submitTime;
            //都转为转为ns
            this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(submitTime - System.nanoTime(), unit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            Student that = (Student) o;
//         Student that = (Student) o;
            return submitTime > that.submitTime ? 1 : (submitTime < that.submitTime ? -1 : 0);
        }

        @Override
        public void run() {
            System.out.println(name + " 交卷,用时" + workTime / 10 + "分钟");
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", submitTime=" + submitTime +
                    ", workTime=" + workTime +
                    '}';
        }

        private static class EndExam extends Student {

            private ExecutorService executorService;

            public EndExam(long submitTime, ExecutorService executorService) {
                super(null, submitTime);
                this.executorService = executorService;
            }

            @Override
            public void run() {
//                try {
//                    executorService.awaitTermination(5,TimeUnit.SECONDS);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                executorService.shutdownNow();
                System.out.println("EndExam");
            }
        }
    }

    static class Teacher implements Runnable {
        private DelayQueue<Student> students;
        private ExecutorService exec;

        public Teacher(DelayQueue<Student> students, ExecutorService exec) {
            super();
            this.students = students;
            this.exec = exec;
        }


        @Override
        public void run() {
            try {
                System.out.println("考试开始……");
                while (!Thread.interrupted()) {
                    System.out.println(new Date());
                    students.take().run();
                }
                System.out.println("考试结束……");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    static class Exam {
        static final int student_SIZE = 40;

        public static void main(String[] args) {
//        Student s=new Student("1",1);
//        s.run();
//
            Random r = new Random();
            DelayQueue<Student> students = new DelayQueue<>();
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < student_SIZE; i++) {
                students.put(new Student(String.valueOf(i), r.nextInt(500)));
            }

            students.put(new Student.EndExam(1200, executorService));

            executorService.execute(new Teacher(students, executorService));

        }
    }


}
