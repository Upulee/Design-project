package com.UI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;


    public class Login extends JFrame {
        private static JFrame loginWindow;
        private JButton button_msg;
        private JPanel panelMain;
        private JTextField txtuser;
        private JTextField txtpass;



        public void login() {
            Dbconnection conn=new Dbconnection();

            Connection dbconn=conn.getConnection();
            Statement stmt = null;
            String x=txtuser.getText();
            String y=txtpass.getText();

            try {
                stmt = dbconn.createStatement();

                String sql = "SELECT * FROM login WHERE username like '"+x+"' AND password like '"+y+"' ";


                ResultSet result = stmt.executeQuery(sql);


                if(result.next()){
                    loginWindow.dispose();

                    JOptionPane.showMessageDialog(null, "Login Successful");

                    Home h = new Home();
                    h.setSize(500,500);
                    h.setContentPane(new Home().MainP);
                    h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    h.pack();
                    h.setVisible(true);



                }
                else

                {
                    JOptionPane.showMessageDialog(null, "Login Failed");

                }


            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }


        }

        public Login() {

            button_msg.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    login();
                }
            });

        }

        public static void main(String[] args) {
            loginWindow= new JFrame("Access Control & Monitoring System");
            loginWindow.setContentPane(new Login().panelMain);
            loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginWindow.pack();
            loginWindow.setVisible(true);




        }

        private void createUIComponents() {
            // TODO: place custom component creation code here
        }
    }

