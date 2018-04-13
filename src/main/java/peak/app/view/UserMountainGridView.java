package peak.app.view;

public class UserMountainGridView extends UserMountainListView {

    private String[][] grid;

    public String[][] getGrid()
    {
        return grid;
    }

    public void setGrid(String[][] grid)
    {
        this.grid = grid;
    }

    public String getComplete(int x, int y)
    {
        return grid[x][y];
    }

    public void setComplete(int x, int y, String year)
    {
        grid[x][y] = year;
    }

}
