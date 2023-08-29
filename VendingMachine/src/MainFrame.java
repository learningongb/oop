import Domen.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainFrame extends JFrame {
    
    
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfCoins, tfIndex;
    
    
    JLabel lbWelcome;

    public void initialize(List<Product> assort) {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.GRAY);
        JLabel l1 = new JLabel();
        l1.setText("Здесь могла быть ваша реклама");
        p1.add(l1);

        JPanel p3 = new JPanel(new BorderLayout());
        JLabel l3 = new JLabel();
        l3.setText("Доступные товары");
        p3.add(l3, BorderLayout.NORTH);

        Box b1 = Box.createVerticalBox();
        int i=1;
        for (Product product : assort) {
            b1.add(new JLabel((i++) + " - " + product.getDescription() + " = " + product.getPrice() + " р."));
        }
        p3.add(b1);

        getContentPane().add(p1, BorderLayout.NORTH);
        getContentPane().add(controlPanel(assort), BorderLayout.EAST);
        getContentPane().add(p3);
        setSize(600, 600);
        setTitle("VendingMachines");
        setVisible(true);
    }

    private JComponent controlPanel(List<Product> assort) {
        Box mainBox = Box.createVerticalBox();
        JLabel label1 = new JLabel();
        label1.setFont(mainFont);
        label1.setText("Введите сумму");
        mainBox.add(label1);

        tfCoins = new JTextField();
        tfCoins.setFont(mainFont);
        tfCoins.setMaximumSize(new Dimension(160, 250));
        mainBox.add(tfCoins);

        JLabel label2 = new JLabel();
        label2.setFont(mainFont);
        label2.setText("Введите номер товара");
        mainBox.add(label2);

        tfIndex = new JTextField();
        tfIndex.setFont(mainFont);
        tfIndex.setMaximumSize(new Dimension(160, 250));
        mainBox.add(tfIndex);

        JButton btnOk = new JButton("Выдать товар");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int coin, index;
                try {
                    coin = Integer.parseInt(tfCoins.getText());
                } catch (Exception excp) {
                    tfCoins.setText("");
                    return;
                }
                try {
                    index = Integer.parseInt(tfIndex.getText());
                } catch (Exception excp) {
                    tfIndex.setText("");
                    return;
                }

                if (index > assort.size() || index < 1) {
                    showMessageDialog(null, "Введен не правильный номер товара");
                } else {
                    Product currentProduct = assort.get(index - 1);
                    if (coin < currentProduct.getPrice()) {
                        showMessageDialog(null, "Недостаточно средств");
                    } else {
                        int change = coin - currentProduct.getPrice();
                        showMessageDialog(null, String.format("Выдан товар\n%s\nСдача: %d", currentProduct, change));
                    }
                }


            }

        });
        mainBox.add(btnOk);

        mainBox.add(Box.createVerticalGlue());

        return mainBox;

    }

}
