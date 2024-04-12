package edu.sejong.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// 원활한 테스트를 위한 일시적 추가
@ToString
public class BoardVo {
	private int bid; 
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
	private int bgroup; // 원본글
	private int bstep; // 세로
	private int bindent; // 가로

	// 입력 페이지에서 게시글 입력 버튼을 눌렀을 때 세팅하게 될 데이터들
	public BoardVo(int bid, String bname, String btitle, String bcontent) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
	}
	
}
