package com.eppear.baiju.security.service;

import com.eppear.baiju.backstage.dao.model.auto.SysUserDO;
import com.eppear.baiju.backstage.dao.model.system.SysAuthorization;
import com.eppear.baiju.backstage.service.system.SysAuthorizationService;
import com.eppear.baiju.common.framework.constant.AppResultCodeEnum;
import com.eppear.baiju.common.framework.execption.AppException;
import com.eppear.baiju.common.framework.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户权限认证服务
 * @author zhangjf
 * @date 2020-06-12 21:25:23
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SysAuthorizationService sysAuthorizationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //TODO 需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (StrUtils.isNull(username)) {
            throw new AppException(AppResultCodeEnum.USER_ACCOUNT_USE_NAME_NOT_NULL);
        }
        SysUserDO sysUserDO = sysAuthorizationService.getUserByName(username);
        if (sysUserDO == null) {
            throw new AppException(AppResultCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<SysAuthorization> sysAuthorizationList = sysAuthorizationService.getGranMenuInfos(sysUserDO.getId());
        sysAuthorizationList.forEach(sysAuthorization ->{
            GrantedAuthority grantedAuthority =
                    new SimpleGrantedAuthority(String.valueOf(sysAuthorization.getGrantFlag()));
            grantedAuthorities.add(grantedAuthority);
        });
        Boolean acEnable = (sysUserDO.getEnabled() == 0);
        Boolean acctNonExp = (sysUserDO.getAcctNonExp() == 0);
        Boolean pwdNonExp  = (sysUserDO.getPwdNonExp() == 0);
        Boolean accountNonLocked = (sysUserDO.getAcctNonLocked() == 0);

        return new User(sysUserDO.getAccount(),sysUserDO.getPassword(),
                acEnable,acctNonExp,pwdNonExp,accountNonLocked,grantedAuthorities);
    }
}