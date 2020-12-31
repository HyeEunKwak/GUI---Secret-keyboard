package keyboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class secretKeyboard extends JFrame {
   
   JTextField t1;//���ڵ��� �������� �ؽ�Ʈ
   JTextArea t2;//�Է��� ���뿡 ���� �޼����� ����ϴ� �ؽ�Ʈ����
   public static String button_names[] = new String[]{"��ĭ","��ĭ","��ĭ","��ĭ","��ü ����", "6", "3", "8", "7", "�ϳ� ����", "4", "1", "5", "9", "2", "0" };//��ư�� �̸��迭
   JButton buttons[] = new JButton[button_names.length];//��ư ����
   JPanel buttonPanel = new JPanel();//��ư �г� ����
   JButton b = new JButton("�Է¿Ϸ�");//�� �ؿ� ���� '�Է¿Ϸ�'��ư ����

   
   
   secretKeyboard(){
      setTitle("���ȿ� Ű����");
      
      ShuffleTest(button_names);//Ű���尡 �����ɶ����� ���Ӱ� ��ġ�Ǵ� ��ư

      
      setLayout(new BorderLayout(10,10));//Ű���� ��ü�� ��ġ������ :BorderLayout
      showNorth();//�� ���� ����
      showCenter();
      showSouth();
      
      setVisible(true);//ȭ�鿡 ���̰� �ϴ°�
      setPreferredSize(new Dimension(400,500));//��ȣ ������ ����
      setSize(new Dimension(400,500));//������ ����
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �����ư�� �Բ� ���α׷� ����
   }
   
   void showNorth() {
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      JPanel panel = new JPanel(new GridLayout(2,0)); //�г�(north�κ�)�� ��ġ������ 
      
      t1 = new JTextField(10);//JTextField ����
      t1.setBackground(Color.WHITE);//JTextField�� ����  : ���
      t1.setHorizontalAlignment(JTextField.CENTER);//JTextField�� �ؽ�Ʈ�� �߰�����
      t1.setFont(new Font("���� ���", Font.BOLD, 30));//JTextField�� �۾�ü�� ũ�� 
      t1.setBounds(8, 10, 230, 50);//JTextField ũ�� �� ��ġ ����
      
      JTextArea t2 = new JTextArea();//JTextArea ����
      t2.setEditable(false);//����� JtextArea edit ���� (���� �� �� ����) true�� ����
      t2.setBackground(Color.GRAY);//JtextArea ���� : ȸ��
      t2.setForeground(Color.BLACK);//JtextArea �۾��� : ������
      t2.setText("���� ���ڸ� �Է��ϼ���");//JtextArea�� ���� "���� ���ڸ� �Է��ϼ���"
      t2.setFont(new Font("���� ���", Font.BOLD, 15)); //JtextArea�� ���� ũ��� �۾�ü
      t2.setBounds(50, 50, 300, 300); //JTeatArea ũ�� �� ��ġ ����
      
      ActionListener listener2 = e ->{
    	  if(e.getSource()==b) //JButton�� ������
      {
    		  String sb = "572943";//�̸� ������ ��й�ȣ
    		  boolean a = t1.getText().equals(sb);//JTextField�� �̸������� ��й�ȣ�� ������ 
		      if(a==true) {
		    	  t2.setText("����� �����Ǿ����ϴ�");//JtextArea�� "����� �����Ǿ����ϴ�"�Է�
		        	}
		       else {
		    	   t2.setText("�߸� �Է��ϼ̽��ϴ�");//JtextArea�� "�߸� �Է��ϼ̽��ϴ�"�Է�
		        	}
			
		}
			};
		
			
			
	b.addActionListener(listener2);//��ư�� �̺�Ʈ �Է�

      p1.add(t1);//JPanel�� JTextField �ø���
      p2.add(t2);//JPanel�� JTextField �ø���
      
      panel.add(p1);//JPanel�� JPanel �ø���
      panel.add(p2);//JPanel�� JPanel �ø���
      
      add(panel,BorderLayout.NORTH);//JPanel�� ���ʿ� �ø���
      

      
   }
   static void getSite(int array[]) // '��ĭ'�� ��ġ ã���ִ� �Լ� 
   {
      shuffle(array,20); //�迭 'array'�� �������ִ� �Լ�
      
      for(int i=0; i<array.length; i++) // �迭�� ���� ���Ҹ��� *4
         array[i]=array[i]*4;
      
      array[1]=array[1]+3;//� ���Ҵ� +3
      array[2]=array[2]+1;//� ���Ҵ� +1
      array[3]=array[3]+2;//� ���Ҵ� +2
   }
   
   public static void ShuffleTest (String array[])// '��ĭ'�� ��ġ�� ���� �������� �������� �������� ���� ��ư�� ��ġ�Ѵ�
   {
      int a[] = {0,1,2,3}; //�迭 ���� 
      getSite(a);//'��ĭ'��ư�� �ε��� ���ϴ� �Լ� 
      
      int t=0;//swap������ �ΰ��� ����(�ε���)
      int j=0;
      
      while(j<button_names.length) //j�� ��ư�� �� �� ����
      {
         String temp3=null;//swap�����ٶ� �ӽ������� ������ ����
         if(button_names[j]=="��ĭ") //'��ĭ'�ι�ư�� '��ĭ'�� ������ ��ư�� swap���ִ� ����
         {
            temp3 = button_names[a[t]];
            button_names[a[t]]=button_names[j];
            button_names[j]=temp3;
            t++;
         }
         j++;
         if(t==4)//'��ĭ'4���� �� ã���� while�� Ż��  
         {
            break;
         }
         }
   
      Random rand = new Random();//���� ����
       for (int i = array.length - 1; i > 0; i--) //���� �迭�� '��ĭ'�� ��ġ�� ������ ������ ��ư���� ���� �����ִ� �ݺ���
       {
          int randIdx = rand.nextInt(i + 1); // 0~i���� �������� ���� �������� �����Ѵ�.
          if(randIdx==a[0])//������ '��ĭ'�� �ε����̸� pass
             continue;
          
          else if(randIdx!=a[1])//������ '��ĭ'�� �ε����̸� pass
             continue;
          
          else if(randIdx!=a[2]) //������ '��ĭ'�� �ε����̸� pass
             continue;
       
          else if(randIdx!=a[3]) //������ '��ĭ'�� �ε����̸� pass
             continue;
          
          else //�׿��� ��� ���� swap ���༭ �ڸ��� �ٲ�
          {
             String temp = array[randIdx];
                 array[randIdx] = array[i];
                 array[i] = temp;
          }
         
       }
           }
   public static void shuffle(int[] array, int count)//�������� �������ִ� �Լ� 
   {
      int temp1, temp2 , randomNum1 , randomNum2;//���� ����
      
      for(int i=0; i<count; i++) //�迭�� �ο��Ҹ� temp1�� temp2�� ����ְ� ���� swap�ϰ� �ٽ� �迭�� �־��ִ� �ݺ���
      {
         randomNum1 = (int)(Math.random()*array.length);
         temp1 = array[randomNum1];
         randomNum2 = (int)(Math.random()*array.length);
         temp2 = array[randomNum2];
         array[randomNum1] = temp2;
         array[randomNum2] = temp1;
      }
      
   }
   
   class PadActionListener implements ActionListener//�迭�� ����ִ� ��ư�� �̺�Ʈ ó���ϴ� Ŭ����
   {
      public void actionPerformed(ActionEvent e) {
         String operation = e.getActionCommand();
         
         if (operation.equals("��ü ����"))//'��ü����'��ư �̺�Ʈó�� 
        	 t1.setText("");
         else if (operation.equals("�ϳ� ����")) //'�ϳ�����'��ư �̺�Ʈó��
         {
        	 int t = t1.getText().length(); //JTextfield�� ���̸� ������ ����
             if (t == 0)//JTextfield�� �ƹ��͵� �Ⱦ��������� 
            	 t1.setText("");
             else if(t>0)//JTextfield�� ���� ����������
            	 {
            	 String b = t1.getText().substring(0, t - 1);//�ε��� ������ �ϳ� �����α����� �ؼ� �ڸ�
                 t1.setText(b);//'�ϳ�����'��ư �ϼ�
                      }}
         else if (operation.equals("��ĭ"))//'��ĭ'�� �ƹ��͵� ó�� ���ص��� 
         {
        	 
         }
         else 
        	 t1.setText(t1.getText() + e.getActionCommand());//������ ��ư�� �̺�Ʈ ó��
       
         
      }
   }
   
   void showCenter() 
   {
      
      buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));//JPanel�� ��ġ������
      buttonPanel.setBounds(15, 90, 270, 235);//JPanel�� ũ��

      JButton buttons[] = new JButton[button_names.length];//JButton����
      
      
      for (int i = 0; i < button_names.length; i++) //JButton �ٹ̰� buttonPanel�� �ø���
      {
         buttons[i] = new JButton(button_names[i]);
         
         if (button_names[i] == "��ü ����"||button_names[i] == "�ϳ� ����") buttons[i].setFont(new Font("���� ���", Font.BOLD, 10));
         else if(button_names[i] == "��ĭ") buttons[i].setFont(new Font("���� ���", Font.BOLD, 15));
         else buttons[i].setFont(new Font("���� ���", Font.BOLD, 20));
         
         if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) buttons[i].setBackground(Color.BLACK);
         else buttons[i].setBackground(Color.GRAY);
         buttons[i].setForeground(Color.WHITE);
         buttons[i].setBorderPainted(false);
         buttons[i].addActionListener(new PadActionListener());
         buttonPanel.add(buttons[i]);
         
      }
      add(buttonPanel);//��ư�� �ö� ��ư�г��� ����Ű���忡 �ø���
   }
   
   class ButtonActionListener implements ActionListener//'�Է¿Ϸ�'��ư �������� �Ͼ �̺�Ʈ ó�� (��ư ����)
   {
      public void actionPerformed(ActionEvent e) 
      {
         String operation = e.getActionCommand();
         
         
         if (operation.equals("�Է¿Ϸ�"))//'�Է¿Ϸ�'��ư�� ������
         {
            t1.setText("");//JTextField�� ���� �����
            String str = t1.getText();
            new secretKeyboard();//���ο� Ű���� ���� (��ư ����)
            }
        }
   }
   void showSouth() 
   {
      b.setBounds(5, 5, 30, 30);//JButton�� ũ��
      b.setFont(new Font("���� ���", Font.BOLD, 15));//JButton�� �۾�ü�� ũ��
      JPanel p = new JPanel();//�г��� ����
      b.addActionListener(new ButtonActionListener());//JButton �̺�Ʈ ó��

      p.add(b);//�гο� ��ư �ø���
      add(p, BorderLayout.SOUTH);
      
      
   }
   public static void main(String[] args) {
      new secretKeyboard();
   
   }
}


