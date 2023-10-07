import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Patient extends JDialog {
    public JTextField textField1;
    public JTextField textField2;
    private JButton searchButton;
    private JTable table1;
    private JPanel parpanel;
    private JButton indexButton;

    public Patient(JFrame parent) {
        super(parent);
        setTitle("Search");
        setContentPane(parpanel);
        setMinimumSize(new Dimension(900, 604));
        setModal(true);
        setLocationRelativeTo(parent);
        textField1.setText("0");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    psearch();
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

    public void msg(String a){
        textField2.setText(a);
    }
    private void psearch() throws SQLException, ClassNotFoundException {
        String i= textField1.getText();
        String te=textField2.getText();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyebank", "root", "livewire");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from PatientReg where eye='"+i+"' or sugar='"+te+"'");
        DefaultTableModel model = new DefaultTableModel(new String[]{"PatientName", "id"}, 0);
        while(rs.next()){
            String d=rs.getString("Patientname");
            String g=rs.getString("id");
            model.addRow(new Object[]{d,g});
        }
        table1.setModel(model);
    }

    public static void main(String[] args) {
        new Patient(null);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
