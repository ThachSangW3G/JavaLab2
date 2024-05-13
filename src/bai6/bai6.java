package bai6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class bai6 extends JFrame implements ActionListener {
    private JList<String> categoryList;
    private JButton submitButton;

    public bai6() {
        setTitle("Bai 6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        String[] categories = {"Văn học", "Khoa học", "Lịch sử", "Công nghệ", "Thể thao", "Văn hóa"};
        categoryList = new JList<>(categories);
        categoryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(categoryList);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            List<String> selectedCategories = categoryList.getSelectedValuesList();
            if (selectedCategories.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một thể loại sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder message = new StringBuilder("Các thể loại sách bạn đã chọn:\n");
                for (String category : selectedCategories) {
                    message.append("- ").append(category).append("\n");
                }
                JOptionPane.showMessageDialog(this, message.toString(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new bai6().setVisible(true);
            }
        });
    }
}
