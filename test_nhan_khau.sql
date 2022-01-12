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