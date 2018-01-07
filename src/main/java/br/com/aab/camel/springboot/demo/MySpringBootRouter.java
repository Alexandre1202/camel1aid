package br.com.aab.camel.springboot.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
    		System.out.println("************\n" + this.getClass() + ".configure() - INICIO");
//        from("timer:trigger")
//                .transform().simple("ref:myBean")
//                .to("log:out");
    		from("file:data/inbox?noop=true").to("file:data/outbox");
    }

    @Bean
    String myBean() {
        return "I'm Spring bean!";
    }

}
