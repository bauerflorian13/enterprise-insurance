package com.enterprise.insurance.contract;

import com.enterprise.insurance.core.service.AbstractService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.PathTemplateMatch;

public class PersonService extends AbstractService {

    private PersonDAO personDAO = new PersonDAO();

    @Override
    public void handleRequest(HttpServerExchange exchange) {
        PathTemplateMatch pathMatch = exchange.getAttachment(PathTemplateMatch.ATTACHMENT_KEY);
        String itemId1 = pathMatch.getParameters().get("id");
        System.out.println("DEBUG ID:" + itemId1);
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send(itemId1 + "\n");
    }
}
