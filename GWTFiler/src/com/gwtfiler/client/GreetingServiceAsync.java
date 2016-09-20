package com.gwtfiler.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {
	void upload(String topic, String stream, String Tag, String plink, String fpath, Boolean checkboxstatus, AsyncCallback<String> callback);

}