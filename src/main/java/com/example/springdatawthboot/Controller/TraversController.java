package com.example.springdatawthboot.Controller;



import com.example.springdatawthboot.API.Documentarist;
import com.example.springdatawthboot.entity.transport.Shipment;
import com.example.springdatawthboot.entity.transport.Travers;
import com.example.springdatawthboot.service.travers.ShipmentService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.*;

@RestController
@RequestMapping("/Travers")
public class TraversController {


    private final ShipmentService service;
    @Autowired
    private Documentarist documentarist;

    public TraversController(ShipmentService service){
        this.service = service;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<?> getOKResponse(HttpServletRequest httpServletRequest){

        return testFlux(httpServletRequest);
    }

    @ResponseStatus(HttpStatus.MULTI_STATUS)
    @GetMapping(path = "/serverWebExchange")
    private ResponseCookie testServerWebExchange(ServerWebExchange serverWebExchange){
        ResponseCookie responseCookie = null;
        if (Objects.requireNonNull(serverWebExchange.getRequest().
                getHeaders().get("user-agent")).
                stream().anyMatch(x -> x.startsWith("curl"))){
            responseCookie = ResponseCookie.
                    from("Invoking.Environment.Cookie", "dev").
                    maxAge(Duration.ofMinutes(1)).build();

            serverWebExchange.getResponse().addCookie(responseCookie);
        }

        return responseCookie;
    }



    public Flux<Pair<String, String>> testFlux(HttpServletRequest servletRequest){
        List<Pair<String, String>> list = new ArrayList<>();
        List.of(servletRequest.getHeaderNames()).forEach(t -> list.add(
                Pair.of(String.valueOf(Math.incrementExact(0)), t.nextElement())));


        return Flux.fromIterable(list).zipWith(
                Flux.interval(Duration.ofSeconds(10))).map(Tuple2::getT1);
    }

    //    @Bean
//    public Object saveData(){
//        Travers travers = new Travers();
//        Shipment shipment = new Shipment();
//        shipment.setDetail("Hello");
//        travers.setTraversDetail("World");
//
//        travers.setShipment(List.of(shipment));
//        shipment.setTravers(List.of(travers));

    //        List<Object> objects = (List<Object>) service.saveShipment(shipment, null);
//        LinkedList<Object> list = new LinkedList<>(objects);
//
//        System.out.println(list.get(0));
//
//        return objects;
//    }
}
