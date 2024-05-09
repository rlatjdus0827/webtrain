package com.shinhan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shinhan.dto.LesDTO;
import com.shinhan.dto.LesDetailDTO;
import com.shinhan.dto.MemDTO;
import com.shinhan.dto.ResDTO;
import com.shinhan.dto.TrainDTO;

import com.shinhan.util.DBUtil;

public class MemDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	CallableStatement cstmt;

	// 회원 추가(회원 가입)
	public int memInsert(MemDTO mem) {
		int result = 0;
		String sql = "insert into members values (?,?,?,?,?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mem.getMem_id());
			pst.setString(2, mem.getMem_pw());
			pst.setString(3, mem.getMem_name());
			pst.setString(4, mem.getMem_email());
			pst.setString(5, mem.getMem_phone());
			pst.setInt(6, 16);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 강사 추가(회원 가입)
	public int trainInsert(TrainDTO trn) {
		int result = 0;
		String sql = "insert into trainers values (?,?,?,?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, trn.getTrn_id());
			pst.setString(2, trn.getTrn_pw());
			pst.setString(3, trn.getTrn_name());
			pst.setString(4, trn.getTrn_email());
			pst.setString(5, trn.getTrn_phone());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 강사 로그인
	public TrainDTO login2(String id, String pw) {
		TrainDTO trn = null;
		String sql = "select * from trainers where trn_id = ? and trn_pw = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				trn = new TrainDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return trn;
	}
	//아이디,비밀번호 체크(회원용)
	public MemDTO loginChk(String id, String pw) {
		MemDTO mem = null;
		String sql = "select * from members where mem_id = ? " ;
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if (rs.next()) {//아이디가 존재하면 비밀번호가 맞는지 확인
				if(rs.getString("mem_pw").equals(pw)) {
					
					mem = new MemDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6));
				}else {
					mem = new MemDTO();
					mem.setMem_id("-2");//비밀번호 오류
					
				}
				
			}else {//아이디 오류
				mem = new MemDTO();
				mem.setMem_id("-1"); //존재하지 않는 직원
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return mem;
	}
	//아이디,비밀번호 체크(강사용)
		public TrainDTO loginChk2(String id, String pw) {
			TrainDTO trn = null;
			String sql = "select * from trainers where trn_id = ? " ;
			conn = DBUtil.dbConnection();
			try {

				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				rs = pst.executeQuery();
				
				if (rs.next()) {//아이디가 존재하면 비밀번호가 맞는지 확인
					if(rs.getString("trn_pw").equals(pw)) {
						
						trn = new TrainDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					}else {
						trn = new TrainDTO();
						trn.setTrn_id("-2");//비밀번호 오류
						
					}
					
				}else {//아이디 오류
					trn = new TrainDTO();
					trn.setTrn_id("-1"); //존재하지 않는 직원
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return trn;
		}
	// 회원 로그인
	public MemDTO login(String id, String pw) {
		MemDTO mem = null;
		String sql = "select * from members where mem_id = ? and mem_pw = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				mem = new MemDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
//						mem.setMem_name(rs.getString("mem_name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return mem;
	}

	// 회원 id 중복검사
	public int alreadyMember(String id) {
		int result = 0;
		String sql = "select count(*) as existuser from members where mem_id = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt("existuser");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

    // 강사 id중복검사
	public int alreadyMember2(String id) {
		int result = 0;
		String sql = "select count(*) as existuser from trainers where trn_id = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt("existuser");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// 수강인원 제한 (0일때 예약할수 없음)
	public int zeroCnt(String lescode) {
		int result = 0;
		String sql = "select count(*) as zerocount from lesson where les_code = ? and les_available_cnt = 0";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lescode);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt("zerocount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// 마이페이지 회원 한명 정보조회
	public MemDTO memInfo(String memid) {
		MemDTO mem = null;
		String sql = "select * from members where mem_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, memid);
			rs = pst.executeQuery();
			if (rs.next()) {
				mem = makeMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;

	}

	// 마이페이지 강사 한명 정보조회
	public TrainDTO trnInfo(String trnid) {
		TrainDTO trn = null;
		System.out.println("타니?1");
		String sql = "select * from trainers where trn_id = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, trnid);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("타니?2");
				trn = makeTrainer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trn;

	}

	// 강사 한 명의 강의 정보 조회
	public List<LesDTO> lesInfo(String trnid) {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "select * from lesson where trn_id = ? order by les_date ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, trnid);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDTO les = makeLesson(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return leslist;
	}

	// 회원 한 명의 예약 정보 조회
	public List<ResDTO> resInfo(String memid) {
		List<ResDTO> reslist = new ArrayList<ResDTO>();
		String sql = "select * from reservations where mem_id = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, memid);
			rs = pst.executeQuery();
			while (rs.next()) {
				ResDTO res = makeRes(rs);
				reslist.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return reslist;
	}

	// 회원의 예약 정보 조회
	public List<LesDetailDTO> resInfo2(String memid) {
		List<LesDetailDTO> ldlist = new ArrayList<>();
		String sql = "select r.res_code,l.les_code,l.trn_id,t.trn_name,l.les_machine,l.les_date,l.les_start_time,l.les_end_time,l.les_porg,r.mem_id "
				+ "from lesson l , reservations r , trainers t "
				+ "where l.les_code = r.les_code and t.trn_id = l.trn_id and mem_id= ? " + "order by les_date ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, memid);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDetailDTO ld = makeLesDetail(rs);
				ldlist.add(ld);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return ldlist;
	}
	
	// 강의 전체 일정 조회
	public List<LesDTO> selectLesAll() {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "select * from lesson order by les_date";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				LesDTO les = makeLesson(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return leslist;
	}
	public List<LesDTO> selectLesAll2() {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "select l.les_code, l.trn_id, t.trn_name, l.les_machine, l.les_date, l.les_start_time, l.les_end_time,l.les_available_cnt, l.les_porg "
				+ "from lesson l, trainers t "
				+ "where l.trn_id = t.trn_id "
				+ "order by les_date ";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				LesDTO les = makeLesson2(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return leslist;
	}
	// 날짜별 일정 조회
	public List<LesDTO> selectLesDate(String date) {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "select * from lesson where les_date = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, date);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDTO les = makeLesson(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return leslist;
	}
	public List<LesDTO> selectLesDate2(Date date) {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "SELECT l.les_code, l.trn_id, t.trn_name, l.les_machine, l.les_date, l.les_start_time, l.les_end_time, l.les_available_cnt, l.les_porg "
				+ "FROM lesson l "
				+ "JOIN trainers t ON l.trn_id = t.trn_id "
				+ "WHERE l.les_date = ?"
				+ "ORDER BY l.les_date";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, date);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDTO les = makeLesson2(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return leslist;
	}
	// 기구별 일정 조회
	public List<LesDTO> selectLesMachine(String machine) {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "select * from lesson where les_machine = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, machine);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDTO les = makeLesson(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return leslist;
	}
	public List<LesDTO> selectLesMachine2(String machine) {
		List<LesDTO> leslist = new ArrayList<LesDTO>();
		String sql = "SELECT l.les_code, l.trn_id, t.trn_name, l.les_machine, l.les_date, l.les_start_time, l.les_end_time,l.les_available_cnt, l.les_porg "
				+ "FROM lesson l "
				+ "JOIN trainers t ON l.trn_id = t.trn_id "
				+ "WHERE l.les_machine = ? "
				+ "ORDER BY l.les_date";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, machine);
			rs = pst.executeQuery();
			while (rs.next()) {
				LesDTO les = makeLesson2(rs);
				leslist.add(les);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return leslist;
	}
	// 강의 예약
	public int resInsert(ResDTO res) {
		int result = 0;
		String sql = "insert into reservations values(res_seq.nextval,?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, res.getMem_id());
			pst.setString(2, res.getLes_code());
			result = pst.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("번호에 맞는 레슨이 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 프로시저 호출로 강의 delete
	public int resDelete(String rescode) {

		String sql = "{call mem_del_table(?, ?)}";
		cstmt = null;
		conn = DBUtil.dbConnection();
		int result = 0;
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, rescode);
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.execute();
			result = cstmt.getInt(2);

		} catch (SQLException e) {
			System.out.println("번호에 맞는 예약이 없습니다.");
		} finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		return result;
	}

	// 강사의 강의 추가
	public int lesInsert(LesDTO les, String trnid) {
		int result = 0;
		String sql = "insert into lesson values (les_seq.nextval,?,?,?,?,?,?,?) ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, trnid);
			pst.setString(2, les.getLes_machine());
			pst.setDate(3, les.getLes_date());
			pst.setString(4, les.getLes_start_time());
			pst.setString(5, les.getLes_end_time());
			pst.setInt(6, les.getLes_available_cnt());
			pst.setString(7, les.getLes_porg());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 강사의 강의 취소
	public int lesDelete(String lescode) {
		int result = 0;
		String sql = "delete from lesson where les_code = ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lescode);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// 회원 정보 수정
	public int memUpdate(MemDTO mem) {
		int result = 0;
		String sql = " update members set MEM_PW= ?,MEM_NAME= ?, MEM_EMAIL= ?, MEM_PHONE= ? " + " where MEM_ID= ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(5, mem.getMem_id());
			pst.setString(1, mem.getMem_pw());
			pst.setString(2, mem.getMem_name());
			pst.setString(3, mem.getMem_email());
			pst.setString(4, mem.getMem_phone());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// 강사 정보 수정
	public int trnUpdate(TrainDTO trn) {
		int result = 0;
		String sql = "update trainers set TRN_PW= ?,TRN_NAME=?, TRN_EMAIL=?, TRN_PHONE=? where TRN_ID= ? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(5, trn.getTrn_id());
			pst.setString(1, trn.getTrn_pw());
			pst.setString(2, trn.getTrn_name());
			pst.setString(3, trn.getTrn_email());
			pst.setString(4, trn.getTrn_phone());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// ------------------------------------------------------------------------------------------------------------------
	// mem
	private MemDTO makeMember(ResultSet rs) throws SQLException {
		MemDTO mem = new MemDTO();
		try {
			mem.setMem_id(rs.getString("mem_id"));
			mem.setMem_pw(rs.getString("mem_pw"));
			mem.setMem_name(rs.getString("mem_name"));
			mem.setMem_email(rs.getString("mem_email"));
			mem.setMem_phone(rs.getString("mem_phone"));
			mem.setMem_lesson_cnt(rs.getInt("mem_lesson_cnt"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	// train
	private TrainDTO makeTrainer(ResultSet rs) throws SQLException {
		TrainDTO trn = new TrainDTO();
		try {
			trn.setTrn_id(rs.getString("trn_id"));
			trn.setTrn_pw(rs.getString("trn_pw"));
			trn.setTrn_name(rs.getString("trn_name"));
			trn.setTrn_email(rs.getString("trn_email"));
			trn.setTrn_phone(rs.getString("trn_phone"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trn;
	}

	// lesson
	private LesDTO makeLesson(ResultSet rs) throws SQLException {
		LesDTO les = new LesDTO();
		try {
			les.setLes_code(rs.getString("les_code"));
			les.setTrn_id(rs.getString("trn_id"));
			les.setLes_machine(rs.getString("les_machine"));
			les.setLes_date(rs.getDate("les_date"));
			les.setLes_start_time(rs.getString("les_start_time"));
			les.setLes_end_time(rs.getString("les_end_time"));
			les.setLes_available_cnt(rs.getInt("les_available_cnt"));
			les.setLes_porg(rs.getString("les_porg"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return les;
	}
	private LesDTO makeLesson2(ResultSet rs) throws SQLException {
		LesDTO les = new LesDTO();
		try {
			les.setLes_code(rs.getString("les_code"));
			les.setTrn_id(rs.getString("trn_id"));
			les.setTrn_name(rs.getString("trn_name"));
			les.setLes_machine(rs.getString("les_machine"));
			les.setLes_date(rs.getDate("les_date"));
			les.setLes_start_time(rs.getString("les_start_time"));
			les.setLes_end_time(rs.getString("les_end_time"));
			les.setLes_available_cnt(rs.getInt("les_available_cnt"));
			les.setLes_porg(rs.getString("les_porg"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return les;
	}
	// Reservation
	private ResDTO makeRes(ResultSet rs) throws SQLException {
		ResDTO res = new ResDTO();
		try {
			res.setRes_code(rs.getString("res_code"));
			res.setMem_id(rs.getString("mem_id"));
			res.setLes_code(rs.getString("les_code"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// LesDetail
	private LesDetailDTO makeLesDetail(ResultSet rs) throws SQLException {
		LesDetailDTO ld = new LesDetailDTO();
		ld.setRes_code(rs.getString("res_code"));
		ld.setLes_code(rs.getString("les_code"));
		ld.setTrn_id(rs.getString("trn_id"));
		ld.setTrn_name(rs.getString("trn_name"));
		ld.setLes_machine(rs.getString("les_machine"));
		ld.setLes_date(rs.getDate("les_date"));
		ld.setLes_start_time(rs.getString("les_start_time"));
		ld.setLes_end_time(rs.getString("les_end_time"));
		ld.setLes_porg(rs.getString("les_porg"));
		ld.setMem_id(rs.getString("mem_id"));

		return ld;
	}
}