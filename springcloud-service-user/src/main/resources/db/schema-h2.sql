
DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `birthday` datetime NOT NULL,
  `user_name` varchar(255) DEFAULT '',
  `user_pwd_hash` varchar(255) DEFAULT '',
  `user_pwd_salt` varchar(255) DEFAULT '',
  `user_type` int(11) DEFAULT '0',
  `role_Ids` varchar(255) DEFAULT '',
  `phone` varchar(255) DEFAULT '',
  `address` varchar(255) DEFAULT '',
  `status` int(11) DEFAULT '0',
  `token_json` varchar(255) DEFAULT '',
  `create_user` varchar(255) DEFAULT '',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_user` varchar(255) DEFAULT '',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
