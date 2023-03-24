package com.example.springboot2.designpattern.composite;

import com.google.common.base.Supplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by 066 on 2017/3/8 0008.
 * 想到Composite就应该想到树形结构图。组合体内这些对象都有共同接口,当组合体一个对象的方法被调用执行 时，Composite将遍历(Iterator)整个树形结构,寻找同样包含这个方法的对象并实现调用执行。可以用牵一动百来形容。
 * 1.使客户端调用简单，客户端可以一致的使用组合结构或其中单个对象，用户就不必关系自己处理的是单个对象还是整个组合结构，这就简化了客户端代码。
 * <p>
 * 　　2.更容易在组合体内加入对象部件. 客户端不必因为加入了新的对象部件而更改代码。
 */
public class Test {
    public static void main(String[] args) {
        buildExcludedPatternsList("/struts/webconsole.html");
    }

    public static List<Pattern> buildExcludedPatternsList(String patterns) {
        if (null != patterns && patterns.trim().length() != 0) {
            List<Pattern> list = new ArrayList<Pattern>();
            String[] tokens = patterns.split(",");
            for (String token : tokens) {
                list.add(Pattern.compile(token.trim()));
                System.out.println(list);
            }
            return Collections.unmodifiableList(list);
        } else {
            return null;
        }
    }

    @org.junit.jupiter.api.Test
    public void test1() {
        Supplier<Integer> supplier = () -> {
            try {
                return 1;
            } catch (Exception e) {
                return 2;
            } finally {
                return 3;
            }
        };
        System.out.println(supplier.get());
    }
}
