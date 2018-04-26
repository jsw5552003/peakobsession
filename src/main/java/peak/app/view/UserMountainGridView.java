package peak.app.view;

public class UserMountainGridView {
	
	UserMountainListView [] grid;
	
	int [] mountainTotals;
	
	int [] monthTotals;
	
	public UserMountainGridView(UserMountainListView[] inputGrid)
	{
		this.grid = inputGrid;
		this.monthTotals = new int[12];
		this.mountainTotals = new int[grid[0].getMountains().size()];
		
		for(int i = 0; i < grid.length; i++ )
		{
			for(int j = 0; j < grid[i].getMountains().size(); j++)
			{
				if(grid[i].getMountains().get(j).isCompleted())
				{
					mountainTotals[j]++;
					monthTotals[i]++;
				}
			}
		}
	}

	public UserMountainListView[] getGrid() {
		return grid;
	}

	public int[] getMountainTotals() {
		return mountainTotals;
	}

	public int[] getMonthTotals() {
		return monthTotals;
	}

 
}
