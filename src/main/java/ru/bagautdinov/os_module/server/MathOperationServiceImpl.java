package ru.bagautdinov.os_module.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bagautdinov.core.shared.component.MathComponent;
import ru.bagautdinov.core.shared.model.MathOperation;
import ru.bagautdinov.os_module.client.service.MathOperationService;

@Service("mathOperationService")
public class MathOperationServiceImpl implements MathOperationService {

	@Autowired
	public MathComponent math;
	
	@Override
	public void proceed(MathOperation m) {
		math.proceed(m);
	}
	
	@Override
	public List<Double> getHistory() {
		return math.getHistory();
	}

}
