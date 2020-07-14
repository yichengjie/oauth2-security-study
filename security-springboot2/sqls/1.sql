CREATE DATABASE `user_db` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `t_user` (
`id` bigint(20) NOT NULL COMMENT '用户id',
`username` varchar(64) NOT NULL,
`password` varchar(64) NOT NULL,
`fullname` varchar(255) NOT NULL COMMENT '用户姓名',
`mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC