package com.gwtfiler.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String upload(String topic, String stream, String Tag, String plink, String fpath, Boolean checkboxstatus);
}