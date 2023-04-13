package com.plannerapp.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {
    private Long id;

    private String username;

    public boolean isLogged() {
        return this.username != null && this.id != null;
    }
}
