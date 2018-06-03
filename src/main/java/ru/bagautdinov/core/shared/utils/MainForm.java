package ru.bagautdinov.core.shared.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import ru.bagautdinov.core.shared.model.MathOperation;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.validation.client.impl.Validation;

public class MainForm {
	
	private TextBox numberInput;
	private ListBox functionInput;
	private Button sendButton;
	private ListBox historyBox;
	private Label errorOutput;
	
	public MainForm() {
		this.numberInput = new TextBox();		
		this.functionInput = new ListBox();
		this.sendButton = new Button("Submit");
		this.errorOutput = new Label();
		this.historyBox = new ListBox();
	}
	
	public void addToPanel(RootPanel root) {
		root.add(this.numberInput);
		root.add(this.functionInput);
		root.add(this.sendButton);
		root.add(historyBox);
		root.add(this.errorOutput);
	}
	
	public MathOperation acquire() {
		MathOperation mo = new MathOperation();
		mo.setFunction(functionInput.getSelectedValue());
		mo.setNumber(numberInput.getValue());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<MathOperation>> violations = validator.validate(mo);
		if (!violations.isEmpty()) {
			throw new RuntimeException("Violation of validation: " + violations.toString());
		}
		return mo;
	}
	
	public Label getErrorOutput() {
		return errorOutput;
	}
	
	public ListBox getFunctionInput() {
		return functionInput;
	}
	
	public ListBox getHistoryBox() {
		return historyBox;
	}
	
	public TextBox getNumberInput() {
		return numberInput;
	}
	
	public Button getSendButton() {
		return sendButton;
	}
	
}
