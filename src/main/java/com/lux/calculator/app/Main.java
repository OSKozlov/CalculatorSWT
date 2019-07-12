package com.lux.calculator.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.ui.CalculatorComposite;

public class Main {
	
	private static final String TITLE_OF_APP = "SWT Calculator";
	
	private static Display display;
	private static Shell shell;
	
	static {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );
	}
	
	public static void main(String[] args) {

		shell.setText(TITLE_OF_APP);
		
		GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		
		CalculatorComposite mainPanel = CalculatorComposite.getInstance();

		shell.setLocation(750, 200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	public static Shell getShell() {
		return shell;
	}
}
