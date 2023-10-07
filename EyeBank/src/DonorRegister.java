import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DonorRegister extends JDialog{
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    private JPanel DRpanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton indexButton;


    public DonorRegister(JFrame parent) {
        super(parent);
        setTitle("Customer Login");
        setContentPane(DRpanel);
        setMinimumSize(new Dimension(500, 404));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    alogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });






        indexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IndexPage(null);
            }
        });
        setVisible(true);
    }

    private void alogin() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        st.executeUpdate("insert into DonorLoginPage (donarname,donarage,eye,bp,sugar,power)values('"+textField1.getText()+"',"+textField2.getText()+",'"+comboBox1.getSelectedItem()+"','"+comboBox3.getSelectedItem()+"','"+comboBox4.getSelectedItem()+"','"+comboBox2.getSelectedItem()+"')");

    }

    public static void main(String[] args) {
        new DonorRegister(null);
    }

}
