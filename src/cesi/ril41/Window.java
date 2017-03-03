package cesi.ril41;
import javax.swing.*;

import cesi.ril41.autentification.Identifiant;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class Window  extends JFrame {
	private JButton okBtn = new JButton("OK");
	private JButton reinitBtn = new JButton("Réinitialiser");
	private JLabel loginTxt = new JLabel("Login");
	private JLabel passwordTxt = new JLabel("Mot de passe");
	private JTextField loginField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);
	
	public Window() {
		Program.loadUsers();
		JPanel loginPanel  = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
	    constraints.anchor = GridBagConstraints.WEST;
	    constraints.insets = new Insets(10, 10, 10, 10);
	    
	    // settings de base
		this.setContentPane(loginPanel);
		this.setSize(400,300);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // placements des boutons et champs
	    constraints.gridx = 0;
        constraints.gridy = 0;     
        this.add(loginTxt, constraints);
        
        constraints.gridx = 1;
        this.add(loginField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;     
        this.add(passwordTxt, constraints);
         
        constraints.gridx = 1;
        this.add(passwordField, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        this.add(okBtn, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(reinitBtn, constraints);
        
        // action listeners et action performed
        okBtn.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
        		String inputIdentifiant = loginField.getText();
        		String inputPassword = new String(passwordField.getPassword());
        		
        		Identifiant identifiant = new Identifiant(inputIdentifiant, inputPassword);
        		Program.checkLogin(identifiant);
        	}
        });
        
        reinitBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		reinitPerformed();
        	}
        });
        
        
        
//		this.add(okBtn);
//		this.add(reinitBtn);
//		this.add(loginField);
//		this.add(passwordField);
//		this.add(loginTxt);
//		this.add(passwordTxt);
	}
	
	public void okPerformed() {
		System.out.println("ok working");
	}
	
	public void reinitPerformed() {
		loginField.setText("");
		passwordField.setText("");
	}
}
