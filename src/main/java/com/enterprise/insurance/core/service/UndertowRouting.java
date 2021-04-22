package com.enterprise.insurance.core.service;

import com.enterprise.insurance.contract.PersonService;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.RoutingHandler;
import io.undertow.util.PathTemplateMatch;

public class UndertowRouting {

    public static final String BASE = "backend/ui/";

    public static void main(String[] args) {

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost", ROUTES)
                .build();

        server.start();
    }

    private static HttpHandler ROUTES = new RoutingHandler()
            .get(BASE + "person/{id}", new PersonService())
//                    httpServerExchange -> {
//                PathTemplateMatch pathMatch = httpServerExchange.getAttachment(PathTemplateMatch.ATTACHMENT_KEY);
//                String itemId1 = pathMatch.getParameters().get("id");
//                System.out.println(itemId1);
//                new PersonService();})
            .get("/", RoutingHandlers.plainTextHandler("GET - My Homepage"))
            .get("/about", RoutingHandlers.plainTextHandler("GET - about"))
            .post("/about", RoutingHandlers.plainTextHandler("POST - about"))
            .get("/new*", RoutingHandlers.plainTextHandler("GET - new*"))
            .setFallbackHandler(RoutingHandlers::notFoundHandler);
}
