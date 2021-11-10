package cn.jcomm.controller.openapi;

public class OrderContext {
    public static class GroupOrderContext extends OrderContext{

        @Override
        void handle() {
            super.handle();
        }
    }

    void handle(){

    }

    OrderContext parse(int type){
        return new GroupOrderContext();
    }


    private String json;


}
