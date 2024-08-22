create database thi_thu ;
use thi_thu;
create table loai_mat_hang(
id_loai_mat_hang int primary key auto_increment,
ten_loai_mat_hang varchar(50) 
);
create table nha_san_xuat(
id_nha_san_xuat int primary key auto_increment,
ten_nha_san_xat varchar(50)
);
create table product(
id int primary key auto_increment,
ma_mat_hang varchar(20),
ten_mat_hang varchar(50),
gia float,
so_luong int,
id_loai_mat_hang int,
id_nha_san_xuat int, 
foreign key (id_loai_mat_hang) references loai_mat_hang(id_loai_mat_hang),
foreign key (id_nha_san_xuat) references nha_san_xuat(id_nha_san_xuat),
trang_thai int 
);


