package cn.jcomm.test.thridpack.packtest.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fastjson 序列化属性！！
 */
public class Test1 {

    public static void main(String[] args) {
        Model model = new Model();
        model.setCategory(Arrays.asList("电子发票", "纸质专票", "纸质普票"));
        ArrayList<Model.Item> items = new ArrayList<Model.Item>();
        items.add(new Model.Item("六位代码", Arrays.asList("1", "2", "3")));
        items.add(new Model.Item("扫二维码", Arrays.asList("1", "2", "3")));
        items.add(new Model.Item("请求开票", Arrays.asList("1", "2", "3")));
        model.setItem(items);
        System.out.println("处理后的结果集" + JSON.toJSONString(JsonData.Fail(model)));
        System.out.println("处理后的结果集" + JSON.toJSONString((model)));
        System.out.println("处理后的结果集" + JSON.toJSONString(items));
        System.out.println("处理后的结果集" + Arrays.asList("1", "2", "3"));

        System.out.println(JSON.toJSON(JsonData.Fail(model)));
        System.out.println(JSON.toJSON(JsonData.Fail(model)));
    }
}

class JsonData<T> {
    private int code;
    private String msg;
    private T data;
    private boolean success;

    public int getcode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public JsonData(T data, boolean success, int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public static <T> JsonData Success(T data) {
        return new JsonData(data, true, 200, "");
    }

    public static <T> JsonData Fail(T data) {
        return new JsonData(data, false, 500, "请求失败");
    }

    public static <T> JsonData Fail(T data, int code, String msg) {
        return new JsonData(data, false, code, msg);
    }
}


class Model {
    public static class Item {
        private String method;
        private List<String> value;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        public Item(String method, List<String> value) {
            this.method = method;
            this.value = value;
        }
    }

    private List<String> category;
    private List<Item> item;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}