import java.util.ArrayList;

public class Brick {
    private int start;
    private int end;
    private int row;

    public Brick(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }
    public ArrayList<Integer> getPoints() {
        ArrayList<Integer> points = new ArrayList<>();
        int point = this.start;
        while (point < this.end) {
            points.add(point);
            point ++;
        }
        return points;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getEnd() {
        return end;
    }
    
    public int getRow() {
        return row;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return "Start: " + start + " --- End: " + end;
    }
}
