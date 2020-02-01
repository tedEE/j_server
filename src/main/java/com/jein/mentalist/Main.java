package com.jein.mentalist;

import com.jein.mentalist.servlets.Mirror;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        Mirror mirror = new Mirror();

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        server.setHandler(context);

        context.addServlet(new ServletHolder(mirror), "/mirror");

        server.start();
        server.join();
    }
}
