package com.jein.mentalist.servlets;

import com.jein.mentalist.template.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mirror extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println(req.getParameterMap().toString());

        Map<String, Object> getVar = new HashMap<String, Object>();

        getVar.put("getParametrs" , req.getParameterMap().get("key")[0]);

        resp.getWriter().println(PageGenerator.instance().getPage("page.html", getVar));
    }
}
