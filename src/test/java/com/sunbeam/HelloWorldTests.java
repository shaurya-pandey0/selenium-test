package com.sunbeam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// just checking jenkins .
public class HelloWorldTests {
    @Test
    public void testGreet() {
        assertEquals("Hello World", HelloWorld.greet());
    }
}
