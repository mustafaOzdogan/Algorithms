package com.algorithm;

import java.util.ArrayList;

public class Main {

    private static final String SPACE_CHARACTER = " ";
    private static final String STAR_CHARACTER = "*";

    public static void main(String[] args)
    {
        int height = 10;

        String[][] tree = createTree(height);

        printTree(tree, height);
    }

    private static String[][] createTree(int height)
    {
        int width = calculateWidth(height);

        String[][] tree = new String[height][width];

        // initialize with elements with " "
        initializeTree(tree, height, width);

        int leftOffset  = 0;
        int rightOffset = width - 1;

        for(int pitch = height - 1; pitch > -1; pitch--)
        {
            for(int start = leftOffset, end = rightOffset ; start < height ;start++, end--)
            {
                tree [pitch][start] = STAR_CHARACTER;
                tree [pitch][end] = STAR_CHARACTER;
            }

            leftOffset++;
            rightOffset--;
        }

        return tree;
    }

    private static void initializeTree(String[][] tree, int height, int width)
    {
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                tree[i][j] = SPACE_CHARACTER;
            }
        }
    }

    private static void printTree(String[][] tree, int height)
    {
        int width = calculateWidth(height);

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                System.out.print(tree[i][j]);
            }
            System.out.println("\n");
        }
    }

    private static int calculateWidth(int height)
    {
        return 2 * (height - 1) + 1;
    }
}
