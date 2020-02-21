package hp;

//username: hp
//password: 1923

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//EXTRACT
class extract extends JFrame implements ActionListener
{
JLabel l1=new JLabel("  AUDIO FILE (.wav) :");
JTextField tf1=new JTextField(15);
JLabel l2=new JLabel("  TEXT FILE (.txt) :");
JTextField tf2=new JTextField(15);
JButton b1=new JButton("ok");
JButton b2=new JButton("cancel");
JButton b3=new JButton("BROWSE");
JButton b4=new JButton("BROWSE");
JPanel p=new JPanel();
public extract()
{
p.setBackground(Color.cyan);
b1.setBackground(Color.black);
b2.setBackground(Color.black);
b1.setForeground(Color.pink);
b2.setForeground(Color.pink);
l1.setForeground(Color.black);
l2.setForeground(Color.black);
p.add(l1);p.add(tf1);p.add(b3);
p.add(l2);p.add(tf2);p.add(b4);
p.add(b1);p.add(b2);
getContentPane().add(p);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

getContentPane().add(p);
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(e.getSource()==b3)
{
FileDialog fd=new FileDialog(this,"AUDIOFILE",FileDialog.LOAD);
fd.setVisible(true);
String f1=fd.getDirectory();
String f2=fd.getFile();
if((f2.substring(f2.lastIndexOf(".") + 1)).equals("wav"))
{
String fl=f1+f2;
tf1.setText(fl);
}
else
JOptionPane.showMessageDialog(null,"plz select the (.wav) audiofile"); 
}

else if(e.getSource()==b4)
{
FileDialog fd=new FileDialog(this,"TEXTFILE",FileDialog.SAVE);
fd.setVisible(true);
String f1=fd.getDirectory();
String f2=fd.getFile();
String fl=f1+f2;
tf2.setText(fl);
}
else if(s.equals("ok"))
{
int c,n,k;
String s1,s2,out;

s1=tf1.getText();
out=tf2.getText();
s2=out+".txt";
if(tf2.getText().equals("") || tf1.getText().equals(""))
JOptionPane.showMessageDialog(null,"plz enter the filenames");
else
{
try
{

//INPUT FILES AND OUTPUT FILES
InputStream faudio=new FileInputStream(s1);
OutputStream txt=new FileOutputStream(s2);

//READ DATA FROM AUDIO FILE
int sizeaudio = faudio.available();
int audio[]=new int[sizeaudio];

int audiobits[][]=new int[sizeaudio][8];
for(int i=0;i<sizeaudio;i++)
{
audio[i]=faudio.read();
}



c=0;
//convert audiobytes into 8bits
for(int i=150;i<sizeaudio;i++)
{
k=0;
if(audio[i]>=0)
{
while(k!=8)
{
if(audio[i]%2==0)
audiobits[i][k]=0;
else
{
audiobits[i][k]=1;
audio[i]=audio[i]-1;
}
audio[i]=audio[i]/2;
k=k+1;
}
c=c+1;
}}

n=(int)(java.lang.Math.ceil(c/8));

int textbits[][]=new int[c][8];
int text[]=new int[n];


//embedding
int j=150;
int count=0;
int no=0;
while(j<sizeaudio)
{
if(audio[j]>=0)
{
textbits[no][count]=audiobits[j][0];
count=count+1;
j=j+5;
if(count>=8)
{
count=0;
no=no+1;
}
if(no > n)
break;
}
else
while(audio[j]<0)
j=j+1;
}



//converting data
for(int i=0;i<n;i++)
{
text[i]=0;
k=0;
while(k<8)
{
text[i]=text[i]+(textbits[i][k]*((int)(java.lang.Math.pow(2,k))));
k=k+1;
}
}


for(int i=1;i<n;i++)
{
if(text[0]=='x')
{
if(text[i]=='x'&&text[i+1]=='x')
{
txt.write(text[i]);
i=i+1;
}
else if(text[i]=='x')
break;
else
txt.write(text[i]);
}}
File ff=new File(s2);
InputStream fis=new FileInputStream(ff);
if(fis.available()==0)
{
ff.delete();
JOptionPane.showMessageDialog(null,"plz enter correct audiofile");
}
else
{
JOptionPane.showMessageDialog(null,"sucessfully completed");
System.exit(0);
}
}
catch(Exception exc)
{
}

}}
else if(s.equals("cancel"))
{
System.exit(0);
}
}
}









//EMBEDDED
 class embed extends JFrame implements ActionListener
{
JLabel l1=new JLabel("AUDIO FILE(.wav) :");
JTextField tf1=new JTextField(15);

JLabel l2=new JLabel("    TEXT FILE(.txt) :");
JTextField tf2=new JTextField(15);

JLabel l3=new JLabel("OUTPUT FILE (.wav):");
JTextField tf3=new JTextField(15);

JButton b1=new JButton("ok");
JButton b2=new JButton("cancel");
JButton b3=new JButton("BROWSE");
JButton b4=new JButton("BROWSE");
JButton b5=new JButton("BROWSE");

JPanel p=new JPanel();
public embed()
{
p.setBackground(Color.cyan);
b1.setBackground(Color.black);
b2.setBackground(Color.black);
b1.setForeground(Color.red);
b2.setForeground(Color.red);

l1.setForeground(Color.black);
l2.setForeground(Color.black);
l3.setForeground(Color.black);
p.add(l1);p.add(tf1);p.add(b3);
p.add(l2);p.add(tf2);p.add(b4);
p.add(l3);p.add(tf3);p.add(b5);
p.add(b1);
p.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
this.add(p,BorderLayout.SOUTH);
getContentPane().add(p);
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(e.getSource()==b3)
{
FileDialog fd=new FileDialog(this,"AUDIOFILE",FileDialog.LOAD);
fd.setVisible(true);
String f1=fd.getDirectory();
String f2=fd.getFile();
if((f2.substring(f2.lastIndexOf(".") + 1)).equals("wav"))
{
String fl=f1+f2;
tf1.setText(fl);
}
else
JOptionPane.showMessageDialog(null,"plz select the (.wav) audiofile"); 
}

else if(e.getSource()==b4)
{
FileDialog fd=new FileDialog(this,"TEXTFILE",FileDialog.LOAD);
fd.setVisible(true);
String f1=fd.getDirectory();
String f2=fd.getFile();
if((f2.substring(f2.lastIndexOf(".") + 1)).equals("txt") )
{
String fl=f1+f2;
tf2.setText(fl);
}
else
JOptionPane.showMessageDialog(null,"plz select the (.txt) textfile"); 
}

else if(e.getSource()==b5)
{
FileDialog fd=new FileDialog(this,"AUDIOFILE",FileDialog.SAVE);
fd.setVisible(true);
String f1=fd.getDirectory();
String f2=fd.getFile();
String fl=f1+f2;
tf3.setText(fl);
}

else if(s.equals("ok"))
{
int sizeaudio,sizetext,k,c,n;
String s1,s2,s3,out;
s1=tf1.getText();
s2=tf2.getText();
out=tf3.getText();
s3=out+".wav";


if(tf3.getText().equals("") || tf2.getText().equals("") || tf1.getText().equals(""))
JOptionPane.showMessageDialog(null,"plz enter the  filenames");


else
{
try
{
File f=new File(s1);
//INPUT FILES AND OUTPUT FILES
FileInputStream faudio=new FileInputStream(f);
FileInputStream ftext=new FileInputStream(s2);
FileOutputStream emd=new FileOutputStream(s3);

//READ DATA FROM AUDIO FILE
sizeaudio = faudio.available();
int audio[]=new int[sizeaudio];
int audiodup[]=new int[sizeaudio];
int audiobits[][]=new int[sizeaudio][8];
for(int i=0;i<sizeaudio;i++)
{
audio[i]=faudio.read();
audiodup[i]=audio[i];
}


//READ DATA FROM TEXT FILE
 sizetext= ftext.available();
int text[]=new int[sizetext];
c=0;
for(int i=0;i<sizetext;i++)
{
text[i]=ftext.read();
if(text[i]=='x')
c=c+1;
}
c=c*2;
int sizetextdup=sizetext+c+2;
int textdup[]=new int[sizetextdup];
int textbits[][]=new int[sizetextdup][8];
n=0;
textdup[n]='x';
for(int i=0;i<sizetext;i++)
{
if(text[i]=='x')
textdup[++n]='x';
textdup[++n]=text[i];
}
textdup[++n]='x';


//COMPARE AUDIO FILE AND TEXT FILE
int j=150;
int count=0;
while(j<sizeaudio)
{
if(audio[j]>=0)
{
count=count+1;
j=j+5;
}
else
while(audio[j]<0)
j=j+1;
}
int t;
t=8*sizetext;
if(count<t)
JOptionPane.showMessageDialog(null,"audiofile not sufficient");


else
{
//convert audiobytes into 8bits
for(int i=150;i<sizeaudio;i++)
{
k=0;
if(audio[i]>=0)
{
while(k!=8)
{
if(audio[i]%2==0)
audiobits[i][k]=0;
else
{
audiobits[i][k]=1;
audio[i]=audio[i]-1;
}
audio[i]=audio[i]/2;
k=k+1;
}
}}




//convert textfilebytes into 8bits
for(int i=0;i<=n;i++)
{
k=0;
while(k<8)
{
if(textdup[i]%2==0)
textbits[i][k]=0;
else
{
textbits[i][k]=1;
textdup[i]=textdup[i]-1;
}
textdup[i]=textdup[i]/2;
k=k+1;
}
}




//embedding
 j=150;
 count=0;
int no=0;
while(j<sizeaudio)
{
if(audiodup[j]>=0)
{
audiobits[j][0]=textbits[no][count];
count=count+1;
j=j+5;
if(count>=8)
{
count=0;
no=no+1;
}
if(no > n)
break;
}
else
while(audiodup[j]<0)
j=j+1;
}





//converting data
for(int i=150;i<sizeaudio;i++)
if(audiodup[i]>=0)
{
audio[i]=0;
k=0;
while(k<8)
{
audio[i]=audio[i]+(audiobits[i][k]*((int)(java.lang.Math.pow(2,k))));
k=k+1;
}
}




//store the data in to given filename
for(int i=0;i<sizeaudio;i++)
emd.write(audio[i]);
JOptionPane.showMessageDialog(null,"sucessfully completed");
System.exit(0);
}}

catch(Exception exc)
{
}}
}
else if(s.equals("cancel"))
{
System.exit(0);
}
}
}






//CHOOSEN
class home extends JFrame implements ActionListener
{
public home()
{
JButton b1=new JButton("embedded");
JButton b2=new JButton("extraction");
JButton b3=new JButton("cancel");
JPanel p=new JPanel();
p.setBackground(Color.cyan);
b1.setBackground(Color.black);
b2.setBackground(Color.black);
b3.setBackground(Color.black);
b1.setForeground(Color.red);
b2.setForeground(Color.red);
b3.setForeground(Color.red);
p.add(b1);p.add(b2);
p.add(b3);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
this.add(p,BorderLayout.SOUTH);
getContentPane().add(p);
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s.equals("embedded"))
{
this.setVisible(false);
embed em=new embed();
em.setSize(400,400);
em.setTitle("EMBEDDED PROCESS");
em.setVisible(true);
em.setResizable(false);
em.setLocation(350,230);
em.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
else if(s.equals("extraction"))
{
this.setVisible(false);
extract ex=new extract();
ex.setSize(400,400);
ex.setTitle("EXTRACTION PROCESS");
ex.setVisible(true);
ex.setResizable(false);
ex.setLocation(350,230);
ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
else if(s.equals("cancel"))
{
System.exit(0);
}
}}




//LOGIN FORM
public class hp extends JFrame implements ActionListener
{
JLabel l1=new JLabel("USERNAME :");
JTextField tf1=new JTextField(15);
JLabel l2=new JLabel("PASSWORD:");
JPasswordField tf2=new JPasswordField(15);

JButton b1=new JButton("ok");
JButton b2=new JButton("cancel");
JPanel jp=new JPanel();
public hp()
{
jp.setBackground(Color.cyan);
//l1.setForeground(Color.black);
//l2.setForeground(Color.black);
//tf1.setBackground(Color.gray);
//tf2.setBackground(Color.gray);
jp.add(l1);jp.add(tf1);
jp.add(l2);jp.add(tf2);
 
b1.setBackground(Color.black);
b2.setBackground(Color.black);
b1.setForeground(Color.red);
b2.setForeground(Color.red);
b1.addActionListener(this);
b2.addActionListener(this);
jp.add(b1);jp.add(b2);



getContentPane().add(jp);

}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s.equals("ok"))
{

if(tf1.getText().equals(""))
{
JOptionPane.showMessageDialog(null,"please enter the username");
}
else if(tf2.getText().equals (""))
{
JOptionPane.showMessageDialog(null,"please enter the password");
}
else if(tf1.getText().equals("ms") && tf2.getText().equals ("594"))
{

this.setVisible(false);
home h=new home();
h.setSize(300,300);
h.setTitle("AUDIO STEGANOGRAPHY");
h.setVisible(true);
h.setResizable(false);
h.setLocation(350,230);
h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
else
{
JOptionPane.showMessageDialog(null,"invalid username & password");
}
}
else if(s.equals("cancel"))
{
System.exit(0);
}
}


public static void main(String args[])
{
hp p=new hp();
p.setSize(300,300);
p.setTitle("LOGIN FORM");
p.setVisible(true);
p.setResizable(false);
p.setLocation(350,230);
p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

