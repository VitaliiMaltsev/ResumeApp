package com.company.web;

import com.company.model.Resume;
import com.company.storage.SerializedFileStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class ResumeServlet extends javax.servlet.http.HttpServlet {
    public static SerializedFileStorage storage = new SerializedFileStorage("E:\\IDEA Ultimate\\java projects ultimate\\CRUDResumeApp\\file_storage");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        Writer w = response.getWriter();
//        String name = request.getParameter("name");
//        w.write("Тестовый сервлет : "+ name);
//        PrintWriter pw = response.getWriter();
//        pw.println("<html>");
//        pw.println("<head><title>Hello World</title></title>");
//        pw.println("<body>");
//        pw.println("<h1>Hello World</h1>");
//        pw.println("</body></html>");
//        pw.close();
//        w.close();
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        Resume r;
//        IStorage storage = WebAppConfig.get().getStorage();

        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("list");
                return;
            case "create":
                r = Resume.EMPTY;
                break;
            case "view":
            case "edit":
                r = storage.load(uuid);
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
}

