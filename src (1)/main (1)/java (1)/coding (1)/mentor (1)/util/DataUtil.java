package coding.mentor.util;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import coding.mentor.entity.Account;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;

public class DataUtil {
	public int getNumberOfPage (int count, int view) {
		int endPage = count/view;
		if (count % view != 0) {
			endPage++;
		}
		return endPage;
	}
	public String convertMonthString(String month) {
        String newMonthConverted = "%___" + month + "%";
        return newMonthConverted;
    }
	public String convertImage (String image) {
		image = "image/" + image + ".jpg";
		return image;
	}
	
	public void sendEmail(String email, String name, String passwordAccount) {
		String to = email; // how i test -> lay email myself -> test :)
	    String from = "dandanewt11344@gmail.com"; // get your own email -> khuyen lay gmail anh nha :)
	    String password = "dandanewt"; // put your own password for email :)
	    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
 
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Forgot Password"); // this is subject anh nhe :)
//            message.setText("Hi " + name + ", you chose to get your password back. Here is your old password: " + passwordAccount
//                 +   ". Please using this to login again."); // this is message anh nhe :) 
            message.setContent("<p>Hello <h1>" + name + "</h1>,<br> "
            		+ "you chose to get your Password back. Following is your old Password:<br>"
            		+ "<h2>" + passwordAccount + "</h2>.<br>"
            		+ "Please change your Password after sucessfully logged in."
            		
            		
            		,"text/html");
            Transport.send(message);
 
            System.out.println("Mail sent succesfully!");
 
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
	
	
	public void sendInvoice(Account account, Order order) {
		String to = account.getEmail(); // how i test -> lay email myself -> test :)
	    String from = "dandanewt11344@gmail.com"; // get your own email -> khuyen lay gmail anh nha :)
	    String password = "dandanewt"; // put your own password for email :)
	    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
 
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("FURNIX Invoice Confirmation!"); // this is subject anh nhe :)
//            message.setText("Hi " + name + ", you chose to get your password back. Here is your old password: " + passwordAccount
//                 +   ". Please using this to login again."); // this is message anh nhe :) 
            message.setContent("<p>Hello <h1>" + account.getFirstName() + "</h1>"
            		+ "Thank you for your recent order from\n"
            		+ "Furnix Minimal Furniture Pty Ltd, ACN 097 147 932, 227 Elizabeth St, NSW AUSTRALIA 2000.\n"
            		+ "\n"
            		+ ". As this order has now been processed we are unable to cancel or amend it.\n"
            		+ "\n"
            		+ "We will send you an email notification once your order has been dispatched - for stock orders this is normally within 1-2 business days of order placement. Non-stock orders are normally dispatched within 7 business days of order placement."
            		+ "<hr>"
            		+ "<h2>Shipping Information</h2>"
            		+ "FURNIX Pty Ltd, ABN 82 097 147 932, 227 Elizabeth St, NSW AUSTRALIA 2000."
            		+ "<h2>Customer Address</h2>"
            		+ account.getFirstName() + " " + account.getLastName() + "<br>"
            		+ account.getEmail() 
            		+ "<h2>Total Purchase: </h2>"
            		
            		+ order.getPrice() 
            		
            		
            		
            		,"text/html");
            Transport.send(message);
 
            System.out.println("Mail sent succesfully!");
 
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
	
	public String convertTextSearch(String textSearch) {
		String newTextSearch = textSearch.replaceAll("\\s+", ",");
		return newTextSearch;
	}
	    
	
	public static void main(String[] args) {
		DataUtil dataUtil = new DataUtil();
		String text = dataUtil.convertTextSearch("chair huhu  dshfoisdhf fjdso fdsjofi");
		System.out.println(text);
	}
}
