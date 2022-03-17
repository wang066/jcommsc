package com.example.springboot2.designpattern.prototype;

import java.io.*;

/**
 * 简历类
 *
 */
 class Resume implements Serializable,Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = 8614140644886700330L;
    private String name;
    private String sex;
    private Integer age;
    private WorkExperience work;

    public Resume(String name){
        this.name = name;
        work = new WorkExperience();
    }
    //设置个人信息
    public void setPersonalInfo(String sex, Integer age){
        this.sex = sex;
        this.age = age;
    }
    //设置工作经历
    public void setWorkExperience(String workDate,String company){
        work.setWorkDate(workDate);
        work.setCompany(company);
    }
    //显示
    public void display(){
        System.out.println(String.format("%s %s %s", name,sex,age));
        System.out.println(String.format("工作经历：%s %s", work.getWorkDate(), work.getCompany()));
    }
    //浅复制
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
    //深复制
    public Object deepClone() throws IOException, ClassNotFoundException{
        //将对象写到流里  
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        //从流里读出来  
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

}

// --------------------------------------------------------------------------------

/**
 * 工作经历类
 *
 */
 class WorkExperience implements Serializable {
    private static final long serialVersionUID = -5461562344310808271L;
    private String workDate;
    public String getWorkDate() {
        return workDate;
    }
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    private String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}


// --------------------------------------------------------------------------------

/**
 * 客户端调用
 *
 */
public class Prototype {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男", 29);
        a.setWorkExperience("1998-2000", "xx公司");
        //浅复制  
        Resume b = (Resume)a.clone();
        b.setPersonalInfo("男", 25);
        b.setWorkExperience("1998-2006", "yy公司");

        a.display();
        b.display();
//      运行结果：a和b的WorkExperience的引用值是一样的，改变b的WorkExperience值，a也会变化
//      大鸟 男 29
//      工作经历：1998-2006 yy公司
//      大鸟 男 25
//      工作经历：1998-2006 yy公司

//       demo2
        Resume c = new Resume("大鸟");
        c.setPersonalInfo("男", 29);
        c.setWorkExperience("1998-2000", "xx公司");
        //深复制  
        Resume d = (Resume)c.deepClone();
        d.setPersonalInfo("男", 25);
        d.setWorkExperience("1998-2006", "yy公司");

        c.display();
        d.display();
//      运行结果：a和b的WorkExperience的引用值是不同的
//      大鸟 男 29
//      工作经历：1998-2000 xx公司
//      大鸟 男 25
//      工作经历：1998-2006 yy公司

    }
}
