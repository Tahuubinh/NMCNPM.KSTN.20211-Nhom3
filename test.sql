select * from nhan_khau
where id in (
	select idnhankhau from thanh_vien_cua_ho
	where idhokhau = 26 and 
	(quanhevoichuho is null or quanhevoichuho != 'Chủ hộ')
)

select * from thanh_vien_cua_ho
delete from thanh_vien_cua_ho
where idnhankhau = 67
DELETE FROM thanh_vien_cua_ho 
WHERE idnhankhau = 67 and idhokhau = 26
select * from ho_khau