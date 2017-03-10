package testz;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
 
import javax.swing.*;
 
 
 
public class openfile extends JFrame{
    JButton b1=new JButton("选择文件");
    JTextField t1=new JTextField(20);
    JTextArea result=new JTextArea();
    JButton b2=new JButton("打开");
    FileReader myfile;
    Font zi=new Font("宋体",Font.TYPE1_FONT,15);
    public openfile() {
             
         setTitle("文件打开演示");
         setLayout(null);
         setSize(700, 600);
         setResizable(false);
         this.setBackground(Color.DARK_GRAY);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
         Dimension frm = this.getSize();
         setLocation( (scr.width - frm.width) / 2,
                 (scr.height - frm.height) / 2 );
         
         b1.setBounds(50, 30, 100, 25);
         t1.setBounds(180,30 , 180, 25);
         JScrollPane s1 = new JScrollPane(result);
         result.setBackground(Color.lightGray);
         result.setFont(zi);
         s1.setBounds(20, 100, 650, 450);
         b2.setBounds(400, 30, 80, 25);
         
            add(b1);
            add(t1);
            add(s1);
            add(b2);
             b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        FileDialog my=new FileDialog(openfile.this);
                        my.setVisible(true);
                        t1.setText(my.getDirectory()+my.getFile());
                    }
                }); 
             b2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try{
                         
                        myfile=new FileReader(t1.getText());
                        int show=myfile.read();
                        while(show!=-1){
                            result.append((char)show+"");
                            show=myfile.read();
                        }
                     
                         
                         
                        }
                        catch(Exception ee){} 
               
                    }
                }); 
          
          
          
          
          
          
          
          
         setVisible(true);
          
          
          
        }
    public static void main(String[] args){
        new openfile();
        System.out.print(new java.util.Date());
         
    }
 
 
}