package com.ntietz.bf.interpreter;

import org.junit.*;
import static org.junit.Assert.*;

public class InterpreterTest
{
    @Test
    public void testBadInput()
    {
        String program = "hello there!";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Program should produce no output", interpreter.output(), "");
    }

    @Test
    public void testInitialPointers()
    {
        String program = "foo bar!";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        
        assertEquals("Data pointer should start at 0", 0, interpreter.dataPointer());
        assertEquals("Instruction pointer should start at 0", 0, interpreter.instructionPointer());
    }

    @Test
    public void testIncrementDataPointer()
    {
        String program = "  >  ";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Data pointer should be at 1", 1, interpreter.dataPointer());
        assertTrue("Instruction pointer should have moved", interpreter.instructionPointer() > 0);
    }

    @Test
    public void testDecrementDataPointer()
    {
        String program = ">><>";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Data pointer should be at 2", 2, interpreter.dataPointer());
        assertTrue("Instruction pointer should have moved", interpreter.instructionPointer() > 0);
    }
}

