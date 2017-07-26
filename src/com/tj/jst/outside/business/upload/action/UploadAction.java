package com.tj.jst.outside.business.upload.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.business.upload.service.IUploadService;
import com.tj.jst.outside.business.upload.service.UploadServiceImpl;

/**
 * 附件上传
 * @author hhc
 *
 */
public class UploadAction extends BaseAction {
	
	//主键
	private String id;
	//环节名称
	private String linkName;
	//提示信息主键
	private String accessotyId;
	//是否单位工程
	private String isUnits;
	// 上传文件，属性名称与jsp页面表单域名称相同
    private File file;
    // 上传文件名字
    private String fileFileName;
    // 上传文件类型
    private String fileContentType;
    //返回页面
    private String returnRoot;
    private String root;
    
    public String uploadFile(){
 
        //获取点最后一次出现的位置
        int index = fileFileName.lastIndexOf(".");
 
        long now = new Date().getTime();
 
        //截取到点最后一次出现的位置，获得图片的名称
        String newName;
        if(index!=-1){
            newName = now+fileFileName.substring(index);
        }else{
            newName = Long.toString(now);
        }
 
        //获取上传路径
        String root = ServletActionContext.getRequest().getRealPath("/upload");
        //root = root.replace("\\", File.separator);
        //定义输入流
        InputStream is;
		try {
			is = new FileInputStream(file);
			//定义文件对象，传入文件存放路径root，文件名称fileName
	        File destFile = new File(root,newName);
	 
	        //定义输出流，将文件对象传入输出流
	        OutputStream os= new FileOutputStream(destFile);
	 
	        byte[] buffer = new byte[4096];
	 
	        int length = 0;
	 
	        while(-1 != (length = is.read(buffer)))
	        {
	            os.write(buffer, 0, length);
	        }
	 
	        is.close();
	        os.close();
	        linkName = URLDecoder.decode(linkName,"utf8");
//	        System.out.println("root= "+root);
//	        System.out.println("newName= "+newName);
//	        System.out.println("id= "+id);
//	        System.out.println("linkName= "+linkName);
//	        System.out.println("isUnits= "+isUnits);
//	        System.out.println("fileFileName= "+fileFileName);
//	        System.out.println("returnRoot= "+returnRoot);
	        IUploadService uploadService = new UploadServiceImpl();
	        uploadService.add(root, newName,linkName,isUnits,fileFileName,id,accessotyId);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        return returnRoot;
    }
    
    public String deleteFile(){
    	IUploadService uploadService = new UploadServiceImpl();
        String prjId = uploadService.delete(id);
        this.setId(prjId);
        return returnRoot;
    }
    
    public void downLoadFile(){
    	
    	IUploadService uploadService = new UploadServiceImpl();
    	Upload upload = uploadService.queryFile(id);
    	
    	BufferedOutputStream bos = null;
    	FileInputStream fis = null;
		try {
			String cType = "application/x-msdownload";
			if (upload.getNewName().endsWith("pdf")) {
				cType = "application/pdf";
			} else if (upload.getNewName().endsWith("xls")) {
				cType = "application/vnd.ms-excel";
			} else if (upload.getNewName().endsWith("doc")) {
				cType = "application/msword";
			}else if (upload.getNewName().endsWith("docx")) {
				cType = "application/msword";
			}

			this.getResponse().setContentType(cType + ";charset=GB2312");
			this.getResponse().setHeader("Content-Disposition", "attachment;"
					+ " filename="
					+ new String(upload.getNewName().getBytes(), "ISO-8859-1"));
			String rootName = upload.getRoot()+"\\"+upload.getNewName();
			
			rootName = rootName.replace("\\", File.separator);
			fis = new FileInputStream(rootName);
			bos = new BufferedOutputStream(this.getResponse().getOutputStream());
            int temp=-1;
			byte[] buffer = new byte[2048];
			while ((temp=fis.read(buffer)) != -1) {
				bos.write(buffer,0,temp); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 
    public File getFile() {
        return file;
    }
 
    public void setFile(File file) {
        this.file = file;
    }
 
    public String getFileFileName() {
        return fileFileName;
    }
 
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
 
    public String getFileContentType() {
        return fileContentType;
    }
 
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getIsUnits() {
		return isUnits;
	}

	public void setIsUnits(String isUnits) {
		this.isUnits = isUnits;
	}

	public String getReturnRoot() {
		return returnRoot;
	}

	public void setReturnRoot(String returnRoot) {
		this.returnRoot = returnRoot;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getAccessotyId() {
		return accessotyId;
	}

	public void setAccessotyId(String accessotyId) {
		this.accessotyId = accessotyId;
	}
 
}
