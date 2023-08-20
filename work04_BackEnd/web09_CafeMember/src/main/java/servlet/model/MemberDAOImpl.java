package servlet.model;
/*
 * DataSource방식으로 디비 연결하기..
 * Connection을 DB 연결할 때마다 직접 생성해서 반환받는 것이 아니라 
 * 이미 컨테이너 차원에서 여러 개의 생성된 Connection을 가지고 있는 Connection Factory에서 
 * 하나씩 Rent 해온다. 
 * 
 * 0. InitialContext 객체 생성(1을 위한 메소드 ic.lookup이 있기 때문)
 * 1. DataSource를 하나 받아온다. 
 * 2. 그 안에 있는 Connection을 하나 빌어다 쓴다.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import servlet.model.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl(){
		//0. InitialContext 객체 생성(1을 위한 메소드 ic.lookup이 있기 때문)
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB"); //Factory를 찾아옴.(부모타입으로-폴리몰피즘)
			System.out.println("DataSource Lookup Success...!");
			
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail...!");
		} 
		//1. DataSource를 하나 받아온다. 
	};
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //Connection 하나씩 Pool에서 받아온다..
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnection();
			String query = "INSERT INTO member1(id, password, name, address) VALUES(?,?,?,?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row Insert OK~");
		
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member1";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllMember()..");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(
						rs.getString("id"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try{
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member1 WHERE id = ?";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO(id, 
                        rs.getString("password"), 
                        rs.getString("name"),
                        rs.getString("address"))
                        ;
			}
			System.out.println(vo);
			//
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}	

//   일종의 dao 단위테스트 -> main()을 달아서 하나의 비즈니스 로직이 성공하는지 꼭 확인하기
//	public static void main(String[] args)throws Exception{
//		MemberDAOImpl dao=MemberDAOImpl.getInstance();
//		MemberVO VO=dao.findByIdMember("encore");
//		System.out.println(VO);
//		
//		ArrayList<MemberVO> list=dao.showAllMember();
//		System.out.println(list);
//		dao.registerMember(new MemberVO("111","222","고길동","여의도"));
//	}
}

















