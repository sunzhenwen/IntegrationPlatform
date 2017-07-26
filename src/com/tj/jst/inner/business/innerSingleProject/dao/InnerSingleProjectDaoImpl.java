package com.tj.jst.inner.business.innerSingleProject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.innerSingleProject.model.InnerSingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public class InnerSingleProjectDaoImpl extends BaseDao implements IInnerSingleProjectDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					InnerSingleProject sp = new InnerSingleProject();
					
					sp.setSpId(rs.getInt("unitid"));//����
					sp.setPrjId(rs.getString("prjid"));//��������
					sp.setSpNum(rs.getString("unitcode"));//��λ����
					sp.setBuildingName(rs.getString("subprjname"));//��λ��(��)��������
					sp.setBuildingArea(rs.getString("buildarea"));//�������(ƽ����)
					sp.setInvestAmount(rs.getString("invest"));//Ͷ�ʶ�(��Ԫ)
					sp.setOvergroundArea(rs.getString("floorbuildarea"));//���Ͻ������(ƽ����)
					sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//���½������(ƽ����)
					sp.setOvergroundNum(rs.getInt("floorcount"));//���ϲ���
					sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//���²���
					sp.setBuildingHeight(rs.getString("buildheight"));//�����߶�(��)
					sp.setEngineeringGrade(rs.getString("prjlevelnum"));//���̵ȼ�   0:���� 1:����  2:С�� 
					sp.setLengthKm(rs.getString("subprojectlength"));//����(����)
					sp.setSpanM(rs.getString("subprojectspan"));//���(��)
					sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
					sp.setProjectSize(rs.getString("pjrsize"));//���̹�ģ
					sp.setOther(rs.getString("memo"));//����
					sp.setLinkName(rs.getString("createtype"));//�����������Ŀ���ڱ�ţ�3��ʩ��ͼ��� 4����ȫ�ල 5��ʩ����� 6���������ձ���
					page.getData().add(sp);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ���
	 * @param construction
	 * @return
	 */
	public void add(InnerSingleProject sp)
	{
		String spId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTUNITINFO(unitid,prjid,unitcode,"
					+ "subprjname,buildarea,invest,floorbuildarea,bottomfloorbuildarea,"
					+ "floorcount,bottomfloorcount,buildheight,prjlevelnum,"
					+ "subprojectlength,subprojectspan,structuretypenum,pjrsize,memo,"
					+ "createtype) values(SINGLE_SEQ.Nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sp.getPrjId());//������Ŀ����
			pstmt.setString(2,sp.getSpNum());//��λ����
			pstmt.setString(3,sp.getBuildingName());//��λ��(��)��������
			pstmt.setString(4,sp.getBuildingArea());//�������(ƽ����)
			pstmt.setString(5,sp.getInvestAmount());//Ͷ�ʶ�(��Ԫ)
			pstmt.setString(6,sp.getOvergroundArea());//���Ͻ������(ƽ����)
			pstmt.setString(7,sp.getUndergroundArea());//���½������(ƽ����)
			pstmt.setInt(8, sp.getOvergroundNum());//���ϲ���
			pstmt.setInt(9, sp.getUndergroundNum());//���²���
			pstmt.setString(10,sp.getBuildingHeight());//�����߶�(��)
			pstmt.setString(11,sp.getEngineeringGrade());//���̵ȼ�   0:���� 1:����  2:С�� 
			pstmt.setString(12,sp.getLengthKm());//����(����)
			pstmt.setString(13,sp.getSpanM());//���(��)
			pstmt.setString(14,sp.getPrjStructureTypeNum());//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
			pstmt.setString(15,sp.getProjectSize());//���̹�ģ
			pstmt.setString(16,sp.getOther());//����
			pstmt.setString(17,sp.getLinkName());//��������
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public InnerSingleProject queryById(Long spId)
	{

		InnerSingleProject sp = new InnerSingleProject();
		try {
			
			String qsql = "select * from TBPROJECTUNITINFO where unitid=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setLong(1, spId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				sp.setSpId(rs.getInt("unitid"));//����
				sp.setPrjId(rs.getString("prjid"));//������Ŀ����
				sp.setSpNum(rs.getString("unitcode"));//��λ����
				sp.setBuildingName(rs.getString("subprjname"));//��λ��(��)��������
				sp.setBuildingArea(rs.getString("buildarea"));//�������(ƽ����)
				sp.setInvestAmount(rs.getString("invest"));//Ͷ�ʶ�(��Ԫ)
				sp.setOvergroundArea(rs.getString("floorbuildarea"));//���Ͻ������(ƽ����)
				sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//���½������(ƽ����)
				sp.setOvergroundNum(rs.getInt("floorcount"));//���ϲ���
				sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//���²���
				sp.setBuildingHeight(rs.getString("buildheight"));//�����߶�(��)
				sp.setEngineeringGrade(rs.getString("prjlevelnum"));//���̵ȼ�   0:���� 1:����  2:С�� 
				sp.setLengthKm(rs.getString("subprojectlength"));//����(����)
				sp.setSpanM(rs.getString("subprojectspan"));//���(��)
				sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
				sp.setProjectSize(rs.getString("pjrsize"));//���̹�ģ
				sp.setOther(rs.getString("memo"));//����
				sp.setLinkName(rs.getString("createtype"));//�����������Ŀ���ڱ�ţ�3��ʩ��ͼ��� 4����ȫ�ල 5��ʩ����� 6���������ձ���
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return sp;
	}
	
	/**
	 * �޸�
	 * @param construction
	 * @return
	 */
	public void modify(InnerSingleProject sp)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTUNITINFO set subprjname=?,buildarea=?,"
					+ "invest=?,floorbuildarea=?,bottomfloorbuildarea=?,floorcount=?,"
					+ "bottomfloorcount=?,buildheight=?,prjlevelnum=?,"
					+ "subprojectlength=?,subprojectspan=?,structuretypenum=?,"
					+ "pjrsize=?,memo=? where unitid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sp.getBuildingName());//��λ��(��)��������
			pstmt.setString(2,sp.getBuildingArea());//�������(ƽ����)
			pstmt.setString(3,sp.getInvestAmount());//Ͷ�ʶ�(��Ԫ)
			pstmt.setString(4,sp.getOvergroundArea());//���Ͻ������(ƽ����)
			pstmt.setString(5,sp.getUndergroundArea());//���½������(ƽ����)
			pstmt.setInt(6, sp.getOvergroundNum());//���ϲ���
			pstmt.setInt(7, sp.getUndergroundNum());//���²���
			pstmt.setString(8,sp.getBuildingHeight());//�����߶�(��)
			pstmt.setString(9,sp.getEngineeringGrade());//���̵ȼ�   0:���� 1:����  2:С�� 
			pstmt.setString(10,sp.getLengthKm());//����(����)
			pstmt.setString(11,sp.getSpanM());//���(��)
			pstmt.setString(12,sp.getPrjStructureTypeNum());//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
			pstmt.setString(13,sp.getProjectSize());//���̹�ģ
			pstmt.setString(14,sp.getOther());//����
			pstmt.setLong(15, sp.getSpId());
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(Long id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTUNITINFO where unitid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);//����
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}
	
	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		String sql = "select * from TBPRJSTRUCTURETYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("struct"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

}
