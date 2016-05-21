1. 각 파일 및 기능

파일명 :  insert.jsp                    액션 :  게시판 입력 폼 출력
          insert_action.jsp                     게시판 입력 폼에서 넘어온 파라메터를 db에 저장
          list.jsp                              게시판 리스트 입력
          content.jsp                           게시판 상세보기
          update.jsp                            게시판 수정 폼에 저장된 출력
          update_action.jsp                     게시판 수정 폼에서 넘어온 파라메터로 db에 수정 
          delete.jsp                            게시판 삭제 폼 출력. 글번호에 대한 비밀번호를 입력
          delete_action.jsp                     게시판 삭제 폼에서 넘어온 글번호와 비밀번호 일치시 게시물삭제   
          
          
 2. table 생성
 -- 글 번호를 얻어오기 위한 시퀀스
 CREATE SEQUENCE seq_m1board;

--게시물을 저장하기 위한  m1board 테이블 생성

CREATE TABLE m1board
(
	no number NOT NULL, 					-- 글번호
	title varchar2(100) NOT NULL,			-- 제목
	name varchar2(20) NOT NULL,				-- 작성자
	content varchar2(4000) NOT NULL,		-- 내용
	pwd varchar2(256) NOT NULL,				-- 비밀번호
	readcount number DEFAULT 0 NOT NULL,	-- 조회수
	regdate date DEFAULT sysdate NOT NULL,	-- 작성시간
	PRIMARY KEY (no)						-- 글번호를 pk로 지정
);

 
