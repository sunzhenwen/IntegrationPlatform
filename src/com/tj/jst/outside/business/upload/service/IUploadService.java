package com.tj.jst.outside.business.upload.service;

import com.tj.jst.outside.business.upload.model.Upload;


/**
 * ¸½¼þÉÏ´«
 * @author hhc
 *
 */
public interface IUploadService {
	
	
	public void add(String root,String newName,String linkName,String isUnits,String fileFileName,String id,String accessotyId);
	
	public String delete(String id);

	public Upload queryFile(String id);
	
}
