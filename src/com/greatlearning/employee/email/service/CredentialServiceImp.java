package com.greatlearning.employee.email.service;

import java.util.Random;

import com.greatlearning.employee.email.model.Employee;

public class CredentialServiceImp implements CredentialService{
	private static final String COMPANY_Domain = "gl.in";
	private static final int PASSWORD_SIZE = 8;

	@Override
	public String generateEmailAddress(Employee employee) {
		// TODO Auto-generated method stub
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String department = employee.getDepartment();

		return firstName+lastName+"@"+department+"."+COMPANY_Domain;
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		String capitalCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallCase = capitalCase.toLowerCase();	//"abc...z";
		//String smallCase = "abcdefghijklmnopqrstuvwxyz"; //We can also do this

		String nums = "0123456789";
		String splChars = "!@#$%^&*()";

		String passwordChars = capitalCase+smallCase+nums+splChars;

		String password = "";

		Random random = new Random();
		for(int i=0; i<PASSWORD_SIZE; i++) {
			password = password+ passwordChars.charAt(random.nextInt(passwordChars.length()));
		}
		return password;
	}

	@Override
	public String showCredentials(Employee employee) {

		System.out.println("Dear "+ employee.getFirstName()+ " your generated credentials are as follows");
		System.out.println("Email    ---> "+ employee.getEmailAddress());
		System.out.println("Password ---> "+ employee.getPassword());
		return null;
	}

}
