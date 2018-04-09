package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;


    public class Login extends JFrame {
        private JButton button_msg;
        private JPanel panelMain;
        private JTextField txtuser;
        private JTextField txtpass;

        public void close(){
            WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
        }

        public Login() {

            button_msg.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    //new Home().setVisible(true);

                    Dbconnection conn=new Dbconnection();

                    Connection dbconn=conn.getConnection();
                    Statement stmt = null;
                    String x=txtuser.getText();
                    String y=txtpass.getText();

                    try {
                        stmt = dbconn.createStatement();

                        String sql = "SELECT * FROM login WHERE username like '"+x+"' AND password like '"+y+"' ";
                        //System.out.println(sql);

                       ResultSet result = stmt.executeQuery(sql);

                        //System.out.println(result);
                        if(result.next()){
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            close();

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
            });

        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Access Control & Monitoring System");
            frame.setContentPane(new Login().panelMain);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);



        }

        private void createUIComponents() {
            // TODO: place custom component creation code here
        }
    }

