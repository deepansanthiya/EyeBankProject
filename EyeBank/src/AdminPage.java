import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminPage  extends JDialog{
    private JButton accecptButton;
    private JButton eyeButton;
    private JButton patientButton;

    private JPanel AdminPanel;
    private JTextField textField1;
    private JTextField textField2;




    public AdminPage(JFrame Parent) {
        super(Parent);
        setTitle("Admin Page");
        setContentPane(AdminPanel);
        setMinimumSize(new Dimension(500,400));
        setModal(true);
        setLocationRelativeTo(Parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        eyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Patient(null);


            }
        });
        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new showDonor(null);


            }
        });



        accecptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                join(textField1.getText(),textField2.getText());
            }
        });
        setVisible(true);
    }
public void join(String a,String b)
{
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM patientreg WHERE id = "+a);
        st.executeUpdate("DELETE FROM donorloginpage WHERE id = "+b);
        JOptionPane.showMessageDialog(this,"Donated Successfully","successfully done",JOptionPane.INFORMATION_MESSAGE);

    } catch (ClassNotFoundException ex) {
        throw new RuntimeException(ex);
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }

}
    public static void main(String[] args) {
        AdminPage a=new AdminPage(null);


    }
}
