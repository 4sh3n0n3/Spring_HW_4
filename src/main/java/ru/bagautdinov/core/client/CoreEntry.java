package ru.bagautdinov.core.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class CoreEntry implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Button toOCModule = new Button();
		toOCModule.setText("To Only Client version");
		toOCModule.addClickHandler(event -> {
			Window.Location.assign("/oc");
		});
		
		Button toOSModule = new Button();
		toOSModule.setText("To Only Server version");
		toOSModule.addClickHandler(event -> {
			Window.Location.assign("/os");
		});
		RootPanel.get("main").add(toOCModule);
		RootPanel.get("main").add(toOSModule);
	}

}
