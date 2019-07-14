package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import com.lux.calculator.listener.ClearHistoryButtonListener;

class HistoryComposite extends Composite {

    private static final String CLEAR = "Clear";
    private List listResults;
    private Button btnClear;

    public HistoryComposite(Composite parent) {
        super(parent, SWT.NONE);
        createContent(parent);
        initListener();
    }

    private void createContent(Composite parent) {
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        setLayout(new GridLayout(1, false));
        setBackground(parent.getShell()
                            .getBackground());

        listResults = new List(this, SWT.V_SCROLL | SWT.BORDER);
        listResults.setLayoutData(new GridData(240, 210));

        btnClear = new Button(this, SWT.PUSH);
        btnClear.setText(CLEAR);
        GridData gridData = new GridData(GridData.END, GridData.CENTER, false, false);
        btnClear.setLayoutData(gridData);
    }

    private void initListener() {
        btnClear.addListener(SWT.Selection, new ClearHistoryButtonListener());
    }

    public void addStatementToHistory(String statement) {
        listResults.add(statement);
    }

    public void clearHistory() {
        listResults.removeAll();
    }
}
