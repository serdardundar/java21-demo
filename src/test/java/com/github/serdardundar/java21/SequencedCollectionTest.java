package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;

public class SequencedCollectionTest {

    @Test
    void ordering() throws Exception {
        var list = new ArrayList<String>();
        if (list instanceof SequencedCollection<String> sequencedCollection) {
            sequencedCollection.addFirst("ciao");
            sequencedCollection.add("hola");
            sequencedCollection.add("merhaba");
            sequencedCollection.add("salute");
            sequencedCollection.add("ola");
            sequencedCollection.addFirst("selam");
            assertEquals("selam", sequencedCollection.getFirst());
            assertEquals("selam", list.get(0));
        }

        var hashSet = LinkedHashSet.<String>newLinkedHashSet(10);
        if (hashSet instanceof SequencedCollection<String> sequencedCollection) {
            sequencedCollection.addFirst("ciao");
            sequencedCollection.add("hola");
            sequencedCollection.add("merhaba");
            sequencedCollection.add("salute");
            sequencedCollection.add("ola");
            sequencedCollection.addFirst("selam");
            assertEquals("selam", sequencedCollection.getFirst());
            assertEquals("selam", hashSet.getFirst());
        }
    }
}
