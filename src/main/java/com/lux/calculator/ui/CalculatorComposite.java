package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

class CalculatorComposite extends Composite {

    private static final String TITLE_CALCULATOR = "Calculator";
    private static final String TITLE_HISTORY = "History";

    private CTabFolder tabFolder;
    private CTabItem tabItemCalc;
    private CTabItem tabItemHistory;

    private MathOperationComposite mathOperationPanel;
    private HistoryComposite historyPanel;

    public CalculatorComposite(Composite parent) {
        super(parent, SWT.BORDER);
        createContent(parent);
    }

    private void createContent(Composite parent) {

        tabFolder = new CTabFolder(parent, SWT.BORDER);
        tabFolder.setLayout(new GridLayout(1, true));
        tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

        mathOperationPanel = new MathOperationComposite(tabFolder);

        tabItemCalc = new CTabItem(tabFolder, SWT.NONE);
        tabItemCalc.setText(TITLE_CALCULATOR);
        tabItemCalc.setControl(mathOperationPanel);

        historyPanel = new HistoryComposite(tabFolder);

        tabItemHistory = new CTabItem(tabFolder, SWT.NONE);
        tabItemHistory.setText(TITLE_HISTORY);
        tabItemHistory.setControl(historyPanel);

        tabFolder.pack();
    }

    public MathOperationComposite getMathOperationPanel() {
        return mathOperationPanel;
    }

    public HistoryComposite getHistoryPanel() {
        return historyPanel;
    }
}
