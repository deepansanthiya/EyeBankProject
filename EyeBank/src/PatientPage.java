import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientPage extends JDialog {
    private JButton updateButton;
    private JPanel ADPanel;
    private JComboBox c1;
    private JComboBox c2;
    private JComboBox c3;
    private JComboBox c4;

private int id1;
    public PatientPage(JFrame Parent,int a) {

        super(Parent);
        id1=a;
        setTitle("Patient Page");
        setContentPane(ADPanel);
        setMinimumSize(new Dimension(500,400));
        setModal(true);
        setLocationRelativeTo(Parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateButton.addActionListener(new ActionListener() {
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

        defalutvalue();
        setVisible(true);
    }
    private void defalutvalue()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
            Statement st = con.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT * FROM patientreg where id="+id1);
            while (resultSet.next()) {
                String c11 = resultSet.getString("eye");
                String c21 = resultSet.getString("bp");
                String c31 = resultSet.getString("sugar");
                String c41 = resultSet.getString("power");
                c1.setSelectedItem(c11);
                c2.setSelectedItem(c21);
                c3.setSelectedItem(c31);
                c4.setSelectedItem(c41);

            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void alogin() throws SQLException, ClassNotFoundException {
        String i1 = (String) c1.getSelectedItem();
        String i2 = (String) c2.getSelectedItem();
        String i3 = (String) c3.getSelectedItem();
        String i4 = (String) c4.getSelectedItem();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        st.executeUpdate("update patientreg set eye='"+i1+"',bp='"+i2+"',sugar='"+i3+"',power='"+i4+"' where id="+id1);


    }
   /* public static void printcustomerdata(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
            Statement st = con.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT * FROM Customer");

           System.out.println("***************************************************************CUSTOMER DETAILS*****************************************");
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("customerId") + "|  NAME: " + resultSet.getString("customerName")+ "|  Phone No: " + resultSet.getString("phone"));
                System.out.print("| Email: " + resultSet.getString("email") + "|  AAdhar : " + resultSet.getString("aadhar")+ "|  Date Of Birth: " + resultSet.getString("dob"));
                System.out.println();

            }
            System.out.println("\n**********************************************************************END*************************************************");
            c4.setSelectedItem("High");
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }*/
    public static void main(String[] args) {
        PatientPage PT=new PatientPage(null,3);
    }
}

