package Mail;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;

// Hier muss die Authentifizierung realisiert werden.. Nach Eingabe der Daten soll eine Anmeldung am Mailserver stattfinden und
// das nächste Fenster geladen werden und dort die Emails in Form einer Tabelle angezeigt werden

public class LoginWindow extends JFrame {

	private String email;
	private String password;
	
	public LoginWindow() {
		
		setTitle("Log-In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(800, 200);
		
		setLayout(new BorderLayout());
		
		final JLabel toplabel = new JLabel("Log-In");
		toplabel.setHorizontalAlignment(SwingConstants.CENTER);
		toplabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		// Creating Main-Panel
		
		final JPanel mainpanel = new JPanel();
		
		// Creating new Panel that is part of the Main-Panel
		// These panels will have two labels and one textfield and one passwordfield
		final JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		
		mainpanel.setLayout(new GridLayout(2, 1));
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		
		final JLabel label1 = new JLabel("Email:");
		final JTextField textfield1 = new JTextField(20);
		
		
		final JToolTip tooltip = new JToolTip();
		//tooltip.setTipText("Es wird derzeit nur der Provider Googlemail unterstützt");
		
		panel1.add(label1);
		panel1.add(textfield1);
		//panel1.add(tooltip);
		
		final JLabel label2 = new JLabel("Password:");
		final JPasswordField password = new JPasswordField(20);
		
		panel2.add(label2);
		panel2.add(password);
		
		// Buttons
		
		final JPanel buttonpanel = new JPanel();
		final JButton loginbutton = new JButton("Login");
		final JButton cancelbutton = new JButton("Cancel");
		buttonpanel.add(loginbutton);
		buttonpanel.add(cancelbutton);
		
		// Top-Level Layout
		
		add(toplabel, BorderLayout.NORTH);
		add(mainpanel, BorderLayout.CENTER);
		add(buttonpanel, BorderLayout.SOUTH);
		//pack();
		
		cancelbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		loginbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				final MainWindow window = new MainWindow();
			}
		});
		
	}
	
}
