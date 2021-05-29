package org.summa;

import javax.swing.*;


public class ErrorDialog extends JDialog {
    private final JLabel label = new JLabel("", SwingConstants.CENTER);

    ErrorDialog(JFrame root) {
        super(root);
        setTitle("Error");
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 100);
        add(label);
    }

    public void dispatchMessage(String message) {
        label.setText(message);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
