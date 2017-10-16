package cn.jcomm.test.designpattern.facade;

/**
 * Created by 066 on 2017/3/8 0008.
 * 门面模式 统一一个接口服务很多职能 比如在用户服务和订单服务之上 有用户订单服务
 */
public class SecurityFacade {

    private static SecurityFacade security;
    private static Camera camera1, camera2;
    private static Light light1, light2, light3;
    private static Sensor sensor;
    private static Alarm alarm;

    static {
        camera1 = new Camera();
        camera2 = new Camera();
        light1 = new Light();
        light2 = new Light();
        light3 = new Light();
        sensor = new Sensor();
        alarm = new Alarm();
    }

    public static void main(String[] args) {
        security = new SecurityFacade();
        security.Activate();

        security.Deactivate();
    }

    public void Activate() {
        camera1.TurnOn();
        camera2.TurnOn();
        light1.TurnOn();
        light2.TurnOn();
        light3.TurnOn();
        sensor.Activate();
        alarm.Activate();
    }

    public void Deactivate() {
        camera1.TurnOff();
        camera2.TurnOff();
        light1.TurnOff();
        light2.TurnOff();
        light3.TurnOff();
        sensor.Deactivate();
        alarm.Deactivate();
    }

}

class Camera {
    public void TurnOn() {
        System.out.println("Turning on the camera.");
    }

    public void TurnOff() {
        System.out.println("Turning off the camera.");
    }

    public void Rotate(int degrees) {
        System.out.println("Rotating the camera by {0} degrees.");
    }
}

class Light {

    public void TurnOff() {
        System.out.println("Turning on the light.");
    }

    public void TurnOn() {
        System.out.println("Turning off the light.");
    }

    public void ChangeBulb() {
        System.out.println("changing the light-bulb.");
    }
}

class Sensor {
    public void Activate() {
        System.out.println("Activating the sensor.");
    }

    public void Deactivate() {
        System.out.println("Deactivating the sensor.");
    }

    public void Trigger() {
        System.out.println("The sensor has triggered.");
    }
}

class Alarm {

    public void Activate() {
        System.out.println("Activating the alarm.");
    }

    public void Deactivate() {
        System.out.println("Deactivating the alarm.");
    }

    public void Ring() {
        System.out.println("Ringing the alarm.");
    }

    public void StopRing() {
        System.out.println("Stop the alarm.");
    }
}

