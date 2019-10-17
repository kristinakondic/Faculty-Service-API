package ftn.FacultyService.dto;

public class MessageDTO {
	private String message;
    private boolean success = false;

    public MessageDTO() {
    }

    public MessageDTO(String message) {
        this.message = message;
        this.success = true;
    }
    public MessageDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    
    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
