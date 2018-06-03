package ru.bagautdinov.os_module.client;

import java.util.List;

import ru.bagautdinov.core.shared.utils.MainForm;
import ru.bagautdinov.os_module.client.service.MathOperationService;
import ru.bagautdinov.os_module.client.service.MathOperationServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class OSModuleEntry implements EntryPoint {

	private MathOperationServiceAsync moss = GWT.create(MathOperationService.class);
	
	@Override
	public void onModuleLoad() {
		MainForm mainForm = new MainForm();
		mainForm.getSendButton().addClickHandler(event -> {
			try {
				moss.proceed(mainForm.acquire(), new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						mainForm.getErrorOutput().setText(caught.getMessage());
					}

					@Override
					public void onSuccess(Void result) {
						moss.getHistory(new AsyncCallback<List<Double>>() {

							@Override
							public void onFailure(Throwable caught) {
								mainForm.getErrorOutput().setText(caught.getMessage());
							}

							@Override
							public void onSuccess(List<Double> result) {
								int lastIndex = result.size() - 1;
								mainForm.getHistoryBox().insertItem(result.get(lastIndex).toString(), lastIndex);
							}
							
						});
					}
					
				});
			} catch (RuntimeException e) {
				mainForm.getErrorOutput().setText(e.getMessage());
			}
		});
		mainForm.addToPanel(RootPanel.get());
	}
	
}
