package com.ninhnh.employeeservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.ninhnh.commonservice.model.EmployeeResponseCommonModel;
//import com.ninhnh.commonservice.query.GetDetailsEmployeeQuery;
import com.ninhnh.employeeservice.command.data.Employee;
import com.ninhnh.employeeservice.command.data.EmployeeRepository;
import com.ninhnh.employeeservice.query.model.EmployeeReponseModel;
import com.ninhnh.employeeservice.query.queries.GetAllEmployeeQuery;
import com.ninhnh.employeeservice.query.queries.GetEmployeesQuery;

@Component
public class EmployeeProjection {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@QueryHandler
    public EmployeeReponseModel handle(GetEmployeesQuery getEmployeesQuery) {
		EmployeeReponseModel model = new EmployeeReponseModel();
	 Employee employee = employeeRepository.getById(getEmployeesQuery.getEmployeeId());
      BeanUtils.copyProperties(employee, model);

        return model;
    }
	@QueryHandler
	public List<EmployeeReponseModel> handle(GetAllEmployeeQuery getAllEmployeeQuery){
		List<EmployeeReponseModel> listModel = new ArrayList<>();
		List<Employee> listEntity = employeeRepository.findAll();
		listEntity.stream().forEach(s -> {
			EmployeeReponseModel model = new EmployeeReponseModel();
			BeanUtils.copyProperties(s, model);
			listModel.add(model);
		});
		return listModel;
	}
//	@QueryHandler
//    public EmployeeResponseCommonModel handle(GetDetailsEmployeeQuery getDetailsEmployeeQuery) {
//		EmployeeResponseCommonModel model = new EmployeeResponseCommonModel();
//	 Employee employee = employeeRepository.getById(getDetailsEmployeeQuery.getEmployeeId());
//      BeanUtils.copyProperties(employee, model);
//
//        return model;
//    }
}
