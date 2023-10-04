package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RecordsTest {

    record User(String name, long accountNumber) {
    }

    record UserDeletedEvent(User user) {
    }

    record UserCreatedEvent(String name) {
    }

    String respond(Object o) {
        return switch (o) {
            case UserDeletedEvent(var user) -> "the user " + user.name() + " has been deleted";
            case UserCreatedEvent(var name) -> "the new user " + name + " has been created";
            default -> null;
        };
    }

    @Test
    void respondToEvents() throws Exception {
        assertEquals("the new user sdundar has been created", respond(new UserCreatedEvent("sdundar")));
        assertEquals("the user sdundar has been deleted", respond(new UserDeletedEvent(new User("sdundar", 1))));
    }
}
