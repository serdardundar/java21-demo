package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SealedTypesTest {

    @Test
    void sealedTypes() throws Exception {
        assertEquals("woof", communicate(new Dog()));
        assertEquals("meow", communicate(new Cat()));
        assertEquals("chirp", communicate(new Bird()));

        assertEquals("woof", communicateWithNewSwitch(new Dog()));
        assertEquals("meow", communicateWithNewSwitch(new Cat()));
        assertEquals("chirp", communicateWithNewSwitch(new Bird()));
    }

    sealed interface Animal permits Cat, Dog, Bird{}

    static final class Cat implements Animal {
        String meow() {
            return "meow";
        }
    }

    static final class Dog implements Animal {
        String bark() {
            return "woof";
        }
    }

    // Compiler error
    static final class Bird implements Animal {
        String chirp() {
            return "chirp";
        }
    }

    String communicate (Animal animal) {
        var message = (String) null;
        if (animal instanceof Dog dog) {
            message = dog.bark();
        }
        if (animal instanceof Cat cat) {
            message = cat.meow();
        }
        if (animal instanceof Bird bird) {
            message = bird.chirp();
        }
        return message;
    }

    String communicateWithNewSwitch (Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
        };
    }
}
