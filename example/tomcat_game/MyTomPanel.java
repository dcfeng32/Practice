package tomcat_copy2;

        import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;
        import java.awt.image.BufferedImage;

public class MyTomPanel extends JPanel implements Runnable, MouseListener {
    //生气的图片
    String[] angrys = new String[26];
    //吃东西的图片
    String[] eats = new String[40];
    String[] cymbals = new String[13];
    String[] drinks = new String[81];
    String[] farts = new String[28];
    String[] pies = new String[24];
    String[] scratchs = new String[56];
    String[] footLefts = new String[30];
    String[] footRights = new String[30];
    String[] knockouts = new String[81];
    //按钮的图片对象
    BufferedImage btn_eat = null;
    BufferedImage btn_cymbal = null;
    BufferedImage btn_drink = null;
    BufferedImage btn_fart = null;
    BufferedImage btn_pie = null;
    BufferedImage btn_scratch = null;
    String action = "angry";

    //遍历图片，放入数组的相应的集合中
    public MyTomPanel() {
        for (int i = 0; i < angrys.length; i++) {
            angrys[i] = "img/Animations/Angry/angry_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < eats.length; i++) {
            eats[i] = "img/Animations/Eat/eat_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < cymbals.length; i++) {
            cymbals[i] = "img/Animations/Cymbal/cymbal_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < drinks.length; i++) {
            drinks[i] = "img/Animations/Drink/drink_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < farts.length; i++) {
            farts[i] = "img/Animations/Fart/fart_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < pies.length; i++) {
            pies[i] = "img/Animations/Pie/pie_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
        for (int i = 0; i < scratchs.length; i++) {
            scratchs[i] = "img/Animations/Scratch/scratch_" + (i > 10 ? "" : "0") + i + ".jpg";
        }
    }

    BufferedImage image_angry = null;
    public void paint(Graphics g) {
        super.paint(g);
        //画出每个按钮的位置
        g.drawImage(image_angry, 0, 0, 430, 700, null);
        g.drawImage(btn_eat, 10, 420, null);
        g.drawImage(btn_cymbal, 25, 480, null);
        g.drawImage(btn_drink, 10, 540, null);
        g.drawImage(btn_scratch, 350, 420, null);
        g.drawImage(btn_fart, 335, 480, null);
        g.drawImage(btn_pie, 350, 540, null);
    }

    int num;
    public void run() {
        //循环图片
        while (true) {
            num++;
            try {
                btn_eat = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/eat.png"));
                btn_drink = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/drink.png"));
                btn_fart = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/fart.png"));
                btn_pie = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/pie.png"));
                btn_scratch = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/scratch.png"));
                btn_cymbal = ImageIO.read(MyTomPanel.class.getResource("img/Buttons/cymbal.png"));
                //
                if ("angry".equals(action)) {
                    if (num == angrys.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(angrys[num]));
                }
                if ("eat".equals(action)) {
                    if (num == eats.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(eats[num]));
                }
                if ("cymbal".equals(action)) {
                    if (num == cymbals.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(cymbals[num]));
                }
                if ("drink".equals(action)) {
                    if (num == drinks.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(drinks[num]));
                }
                if ("scratch".equals(action)) {
                    if (num == scratchs.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(scratchs[num]));
                }

                if ("fart".equals(action)) {
                    if (num == farts.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(farts[num]));
                }

                if ("pie".equals(action)) {
                    if (num == pies.length) {
                        num = 0;
                    }
                    image_angry = ImageIO.read(MyTomPanel.class.getResource(pies[num]));
                }
                Thread.sleep(90);
            } catch (Exception e) {
                e.printStackTrace();
                // num = 0;
            }
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        //根据坐标确地鼠标点击的范围，在范围内会有对应的动作转换
        int x = e.getX();
        int y = e.getY();
        //原数据吃东西按钮坐标是（10，420）
        if (x > 10 && x < 10 + btn_eat.getWidth() && y > 420 && y < 420 + btn_eat.getHeight()) {
            action = "eat";
            num = 0;
        }
        else if (x > 25 && x < 25 + btn_cymbal.getWidth() && y > 480 && y < 480 + btn_cymbal.getHeight()) {
            action = "cymbal";
            num = 0;
        }

        else if (x > 10 && x < 10 + btn_drink.getWidth() && y > 540 && y < 540 + btn_drink.getHeight()) {
            action = "drink";
            num = 0;
        }
        else if (x > 350 && x < 350 + btn_scratch.getWidth() && y > 420 && y < 420 + btn_scratch.getHeight()) {
            action = "scratch";
            num = 0;
        }

        else if (x > 335 && x < 335 + btn_fart.getWidth() && y > 480 && y < 480 + btn_fart.getHeight()) {
            action = "fart";
            num = 0;
        }
        else if (x > 350 && x < 350 + btn_pie.getWidth() && y > 540 && y < 540 + btn_pie.getHeight()) {
            action = "pie";
            num = 0;
        }else{
            action = "angry";
            num = 0;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}