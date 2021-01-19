package com.algorithm;

public class Program
{

    public static final String SPACE_CHARACTER = " ";
    public static final String STAR_CHARACTER = "*";

    public static void main(String[] args)
    {
        try
        {
            int height = 0;

            String[][] tree = createTree(height);

            printTree(tree, height);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String[][] createTree(int height) throws Exception
    {
        if(height <= 0)
            throw new Exception("Height of tree should be more than zero!");

        // initialize with elements with " "
        String[][] tree = initializeTree(height);

        int width = calculateWidth(height);

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

    public static String[][] initializeTree(int height)
    {
        int width = calculateWidth(height);
        String[][] tree = new String[height][width];

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                tree[i][j] = SPACE_CHARACTER;
            }
        }

        return tree;
    }

    public static void printTree(String[][] tree, int height)
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

    public static int calculateWidth(int height)
    {
        if(height <= 0)
            return 0;
        else
            return 2 * (height - 1) + 1;
    }
}
