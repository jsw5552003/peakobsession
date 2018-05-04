package peak.app.view;

import java.util.HashMap;
import java.util.Map;

public class UserMountainGridView {
	
	UserMountainListView [] grid;
	
	int [] mountainTotals;
	
	int [] monthTotals;
	
    int[] roundTotals;

    int totalComplete;

    Map<String, Integer> yearTotals;

	public UserMountainGridView(UserMountainListView[] inputGrid)
	{
		this.grid = inputGrid;
		this.monthTotals = new int[12];
		this.mountainTotals = new int[grid[0].getMountains().size()];
        this.roundTotals = new int[13];
        this.yearTotals = new HashMap<>();
		
		for(int i = 0; i < grid.length; i++ )
		{
			for(int j = 0; j < grid[i].getMountains().size(); j++)
			{
				if(grid[i].getMountains().get(j).isCompleted())
				{
					mountainTotals[j]++;
					monthTotals[i]++;
                    totalComplete++;
                    // update the year totals
                    String year = grid[i].getMountains().get(j).getYear();
                    int count = yearTotals.containsKey(year) ? yearTotals.get(year) : 0;
                    yearTotals.put(year, count + 1);
				}
			}
		}
        // now use the mountain totals to get round totals
        for (int i = 0; i < mountainTotals.length; i++)
        {
            roundTotals[mountainTotals[i]]++;
        }
	}

    public int getTotalComplete()
    {
        return totalComplete;
    }

    public int getTotalNeeded()
    {
        return grid[0].mountains.size() * 12;
    }

    public int getPercentComplete()
    {
        if (this.getTotalComplete() == 0)
        {
            System.out.println("PERCENT IS 0");
            return 0;
        }
        else
        {
            return Math.round(this.getTotalComplete() / (float) getTotalNeeded() * 100);
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

    public int[] getRoundTotals()
    {
        return roundTotals;
    }

    public Map<String, Integer> getYearTotals()
    {
        return yearTotals;
    }

 
}
