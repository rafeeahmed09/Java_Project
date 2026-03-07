import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dome extends JFrame {

    // Components
    private JTextField nameField, phoneField;
    private JButton addButton, deleteButton;
    private JTable contactTable;
    private DefaultTableModel tableModel;

    public Dome() {
        // Setup Window
        setTitle("Contact Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- TOP PANEL: Input Fields ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        // --- CENTER PANEL: Table ---
        String[] columns = {"Name", "Phone Number"};
        tableModel = new DefaultTableModel(columns, 0);
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // --- BOTTOM PANEL: Buttons ---
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Contact");
        deleteButton = new JButton("Delete Selected");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Action Listeners ---

        // Add Contact Logic
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String phone = phoneField.getText().trim();

                if (!name.isEmpty() && !phone.isEmpty()) {
                    tableModel.addRow(new Object[]{name, phone});
                    nameField.setText("");
                    phoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            }
        });

        // Delete Contact Logic
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a contact to delete.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new Dome().setVisible(true);
        });
    }
}