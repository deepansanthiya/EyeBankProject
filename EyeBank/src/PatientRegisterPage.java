import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientRegisterPage extends JDialog{
    private JTextField textField2;
    private JTextField textField1;
    private JPanel RegPanel;
    private JButton submitButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton indexButton;


    public PatientRegisterPage(JFrame Parent) {
        super(Parent);
        setTitle("AdminLoginPage");
        setContentPane(RegPanel);
        setMinimumSize(new Dimension(500,400));
        setModal(true);
        setLocationRelativeTo(Parent);
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
        st.executeUpdate("insert into patientreg (patientname,patientage,eye,bp,sugar,power) values('"+textField2.getText()+"',"+textField1.getText()+",'"+comboBox4.getSelectedItem()+"','"+comboBox2.getSelectedItem()+"','"+comboBox3.getSelectedItem()+"','"+comboBox1.getSelectedItem()+"')");

    }

    public static void main(String[] args) {
        PatientRegisterPage p=new PatientRegisterPage(null);

    }

}

