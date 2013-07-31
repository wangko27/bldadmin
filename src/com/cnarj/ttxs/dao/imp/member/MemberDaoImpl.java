package com.cnarj.ttxs.dao.imp.member;

import java.util.List;

import org.springframework.util.Assert;

import com.cnarj.ttxs.dao.MemberDao;
import com.cnarj.ttxs.dao.imp.BaseDaoImpl;
import com.cnarj.ttxs.pojo.Page;
import com.cnarj.ttxs.pojo.Result;
import com.cnarj.ttxs.pojo.user.Member;

/**
 * 会员接口实现类-用于与持久层交互
 * 
 * @copyright 湖南爱瑞杰科技发展股份有限公司
 * @author hedan
 * @version 1.0
 * @since 2011-08-11
 */
public class MemberDaoImpl extends BaseDaoImpl<Member, String> implements
		MemberDao {

	@SuppressWarnings("unchecked")
	public List<Member> checkMember(String userName, String memberPassword,
			Long memberType) {
		String hql = "from Member m where 1=1 and m.username = ? and m.memberpassword = ? and m.memberType = ? ";
		return getSession().createQuery(hql).setParameter(0, userName)
				.setParameter(1, memberPassword).setParameter(2, memberType)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Member> listMemberByUsername(String username, Long memberType)
			throws Exception {
		StringBuffer sbHql = new StringBuffer("from Member m where 1=1 ");
		if (null != username && !"".equals(username)) {
			sbHql.append(" and username like ?");
		}
		if (null != memberType) {
			sbHql.append(" and memberType = ?");
		}

		List<Member> list_memeber = getSession().createQuery(sbHql.toString())
				.setParameter(0, '%' + username + '%').setParameter(1,
						memberType).list();

		return list_memeber;
	}

	public Member getMember(Long dsisUserId, Long memberType) {
		Assert.notNull(dsisUserId, "dsisUserId is required");
		Assert.notNull(memberType, "memberType is required");
		String hql = " from Member m where 1=1 and m.dsisuserid = ? and m.memberType = ?";
		Object obj = getSession().createQuery(hql).setParameter(0, dsisUserId)
				.setParameter(1, memberType).uniqueResult();
		return obj == null ? null : (Member) obj;
	}

	@SuppressWarnings("unchecked")
	public List<Member> listMemberByNikename(String nikename, Long memberType)
			throws Exception {
		StringBuffer sbHql = new StringBuffer("from Member m where 1=1 ");
		if (null != nikename && !"".equals(nikename)) {
			sbHql.append(" and nikename like ?");
		}
		if (null != memberType) {
			sbHql.append(" and memberType = ?");
		}

		List<Member> list_memeber = getSession().createQuery(sbHql.toString())
				.setParameter(0, '%' + nikename + '%').setParameter(1,
						memberType).list();

		return list_memeber;
	}

	public Result listMemberByMastersPage(Page page) {
		// 查询有效的名师
		String hql = "from Member where memberType=3 and isrecommend=1 and isaccountenabled=1 and isaccountlocked=1";
		return this.findByPager(page, hql);
	}

	
	public void updatePwd(String memberid, String newpassword) {
		String hql = " update Member m set m.memberpassword = ? where 1=1 and m.memberid = ? ";
		getSession().createQuery(hql).setParameter(0, newpassword).setParameter(1, memberid).executeUpdate();
	}

	
	public void updateNikename(String memberid, String nikename) {
		String hql = " update Member m set m.nikename = ? where 1=1 and m.memberid = ? ";
		getSession().createQuery(hql).setParameter(0, nikename).setParameter(1, memberid).executeUpdate();
	}

	
	public void updateHeadpath(String memberid, String headpath) {
		String hql = " update Member m set m.headpath = ? where 1=1 and m.memberid = ? ";
		getSession().createQuery(hql).setParameter(0, headpath).setParameter(1, memberid).executeUpdate();
	}

	
	public void updateEmail(String memberid, String email) {
		String hql = "update Member m set m.email = ? where 1=1 and m.memberid = ? ";
		getSession().createQuery(hql).setParameter(0, email).setParameter(1, memberid).executeUpdate();
	}

}
