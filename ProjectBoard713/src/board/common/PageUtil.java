package board.common;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	private static PageUtil instance;
	private int TotalRecord;
	private int PageSize = 10;        //�� �������� ������ ���� ����
	private int CurrentPage = 1;    //���� ������
	private int BlockSize = 10;     //�ѹ��� ������ ��(������ ����) ����
	private int TotalPage;
	private int FirstBlock;
	private int LastBlock;
	private int curPos;
	private int num;
	private String keyword = "";
	private String keyColumn = "title";
	
	
	public static PageUtil getInstance() {
		if(instance == null){
			instance = new PageUtil();
		}
		return instance;
	}

	public void init(int TotalRecord, HttpServletRequest req, String keyword, String  keyColumn, int CurrentPage){
		this.TotalRecord = TotalRecord;  //�Խñ��� �� ����
		TotalPage =  (int) Math.ceil((float)TotalRecord/PageSize);		   // �Խñ� �� ���� % ���������� ������ ��� ���� 
		System.out.println("�Ѱܹ��� keyword �� : " + keyword);

		this.CurrentPage = CurrentPage;
		if(keyword != null) {
			this.keyword = keyword;
		}
		this.keyColumn = keyColumn;
		
		FirstBlock = CurrentPage - ((CurrentPage-1) % BlockSize);       
		LastBlock  = FirstBlock + (BlockSize-1);                       
		curPos = (CurrentPage-1) * PageSize;
		num    = TotalRecord - curPos;
	}

	public String getKeyColumn() {
		return keyColumn;
	}

	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getTotalRecord() {
		return TotalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		TotalRecord = totalRecord;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getCurrentPage() {
		return CurrentPage;
	}

	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}

	public int getBlockSize() {
		return BlockSize;
	}

	public void setBlockSize(int blockSize) {
		BlockSize = blockSize;
	}

	public int getTotalPage() {
		return TotalPage;
	}

	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}

	public int getFirstBlock() {
		return FirstBlock;
	}

	public void setFirstBlock(int firstBlock) {
		FirstBlock = firstBlock;
	}

	public int getLastBlock() {
		return LastBlock;
	}

	public void setLastBlock(int lastBlock) {
		LastBlock = lastBlock;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
