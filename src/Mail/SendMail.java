package Mail;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SendMail extends JFrame {
	
	JTextField from = new JTextField();
	JTextField to = new JTextField();
	JTextField bcc = new JTextField();
	JTextField cc = new JTextField();
	JTextField subject = new JTextField();
	JComboBox smtpserver = new JComboBox();			// Entfällt auch durch Authentifzierung bei Anmeldung
	JTextField username = new JTextField();			// Kann weg, wenn Authentifizierung im Anmeldefenster erfolgreich
	JPasswordField password = new JPasswordField();	// ""			""				""						""
	JTextArea content = new JTextArea();
	
	public SendMail() {
		
		setTitle("Send an E-Mail");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 300));
		
		getContentPane().setLayout(new BorderLayout());
		
		//
		// Property Panel
		//
		final JPanel propertyPanel = new JPanel();
		propertyPanel.setLayout(new GridLayout(8, 2));
		propertyPanel.add(new JLabel("From:"));
		propertyPanel.add(from);
		
		propertyPanel.add(new JLabel("To:"));
		propertyPanel.add(to);
		
		propertyPanel.add(new JLabel("Bcc"));
		propertyPanel.add(bcc);
		
		propertyPanel.add(new JLabel("Cc"));
		propertyPanel.add(cc);
		
		propertyPanel.add(new JLabel("Subject:"));
		propertyPanel.add(subject);
		
		propertyPanel.add(new JLabel("SMTP Server:"));
		propertyPanel.add(smtpserver);
		smtpserver.addItem("smtp.gmail.com");
		
		propertyPanel.add(new JLabel("Username:"));
		propertyPanel.add(username);
		
		propertyPanel.add(new JLabel("Password:"));
		propertyPanel.add(password);
		
		//
		// Message Panel
		//
		final JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		messagePanel.add(new JLabel("Message:"), BorderLayout.NORTH);
		messagePanel.add(content, BorderLayout.CENTER);
		
		//
		//
		//
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		final JButton sendMailButton = new JButton("Send E-mail");
		
		buttonPanel.add(sendMailButton, BorderLayout.SOUTH);
		
		getContentPane().add(propertyPanel, BorderLayout.NORTH);
		getContentPane().add(messagePanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		sendMailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final Properties props = new Properties();
				props.put("mail.smtp.host", smtpserver.getSelectedItem());
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.smtp.starttls.enable", "true");
				
				final Session session = Session.getDefaultInstance(props);
				
				try {
					final InternetAddress fromAddress = new InternetAddress(from.getText());
					final InternetAddress toAddress = new InternetAddress(to.getText());
					//final InternetAddress bccAddress = new InternetAddress(bcc.getText());
					//final InternetAddress ccAddress = new InternetAddress(cc.getText());
					
					// Fehlermeldung, wenn bcc und cc freigelassen wird
					// Lösung mit if hat nicht geklappt
					
					final Message message = new MimeMessage(session);
					message.setFrom(fromAddress);
					message.setRecipient(Message.RecipientType.TO, toAddress);
					//message.setRecipient(Message.RecipientType.BCC, bccAddress);
					//message.setRecipient(Message.RecipientType.CC, bccAddress);
					
					message.setSubject(subject.getText());
					message.setText(content.getText());
					
					Transport.send(message, username.getText(),
							new String(password.getPassword()));
				} catch (final MessagingException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
}
