package org.summa;

import javax.swing.*;
import java.awt.*;


public class Form extends JFrame {
    private int numA = 1;
    private int numB = 2;
    private final JTextField aNumField = new JFormattedTextField(Integer.toString(numA));
    private final JTextField bNumField = new JFormattedTextField(Integer.toString(numB));
    private final JLabel resultLabel = new JLabel();
    private final ErrorDialog dialog = new ErrorDialog(this);

    Form() {
        super("Sum of divisors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel(new GridLayout(3, 2, 15, 20));

        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(e -> setNumbers());

        pane.add(aNumField);
        pane.add(new JLabel("Enter the number A (A < B)"));
        pane.add(bNumField);
        pane.add(new JLabel("Enter the number B (A < B)"));
        pane.add(resultLabel);
        pane.add(calculate);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flow.add(pane);
        add(flow);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setNumbers() {
        try {
            resultLabel.setText("");
            numA = Integer.parseInt(aNumField.getText());
            numB = Integer.parseInt(bNumField.getText());
            if (numA < 1 | numB < 1) {
                dialog.dispatchMessage("Unnatural number entered !");
            } else if (numA >= numB) {
                dialog.dispatchMessage("(A >= B) !");
            } else calculateSum();
        } catch (NumberFormatException err) {
            dialog.dispatchMessage("Incorrect input format !");
        }
    }

    private void calculateSum() {
        int num = 0;
        int sum = 0;
        for (int i = numA; i <= numB; i++) {
            int currentSum = calcSumDivisors(i);
            if (currentSum > sum) {
                sum = currentSum;
                num = i;
            }
        }
        resultLabel.setText("Num/Sum: " + num + " " + sum);
    }

    private int calcSumDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
            if ((number % i) == 0) sum += i;
        }
        return sum;
    }
}