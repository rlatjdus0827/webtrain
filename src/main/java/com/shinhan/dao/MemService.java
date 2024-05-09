package com.shinhan.dao;

import java.sql.Date;
import java.util.List;

import com.shinhan.dto.LesDTO;
import com.shinhan.dto.LesDetailDTO;
import com.shinhan.dto.MemDTO;
import com.shinhan.dto.ResDTO;
import com.shinhan.dto.TrainDTO;

public class MemService {
	MemDAO memDAO = new MemDAO();
	//trn loginchk
	public TrainDTO loginChk2(String id, String pw) {
		return memDAO.loginChk2(id, pw);
	}
	//mem loginchk
	public MemDTO loginChk(String id, String pw) {
		return memDAO.loginChk(id, pw);
	}
	//trainer 정보조회
	public TrainDTO trnInfo(String trnid) {
		return memDAO.trnInfo(trnid);
	}
	//member 정보조회
	public MemDTO memInfo(String memid) {
		return memDAO.memInfo(memid);
	}
	//mem 정보수정
	public int memUpdate(MemDTO mem) {
		return memDAO.memUpdate(mem);
	}
	//trn 정보수정
	public int trnUpdate(TrainDTO trn) {
		return memDAO.trnUpdate(trn);
	}
	//강의 일정 전체 조회
	public List<LesDTO> selectLesAll() {
		return memDAO.selectLesAll();
	}
	public List<LesDTO> selectLesAll2() {
		return memDAO.selectLesAll2();
	}
	//회원추가
	public int memInsert(MemDTO mem) {
		return memDAO.memInsert(mem);
	}
	//강의추가
	public int lesInsert(LesDTO les,String trnid) {
		return memDAO.lesInsert(les, trnid);
	}
	//예약추가
	public int resInsert(ResDTO res) {
		return memDAO.resInsert(res);
	}
	//예약취소
	public int resDelete(String rescode) {
		return memDAO.resDelete(rescode);
	}
	//강의삭제
	public int lesDelete(String lescode) {
		return memDAO.lesDelete(lescode);
	}
	//강의리스트 조회
	public List<LesDTO> lesInfo(String trnid) {
		return memDAO.lesInfo(trnid);
	}
	//날짜별 레슨 조회
	public List<LesDTO> selectLesDate(String date){
		return memDAO.selectLesDate(date);
	}
	public List<LesDTO> selectLesDate2(Date date){
		return memDAO.selectLesDate2(date);
	}
	//기구별 레슨 조회
	public List<LesDTO> selectLesMachine(String machine){
		return memDAO.selectLesMachine(machine);
	}
	public List<LesDTO> selectLesMachine2(String machine) {
		return memDAO.selectLesMachine2(machine);
	}
	//예약리스트 조회
	public List<ResDTO> resInfo(String memid) {
		return memDAO.resInfo(memid);
	}
	//강사추가
	public int trainInsert(TrainDTO trn) {
		return memDAO.trainInsert(trn);
	}
	//한명 회원의 예약정보조회
	public List<LesDetailDTO> resInfo2(String memid) {
		return memDAO.resInfo2(memid);
	}
	//id검사(회원
	public int alreadyMember(String id) {

		return memDAO.alreadyMember(id);
	}
	//id검사(강사
	public int alreadyMember2(String id) {

		return memDAO.alreadyMember2(id);
	}
	//수강인원 제한
	public int zeroCnt(String lescode) {
		return memDAO.zeroCnt(lescode);
	}
	//로그인
	public int login(String id, String pw) {

		MemDTO mem = memDAO.login(id, pw);
		if (mem == null) {
			return 0;
		}
		return 1;
	}

	public int login2(String id, String pw) {

		TrainDTO trn = memDAO.login2(id, pw);
		if (trn == null) {
			return 0;
		}
		return 1;
	}
}