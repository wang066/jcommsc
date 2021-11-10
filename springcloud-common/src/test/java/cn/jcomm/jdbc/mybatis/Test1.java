package cn.jcomm.jdbc.mybatis;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: jowang
 * @date: 2018-11-28 9:46
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo.class) {
            @Override
            public <T> T getBean(Class<T> requiredType) throws BeansException {
                // assertBeanFactoryActive();
                return getBeanFactory().getBean(requiredType);
            }
        };


        context.start();

        Demo bean = context.getBean(Demo.class);

        context.close();

        bean = context.getBean(Demo.class);

    }

    @Service
    static class Demo {
        public Demo() {
            System.out.println("Demo create...");
        }
    }
}
