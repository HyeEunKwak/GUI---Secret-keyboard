# GUI---Secret-keyboard
보안키보드를 자바 GUI를 활용하여 만들어보기
⦁	버튼 배치 알고리즘
 배열 ‘button_names’에 버튼들을 넣어 놓고 이것을 모두 버튼에 올린 후 버튼을 버튼 패널에 올립니다. 
 <빈칸의 위치를 구현하는 알고리즘>
  버튼 ‘빈칸’의 위치를 잡아주기 위해 함수 getSite를 만들어 버튼 ‘빈칸’이 들어갈 인덱스들을 구해놓습니다. 여기서 getSite의 구현 방식은 밑 그림과 같이 버튼 판을 4*4 배열로 생각했을 각    줄마다 끊으면 0~3 ,4~7,8~11,12~15가 됩니다. 여기서 각 줄에 하나 각 칸의 하나로 집어넣을려면 기준이 되는 인덱스 [0],[4],[8],[12]를 랜덤으로 셔플해준후 셔플된 인덱스에 각각 +0,+1,+2,+3을 해줍니다. for문을 통해 배열 ‘button_names’에서 버튼’빈칸’을 만날때마다 버튼’빈칸’이 들어가야할 인덱스들과 swap해줍니다.
  <버튼을 swap 해주는 알고리즘>
  버튼’빈칸’의 위치가 정해진 후 배열‘button_names’에 나머지 원소들은 swap과 난수를 이용하여 셔플해줍니다. 그리하면 버튼이 생성될때마다 버튼’빈칸’의 위치는 제시된 조건과 맞으면서 셔플이 가능해집니다.
⦁	GUI 구성
 배치관리자 ‘BorderLayout’을 통해 North,Center,South 세부분으로 나뉘어 전체를 완성합니다. North (showNorth) 부분에서는 배치관리자 GridLayout을 이용하여 JTextField와 JTextArea가 올라간 JPanel들을 배치하고 있습니다. Center (showCenter) 부분에서는 배치관리자 GridLayout을 이용하여 JPanel들을 배치하고 있습니다. South(voidSouth)부분은 버튼 하나와 패널 하나만 올리므로 따로 배치관리자를 사용하지 않습니다. 각각의 JTextArea,JTextField,JButton은 JPanel에 올린후 JPanel을 프로그램에 올립니다.   
⦁	프로그램 구성
 이 프로그램의 함수는 총 7개이고 클래스는 2개입니다. 메인이 되는 함수인 secretKeyboard와 그 외 나머지 showNorth,showCenter,showSouth,shuffleTest,Shuffle,getSite가 있습니다. 2개의 클래스인 PadActionListener, ButtonActionListener가 버튼의 이벤트를 처리해줍니다. 메인함수 안에서 여러함수등을 호출하는 방식으로 짜여져 있습니다. 
⦁	버튼 ‘입력완료’ 눌린 후 JTextArea의 변화
 처음에는 JTextArea에 ‘보안 문자를 입력하세요’라고 뜨다가 '입력완료'버튼이 누르면 JTextField의 값과 원래 지정되어있는 비밀번호 값과 비교한후 true이면 '잠금이 해제되었습니다'가 뜨고 false이면 '잘못 입력하셨습니다'가 뜬다 
