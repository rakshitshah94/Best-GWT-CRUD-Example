package com.gwtfiler.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UploadFile implements IsSerializable{
	public int id;
    public String topic = "";
    public String stream = "";
    public String tag ="";
    public String plink = "";
    public String fpath = "";
    public Boolean checkboxstatus;
    
    public UploadFile(){}
    public UploadFile(int id, String topic, String stream, String Tag, String plink, String fpath, Boolean checkboxstatus) {
        this.setId(id);
        this.setTopic(topic);
        this.setStream(stream);
        this.setTag(Tag);
        this.setPlink(plink);
        this.setFpath(fpath);
        this.setCheckboxstatus(checkboxstatus);        
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPlink() {
		return plink;
	}
	public void setPlink(String plink) {
		this.plink = plink;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public Boolean isCheckboxstatus(Boolean b) {
		return checkboxstatus;
	}
	public void setCheckboxstatus(Boolean checkboxstatus) {
		this.checkboxstatus = checkboxstatus;
	}
    
   

}
