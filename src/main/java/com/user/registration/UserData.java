package com.user.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
	private String employeeId;
	private String caste;
	private String dateOfJoining;
	private String employeeName;
	private String subCaste;
	private String employeeFatherName;
	private Double thriftDeposit;
}
