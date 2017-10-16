package cn.jcomm.test.basicjava.validate;

import junit.framework.TestCase;

/**
 * Created by jowang on 2016/12/25 0025.
 */
public class SpringValidateTest extends TestCase {

    private static class User {

        private String username;

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String toString() {
            return username + ", " + password;
        }

    }


    public void test() {

    }
}
