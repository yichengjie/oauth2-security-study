package com.yicj.security.service;

import com.yicj.security.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * ClassName: BankService
 * Description: TODO(描述)
 * Date: 2020/7/14 15:40
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public interface BankService {
    @PreAuthorize("isAnonymous()")
    public Account readAccount(Long id);
    @PreAuthorize("isAnonymous()")
    public Account[] findAccounts();
    @PreAuthorize("hasAuthority('p_transfer') and hasAuthority('p_read_account')")
    public Account post(Account account, double amount);
}
