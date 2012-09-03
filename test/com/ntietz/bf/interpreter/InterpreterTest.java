package com.ntietz.bf.interpreter;

import org.junit.*;
import static org.junit.Assert.*;

public class InterpreterTest
{
    @Test
    public void test()
    {
        fail("A simple test failure");
    }

    @Test
    public void testBadInput()
    {
        String program = "hello there!";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Program should produce no output", interpreter.output(), "");
    }
}

