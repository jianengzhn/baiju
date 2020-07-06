package com.eppear.baiju.backstage.service.impl.system;

import com.eppear.baiju.backstage.dao.mapper.auto.SysMenuDao;
import com.eppear.baiju.backstage.dao.mapper.auto.SysUserDao;
import com.eppear.baiju.backstage.dao.mapper.system.SysAuthorizationDao;
import com.eppear.baiju.backstage.dao.model.auto.SysMenuDO;
import com.eppear.baiju.backstage.dao.model.auto.SysUserDO;
import com.eppear.baiju.backstage.dao.model.system.SysAuthorization;
import com.eppear.baiju.backstage.service.system.SysAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjf
 * @date 2020-07-01 20:35:16
 */
@Service
public class SysAuthorizationServiceImpl implements SysAuthorizationService {

    @Autowired
    private SysUserDao sysUserDao;
//    @Autowired
//    private SysAuthorizationDao sysAuthorizationDao;

    @Autowired
    private SysMenuDao sysAuthorizationDao;

    @Override
    public SysUserDO getUserByName(String userName) {
        SysUserDO parm = new SysUserDO();
        parm.setAccount(userName);
        return sysUserDao.selectOne(parm);
    }

    @Override
    public List<SysAuthorization> getGranMenuInfos(Integer userId) {
//        List<SysMenuDO> mns = sysAuthorizationDao.selectAll();
        List<SysAuthorization> ret = sysAuthorizationDao.getGranMenuInfo(userId);
       return ret;
    }
}
