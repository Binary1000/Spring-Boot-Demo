package com.cnqisoft.demo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import static java.awt.Font.BOLD;

public class VevifyUtil<main> {

    // 验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    // 字符数量
    private static final int SIZE = 4;
    // 干扰线数量
    private static final int LINES = 5;
    // 宽度
    private static final int WIDTH = 120;
    // 高度
    private  static final int HEIGHT = 40;
    // 字体大小
    private static  final  int FONT_SIZE = 30;

    public static Object[] generateImage() {
        StringBuilder sb = new StringBuilder();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        Random random = new Random();
        int len = chars.length;
        for (int i = 0; i < SIZE; i++) {
            int n = random.nextInt(len);
            Font font = new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE);
            graphics.setFont(font);
            graphics.setColor(getRandomColor());
            graphics.drawString(chars[n] + "" , i * WIDTH / SIZE + 5 , HEIGHT * 2 / 3);
            sb.append(chars[n]);
        }
        for (int i = 0; i < LINES; i++) {
            graphics.setColor(getRandomColor());
            graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        return new Object[]{sb.toString(), image};
    }

    private static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }

}
