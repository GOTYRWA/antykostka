import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class SettingsGuiScreen extends JFrame {  
    private JPanel panel;  
    private JButton[] itemButtons;  
    private JLabel titleLabel;  

    public SettingsGuiScreen() {  
        setTitle("Hotbar Items Configuration");  
        setSize(400, 300);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setLocationRelativeTo(null);  

        panel = new JPanel();  
        panel.setLayout(new BorderLayout());  

        titleLabel = new JLabel("Configure Your Hotbar Items", SwingConstants.CENTER);  
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));  
        panel.add(titleLabel, BorderLayout.NORTH);  

        itemButtons = new JButton[9];  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setLayout(new GridLayout(3, 3));  

        for (int i = 0; i < itemButtons.length; i++) {  
            itemButtons[i] = new JButton("Item " + (i + 1));  
            itemButtons[i].addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    JButton source = (JButton) e.getSource();  
                    // Handle item configuration here  
                    JOptionPane.showMessageDialog(null, source.getText() + " clicked.");  
                }  
            });  
            buttonPanel.add(itemButtons[i]);  
        }  

        panel.add(buttonPanel, BorderLayout.CENTER);  
        add(panel);  
    }  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            SettingsGuiScreen frame = new SettingsGuiScreen();  
            frame.setVisible(true);  
        });  
    }  
}