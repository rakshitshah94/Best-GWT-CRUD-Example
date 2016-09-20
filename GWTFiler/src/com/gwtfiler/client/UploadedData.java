package com.gwtfiler.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwtfiler.shared.UploadFile;

@RemoteServiceRelativePath("uploadeddata")
public interface UploadedData extends RemoteService {
	public List<UploadFile> selectUploadedFiles(int id, String topic, String stream, String Tag, String plink,
			String fpath, Boolean checkboxstatus);

	List<UploadFile> getData();

	Boolean removeData(int i);

	Boolean editData(int id, String topic, String stream, String Tag, String plink, String fpath);
	
	public List<UploadFile> forUpdateUploadedFiles(int id);
}
