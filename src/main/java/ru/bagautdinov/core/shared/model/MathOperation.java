package ru.bagautdinov.core.shared.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class MathOperation implements Serializable {

	private static final long serialVersionUID = 589493082290302848L;

	@NotNull(message = "Not empty or null!")
	@Pattern(regexp = "^-?[0-9]+\\.?[0-9]*$", message = "Must be a number!")
	private String number;

	@NotNull(message = "Not empty or null!")
	@Size(max = 1, message = "Must be 1 sized.")
	@Pattern(regexp="^(-|\\+|\\*|/|=)$", message="You have to use these: +, -, *, /, =")
	private String function;
	
	public void setFunction(String function) {
		this.function = function;
	}
	public String getFunction() {
		return function;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "(" + number + ", " + function + ")";
	}
	
}

