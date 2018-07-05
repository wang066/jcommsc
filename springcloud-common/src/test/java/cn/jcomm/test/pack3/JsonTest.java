package cn.jcomm.test.pack3;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-07-02 11:24
 * @description:
 */
public class JsonTest extends TestCase {
    public void  test(){
        JSONObject object=new JSONObject();
        object.put("a",null);
        System.out.println(object.toJSONString());
    }
}
