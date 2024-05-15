import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {
    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public JButton addButton;

    public StudentsPanel() {
        init();
    }

    private void init() {
        studentsTableModel = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);

        studentIDLabel = new JLabel("Student ID:");
        nameLabel = new JLabel("Name:");
        studentIDField = new JTextField(10);
        nameField = new JTextField(10);
        addButton = new JButton("ADD");

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(studentIDLabel);
        inputPanel.add(studentIDField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(studentsTable), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIDField.getText();
                String name = nameField.getText();

                if (!id.isEmpty() && !name.isEmpty()) {
                    studentsTableModel.addStudent(new Student(id, name));
                    studentIDField.setText("");
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both ID and Name");
                }
            }
        });
    }
}
