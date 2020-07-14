package com.yicj.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: TestBCrypt
 * Description: TODO(描述)
 * Date: 2020/7/14 12:47
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Slf4j
//@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void test1(){
        // 对原始密码加密
        String hashpw = BCrypt.hashpw("secret", BCrypt.gensalt()) ;
        log.info("hashpw : {}", hashpw);
        //校验原始密码和BCrypt密码是否一致
        String pw = "$2a$10$DMzcQsmhTUdLexk6ZjalaO6iEBOUhDec9MfZ1pkzRfcDa6mx49bdC" ;
        boolean checkpw = BCrypt.checkpw("123", pw) ;
        log.info("checkpw : {}", checkpw);
    }

}
