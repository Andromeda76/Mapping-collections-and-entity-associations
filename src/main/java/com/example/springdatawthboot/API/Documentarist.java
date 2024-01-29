package com.example.springdatawthboot.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Documentarist {

    private Singer singer;

    @Autowired
    @Qualifier("JohnMayer")
    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public void execute(){
        singer.talk();
        singer.sing();
    }


}
