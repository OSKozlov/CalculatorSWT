package com.lux.calculator.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.lux.calculator.listener.CalculateButtonListener;
import com.lux.calculator.listener.CheckBoxSelectionListener;
import com.lux.calculator.listener.FirstOperandModifyListener;
import com.lux.calculator.listener.MathOperatorListener;
import com.lux.calculator.listener.OperandVerifyListener;
import com.lux.calculator.listener.SecondOperandModifyListener;
import com.lux.calculator.operation.MathOperationType;

class MathOperationComposite extends Composite {

    private static final String RESULT = "Result:";
    private static final String CALCULATE = "Calculate";
    private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

    private static final Map<String, String> items = new HashMap() {
        {
            put(MathOperationType.ADDITION.getOperationSign(), MathOperationType.ADDITION.getValue());
            put(MathOperationType.SUBTRACTION.getOperationSign(), MathOperationType.SUBTRACTION.getValue());
            put(MathOperationType.MULTIPLICATION.getOperationSign(), MathOperationType.MULTIPLICATION.getValue());
            put(MathOperationType.DIVISION.getOperationSign(), MathOperationType.DIVISION.getValue());
        }
    };

    private Text firstNumber;
    private Text secondNumber;
    private Text textResult;

    private Label labelCalcOnTheFly;
    private Label labelResult;

    private Combo mathOperationCombo;

    private Button checkBoxOnFlyMode;
    private Button btnCalculate;

    public MathOperationComposite(Composite parent) {
        super(parent, SWT.NONE);

        createContent(parent);
        initListeners();
    }

    private void createContent(Composite parent) {

        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout gridLayout = new GridLayout(3, false);
        gridLayout.verticalSpacing = 85;
        gridLayout.horizontalSpacing = 18;
        setLayout(gridLayout);
        setBackground(parent.getShell()
                            .getBackground());

        firstNumber = new Text(this, SWT.BORDER);

        mathOperationCombo = new Combo(this, SWT.DROP_DOWN);
        mathOperationCombo.setItems(items.keySet()
                                         .stream()
                                         .toArray(String[]::new));
        GridData gridData = new GridData(GridData.CENTER, GridData.FILL, false, false);
        gridData.widthHint = 50;
        gridData.heightHint = 5;
        gridData.minimumHeight = 200;
        mathOperationCombo.setLayoutData(gridData);

        secondNumber = new Text(this, SWT.BORDER);

        checkBoxOnFlyMode = new Button(this, SWT.CHECK);

        labelCalcOnTheFly = new Label(this, SWT.NONE);
        labelCalcOnTheFly.setText(CALCULATE_ON_THE_FLY);
        gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
        gridData.horizontalIndent = -70;
        gridData.verticalIndent = 4;
        labelCalcOnTheFly.setLayoutData(gridData);

        btnCalculate = new Button(this, SWT.PUSH);
        btnCalculate.setText(CALCULATE);
        gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
        gridData.horizontalIndent = 10;
        gridData.minimumWidth = 50;
        gridData.minimumHeight = 5;
        btnCalculate.setLayoutData(gridData);

        labelResult = new Label(this, SWT.NONE);
        labelResult.setText(RESULT);

        textResult = new Text(this, SWT.BORDER);
        gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
        gridData.horizontalSpan = 2;
        textResult.setLayoutData(gridData);
    }

    private void initListeners() {
        firstNumber.addModifyListener(new FirstOperandModifyListener());
        firstNumber.addListener(SWT.Verify, new OperandVerifyListener());
        secondNumber.addModifyListener(new SecondOperandModifyListener());
        secondNumber.addListener(SWT.Verify, new OperandVerifyListener());
        mathOperationCombo.addSelectionListener(new MathOperatorListener());
        checkBoxOnFlyMode.addSelectionListener(new CheckBoxSelectionListener());
        btnCalculate.addListener(SWT.Selection, new CalculateButtonListener());
    }

    /**
     * This method update result field in calculator.
     * 
     * @param text
     */
    public void updateResultField(String text) {
        textResult.setText(text);
    }

}
