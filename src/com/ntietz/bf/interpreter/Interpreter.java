package com.ntietz.bf.interpreter;

import java.util.*;

public class Interpreter
{
    private static final int MEMORY_SIZE = 1000;

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
        for (int index = 0; index < MEMORY_SIZE; ++index)
        {
            data.add(0);
        }

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

                case '+' :
                    data.set(dataPointer, data.get(dataPointer)+1);
                    break;

                case '-' :
                    data.set(dataPointer, data.get(dataPointer)-1);
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

    public int getData(int index)
    {
        if (index < MEMORY_SIZE)
        {
            return data.get(index);
        }
        else
        {
            return 0;
        }
    }
}

