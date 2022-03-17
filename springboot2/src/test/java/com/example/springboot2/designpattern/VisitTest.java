package com.example.springboot2.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jowang
 * @date: 2018-07-05 20:16
 * @description:访问者模式
 */
public class VisitTest {
    public static void main(String[] args) {
        ObjectStructure o=new ObjectStructure();
        o.Attach(new ElementA());
        o.Attach(new ElementB());

        VisitorA a=new VisitorA();
        VisitorB b=new VisitorB();

        o.Accept(a);
    }
}

abstract class Visitor {
    abstract void VisitElementA(ElementA elementA);

    abstract void VisitElementB(ElementB elementB);
}

class VisitorA extends Visitor {

    @Override
    void VisitElementA(ElementA elementA) {
        System.out.println("AA");
    }

    @Override
    void VisitElementB(ElementB elementB) {
        System.out.println("AB");
    }
}

class VisitorB extends Visitor {

    @Override
    void VisitElementA(ElementA elementA) {
        System.out.println("BA");
    }

    @Override
    void VisitElementB(ElementB elementB) {
        System.out.println("BB");
    }
}

abstract class Element {
    abstract void Accept(Visitor visitor);
}

class ElementA extends Element {

    @Override
    void Accept(Visitor visitor) {
        visitor.VisitElementA(this);
    }
}

class ElementB extends Element {

    @Override
    void Accept(Visitor visitor) {
        visitor.VisitElementB(this);
    }
}

class ObjectStructure{
    private List<Element> elements=new ArrayList<>();

    public void Attach(Element e){
        elements.add(e);
    }

    public void Detach(Element e){
        elements.remove(e);
    }

    public void Accept(Visitor v){
        for (Element element : elements) {
            element.Accept(v);;
        }
    }
}