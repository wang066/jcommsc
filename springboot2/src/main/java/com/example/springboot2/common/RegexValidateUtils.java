package com.example.springboot2.common;

import java.util.regex.Pattern;

/**
 * Created by jowang on 2016/11/15 0015.
 */
public final class RegexValidateUtils {

    public static Pattern PatternPhone = Pattern.compile("^[0-9]+[-]?[0-9]+[-]?[0-9]$");
    public static Pattern PatternNumber = Pattern.compile("^[0-9]+$");
    public static Pattern PatternNumberSign = Pattern.compile("^[+-]?[0-9]+$");
    public static Pattern PatternDecimal = Pattern.compile("^[0-9]+[.]?[0-9]+$");
    public static Pattern PatternDecimalSign = Pattern.compile("^[+-]?[0-9]+[.]?[0-9]+$"); //等价于^[+-]?\d+[.]?\d+$
    public static Pattern PatternEmail = Pattern.compile("^[\\w-]+@[\\w-]+\\.(com|net|org|edu|mil|tv|biz|info)$");//w 英文字母或数字的字符串，和 [a-zA-Z0-9] 语法一样
    public static Pattern PatternCHZN = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 手机验证
     * @param input
     * @return
     */
    public static Boolean IsPhone(String input) {
        return PatternPhone.matcher(input).find();
    }

    /**
     * 数字验证
     * @param input
     * @return
     */
    public static Boolean IsNumber(String input) {
        return PatternNumber.matcher(input).find();
    }

    public static Boolean IsNumberSign(String input) {
        return PatternNumberSign.matcher(input).find();
    }

    public static Boolean IsDecimal(String input) {
        return PatternDecimal.matcher(input).find();
    }

    public static Boolean IsDecimalSign(String input) {
        return PatternDecimalSign.matcher(input).find();
    }

    /***
     * 邮箱验证
     * @param input
     * @return
     */
    public static Boolean IsEmail(String input) {
        return PatternEmail.matcher(input).find();
    }

    /**
     * 中文验证
     * @param input
     * @return
     */
    public static Boolean IsCHZN(String input) {
        return PatternCHZN.matcher(input).find();
    }
}
