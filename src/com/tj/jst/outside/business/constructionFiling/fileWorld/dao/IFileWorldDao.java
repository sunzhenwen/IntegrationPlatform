package com.tj.jst.outside.business.constructionFiling.fileWorld.dao;

import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * ʩ����ͬwordģ��
 * @author hhc
 *
 */
public interface IFileWorldDao {

	/**
	 * ��ѯ�б�(ҵ���)
	 * @param recordId
	 * @return
	 */
	public List<FileWorld> queryFileWorldBusiness(String recordId,String conType);
	
	/**
	 * ��ѯģ���
	 * @return
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType);
	
	//δ�ύ,��ѯģ���
	public FileWorld queryFileWorldById(String conId);
	
	//���ύ,��ѯҵ���
	public FileWorld queryFileWorldBusinessById(String conId);
	
	/**
	 * ���δ�ύ����ҵ����в�������
	 * @param fileWorld
	 */
	public String save(FileWorld fileWorld);

//	/**
//	 * ������ύ�޸�ҵ����е�����
//	 * @param fileWorld
//	 */
//	public String update(FileWorld fileWorld);
	
	/**
	 * ɾ��ҵ������ݻ�ԭģ��
	 * @return
	 */
	public void delete(String conId);
	
	/**
	 * �鿴
	 * @return
	 */
	public FileWorld viewDetails(String conId);
}
