package tomcat_copy2;

import tomcat_copy2.Utils.FrameUtils;

import javax.swing.*;

public class MyTom {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tom");
        FrameUtils.initFrame(frame,430,700);
        //新建空白画板
        MyTomPanel panel = new MyTomPanel();
        frame.add(panel);
        // 给面板绑定点击事件
        panel.addMouseListener(panel);
        //开始启动线程
        new Thread(panel).start();
        //显示窗口
        frame.setVisible(true);
    }
}
