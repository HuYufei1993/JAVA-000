create table user (
 id int not null auto increment comment '用户id',
 name varchar(32) comment '用户名',
 age int comment '年龄',
 mobile varchar(16) comment '手机号',
 adress varchar(256) comment '地址',
 primary key (id)
)comment '用户表'

create table product (
 id int not null auto increment comment '商品id',
 product_name varchar(128) comment '商品名称',
 product_type varchar(32) comment '商品类型',
 product_count int comment '库存',
 product_amount decimal(10,2) comment '价格',
 primary key (id)
)comment '商品表'

create table user_order (
 id int not null auto increment comment '订单id',
 user_id int comment '用户id',
 user_address varchar(256) comment '收货地址', 
 total_amount decimal(10,2) comment '订单总金额',
 createtime timestamp comment '创建时间',
 order_status varchar(8) comment '订单状态',
 primary key (id)
)comment '用户订单表'

create table user_order_detail (
 order_id int comment '订单id',
 product_id int comment '商品id',
 product_count int comment '商品数量'
)comment '订单详细表'
