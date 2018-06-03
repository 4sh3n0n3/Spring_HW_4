package ru.bagautdinov.os_module.client.service;

import java.util.List;

import ru.bagautdinov.core.shared.model.MathOperation;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MathOperationServiceAsync {
	void proceed(MathOperation m, AsyncCallback<Void> callback);
	List<Double> getHistory(AsyncCallback<List<Double>> callback);
}
