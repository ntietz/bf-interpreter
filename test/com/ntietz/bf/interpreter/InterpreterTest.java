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

    @Test
    public void testDataEmpty()
    {
        Interpreter interpreter = new Interpreter();

        assertEquals("Data should start at 0", 0, interpreter.getData(10));
    }

    @Test
    public void testIncrementDataCell()
    {
        String program = "+>+++>>>++";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Data pointer should be at 4", 4, interpreter.dataPointer());
        assertEquals("Data should still be 0", 0, interpreter.getData(2));
        assertEquals("Data should still be 0", 0, interpreter.getData(3));
        assertEquals("Data should still be 0", 0, interpreter.getData(5));
        assertEquals("Data should have changed", 1, interpreter.getData(0));
        assertEquals("Data should have changed", 3, interpreter.getData(1));
        assertEquals("Data should have changed", 2, interpreter.getData(4));
    }

    @Test
    public void testDecrementDataCell()
    {
        String program = "+>++-+>>>+-+++-";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Data pointer should be at 4", 4, interpreter.dataPointer());
        assertEquals("Data should still be 0", 0, interpreter.getData(2));
        assertEquals("Data should still be 0", 0, interpreter.getData(3));
        assertEquals("Data should still be 0", 0, interpreter.getData(5));
        assertEquals("Data should have changed", 1, interpreter.getData(0));
        assertEquals("Data should have changed", 2, interpreter.getData(1));
        assertEquals("Data should have changed", 2, interpreter.getData(4));
    }

    @Test
    public void testJumpPointerForward()
    {
        String program = "+>[++[++]++]";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("First cell should change", 1, interpreter.getData(0));
        assertEquals("Second cell should not change.", 0, interpreter.getData(1));
    }

    @Test
    public void testJumpPointerBackward()
    {
        String program = "+>+>+<<[+>]>";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("Data pointer should be at 4", 4, interpreter.dataPointer());
        assertEquals("First cell should be 2", 2, interpreter.getData(0));
        assertEquals("Second cell should be 2", 2, interpreter.getData(1));
        assertEquals("Third cell should be 2", 2, interpreter.getData(2));
        assertEquals("Fourth cell should be 0", 0, interpreter.getData(3));
    }

    @Test
    public void testOutput()
    {
        String program = "++ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + . > + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + ... ";

        Interpreter interpreter = new Interpreter();
        interpreter.load(program);
        interpreter.run();

        assertEquals("First cell should be 77", 77, interpreter.getData(0));
        assertEquals("Second cell should be 97", 97, interpreter.getData(1));
        assertEquals("Output should be \"Maaa\"", "Maaa", interpreter.output());

    }
}

