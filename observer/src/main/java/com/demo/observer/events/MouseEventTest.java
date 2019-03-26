package com.demo.observer.events;

import com.demo.observer.events.mouseevent.Mouse;
import com.demo.observer.events.mouseevent.MouseEventCallBack;
import com.demo.observer.events.mouseevent.MouseEventType;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:48
 * @version: V1.0
 * @detail:
 **/
public class MouseEventTest {
    public static void main(String[] args) {
        MouseEventCallBack callBack = new MouseEventCallBack();

        Mouse mouse = new Mouse();

        mouse.addListener(MouseEventType.ON_BLUR,callBack);
        mouse.addListener(MouseEventType.ON_FOCUS,callBack);

        mouse.blur();
        mouse.focus();
    }
}
