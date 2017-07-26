package com.tj.jst.outside.business.upload.service;

import java.io.File;

import com.tj.jst.outside.business.upload.dao.IUploadDao;
import com.tj.jst.outside.business.upload.dao.UploadDaoImpl;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ¸½¼þÉÏ´«
 * @author hhc
 *
 */
public class UploadServiceImpl implements IUploadService {
	
	
	public void add(String root,String newName,String linkName,String isUnits,String fileFileName,String id,String accessotyId)
	{
		IUploadDao dao = new UploadDaoImpl();
		dao.add(root, newName,linkName,isUnits,fileFileName,id,accessotyId);
	}
	
	public String delete(String id)
	{
		IUploadDao dao = new UploadDaoImpl();
		String[] uploads = dao.delete(id);
		try {
			File myDelFile = new File(uploads[1]);
			if (myDelFile.exists())
				myDelFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploads[0];
	}
	
	public Upload queryFile(String id)
	{
		IUploadDao dao = new UploadDaoImpl();
		return dao.queryFile(id);
	}
}
