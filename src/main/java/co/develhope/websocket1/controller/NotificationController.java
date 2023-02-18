package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.MessageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpleMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClient(@RequestBody MessageDTO message){
        simpleMessagingTemplate.convertAndSend("/topic/broadcast", message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/message")
    public void handleMessageFromWebSocket(MessageDTO message){

    }
}