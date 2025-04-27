import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagazzinoGUI {
    public static void main(String[] args) {
        // Creazione della finestra principale
        JFrame frame = new JFrame("Gestione Magazzino");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Creazione del pannello principale
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tabella per visualizzare le scorte
        String[] columns = {"ID", "Nome Prodotto", "Quantità"};
        String[][] data = {
            {"1", "Prodotto A", "10"},
            {"2", "Prodotto B", "20"},
            {"3", "Prodotto C", "15"}
        };
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Pannello per i controlli
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JTextField productField = new JTextField(10);
        JTextField quantityField = new JTextField(5);
        JButton addButton = new JButton("Aggiungi");
        JButton removeButton = new JButton("Rimuovi");

        controlPanel.add(new JLabel("Prodotto:"));
        controlPanel.add(productField);
        controlPanel.add(new JLabel("Quantità:"));
        controlPanel.add(quantityField);
        controlPanel.add(addButton);
        controlPanel.add(removeButton);

        panel.add(controlPanel, BorderLayout.SOUTH);

        // Azioni dei pulsanti
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prodotto = productField.getText();
                String quantita = quantityField.getText();
                if (!prodotto.isEmpty() && !quantita.isEmpty()) {
                    ((DefaultTableModel) table.getModel()).addRow(new Object[]{table.getRowCount() + 1, prodotto, quantita});
                    productField.setText("");
                    quantityField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Inserisci tutti i dati!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleziona una riga da rimuovere!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Aggiunta del pannello alla finestra
        frame.add(panel);
        frame.setVisible(true);
    }
}