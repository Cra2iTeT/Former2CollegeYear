package response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Random;

public class imageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh", "3");//3秒自动刷新

        BufferedImage image = new BufferedImage(90, 30, BufferedImage.TYPE_INT_RGB);//创建图片

        Graphics2D g = (Graphics2D) image.getGraphics();//笔

        g.setColor(Color.WHITE);//设置背景颜色
        g.fillRect(0, 0, 90, 30);

        g.setColor(Color.blue);
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(f(), 0, 20);

        resp.setContentType("image/jpg");//让浏览器以图片形式打开
        resp.setDateHeader("expires", -1);//不让浏览器缓存
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("pragma", "no-cache");

        ImageIO.write(image, "jpg", resp.getOutputStream());//把图片写给浏览器

    }

    private String f() {
        Random random = new Random();
        String s = random.nextInt(99999999) + "";

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8 - s.length(); i++) {
            stringBuffer.append("0");//保证序列位数
        }
        String s1 = stringBuffer.toString() + s;
        return s1;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
