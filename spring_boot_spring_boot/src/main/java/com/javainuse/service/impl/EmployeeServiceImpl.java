/**
 *
 * @author gurpreet.s
 */

package com.javainuse.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Map<String,String> gfg = new HashMap<String,String>();
	
	@Override
	public void insertEmployee(Employee emp) {
		gfg.put(emp.getEmpId(),emp.getEmpName());
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> result = new ArrayList<Employee>();
	    gfg.put("GFG", "geeksforgeeks.org");
	    gfg.put("Code", "code.geeksforgeeks.org");
	    gfg.put("Quiz", "quiz.geeksforgeeks.org");
		for (Map.Entry<String, String> entry : gfg.entrySet()) {
			System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
			Employee emp = new Employee();
			emp.setEmpId(entry.getKey());
			emp.setEmpName(entry.getValue());
			result.add(emp);
		}
            
		
		return result;
	}

}
