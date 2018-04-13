package peak.app.model;

import java.time.LocalDate;

public class UserMountain {

    Mountain mountain;

    LocalDate date;

    public UserMountain(Mountain mountain, LocalDate date)
    {
        if (mountain == null)
            throw new IllegalArgumentException();
        this.mountain = mountain;
        this.date = date;
    }

    public Mountain getMountain()
    {
        return mountain;
    }

    public void setMountain(Mountain mountain)
    {
        this.mountain = mountain;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    @Override
    public boolean equals(Object userMountain)
    {
        if (userMountain != null && userMountain instanceof UserMountain)
        {
            if (((UserMountain) userMountain).getMountain().equals(this.getMountain()))
                return true;
        }
        return false;
    }

}
