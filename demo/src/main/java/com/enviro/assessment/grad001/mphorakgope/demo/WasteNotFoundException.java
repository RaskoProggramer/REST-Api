package com.enviro.assessment.grad001.mphorakgope.demo;

public class WasteNotFoundException extends RuntimeException{
    WasteNotFoundException(Long id){
        super("Could not find waste "+ id);
    }
}
