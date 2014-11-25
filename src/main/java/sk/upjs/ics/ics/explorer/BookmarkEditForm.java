package sk.upjs.ics.ics.explorer;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class BookmarkEditForm extends JDialog {
    
    private JLabel lblName = new JLabel("Name:");
    
    private JTextField txtName = new JTextField();
    
    private JLabel lblUrl = new JLabel("URL:");
    
    private JTextField txtUrl = new JTextField();
    
    private JButton btnOk = new JButton("OK");
    
    private JButton btnCancel = new JButton("Cancel");
    

    public BookmarkEditForm(Frame owner) {
        super(owner, true);
        
        setLayout(new MigLayout("wrap 2", "[] [fill, grow]", "[] [] [nogrid]"));
        
        add(lblName);
        add(txtName);
        
        add(lblUrl);
        add(txtUrl);
        
        add(btnOk, "tag ok");
        
        add(btnCancel, "tag cancel");
        
        pack();
    }
    
    public static void main(String[] args) {
        new BookmarkEditForm(null).setVisible(true);
    }
}
