package com.gwtfiler.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwtfiler.shared.UploadFile;

public class GWTFiler implements EntryPoint {
	private final GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	private final UploadedDataAsync u1 = GWT.create(UploadedData.class);
	RootPanel rt;
	AbsolutePanel absolutePanel;
	TextBox textBox;
	ListBox comboBox;
	TextBox textBox_1;
	TextBox textBox_2;
	FileUpload fileUpload;
	Button button;
	Button display;
	CheckBox checkbox;
	String s1, s2, s3, s4, s5;
	DialogBox dialogBox = new DialogBox();

	public void onModuleLoad() {

		rt = RootPanel.get();

		absolutePanel = new AbsolutePanel();
		rt.add(absolutePanel, 218, 24);
		absolutePanel.setSize("450px", "430px");

		textBox = new TextBox();
		absolutePanel.add(textBox, 143, 39);

		Label lblTopic = new Label("Topic");
		absolutePanel.add(lblTopic, 86, 42);

		comboBox = new ListBox();
		comboBox.addItem("Computer Engineering");
		comboBox.addItem("Information Technology");
		comboBox.addItem("Mechanical Engineering");
		comboBox.addItem("Other");
		absolutePanel.add(comboBox, 143, 88);
		comboBox.setSize("148px", "24px");

		Label lblStreams = new Label("Streams");
		absolutePanel.add(lblStreams, 69, 88);

		textBox_1 = new TextBox();
		absolutePanel.add(textBox_1, 143, 139);

		Label lblTags = new Label("Tags");
		absolutePanel.add(lblTags, 87, 139);

		textBox_2 = new TextBox();
		absolutePanel.add(textBox_2, 143, 194);

		Label lblPublicLink = new Label("Description");
		absolutePanel.add(lblPublicLink, 49, 194);

		fileUpload = new FileUpload();
		absolutePanel.add(fileUpload, 143, 254);

		Label lblcheckbox = new Label("Subscribe");
		absolutePanel.add(lblcheckbox, 49, 310);

		checkbox = new CheckBox();
		absolutePanel.add(checkbox, 143, 310);

		button = new Button("New button");
		absolutePanel.add(button, 106, 350);

		display = new Button("New Display");
		absolutePanel.add(display, 246, 350);

		button.setText("Submit");
		button.setSize("133px", "30px");

		display.setText("Display");
		display.setSize("133px", "30px");

		Label lblFile = new Label("File");
		absolutePanel.add(lblFile, 98, 254);
		lblFile.setSize("27px", "21px");

		DecoratorPanel decoratorPanel = new DecoratorPanel();
		decoratorPanel.add(absolutePanel);
		RootPanel.get().add(decoratorPanel);

		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String topic = textBox.getText();
				String strm = comboBox.getItemText(comboBox.getSelectedIndex());
				String tag = textBox_1.getText();
				String plink = textBox_2.getText();
				String fpath = fileUpload.getFilename();
				Boolean checkboxstatus = checkbox.getValue();

				a1.upload(topic, strm, tag, plink, fpath, checkboxstatus, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						String f = "yes";
						if (result.equals(f)) {
							Window.alert("Success---->  New entry inserted");

						} else {
							Window.alert("Sorry----> New entry does not inserted");
						}

					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Failure----> " + caught);
					}
				});
			}
		});

		display.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error" + caught);
					}

					public void onSuccess(List<UploadFile> result) {
						final CellTable<UploadFile> table = new CellTable<UploadFile>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						TextColumn<UploadFile> topicColumn = new TextColumn<UploadFile>() {
							@Override
							public String getValue(UploadFile object) {
								return object.topic;
							}
						};
						table.addColumn(topicColumn, "Topic");

						TextColumn<UploadFile> streamColumn = new TextColumn<UploadFile>() {
							@Override
							public String getValue(UploadFile object) {
								return object.stream;
							}
						};
						table.addColumn(streamColumn, "Stream");

						TextColumn<UploadFile> tagColumn = new TextColumn<UploadFile>() {
							@Override
							public String getValue(UploadFile object) {
								return object.tag;
							}
						};
						table.addColumn(tagColumn, "Tag");

						TextColumn<UploadFile> plinkColumn = new TextColumn<UploadFile>() {
							@Override
							public String getValue(UploadFile object) {
								return object.plink;
							}
						};
						table.addColumn(plinkColumn, "Description");

						TextColumn<UploadFile> filebodyColumn = new TextColumn<UploadFile>() {
							@Override
							public String getValue(UploadFile object) {
								return object.fpath;
							}
						};
						table.addColumn(filebodyColumn, "File Path");

						TextColumn<UploadFile> checkboxColumn = new TextColumn<UploadFile>() {
							String flag;
							Boolean bar = true;
							@Override
							public String getValue(UploadFile object) {
								if (object.equals(bar)) {
									flag = "Y";
								} else {
									flag = "N";
								}
								return flag;
							}

						};

						table.addColumn(filebodyColumn, "File Path");
						table.addColumn(checkboxColumn, "Subscribed");
						final Button deleteButton = new Button("DELETE");
						final Button editButton = new Button("Edit");
						final SingleSelectionModel<UploadFile> selectionModel = new SingleSelectionModel<UploadFile>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								final UploadFile selected = selectionModel.getSelectedObject();
								if (selected != null) {
								
								}

								deleteButton.addClickHandler(new ClickHandler() {

									@Override
									public void onClick(ClickEvent result) {
										u1.removeData(selected.id, new AsyncCallback<Boolean>() {

											@Override
											public void onSuccess(Boolean result) {
												
												if (result) {
													Window.alert("Success---->Selected row deleted");

												} else {
													Window.alert("Sorry----> cant delete " + result);
												}
												u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

													@Override
													public void onFailure(Throwable arg0) {
														
													}

													@Override
													public void onSuccess(List<UploadFile> arg0) {
														
													}
													
												});
											}

											@Override
											public void onFailure(Throwable caught) {
												u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

													@Override
													public void onFailure(Throwable arg0) {
														
													}

													@Override
													public void onSuccess(List<UploadFile> arg0) {
														
													}
													
												});
											}
										});
									}
								});
								editButton.addClickHandler(new ClickHandler() {

									@Override
									public void onClick(ClickEvent result) {
										u1.forUpdateUploadedFiles(selected.id, new AsyncCallback<List<UploadFile>>() {

											@Override
											public void onFailure(Throwable arg0) {
											}

											@Override
											public void onSuccess(List<UploadFile> resultlist) {
												u1.editData(selected.id, selected.topic, selected.stream, selected.tag,
														selected.plink, selected.fpath, new AsyncCallback<Boolean>() {

															@Override
															public void onFailure(Throwable arg0) {
															}

															@Override
															public void onSuccess(Boolean result) {
																Button updateButton1;

																RootPanel rt2 = RootPanel.get();

																absolutePanel = new AbsolutePanel();

																rt2.add(absolutePanel, 718, 24);
																absolutePanel.setSize("450px", "430px");

																final TextBox textBox2 = new TextBox();
																absolutePanel.add(textBox2, 643, 39);
																textBox2.setText(selected.topic);

																Label lblTopic = new Label("Topic");
																absolutePanel.add(lblTopic, 586, 42);

																final ListBox comboBox2 = new ListBox();
																comboBox2.addItem("Computer Engineering");
																comboBox2.addItem("Information Technology");
																comboBox2.addItem("Mechanical Engineering");
																comboBox2.addItem("Other");
																absolutePanel.add(comboBox2, 643, 88);
																comboBox2.setSize("148px", "24px");

																Label lblStreams = new Label("Streams");
																absolutePanel.add(lblStreams, 569, 88);

																final TextBox textBox_12 = new TextBox();
																absolutePanel.add(textBox_12, 643, 139);
																textBox_12.setText(selected.tag);

																Label lblTags = new Label("Tags");
																absolutePanel.add(lblTags, 587, 139);

																final TextBox textBox_22 = new TextBox();
																absolutePanel.add(textBox_22, 643, 194);
																textBox_22.setText(selected.plink);

																Label lblPublicLink = new Label("Description");
																absolutePanel.add(lblPublicLink, 549, 194);

																fileUpload = new FileUpload();
																absolutePanel.add(fileUpload, 643, 254);
																fileUpload.setTitle(selected.fpath);
																Label lblcheckbox = new Label("Subscribe");
																absolutePanel.add(lblcheckbox, 549, 310);

																CheckBox checkbox2 = new CheckBox();
																absolutePanel.add(checkbox2, 643, 310);

																updateButton1 = new Button("Update");
																absolutePanel.add(updateButton1, 606, 350);

																Button updatedisplay = new Button("Update Display");
																absolutePanel.add(updatedisplay, 746, 350);

																updateButton1.setText("Update");
																updateButton1.setSize("133px", "30px");

																updatedisplay.setText("Update Display");
																updatedisplay.setSize("133px", "30px");
																//updatedisplay.setEnabled(false);

																Label lblFile = new Label("File");
																absolutePanel.add(lblFile, 598, 254);
																lblFile.setSize("27px", "21px");

																RootPanel.get().add(absolutePanel);
																
																updatedisplay.addClickHandler(new ClickHandler() {
																	
																	@Override
																	public void onClick(ClickEvent arg0) {
																		u1.getData(new AsyncCallback<List<UploadFile>>() {

																			@Override
																			public void onFailure(Throwable arg0) {
																				u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

																					@Override
																					public void onFailure(Throwable arg0) {
																						
																					}

																					@Override
																					public void onSuccess(List<UploadFile> arg0) {
																						
																					}
																					
																				});
																			}

																			@Override
																			public void onSuccess(
																					List<UploadFile> arg0) {
																				u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

																					@Override
																					public void onFailure(Throwable arg0) {
																						
																					}

																					@Override
																					public void onSuccess(List<UploadFile> arg0) {
																						
																					}
																					
																				});
																			}
																		});
																	}
																});

																updateButton1.addClickHandler(new ClickHandler() {

																	@Override
																	public void onClick(ClickEvent arg0) {
																		String topic2 = textBox2.getText();
																		String strm2 = comboBox2.getItemText(
																				comboBox.getSelectedIndex());
																		String tag2 = textBox_12.getText();
																		String plink2 = textBox_22.getText();
																		String fpath2 = fileUpload.getFilename();
																		u1.editData(selected.id, topic2, strm2, tag2,
																				plink2, fpath2,
																				new AsyncCallback<Boolean>() {

																					@Override
																					public void onFailure(
																							Throwable caught) {
																						u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

																							@Override
																							public void onFailure(Throwable arg0) {
																								
																							}

																							@Override
																							public void onSuccess(List<UploadFile> arg0) {
																								
																							}
																							
																						});
																					}

																					@Override
																					public void onSuccess(
																							Boolean result) {

																						if (result) {
																							Window.alert(
																									"Success---->Row Updated");
																							
																						} else {
																							Window.alert(
																									"Sorry----> Can't Update! "
																											+ result);
																						}
																						u1.selectUploadedFiles(0, "", "", "", "", "", false, new AsyncCallback<List<UploadFile>>(){

																							@Override
																							public void onFailure(Throwable arg0) {
																								
																							}

																							@Override
																							public void onSuccess(List<UploadFile> arg0) {
																								
																							}
																							
																						});
																					}
																				});
																	}
																});

															}
														});
											}

										});
									}
								});

							}
						});
						table.setRowCount(result.size(), true);
						table.setRowData(0, result);
						table.setWidth("100%");
						RootPanel.get().add(deleteButton);
						RootPanel.get().add(editButton);
						RootPanel.get().add(table);
					}

				});

			}
		});

	}
}