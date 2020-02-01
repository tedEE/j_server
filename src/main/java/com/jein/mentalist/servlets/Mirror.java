package com.jein.mentalist.servlets;

import com.jein.mentalist.template.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Mirror extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> getVar = new HashMap<String, Object>();
        int flag = 1;

        for (String[] v : req.getParameterMap().values()) {
            getVar.put("getParametrs" + flag , v[v.length -1]);
            flag ++;
        }



        resp.getWriter().println(PageGenerator.instance().getPage("page.html", getVar));
    }
}
