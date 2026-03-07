package Medical_Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Professional GUI for Medical Store Management
 * Integrates with Medical_Services to manage Customers and Medicines.
 */
public class MedicalStoreGUI extends JFrame {

    // UI Components
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MedicalStoreGUI() {
        setupWindow();
        createSidebar();
        createMainPanel();
        setVisible(true);
    }

    private void setupWindow() {
        setTitle("PharmaCare | Professional Medical Management");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.setBackground(new Color(44, 62, 80)); // Professional Dark Blue
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton btnMedicines = createSidebarButton("Medicines Stock");
        JButton btnCustomers = createSidebarButton("Customer List");
        JButton btnAddCust = createSidebarButton("Add Customer");
        JButton btnAddDelete = createSidebarButton("Delete Customer");

        btnMedicines.addActionListener(e -> loadMedicinesView());
        btnCustomers.addActionListener(e -> loadCustomersView());
        btnAddCust.addActionListener(e -> showAddCustomerDialog());
        btnAddDelete.addActionListener(e -> showAddCustomerDialog());

        sidebar.add(btnMedicines);
        sidebar.add(btnCustomers);
        sidebar.add(btnAddCust);
        sidebar.add(btnAddDelete);

        add(sidebar, BorderLayout.WEST);
    }

    private JButton createSidebarButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(52, 73, 94));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return btn;
    }

    private void createMainPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Data Table View
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        dataTable.setRowHeight(25);
        dataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(dataTable);
        cardPanel.add(scrollPane, "TableView");

        add(cardPanel, BorderLayout.CENTER);
    }

    // --- Backend Integration Logic ---

    private void loadCustomersView() {
        tableModel.setColumnIdentifiers(new String[]{"ID", "Customer Name", "Phone Number"});
        tableModel.setRowCount(0);

        try {
            Medical_Services service = new Medical_Services();
            List<Customers> list = service.getviewALL(); // Uses your existing getviewALL method
            for (Customers c : list) {
                tableModel.addRow(new Object[]{c.getId(), c.getName(), c.getPhone()});
            }
            cardLayout.show(cardPanel, "TableView");
        } catch (SQLException e) {
            showError("Database Error: " + e.getMessage());
        }
    }

    private void showAddCustomerDialog() {
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        Object[] message = {
                "Customer Name:", nameField,
                "Phone:", phoneField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add New Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Uses your Customers constructor: Customers(id, name, phone)
            Customers newCust = new Customers(0, nameField.getText(), phoneField.getText());
            Medical_Services.AddCustomers(newCust); // Calls your existing static method
            JOptionPane.showMessageDialog(this, "Customer Added Successfully!");
            loadCustomersView();
        }
    }

    private void loadMedicinesView() {
        tableModel.setColumnIdentifiers(new String[]{"ID", "Medicine", "Price", "Stock"});
        tableModel.setRowCount(0);
        // Medicine loading logic would follow similar pattern using Medicines class
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Initialize DB Tables using your existing method
        Medical_Services.createTable();

        // Launch UI
        SwingUtilities.invokeLater(() -> new MedicalStoreGUI());
    }
}