package com.yh.sys.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.yh.sys.dao.UserDao;
import com.yh.sys.domain.Role_info;
import com.yh.sys.utils.DBUtils;
import com.yh.sys.utils.Mark;

public class UserQueryService {

	private UserDao dao = new UserDao();

	/**
	 * ��ѯ��ɫ��Ϣ
	 * @param user
	 * @return
	 */
	public List<Role_info> getList(Role_info info) {
		// sql�������ݿ�
		StringBuffer sb = new StringBuffer("select * from role_info where role_mark = ?");
		List<Object> list = new ArrayList<Object>();

		list.add(Mark.DB_YES);

		if (info != null) {
			if (info.getRole_name() != null && !info.getRole_name().equals("")) {
				sb.append("  and role_name like ? ");
				list.add("%" + info.getRole_name() + "%");
			}
		}
		// ����û�˳���ս���
		sb.append(" order by role_id desc ");

		return dao.getList(sb.toString(), list.toArray());
	}

	/**
	 * ����ɾ����ɾ���û�(�޸ı�ʶMark==0����ʾ�������,���ݿ�ûɾ��)
	 * 
	 * @param user
	 * @return
	 */
	public boolean delete(Role_info info) {
		if (info != null && info.getRole_id() != null) {
			// �Ȳ�ѯ ���޸�
			Role_info prole = getUserId(info.getRole_id());

			if (prole != null) {
				// �޸ľ�����ֶ�
				prole.setRole_mark(Mark.DB_NO);
			}
			return dao.update(prole);
		}
		return false;
	}

	/**
	 * ͨ��idɾ��
	 * 
	 * @param id
	 */
	public void delete1(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			// 3.�������
			String sql = "delete from role_info where role_id = ? ";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			// 4.ִ�����
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ts�Ǹ��࣬ps���������ֱ�Ӽ̳�
			DBUtils.close(conn, ps, null);
		}
	}

	/**
	 * �޸ģ�update������
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(Role_info info) {

		if (info != null && info.getRole_id() != null) {
			// �Ȳ�ѯ ���޸�
			Role_info prole = getUserId(info.getRole_id());

			if (prole != null) {
				// �޸ľ�����ֶ�
				prole.setRole_name(info.getRole_name());
				prole.setRole_desc(info.getRole_desc());
			}
			return dao.update(prole);
		}
		return false;
	}

	/**
	 * �õ���Ҫ�޸���Ϣ��id,��ID���������ݷ���
	 * 
	 * @param infoId
	 * @return
	 */
	public Role_info getUserId(Integer infoId) {
		if (infoId != null) {

			StringBuffer sb = new StringBuffer("select * from role_info where role_mark = ? and role_id = ?");
			List<Object> list = new ArrayList<Object>();

			list.add(Mark.DB_YES);
			list.add(infoId);

			List<Role_info> plist = dao.getList(sb.toString(), list.toArray());
			if (plist != null && plist.size() == 1) {
				return plist.get(0);
			}
		}
		return null;
	}

}
