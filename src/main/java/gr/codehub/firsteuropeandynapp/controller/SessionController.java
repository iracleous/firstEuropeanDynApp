package gr.codehub.firsteuropeandynapp.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SessionData implements Serializable {
        private String userName;
        private LocalDateTime firstCall;
        private LocalDateTime lastCall;
        private int callCount;
    }

    @GetMapping("/set-user/{userName}")
    public String setSessionAttribute(HttpSession session, @PathVariable(name = "userName") String userName) {
        var now = LocalDateTime.now();
        SessionData sessionData = new SessionData(userName, now, now, 0);
        session.setAttribute(userName, sessionData);
        return "Session attribute set for userName=" + userName;
    }

    @GetMapping(value = "/get-user/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SessionData getSessionAttribute(HttpSession session, @PathVariable(name = "userName") String userName) {
        SessionData sessionData = (SessionData) session.getAttribute(userName);
        // no check for user not found
        sessionData.callCount++;
        sessionData.lastCall = LocalDateTime.now();
        return sessionData;
    }
}
