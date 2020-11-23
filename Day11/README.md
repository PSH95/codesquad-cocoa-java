CodeSquad Masters Cocoa Java Practice
=====================================

2020/11/16, Day 11
-----------------

한글시계 클론
--------------------

[참고링크](https://hangulclock.today/#/main)

![](https://raw.githubusercontent.com/dsa28s/windows-hangul-clock/master/Resources/dashboard-screenshot.png)


구현된 기능
----------

 - 2차원 배열이 아닌, ArrayList를 통해 한글시간 구축
 - 현재시간을 불러와 한글시계 출력 (삭제)
 - 임의의 시간을 키보드로 입력받아 한글시계 출력 (삭제)
 - 0.5초 간격으로 시간의 주기적 변화
 - ANSI 이스케이프 코드를 활용하여 현재 한글 시간 콘솔 글씨 색 변경
 
개선할 기능
----------
 - 직관성과 효율성을 위해, 2차원 배열로 다시 제작
 - 알람기능 제작 (지정한 알람시간이 될 경우, 사운드와 글자 출력)
 - 클래스로 분리하기


 구현결과
 ------
  ![](https://images.velog.io/images/san/post/95015a9f-8d76-4e7e-9e70-b003ae0175b6/%EC%BA%A1%EC%B2%98.PNG)