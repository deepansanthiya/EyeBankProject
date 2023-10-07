import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DonorPage extends JDialog {
    private JButton updateButton;
    private JPanel UpdatePanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton indexButton;

    public DonorPage(JFrame Parent,int id1) {
        super(Parent);
        setTitle("Donor Page");
        setContentPane(UpdatePanel);
        setMinimumSize(new Dimension(500,400));
        setModal(true);
        setLocationRelativeTo(Parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    alogin(id1);
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
        defalutvalue(id1);
        setVisible(true);
    }

    private void alogin(int id1) throws SQLException, ClassNotFoundException {
        String i1 = (String) comboBox1.getSelectedItem();
        String i2 = (String) comboBox2.getSelectedItem();
        String i3 = (String) comboBox3.getSelectedItem();
        String i4 = (String) comboBox4.getSelectedItem();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st = con.createStatement();
        st.executeUpdate("update donorloginpage set eye='"+i1+"',bp='"+i2+"',sugar='"+i3+"',power='"+i4+"' where id="+id1);


    }

    private void defalutvalue(int id1)
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
                comboBox1.setSelectedItem(c11);
                comboBox2.setSelectedItem(c21);
                comboBox3.setSelectedItem(c31);
                comboBox4.setSelectedItem(c41);

            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DonorPage d=new DonorPage(null,3);

    }

}





