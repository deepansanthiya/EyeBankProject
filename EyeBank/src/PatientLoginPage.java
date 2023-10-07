import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientLoginPage extends  JDialog {
    private JPasswordField passwordField1;
    private JButton loginButton;

    private JPanel PLPanel;
    private JTextField textField2;
    private JButton cancelButton;
    private JButton indexButton;

    public PatientLoginPage(JFrame parent) {

        super(parent);
        setTitle("Customer Login");
        setContentPane(PLPanel);
        setMinimumSize(new Dimension(500, 404));
        setModal(true);
        setLocationRelativeTo(parent);
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
                setVisible(false);
                new IndexPage(null);
            }
        });
        setVisible(true);
    }

    private void alogin() throws SQLException, ClassNotFoundException {
        String i= textField2.getText();
        int ii=0;
        String te=String.valueOf(passwordField1.getPassword());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EyeBank" ,"root", "livewire");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from patientReg where id='"+i+"' and patientname='"+te+"'");
        while(rs.next()){
            ii++;
        }
        if(ii==0){
            System.out.println("unsuccess");
        } else if (ii>0) {
            int id1= Integer.parseInt(i);
            setVisible(false);
            new PatientPage(null,id1);

        }
    }

    public static void main(String[] args) {
        PatientLoginPage pa=new PatientLoginPage(null);

    }


}
