use case_study;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from nhan_vien 
where ((ho_ten like'H%') or (ho_ten like'K%') or (ho_ten like'T%') ) and char_length(ho_ten) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * 
from khach_hang kh
where  	Year(curdate()) - year(ngay_sinh)  between 18 and 50  and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ma_khach_hang, kh.ho_ten, count(hd.ma_khach_hang) as so_lan_dat_phong
from loai_khach lk join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where kh.ma_khach_hang = hd.ma_khach_hang and lk.ten_loai_khach = 'Diamond'
group by  kh.ma_khach_hang,kh.ho_ten, lk.ten_loai_khach
order by so_lan_dat_phong;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
 select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong , dv.ten_dich_vu , hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , sum( dv.chi_phi_thue + (hdct.so_luong * dvdk.gia)) as tong_tien
 from loai_khach lk 
 left join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
 left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
 left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
 left join hop_dong_chi_tiet  hdct on hd.ma_hop_dong = hdct.ma_hop_dong
 left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 group by kh.ma_khach_hang, Kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc;

 
--  6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
 select dv.ma_dich_vu , dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue,ldv.ten_loai_dich_vu
 from loai_dich_vu ldv join dich_vu dv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
 where dv.ma_dich_vu not in (
 select distinct hd.ma_dich_vu 
 from hop_dong hd
 where year(hd.ngay_lam_hop_dong ) >= 2021 and quarter(hd.ngay_lam_hop_dong) = 1);
 
 -- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
 select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da,dv.chi_phi_thue, ldv.ten_loai_dich_vu
 from dich_vu dv 
 join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
 join hop_dong hd on dv.ma_dich_vu = hd.ma_hop_dong
 where dv.ma_dich_vu in 
 (select distinct hd.ma_dich_vu
 from hop_dong hd
 where year (hd.ngay_lam_hop_dong) = 2020)
 and dv.ma_dich_vu not in  ( select distinct hd.ma_dich_vu
 from hop_dong hd
 where year (hd.ngay_lam_hop_dong) >= 2021) ;
 
 -- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- cách 1 
select distinct ho_ten 
from khach_hang; 
-- cách 2
select ho_ten
from khach_hang
group by ho_ten;
-- cách 3
select ho_ten
from Khach_hang
where ho_ten in (
select distinct ho_ten 
from khach_hang
);
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as thang, count(kh.ma_khach_hang) as so_luong_khach_hang
from hop_dong hd
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang 
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang;

 -- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
 select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
 from dich_vu_di_kem dvdk 
 join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
 join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
 join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
 join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
 where lk.ten_loai_khach = 'Diamond' 
 and (kh.dia_chi like '%Vinh%' or kh.dia_chi like '%Quảng Ngãi%');
 
--  12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong , nv.ho_ten, kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu, sum(hdct.so_luong) as so_luong_dich_vu_di_kem , sum(hd.tien_dat_coc) as tien_dat_coc
from hop_dong hd 
join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien 
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu 
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
-- where hd.tien_dat_coc in (
-- select distinct hd.ma_dich_vu 
--  from hop_dong hd
--  where year(hd.ngay_lam_hop_dong ) = 2020 and quarter(hd.ngay_lam_hop_dong) = 4)
--  and hd.tien_dat_coc  not in (
-- select distinct hd.ma_dich_vu 
--  from hop_dong hd
--  where year(hd.ngay_lam_hop_dong ) = 2021 and quarter(hd.ngay_lam_hop_dong) = 1 and quarter(hd.ngay_lam_hop_dong) = 2)
 group by hd.ma_hop_dong, nv.ho_ten, kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu;
 
 -- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
having so_luong_dich_vu_di_kem = (select max(so_luong_dich_vu_di_kem) from (select 	sum(hdct2.so_luong) as so_luong_dich_vu_di_kem
																					from dich_vu_di_kem dvdk2 
																					join hop_dong_chi_tiet hdct2 on dvdk2.ma_dich_vu_di_kem = hdct2.ma_dich_vu_di_kem
                                                                                    group by dvdk2.ma_dich_vu_di_kem)as max)
order by  ma_dich_vu_di_kem;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select group_concat(hd.ma_hop_dong) as ma_hop_dong,group_concat(ldv.ten_loai_dich_vu) as ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem as ten_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung 
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
group by dvdk.ten_dich_vu_di_kem
having so_lan_su_dung = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

	select  nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do,bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi
	from nhan_vien nv 
	join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do 
	join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
	left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
	where year(hd.ngay_lam_hop_dong) between 2020 and 2021 
	group by nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do,bp.ten_bo_phan,nv.so_dien_thoai, nv.dia_chi
	having count(hd.ma_nhan_vien) <= 3;
    
--     16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021
	   delete nv from nhan_vien
	   left join ( select nv.ma_nhan_vien, nv.ho_ten, count(hd.ma_nhan_vien) as so_lan from nhan_vien nv 
				left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
				where year(hd.ngay_lam_hop_dong) between 2019 and 2021 OR hd.ngay_lam_hop_dong IS NULL
				group by nv.ma_nhan_vien, nv.ho_ten
				having  so_lan = 0 ) as subquery on nv.ma_nhan_vien = subquery.ma_nhan_vien
                where subquery.ma_nhan_vien is not null;
            
		
         
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
	 update khach_hang as kh
		join (select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, sum(dv.chi_phi_thue)
    from khach_hang kh 
    join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
    join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
    join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
    where year(hd.ngay_lam_hop_dong) = 2021
    group by  kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach
    having sum(dv.chi_phi_thue) > 10000000) as  subquery ON kh.ma_khach_hang = subquery.ma_khach_hang
SET kh.ma_loai_khach = 1;
    
	--     18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
	delete khach_hang
	from khach_hang  
	join hop_dong  on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
	where year(hop_dong.ngay_lam_hop_dong) < 2021;

	DELIMITER //
	create trigger tr_drop_hop_dong
	before delete on khach_hang
	for each row
	begin 
	delete from hop_dong
	where ma_khach_hang = old.ma_khach_hang;
	end //
	DELIMITER ;

drop trigger tr_drop_hop_dong;

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 3 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem as dvdk
join (select dvdk.ma_dich_vu_di_kem
from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 3) as subquery on dvdk.ma_dich_vu_di_kem = subquery.ma_dich_vu_di_kem
set gia = gia * 2;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

select nv.ma_nhan_vien as id, nv.ho_ten, nv.ngay_sinh,nv.so_dien_thoai, nv.email, nv.dia_chi from nhan_vien nv 
union select kh.ma_khach_hang , kh.ho_ten, kh.ngay_sinh, kh.so_dien_thoai, kh.email, kh.dia_chi from khach_hang kh;


-- NÂNG CAO-- 

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

create view v_nhan_vien as
select nv.ma_nhan_vien, nv.ho_ten, nv.email, nv.dia_chi,nv.ngay_sinh,nv.so_cmnd,nv.so_dien_thoai, td.ten_trinh_do, vt.ten_vi_tri, bp.ten_bo_phan from nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join vi_tri vt on nv.ma_vi_tri = vt.ma_vi_tri
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
where dia_chi like "%Huế%" and DATE_FORMAT(hd.ngay_lam_hop_dong, '%Y-%m-%d') = '2021-05-25';

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này-- 
update v_nhan_vien
set dia_chi = "Liên chiểu"
WHERE dia_chi LIKE '%Huế%' AND DATE_FORMAT(ngay_lam_hop_dong, '%Y-%m-%d') = '2021-05-25';

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang

delimiter //
create procedure sp_xoa_khach_hang (in kh_ma_khach_hang int)
begin
delete from khach_hang
where khach_hang.ma_khach_hang = kh_ma_khach_hang;
end //
delimiter ;

call sp_xoa_khach_hang(10)

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure sp_them_moi_hop_dong (in p_ngay_lam_hop_dong datetime, in p_ngay_ket_thuc datetime, in p_tien_dat_coc double, in p_ma_nhan_vien int , in p_ma_khach_hang int, in p_ma_dich_vu int )
begin
	declare ma_nhan_vien_count int;
    declare ma_khach_hang_count int ;
    declare ma_dich_vu_count int ;
	select count(*) into ma_nhan_vien_count from nhan_vien where ma_nhan_vien = p_ma_nhan_vien;
	if ma_nhan_vien_count = 0 then 
	signal sqlstate '45000';
	set message_text = 'nhân viên không tồn tại';
	end if ;

	select count(*) into ma_khach_hang_count from khach_hang where ma_khach_hang = p_ma_khach_hang;
	if ma_khach_hang_count = 0 then 
	signal sqlstate '45000';
	set message_text = 'khách hàng không tồn tại';
	end if;
	
	select count(*) into ma_dich_vu_count from dich_vu where ma_dich_vu = p_ma_dich_vu;
	if ma_dich_vu_count = 0 then 
	signal sqlstate '45000';
	set message_text = 'mã dịch vụ không tồn tại';
	end if;
	insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
	values(p_ngay_lam_hop_dong,p_ngay_ket_thuc,p_tien_dat_coc,p_ma_nhan_vien,p_ma_khach_hang,p_ma_dich_vu);
end //
delimiter ;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
delimiter //
create trigger tr_xoa_hop_dong 
after update on hop_dong
for each row
begin
declare total_rows int;
 select count(*) into total_rows from hop_dong;
 signal sqlstate '45000'
  set message_text = concat ( 'Tổng số bản ghi còn lại trong bảng hop_dong: ', total_rows ) ;
end //
delimiter ;
 
