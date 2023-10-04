package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SealedTypesTest {

    @Test
    void sealedTypes() throws Exception {
        assertEquals("woof", communicate(new Dog()));
        assertEquals("meow", communicate(new Cat()));
        assertEquals("chirp", communicate(new Bird()));
    }

    sealed static class Animal permits Cat, Dog{}

    static final class Cat extends Animal {
        String meow() {
            return "meow";
        }
    }

    static final class Dog extends Animal {
        String bark() {
            return "woof";
        }
    }

    // Compiler error
    static class Bird extends Animal {
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
        return message;
    }
}
