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
   
   JTextField t1;//숫자들이 쓰여지는 텍스트
   JTextArea t2;//입력한 내용에 대한 메세지를 출력하는 텍스트영역
   public static String button_names[] = new String[]{"빈칸","빈칸","빈칸","빈칸","전체 지움", "6", "3", "8", "7", "하나 지움", "4", "1", "5", "9", "2", "0" };//버튼의 이름배열
   JButton buttons[] = new JButton[button_names.length];//버튼 생성
   JPanel buttonPanel = new JPanel();//버튼 패널 생성
   JButton b = new JButton("입력완료");//맨 밑에 들어가는 '입력완료'버튼 생성

   
   
   secretKeyboard(){
      setTitle("보안용 키보드");
      
      ShuffleTest(button_names);//키보드가 생성될때마다 새롭게 배치되는 버튼

      
      setLayout(new BorderLayout(10,10));//키보드 전체의 배치관리자 :BorderLayout
      showNorth();//각 영역 실행
      showCenter();
      showSouth();
      
      setVisible(true);//화면에 보이게 하는거
      setPreferredSize(new Dimension(400,500));//선호 사이즈 결정
      setSize(new Dimension(400,500));//사이즈 설정
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료버튼과 함께 프로그램 종료
   }
   
   void showNorth() {
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      JPanel panel = new JPanel(new GridLayout(2,0)); //패널(north부분)의 배치관리자 
      
      t1 = new JTextField(10);//JTextField 생성
      t1.setBackground(Color.WHITE);//JTextField의 배경색  : 흰색
      t1.setHorizontalAlignment(JTextField.CENTER);//JTextField의 텍스트는 중간부터
      t1.setFont(new Font("맑은 고딕", Font.BOLD, 30));//JTextField의 글씨체와 크기 
      t1.setBounds(8, 10, 230, 50);//JTextField 크기 및 위치 지정
      
      JTextArea t2 = new JTextArea();//JTextArea 생성
      t2.setEditable(false);//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
      t2.setBackground(Color.GRAY);//JtextArea 배경색 : 회색
      t2.setForeground(Color.BLACK);//JtextArea 글씨색 : 검은색
      t2.setText("보안 문자를 입력하세요");//JtextArea의 내용 "보안 문자를 입력하세요"
      t2.setFont(new Font("맑은 고딕", Font.BOLD, 15)); //JtextArea의 글자 크기및 글씨체
      t2.setBounds(50, 50, 300, 300); //JTeatArea 크기 및 위치 지정
      
      ActionListener listener2 = e ->{
    	  if(e.getSource()==b) //JButton이 눌릴때
      {
    		  String sb = "572943";//미리 정해진 비밀번호
    		  boolean a = t1.getText().equals(sb);//JTextField가 미리정해진 비밀번호와 같을때 
		      if(a==true) {
		    	  t2.setText("잠금이 해제되었습니다");//JtextArea에 "잠금이 해제되었습니다"입력
		        	}
		       else {
		    	   t2.setText("잘못 입력하셨습니다");//JtextArea에 "잘못 입력하셨습니다"입력
		        	}
			
		}
			};
		
			
			
	b.addActionListener(listener2);//버튼에 이벤트 입력

      p1.add(t1);//JPanel에 JTextField 올리기
      p2.add(t2);//JPanel에 JTextField 올리기
      
      panel.add(p1);//JPanel에 JPanel 올리기
      panel.add(p2);//JPanel에 JPanel 올리기
      
      add(panel,BorderLayout.NORTH);//JPanel을 북쪽에 올리기
      

      
   }
   static void getSite(int array[]) // '빈칸'의 위치 찾아주는 함수 
   {
      shuffle(array,20); //배열 'array'를 셔플해주는 함수
      
      for(int i=0; i<array.length; i++) // 배열의 각각 원소마다 *4
         array[i]=array[i]*4;
      
      array[1]=array[1]+3;//어떤 원소는 +3
      array[2]=array[2]+1;//어떤 원소는 +1
      array[3]=array[3]+2;//어떤 원소는 +2
   }
   
   public static void ShuffleTest (String array[])// '빈칸'의 위치를 먼저 지정한후 나머지를 랜덤으로 돌려 버튼을 배치한다
   {
      int a[] = {0,1,2,3}; //배열 생성 
      getSite(a);//'빈칸'버튼의 인덱스 구하는 함수 
      
      int t=0;//swap시켜줄 두개의 변수(인덱스)
      int j=0;
      
      while(j<button_names.length) //j가 버튼을 다 돌 동안
      {
         String temp3=null;//swap시켜줄때 임시적으로 저장할 공간
         if(button_names[j]=="빈칸") //'빈칸'인버튼과 '빈칸'이 들어가야할 버튼을 swap해주는 과정
         {
            temp3 = button_names[a[t]];
            button_names[a[t]]=button_names[j];
            button_names[j]=temp3;
            t++;
         }
         j++;
         if(t==4)//'빈칸'4개를 다 찾으면 while문 탈출  
         {
            break;
         }
         }
   
      Random rand = new Random();//난수 생성
       for (int i = array.length - 1; i > 0; i--) //먼저 배열된 '빈칸'의 위치를 제외한 나머지 버튼들을 셔플 시켜주는 반복문
       {
          int randIdx = rand.nextInt(i + 1); // 0~i값의 범위에서 정수 랜덤값을 추출한다.
          if(randIdx==a[0])//난수가 '빈칸'의 인덱스이면 pass
             continue;
          
          else if(randIdx!=a[1])//난수가 '빈칸'의 인덱스이면 pass
             continue;
          
          else if(randIdx!=a[2]) //난수가 '빈칸'의 인덱스이면 pass
             continue;
       
          else if(randIdx!=a[3]) //난수가 '빈칸'의 인덱스이면 pass
             continue;
          
          else //그외의 경우 서로 swap 해줘서 자리를 바꿈
          {
             String temp = array[randIdx];
                 array[randIdx] = array[i];
                 array[i] = temp;
          }
         
       }
           }
   public static void shuffle(int[] array, int count)//정수형을 셔플해주는 함수 
   {
      int temp1, temp2 , randomNum1 , randomNum2;//변수 생성
      
      for(int i=0; i<count; i++) //배열의 두원소를 temp1과 temp2에 집어넣고 둘이 swap하고 다시 배열에 넣어주는 반복문
      {
         randomNum1 = (int)(Math.random()*array.length);
         temp1 = array[randomNum1];
         randomNum2 = (int)(Math.random()*array.length);
         temp2 = array[randomNum2];
         array[randomNum1] = temp2;
         array[randomNum2] = temp1;
      }
      
   }
   
   class PadActionListener implements ActionListener//배열에 들어있는 버튼들 이벤트 처리하는 클래스
   {
      public void actionPerformed(ActionEvent e) {
         String operation = e.getActionCommand();
         
         if (operation.equals("전체 지움"))//'전체지움'버튼 이벤트처리 
        	 t1.setText("");
         else if (operation.equals("하나 지움")) //'하나지움'버튼 이벤트처리
         {
        	 int t = t1.getText().length(); //JTextfield의 길이를 변수로 생성
             if (t == 0)//JTextfield에 아무것도 안쓰여있을때 
            	 t1.setText("");
             else if(t>0)//JTextfield에 무언가 쓰여있을때
            	 {
            	 String b = t1.getText().substring(0, t - 1);//인덱스 끝에서 하나 앞으로까지로 해서 자름
                 t1.setText(b);//'하나지움'버튼 완성
                      }}
         else if (operation.equals("빈칸"))//'빈칸'은 아무것도 처리 안해도됨 
         {
        	 
         }
         else 
        	 t1.setText(t1.getText() + e.getActionCommand());//나머지 버튼들 이벤트 처리
       
         
      }
   }
   
   void showCenter() 
   {
      
      buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));//JPanel의 배치관리자
      buttonPanel.setBounds(15, 90, 270, 235);//JPanel의 크기

      JButton buttons[] = new JButton[button_names.length];//JButton생성
      
      
      for (int i = 0; i < button_names.length; i++) //JButton 꾸미고 buttonPanel에 올리기
      {
         buttons[i] = new JButton(button_names[i]);
         
         if (button_names[i] == "전체 지움"||button_names[i] == "하나 지움") buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 10));
         else if(button_names[i] == "빈칸") buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
         else buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
         
         if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) buttons[i].setBackground(Color.BLACK);
         else buttons[i].setBackground(Color.GRAY);
         buttons[i].setForeground(Color.WHITE);
         buttons[i].setBorderPainted(false);
         buttons[i].addActionListener(new PadActionListener());
         buttonPanel.add(buttons[i]);
         
      }
      add(buttonPanel);//버튼이 올라간 버튼패널을 보안키보드에 올리기
   }
   
   class ButtonActionListener implements ActionListener//'입력완료'버튼 눌렀을때 일어날 이벤트 처리 (버튼 셔플)
   {
      public void actionPerformed(ActionEvent e) 
      {
         String operation = e.getActionCommand();
         
         
         if (operation.equals("입력완료"))//'입력완료'버튼이 눌리면
         {
            t1.setText("");//JTextField의 내용 지우기
            String str = t1.getText();
            new secretKeyboard();//새로운 키보드 생성 (버튼 셔플)
            }
        }
   }
   void showSouth() 
   {
      b.setBounds(5, 5, 30, 30);//JButton의 크기
      b.setFont(new Font("맑은 고딕", Font.BOLD, 15));//JButton의 글씨체와 크기
      JPanel p = new JPanel();//패널을 생성
      b.addActionListener(new ButtonActionListener());//JButton 이벤트 처리

      p.add(b);//패널에 버튼 올리기
      add(p, BorderLayout.SOUTH);
      
      
   }
   public static void main(String[] args) {
      new secretKeyboard();
   
   }
}


