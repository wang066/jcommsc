package com.example.springboot2.designpattern.callback;

import org.junit.jupiter.api.Test;

public class CallBackTest2 {

    /**
     * 回调接口，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
     */
    public interface Callback {

        public void tellAnswer(int answer);

    }

    /**
     * 老师对象，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
     */
    public class Teacher implements Callback {

        private Student student;

        public Teacher(Student student) {
            this.student = student;
        }

        public void askQuestion() {
            student.resolveQuestion(this);
        }

        @Override
        public void tellAnswer(int answer) {
            System.out.println("知道了，你的答案是" + answer);
        }

    }

    /**
     * 学生接口，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
     */
    public interface Student {

        public void resolveQuestion(Callback callback);

    }

    /**
     * 一个名叫Ricky的同学解决老师提出的问题，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
     */
    public class Ricky implements Student {

        @Override
        public void resolveQuestion(Callback callback) {
            // 模拟解决问题
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }

            // 回调，告诉老师作业写了多久
            callback.tellAnswer(3);
        }

    }

    /**
     * 回调测试，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
     */
    public class CallbackTest {

        @Test
        public void testCallback() {
            Student student = new Ricky();
            Teacher teacher = new Teacher(student);

            teacher.askQuestion();

        }

    }
}
