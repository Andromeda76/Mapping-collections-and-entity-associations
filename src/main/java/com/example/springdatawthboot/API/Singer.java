package com.example.springdatawthboot.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component("JohnMayer")
public class Singer {
    private static Logger logger = LoggerFactory.getLogger(Singer.class);

    public void sing(){
        logger.info("singing in Singer class");
    }

    public void talk(){
        logger.info("sing a song");
    }

}
