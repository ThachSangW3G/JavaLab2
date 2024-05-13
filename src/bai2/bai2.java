package bai2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class bai2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bai 2");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);

        JLabel label = new JLabel("Vui lòng nhấn một phím bất kỳ");
        panel.add(label);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                JOptionPane.showMessageDialog(frame, "Bạn đã nhấn phím " + keyChar + " (với mã là " + keyCode + ")");
            }
        });
    }
}
