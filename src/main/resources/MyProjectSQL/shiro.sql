DROP TABLE IF EXISTS `sys_user`
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_account` varchar(30) NOT NULL COMMENT '登录账号',
  `login_password` varchar(65) NOT NULL COMMENT '登录密码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `user_head` varchar(30) DEFAULT NULL COMMENT '头像',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `user_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_sex` int(11) DEFAULT NULL COMMENT '性别',
  `user_birthday` varchar(30) DEFAULT NULL COMMENT '生日',
  `register_time` varchar(30) NOT NULL COMMENT '注册时间',
  `department_key` varchar(20) DEFAULT NULL COMMENT '部门编码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_sys_user_login_account` (`login_account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';