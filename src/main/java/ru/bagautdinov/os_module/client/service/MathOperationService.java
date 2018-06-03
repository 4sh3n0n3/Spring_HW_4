package ru.bagautdinov.os_module.client.service;

import java.util.List;

import ru.bagautdinov.core.shared.model.MathOperation;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/mathOperationService")
public interface MathOperationService extends RemoteService {
	void proceed(MathOperation m);
	List<Double> getHistory();
}
