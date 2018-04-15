package rsaGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class MainClass {

	private JFrame frame;
	private JTextField plainText;
	private JTextField cipherText;
	private JTextField plainText2;

	//byte[] cipherData;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClass() {

		CryptoClass cryptoClass = new CryptoClass();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 785, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		plainText = new JTextField();
		plainText.setBounds(22, 107, 124, 31);
		frame.getContentPane().add(plainText);
		plainText.setColumns(10);
		
		
		
		cipherText = new JTextField();
		cipherText.setBounds(307, 109, 145, 26);
		frame.getContentPane().add(cipherText);
		cipherText.setColumns(10);
		
		JLabel lblPlainText = new JLabel("Plain Text");
		lblPlainText.setBounds(32, 148, 100, 23);
		frame.getContentPane().add(lblPlainText);
		
		
		
		
		
		
		
		
		
		
		plainText2 = new JTextField();
		plainText2.setBounds(613, 107, 106, 31);
		frame.getContentPane().add(plainText2);
		plainText2.setColumns(10);
		
		JLabel lblCipherText = new JLabel("cipher text");
		lblCipherText.setBounds(348, 152, 80, 14);
		frame.getContentPane().add(lblCipherText);
		
		JLabel lblPlainText_1 = new JLabel("Plain Text");
		lblPlainText_1.setBounds(644, 152, 75, 14);
		frame.getContentPane().add(lblPlainText_1);
		
		
		
		
		
		
		JButton btnEncrytion = new JButton("Encrytion");
		btnEncrytion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				String text = plainText.getText();
				
				
			    BigInteger cipherData = cryptoClass.encrypt(text);
			    
			   // System.out.println("....."+cipherData);
			    
			    String stringCipherText = "" + cipherData;
			    
			    cipherText.setText(stringCipherText);
			   
			}
		});
		btnEncrytion.setBounds(158, 111, 106, 26);
		frame.getContentPane().add(btnEncrytion);
		
		
		
		
		
		
		JButton btnDecryption = new JButton("Decryption");
		btnDecryption.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				String text = cipherText.getText();
				
				BigInteger decryptData = cryptoClass.decrypt(text);
				
				String plainext = new String(decryptData.toByteArray());
				
				plainText2.setText(plainext);
				
			}});
		btnDecryption.setBounds(491, 111, 110, 23);
		frame.getContentPane().add(btnDecryption);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	public static String bytesToString(byte[] encrypted)

    {

        String test = "";

        for (byte b : encrypted)

        {

            test += Byte.toString(b);

        }

        return test;

    }
}
