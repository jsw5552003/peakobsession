package peak.app.view;

import java.util.List;

public class LeaderBoardView {

    List<LeaderBoardEntryView> monthlyLeaders;

    List<LeaderBoardEntryView> yearlyLeaders;

    List<LeaderBoardEntryView> allTimeLeaders;

    public List<LeaderBoardEntryView> getMonthlyLeaders() {
        return monthlyLeaders;
    }

    public void setMonthlyLeaders(List<LeaderBoardEntryView> monthlyLeaders) {
        this.monthlyLeaders = monthlyLeaders;
    }

    public List<LeaderBoardEntryView> getYearlyLeaders() {
        return yearlyLeaders;
    }

    public void setYearlyLeaders(List<LeaderBoardEntryView> yearlyLeaders) {
        this.yearlyLeaders = yearlyLeaders;
    }

    public List<LeaderBoardEntryView> getAllTimeLeaders() {
        return allTimeLeaders;
    }

    public void setAllTimeLeaders(List<LeaderBoardEntryView> allTimeLeaders) {
        this.allTimeLeaders = allTimeLeaders;
    }

}
