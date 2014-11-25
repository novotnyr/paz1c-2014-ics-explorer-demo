package sk.upjs.ics.ics.explorer;

import com.jgoodies.looks.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import net.miginfocom.swing.MigLayout;


public class MainForm extends JFrame {
    private static final Component CENTER_SCREEN = null;    
    
    private static final String DEFAULT_ADDRESS 
            = "http://www.textfiles.com/computers/basunix.hac";
    
    private JButton btnBack = new JButton("<-");
    
    private JButton btnRefresh = new JButton("F5");
    
    private JTextField txtAddress = new JTextField(DEFAULT_ADDRESS);
    
    private JButton btnGo = new JButton("Go!");
    
    private JButton btnAdBlock = new JButton("AB");
    
    private JButton btnMenu = new JButton("...");
    
    private JEditorPane txtWebPage = new JEditorPane();

    private JScrollPane scrollTxtWebPage = new JScrollPane(txtWebPage);
    
    public MainForm() throws HeadlessException {
        setLayout(new MigLayout("", "[] [] [fill, grow] [] [] []"));
                
        add(btnBack);
        add(btnRefresh);
        add(txtAddress);
        add(btnGo);
        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGoActionPerformed(e);
            }

        });
        
        add(btnAdBlock);
        add(btnMenu, "wrap");
        
        add(scrollTxtWebPage, "dock center, span 6");
        
        setPreferredSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(CENTER_SCREEN);

        pack();
        
    }

    private void btnGoActionPerformed(ActionEvent event) {
        try {
            String webPage = WebPageUtils.downloadWebPage(txtAddress.getText());
            
            System.err.println(webPage);
            
            txtWebPage.setText(webPage);
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this, "Zly format adresy");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Nepodarilo sa nacitat stranku");
        }
    }    
    
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new WindowsLookAndFeel());
        
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
}
