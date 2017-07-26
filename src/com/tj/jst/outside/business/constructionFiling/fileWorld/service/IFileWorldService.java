package com.tj.jst.outside.business.constructionFiling.fileWorld.service;

import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * ʩ����ͬwordģ��
 * @author hhc
 *
 */
public interface IFileWorldService {
	
	/**
	 * ��ѯ�б�
	 * @param recordId
	 * @return
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType);
	
	/**
	 * ��ѯ��ϸ
	 * @param conId
	 * @param checkType
	 * @return
	 */
	public FileWorld queryConMessage(String conId,String checkType,String recordId);
	
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
