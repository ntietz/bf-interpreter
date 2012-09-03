package com.ntietz.bf.interpreter;

import java.util.*;

public class Interpreter
{
    private String program;
    private String output;
    private List<Integer> data;
    private int dataPointer;
    private int instructionPointer;

    public Interpreter()
    {
        program = "";
        output = "";
        data = new ArrayList<Integer>();
        dataPointer = 0;
        instructionPointer = 0;
    }

    public void load(String program)
    {
        this.program = program;
    }

    public void run()
    {
        while (instructionPointer < program.length())
        {
            char command = program.charAt(instructionPointer);

            switch (command)
            {
                case '>' :
                    ++dataPointer;
                    break;

                case '<' :
                    --dataPointer;
                    break;
            }

            ++instructionPointer;
        }
    }

    public String output()
    {
        return output;
    }

    public int dataPointer()
    {
        return dataPointer;
    }

    public int instructionPointer()
    {
        return instructionPointer;
    }
}

