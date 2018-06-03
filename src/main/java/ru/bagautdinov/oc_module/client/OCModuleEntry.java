package ru.bagautdinov.oc_module.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.bagautdinov.core.shared.utils.MainForm;
import ru.bagautdinov.os_module.client.service.MathOperationService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

@Component
public class OCModuleEntry implements EntryPoint {

	@Autowired
	public MathOperationService mos;
	
	@Override
	public void onModuleLoad() {
		MainForm mainForm = new MainForm();
		mainForm.getSendButton().addClickHandler(event -> {
			try {
				mos.proceed(mainForm.acquire());
			} catch (RuntimeException e) {
				mainForm.getErrorOutput().setText(e.getMessage());
				return;
			}
			mainForm.getHistoryBox().insertItem(mos.getHistory().get(mos.getHistory().size() - 1).toString(), 
					mos.getHistory().size() - 1);
		});
		mainForm.addToPanel(RootPanel.get());
	}

}
