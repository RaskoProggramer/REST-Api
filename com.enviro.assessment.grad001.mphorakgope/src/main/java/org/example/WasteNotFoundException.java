package org.example;

public class WasteNotFoundException extends RuntimeException{
    WasteNotFoundException(Long id){
        super("Could not find waste "+ id);
    }
}
