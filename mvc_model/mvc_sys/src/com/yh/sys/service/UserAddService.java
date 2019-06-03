package com.yh.sys.service;


import com.yh.sys.dao.UserDao;
import com.yh.sys.domain.Role_info;
import com.yh.sys.utils.Mark;

/**
 * ҵ���߼���
 * 
 * @author Administrator
 *
 */

public class UserAddService {
	//
	private UserDao dao = new UserDao();

	/**
	 * ��ӽ�ɫ��Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(Role_info info) {
		if (info != null && info.getRole_name() != null) {
			info.setRole_mark(Mark.DB_YES);
			return dao.add(info);
		}
		return false;
	}


}
