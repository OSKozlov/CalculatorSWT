package com.lux.calculator.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CalculatorApp {
	
	private static final String TITLE_OF_APP = "SWT Calculator";
	
	public static void main(String[] args) {

	  Display display = new Display();
	  Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );
		shell.setText(TITLE_OF_APP);
		
		GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		
		AbstractCalculator calculator = new Calculator();
		calculator.runUI(shell);

		shell.setLocation(750, 200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
}
