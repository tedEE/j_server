package com.jein.mentalist;

import com.jein.mentalist.accounts.AccountService;
import com.jein.mentalist.accounts.UserProfile;
import com.jein.mentalist.servlets.Mirror;
import com.jein.mentalist.servlets.SessionsServlet;
import com.jein.mentalist.servlets.UsersServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        AccountService accountService = new AccountService();

        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("admin"));

//        Mirror mirror = new Mirror();


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);


//        context.addServlet(new ServletHolder(mirror), "/mirror");
        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("templates");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
