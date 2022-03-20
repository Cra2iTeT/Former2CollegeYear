package response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = "C:\\CS\\Java\\IdeaProjects\\JavaWebLearn\\practice01\\src\\main\\resources\\csgo.png";

        String path = realPath.substring(realPath.lastIndexOf("\\"));

        resp.setHeader("Content-Disposition", "attachment;filename" + path);

        FileInputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];

        ServletOutputStream out = resp.getOutputStream();

        while ((len = in.read(buffer)) != -1) {
            out.write(buffer,0,len);
        }

        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
