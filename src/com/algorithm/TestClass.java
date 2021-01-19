package com.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass
{
    @Test
    public void whenCalculationTreeWidth()
    {
        assertEquals(0, Program.calculateWidth(-6));
        assertEquals(0, Program.calculateWidth(0));
        assertEquals(1, Program.calculateWidth(1));
        assertEquals(3, Program.calculateWidth(2));
        assertEquals(7, Program.calculateWidth(4));
    }

    @Test
    public void whenInitializeTree()
    {
        int height = 3;
        String[][] tree = Program.initializeTree(height);

        // test element of indexes
        assertEquals(tree[0][0], Program.SPACE_CHARACTER);
        assertEquals(tree[0][1], Program.SPACE_CHARACTER);

        int width = Program.calculateWidth(height);
        assertEquals(tree[height - 1][width - 1], Program.SPACE_CHARACTER);

        // test dimension length
        assertEquals(tree.length, height);
        assertEquals(tree[0].length, width);
    }

//    @Test
//    public void whenPrintTree()
//    {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        int height = 3;
//        String[][] tree = initializeTree(height);
//        printTree(tree, height);
//
//        assertEquals("", outContent.toString());
//    }
}
