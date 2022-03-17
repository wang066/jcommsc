package com.example.springboot2.designpattern.decorate;

/**
 *
 */
interface Component {
    void operation();
}

/**
 * 装饰者
 */
class Decorate implements Component {

    private Component component;

    public Decorate(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreateComponet implements Component {

    @Override
    public void operation() {
        System.out.println("operation");
    }
}

class DecorateA extends Decorate {

    public DecorateA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("oa");
    }
}

class main{
    public static void main(String[] args) {
//        List<Integer> areaIds=new ArrayList<>();
//        areaIds.add(3);
//        areaIds.add(1);
//        areaIds.add(2);
//        Collections.sort(areaIds);
//        areaIds.forEach(t-> System.out.println(t));
        Component component=new DecorateA(new ConcreateComponet());
        component.operation();
    }
}