import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] grid;
    private int i;
    private long lastUpdateTime = 0;
    

    public BrickLayout(String inputFile) {
        ArrayList<String> fileData = getFileData("C:/Users/shaya/Downloads/Programs, Java + Python/data");
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        grid = new int[30][40];
        i = 0;
       
    }

    public int[][] getGrid() {
        return grid;
    }

    public void dropOneBrick(int row) { //part 1
        boolean taken = false;
        for (int c = bricks.get(i).getStart(); c < bricks.get(i).getEnd() + 1; c++) {
           if (grid[row][c] == 1) { 
            taken = true;
            break;
            
        } 
    }
    if (taken) {
        dropOneBrick(row - 1); //i felt that i did not understand recursion that well, however
    } // while writing this, it just felt very natural to use recursion here. 
    if (!taken) {
        for (int c = bricks.get(i).getStart(); c < bricks.get(i).getEnd() + 1; c++) {
           grid[row][c - 1] = 1;
        }
        bricks.get(i).setRow(row);
        i++;
    }
}

public void fallingBricks(int i) {
    //despite a lot of attempts i haven't been able to get this to work, so i am leaving it at part 1.
}

    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }
}
