import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminLoginPage extends JDialog {
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel FirstPanel;
    private JButton indexButton;


    public AdminLoginPage (JFrame Parent) {
        super(Parent);
        setTitle("AdminLoginPage");
        setContentPane(FirstPanel);
        setMinimumSize(new Dimension(500,400));
        setModal(true);
        setLocationRelativeTo(Parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




        loginButton.addActionListener(new ActionListener() {
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
                aindex();
            }
        });
        setVisible(true);
    }
    private void aindex() {
        setVisible(false);
        new IndexPage(null);
    }

    private void alogin() throws SQLException, ClassNotFoundException {
        String i = textField1.getText();
        int ii = 0;
        String te = String.valueOf(passwordField1.getPassword());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from admin where name='" + i + "' and pass='" + te + "'");
        while (rs.next()) {
            ii++;
        }
        if (ii == 0) {
            System.out.println("unsuccess");
        } else if (ii > 0) {
            setVisible(false);
            new AdminPage(null);
        }
    }





    public static void main(String[] args) {
        AdminLoginPage a=new AdminLoginPage(null);

    }

}








