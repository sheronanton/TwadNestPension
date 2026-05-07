package com.nic.hrms.pension.service;

import com.nic.hrms.pension.model.MstPension;
import java.util.List;

public interface Pension_service {
	/*
	 * interface for getting the data for db
	 */

	boolean saveuser(MstPension mstpension);
	/*
	 * declaration for getting the class of pension
	 */
	List<MstPension>getAllClassOfPension();
	/*
	 * declaration for deleting a record from class of pension
	 */
	boolean deleteuser(String classId);
	/*
	 * declaration for updating a record from class of pension
	 */
	boolean updateuser(String classId,String classDesc);
	
	
}
