package com.gwtfiler.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtfiler.shared.UploadFile;

public interface UploadedDataAsync {

	void selectUploadedFiles(int id, String topic, String stream, String Tag, String plink, String fpath,
			Boolean checkboxstatus, AsyncCallback<List<UploadFile>> callback);

	void removeData(int i, AsyncCallback<Boolean> callback);

	void editData(int id, String topic, String stream, String Tag, String plink, String fpath, 
			AsyncCallback<Boolean> callback);

	void getData(AsyncCallback<List<UploadFile>> callback);

	void forUpdateUploadedFiles(int id,AsyncCallback<List<UploadFile>> callback);

}
