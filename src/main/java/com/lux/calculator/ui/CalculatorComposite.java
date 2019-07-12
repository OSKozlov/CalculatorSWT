package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.lux.calculator.app.Main;

public class CalculatorComposite extends Composite {

	private static final String TITLE_CALCULATOR = "Calculator";
	private static final String TITLE_HISTORY = "History";

	private CTabFolder tabFolder;
	private CTabItem tabItemCalc;
	private CTabItem tabItemHistory;
	
	private MathOperationComposite mathOperationPanel;
	private HistoryComposite historyPanel;
	
	private static CalculatorComposite instance;

	private CalculatorComposite(Composite parent) {
		super(parent, SWT.BORDER);		
		createContent(parent);
	}
	
	public static CalculatorComposite getInstance() {
		if (instance == null)
            instance = new CalculatorComposite(Main.getShell());
        return instance;
	}
	
	private void createContent(Composite parent) {
		tabFolder=new CTabFolder(CalculatorComposite.this, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(1,false);
		tabFolder.setLayout(gridLayout);
		
		GridData gridData = new GridData(SWT.FILL,SWT.FILL,true,true);
		tabFolder.setLayoutData(gridData);
		tabFolder.setSize(280, 280);

		mathOperationPanel = new MathOperationComposite(tabFolder);
		
		tabItemCalc=new CTabItem(tabFolder,SWT.NONE);
		tabItemCalc.setText(TITLE_CALCULATOR);
		tabItemCalc.setControl(mathOperationPanel);
	
		
		historyPanel = new HistoryComposite(tabFolder);
		
		tabItemHistory=new CTabItem(tabFolder,SWT.NONE);
		tabItemHistory.setText(TITLE_HISTORY);
		tabItemHistory.setControl(historyPanel);
	}

	public MathOperationComposite getMathOperationPanel() {
		return mathOperationPanel;
	}

	public HistoryComposite getHistoryPanel() {
		return historyPanel;
	}
}
