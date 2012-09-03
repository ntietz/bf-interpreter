package com.ntietz.bf.intepreter;

public class Interpreter
{
    private String program;
    private List<Integer> data;
    private int dataPointer;
    private int instructionPointer;

    public Interpreter()
    {
        program = "";
        data = new ArrayList<Integer>();
        dataPointer = 0;
        instructionPointer = 0;
    }
}

