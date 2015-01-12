package Mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class ReceiveMail {

    public ReceiveMail() {
        // TODO Auto-generated constructor stub
    }

    public static void receive(String host,String user,String password) throws Exception {
        /*
         Properties propertiesToReceive = new Properties();
			 
			  
			  
         propertiesToReceive.put("mail.pop3.socketFactory.class", "javax.net.SSLSocketFactory");
         propertiesToReceive.put("mail.pop3.socketFactory.fallback", "false");
         propertiesToReceive.put("mail.pop3.socketFactory.port", "995");
         propertiesToReceive.put("mail.pop3.port", "995");
         propertiesToReceive.put("mail.pop3.host", "pop.gmail.com" );
         propertiesToReceive.put("mail.pop3.user", user);
         propertiesToReceive.put("mail.store.protocol", "pop3");
			  
         Authenticator authenticator = null;
			  
         Session sessionToReceive =Session.getDefaultInstance(propertiesToReceive, authenticator);
			 
			 
         Store store = sessionToReceive.getStore("pop3");
         store.connect("pop.gmail.com", "javaprojectnew", "javamail");
			 
			 
         Folder inbox = store.getFolder("INBOX");
         inbox.open(Folder.READ_ONLY);
			 
         Message[] messagesInbox = inbox.getMessages();
			 
         for (int i = 0; i < messagesInbox.length; i++) { System.out.println("------------ Message " + (i+1)
         + " ------------");
         messagesInbox[i].writeTo(System.out);
         }
         inbox.close(false);
         store.close();
         */

        //String host = "pop.gmx.net";
        //String user = "javaproject@gmx.de";
        //String pass = "javamail";

        /*
                      
         Properties props = System.getProperties();
         props.put("mail.pop3.host", host);
         props.put("mail.pop3.auth", "true");
         props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.pop3.socketFactory.fallback", "false");
         props.put("mail.pop3.socketFactory.port", "995");
         props.put("mail.pop3.port", "995");
         props.put("mail.pop3.host", host);
         props.put("mail.pop3.user", user);
         props.put("mail.pop.password", pass);
         props.put("mail.store.protocol", "pop3");
		 
         //
         // 2. Creates a javax.mail.Authenticator object.
         //
         Authenticator auth = null;
		 
         //
         // 3. Creating mail session.
         //
         Session session = Session.getDefaultInstance(props, auth);
		 
         //
         // 4. Get the POP3 store provider and connect to the store.
         //
         Store store = session.getStore("pop3");
         store.connect("pop.gmx.net", user, pass);
		 
         //
         // 5. Get folder and open the INBOX folder in the store.
         //
         Folder inbox = store.getFolder("INBOX");
         inbox.open(Folder.READ_ONLY);
		 
         //
         // 6. Retrieve the messages from the folder.
         //
         Message[] messages = folder.getMessages();
         for ( int i = 0; i < message.length; i++ ) {
         Message m = message[i];
         System.out.println( "Nachricht: " + i );
         System.out.println( "From: " + m.getFrom()[0] );
         System.out.println( "Subject: " + m.getSubject() );
         System.out.println( "Message: " +m.getContent());
         }
		 
         //
         // 7. Close folder and close store.
         //
         inbox.close(false);
         store.close();
         */
        Properties props = System.getProperties();
        props.put("mail.pop3.host", host);
        props.put("mail.pop3.auth", "true");
        props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.pop3.socketFactory.fallback", "false");
        props.put("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.host", host);
        props.put("mail.pop3.user", user);
        props.put("mail.pop.password", password);
        props.put("mail.store.protocol", "pop3");

        Authenticator auth = null;

        Session session = Session.getDefaultInstance(props, auth);

        Store store = session.getStore("pop3"); // Protokoltyp
        store.connect(host, user, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message[] message = folder.getMessages();

        for (int i = 0; i < message.length; i++) {
            Message m = message[i];
            System.out.println("Nachricht: " + i);
            System.out.println("From: " + m.getFrom()[0]);
            System.out.println("Subject: " + m.getSubject());
            System.out.println("Message: " + m.getContent());
        }
        folder.close(false);
        store.close();
    }

}

/*Session session = Session.getDefaultInstance( new Properties() );
 Store store = session.getStore( "imap" ); // Protokoltyp
 store.connect( host, user, passwd );
 Folder folder = store.getFolder( "INBOX" );
 folder.open( Folder.READ_ONLY );
 Message[] message = folder.getMessages();
 for ( int i = 0; i < message.length; i++ ) {
 Message m = message[i];
 System.out.println( "Nachricht: " + i );
 System.out.println( "From: " + m.getFrom()[0] );
 System.out.println( "Subject: " + m.getSubject() );
 System.out.println( "Message: " +m.getContent());
 }
 folder.close( false );
 store.close();
		 
 */
