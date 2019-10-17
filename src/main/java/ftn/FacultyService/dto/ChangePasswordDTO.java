package ftn.FacultyService.dto;

public class ChangePasswordDTO {

	private String oldPassword;
	private String newPassword;
	private String userEmail;
	
	public ChangePasswordDTO() {
	}

	public ChangePasswordDTO(String oldPassword, String newPassword, String userEmail) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
