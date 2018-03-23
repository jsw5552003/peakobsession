package peak.app.view;

public class StatusMessage {
    
    private String message;
    private boolean success;
    
    public StatusMessage() {}
    
    
    public StatusMessage(String message, boolean success)
    {
        super();
        this.message = message;
        this.success = success;
    }
    
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public boolean isSuccess()
    {
        return success;
    }
    public void setSuccess(boolean success)
    {
        this.success = success;
    }
    
    

}
