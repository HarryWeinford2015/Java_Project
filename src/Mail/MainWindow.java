package Mail;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;



public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("Emails");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		final JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		final JButton send = new JButton("New Email");
		final JButton update = new JButton("Update");
		final JButton reply = new JButton("Reply");
		
		send.setEnabled(true);
		update.setEnabled(true);
		reply.setEnabled(true);
		
		buttonpanel.add(send);
		buttonpanel.add(update);
		buttonpanel.add(reply);
		
		buttonpanel.setEnabled(true);
		
		JPanel listpanel = new JPanel();
		
		
		JList <String> list = new <String> JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(250,80));
		
		
		
		
		
		
		add(buttonpanel, BorderLayout.NORTH);
		add(listpanel, BorderLayout.CENTER);
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				final SendMail snd = new SendMail();
				snd.setVisible(true);
				
			}
		});
	}
};
