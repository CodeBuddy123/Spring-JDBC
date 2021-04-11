package com.ashsoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashsoft.bo.EmployeeBO;
import com.ashsoft.dao.IEmployeeDao;
import com.ashsoft.dto.EmployeeDTO;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public EmployeeDTO fetchEmployeeByNo(int eno) {

		EmployeeDTO dto = new EmployeeDTO();
		EmployeeBO bo = dao.getEmployeeByNo(eno);

		dto.setEmpNo(bo.getEmpNo());
		dto.setEname(bo.getEname());
		dto.setJob(bo.getJob());
		dto.setSal(bo.getSal());

		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) {

		// use DAO
		List<EmployeeBO> listBo = dao.getEmployeesByDesgs(desg1, desg2, desg3);

		// convert listBo to listDTO

		List<EmployeeDTO> listDto = new ArrayList();

		listBo.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});
		return listDto;
	}

}
