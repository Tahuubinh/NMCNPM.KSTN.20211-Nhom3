select n.*, h.diachi 
from nhan_khau n, ho_khau h, thanh_vien_cua_ho tv
where n.id = h.idchuho
or 
select * from ho_khau

SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h 
WHERE n.id = idchuho
AND n.hoten LIKE '%add%'
UNION
SELECT n.*, h.diachi FROM nhan_khau n, ho_khau h, thanh_vien_cua_ho tv
WHERE n.id = tv.idnhankhau 
AND h.id = idhokhau
AND n.hoten LIKE '%add%'
UNION
SELECT n.*, h.diachi FROM nhan_khau n FULL JOIN ho_khau h
ON n.id = h.idchuho FULL JOIN thanh_vien_cua_ho tv 
ON n.id = tv.idnhankhau
WHERE n.id NOT IN (
	SELECT idchuho FROM ho_khau
) 
AND n.id NOT IN (
	SELECT idnhankhau FROM thanh_vien_cua_ho
) 
AND n.hoten LIKE '%add%'
ORDER BY id;

select * from tam_tru
delete from tam_tru
where idnhankhau = 81
select * from nhan_khau
insert into tam_tru (idnhankhau, tungay, denngay)
values (81, NOW(), NOW())

select * from tam_vang
select * from nhan_khau
where id in (
	select idnhankhau from tam_tru
)

SELECT * FROM nhan_khau
 LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau 
 LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau
  WHERE DATE_PART('year', AGE(CURRENT_DATE, namSinh))  >= -1 
AND DATE_PART('year', AGE(CURRENT_DATE, namSinh))  <= 200 AND (DATE_PART('year', tam_tru.tuNgay) BETWEEN 0 AND 2100) 
ORDER BY ngayTao DESC

SELECT * FROM nhan_khau 
 LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau 
 LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau
  WHERE DATE_PART('year', AGE(CURRENT_DATE, namSinh))  >= -1
select * from tam_tru
select * from xoa_nhan_khau
where lydo = 'Chuyển đi nơi khác'
SELECT * FROM xoa_nhan_khau WHERE lydo = 'Chuyển đi' ORDER BY ngayxoa DESC
where lydochet
insert into xoa_nhan_khau(idnhankhau)
values (1)





