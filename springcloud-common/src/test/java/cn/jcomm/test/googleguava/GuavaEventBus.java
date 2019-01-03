package cn.jcomm.test.googleguava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jowang
 * @date: 2018-12-28 10:46
 * @description:
 */
public class GuavaEventBus {
    public static void main(String[] args) {
        GuavaListener listener=new GuavaListener();
        EventBus eventBus=new EventBus();
        eventBus.register(listener);

        eventBus.post(new HelloEvent("hello"));
        System.out.println("-------------------");
        eventBus.post(new WorldEvent("word",2333));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class HelloEvent {
    private String eventName;
}


@Data
class WorldEvent extends HelloEvent {

    private int eventNo;

    public WorldEvent(String name, int no) {
        setEventName(name);
        setEventNo(no);
    }
}

/**
 * Desc: 事件监听器，可以监听多个事件。处理方法添加 @Subscribe 注解即可。
 */
class GuavaListener {

    /**
     * 监听 HelloEvent 类型及其父类型（Object）的事件
     */
    @Subscribe
    public void processEvent(HelloEvent event) {
        System.out.println("process hello event, name:" + event.getEventName());
    }

    /**
     * 监听 WorldEvent 类型及其父类型（HelloEvent 和 Object）的事件
     */
    @Subscribe
    public void processWorldEvent(WorldEvent event) {
        System.out.println("process world eventV1, no:" + event.getEventNo() + ", name:" + event.getEventName());
    }

    /**
     * 注册多个监听器 监听同一事件
     *
     * @param event
     */
    @Subscribe
    public void processWorldEventV2(WorldEvent event) {
        System.out.println("process world eventV2, no:" + event.getEventNo() + ", name:" + event.getEventName());
    }

    @Subscribe
    public void processObject(Object object) {
        System.out.println("process common event, class:" + object.getClass().getSimpleName());
    }
}