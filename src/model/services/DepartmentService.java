package model.services;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class DepartmentService {

	private DepartmentDAO dao = DAOFactory.createDepartmentDao();
	
	public List<Department> findAll() {
		return dao.findAll();
	}
}
