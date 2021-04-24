package com.enterprise.insurance.contract;

import com.enterprise.insurance.core.service.AbstractService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.PathTemplateMatch;
import org.apache.commons.lang3.StringUtils;

public class PersonService extends AbstractService {

    private PersonDAO personDAO = new PersonDAO();

    @Override
    public void handleRequest(HttpServerExchange exchange) {
        PathTemplateMatch pathMatch = exchange.getAttachment(PathTemplateMatch.ATTACHMENT_KEY);
        String idPathItem = pathMatch.getParameters().get("id");
        System.out.println("DEBUG ID:" + idPathItem);
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        if(StringUtils.isNumeric(idPathItem)){
            long id = Long.parseLong(idPathItem);
            Person person = personDAO.getById(id);
            if(person != null){
                exchange.getResponseSender().send(person.toString());
            } else {
                exchange.getResponseSender().send("No Person found for given id " + id);
            }
        }else{
            exchange.getResponseSender().send("No id given for request.");
        }
    }
}
