import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexPage extends JDialog {

    private JButton adminLoginButton;
    private JButton donorLoginButton;
    private JButton patientLoginButton;
    private JButton donorRegisterButton;
    private JButton patientRegsiterButton;
    private JPanel InPanel;

    public IndexPage(JFrame parent) {
        super(parent);
        setTitle("Index Page");
        setContentPane(InPanel);
        setMinimumSize(new Dimension(1200, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        donorLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donarlogin();
            }
        });

        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                adminlogin();
            }
        });

        patientLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientlogin();
            }
        });

        donorRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donorreg();
            }
        });

        patientRegsiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientreg();
            }
        });

        setVisible(true);
    }

    private void donarlogin() {
        setVisible(false);
        new DonorLogoinPage(null);

    }
    private void patientlogin() {
        setVisible(false);
        new PatientLoginPage(null);

    }
    private void adminlogin() {
        setVisible(false);
        new AdminLoginPage(null);

    }
    private void donorreg() { setVisible(false);
        new DonorRegister(null);

    }
    private void patientreg() {
        setVisible(false);
        new PatientRegisterPage(null);

    }
    public static void main(String[] args) {
        IndexPage in = new IndexPage(null);

    }
}












