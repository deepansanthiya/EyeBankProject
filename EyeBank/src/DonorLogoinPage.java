import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DonorLogoinPage extends JDialog {


    private JPasswordField passwordField1;
    private JButton cancelButton;
    private JButton loginButton;
    private JPanel donorpan;
    private JTextField textField2;
    private JButton indexButton;


    public DonorLogoinPage(JFrame Parent) {
        super(Parent);
        setTitle("AdminLoginPage");
        setContentPane( donorpan);
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
                new IndexPage(null);
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
        String i = textField2.getText();
        int ii = 0;
        String te = String.valueOf(passwordField1.getPassword());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from DonorLoginPage where id='" +i+"' and Donarname='" + te + "'");
        while (rs.next()) {
            ii++;
        }
        if (ii == 0) {
            System.out.println("unsuccess");
        } else if (ii > 0) {
            int id1= Integer.parseInt(te);
            setVisible(false);
            new DonorPage(null,id1);

        }

    }

    public static void main(String[] args) {
        DonorLogoinPage d=new DonorLogoinPage(null);

    }
    }


