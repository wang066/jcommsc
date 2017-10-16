package cn.jcomm.test.basicjava.matrix;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by jowang on 2016/12/23 0023.
 */
public class MatrixTest1 {

    static class T {
        public int row;
        public int col;
        public int x;
        public int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 4;

        int x, y;
        Map<Integer,Integer> map=new HashedMap();
        for (int i = 0; i < row * col; i++) {
            x = i % col;
            y = i / col;
//            System.out.println(x+"----"+y);
      }
    }
}
