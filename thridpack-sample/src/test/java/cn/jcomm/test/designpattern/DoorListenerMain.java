package cn.jcomm.test.designpattern;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;

interface DoorListener extends EventListener {
    public void doorEvent(DoorEvent event);
}

/**
 * java 事件
 * Created by jowang on 2016/11/21 0021.
 */
public class DoorListenerMain {
    public static void main(String[] args) {
        DoorManager doorManager = new DoorManager();
        DoorListener listener = new DoorListener() {
            @Override
            public void doorEvent(DoorEvent event) {
                if (event.getDoorState() == "open") {
                    System.out.println("open");
                } else {
                    System.out.println("close");
                }
            }
        };

        doorManager.addDoorListener(listener);

        doorManager.fireWorkspaceOpened();
        doorManager.fireWorkspaceClosed();
    }
}

class DoorManager {
    private Collection listeners;

    /**
     * 添加事件
     *
     * @param listener DoorListener
     */
    public void addDoorListener(DoorListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     *
     * @param listener DoorListener
     */
    public void removeDoorListener(DoorListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        listeners.forEach(i -> ((DoorListener) i).doorEvent(event));
    }
}

class DoorEvent extends EventObject {

    private static final long serialVersionUID = 6496098798146410884L;

    private String doorState = "";// 表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public String getDoorState() {
        return this.doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

}

class DoorListener1 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }
}