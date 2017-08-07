职业表:
create table `magor`(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`magor` varchar(10) DEFAULT NULL COMMENT '专业',
`pp_number` INT COMMENT '学员人数',
 PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '专业表';



班级表class:id,所属专业magor,班级编号number,学生人数student_number,qq群qq,开始时间start_time
班级宣言class_info,首席弟子super_student
create table `class`(
`id` INT NOT NULL AUTO_INCREMENT COMMENT'主键',
`magor` VARCHAR(10) DEFAULT NULL COMMENT'职业',
`c_number` INT COMMENT '班级编号',
`student_number` INT COMMENT'学生人数',
`qq` VARCHAR(20) DEFAULT NULL COMMENT'qq群',
`start_time` timestamp default current_timestamp  COMMENT'开始时间',
`class_info` VARCHAR(50) DEFAULT NULL COMMENT'班级宣言',
`super_student` INT COMMENT'首席弟子',
 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '班级表';

学员表

CREATE TABLE `student`(
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(10) COMMENT'名字',
  `qq` varchar(20) COMMENT'qq',
  `school` varchar(10) COMMENT'毕业院校',
  `magor` INT COMMENT'职业',
  `ruxuetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '学员注册时间',
  `url` varchar(255) COMMENT'日报链接',
  `wish` varchar(255) COMMENT'志愿',
  `teacher` int COMMENT'师兄',
  PRIMARY KEY (`id`)
);


CREATE TABLE `register`(
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` VARCHAR (64),
  `email` VARCHAR (64),
  `password` VARCHAR (64),
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '注册信息表';




