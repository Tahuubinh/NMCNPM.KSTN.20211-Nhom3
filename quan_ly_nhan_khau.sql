create database quan_ly_nhan_khau

--
-- Cơ sở dữ liệu:  quan_ly_nhan_khau 
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  chung_minh_thu 
--

CREATE TABLE  chung_minh_thu  (
   ID  int  NOT NULL,
   idNhanKhau  int   NULL,
   soCMT  varchar(12)   NOT NULL,
   ngayCap  date  NULL,
   noiCap  varchar(100)    NULL
)  ;

--
-- Đang đổ dữ liệu cho bảng  chung_minh_thu 
--

INSERT INTO  chung_minh_thu  ( ID ,  idNhanKhau ,  soCMT ,  ngayCap ,  noiCap ) VALUES
(13, 26, '000000000001', NULL, NULL),
(14, 27, '000000000002', NULL, NULL),
(15, 28, '000000000003', NULL, NULL),
(16, 29, '000000000004', NULL, NULL),
(17, 30, '000000000005', NULL, NULL),
(18, 31, '000000000006', NULL, NULL),
(19, 32, '000000000007', NULL, NULL),
(20, 33, '000000000008', NULL, NULL),
(21, 34, '000000000009', NULL, NULL),
(22, 35, '100000000001', NULL, NULL),
(23, 36, '100000000002', NULL, NULL),
(24, 37, '000000000010', NULL, NULL),
(25, 38, '000000000011', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  dinh_chinh 
--

CREATE TABLE  dinh_chinh  (
   ID  int  NOT NULL,
   idHoKhau  int   NULL,
   thongTinThayDoi  varchar(100)    NULL,
   thayDoiTu  varchar(100)    NULL,
   thayDoiThanh  varchar(100)    NULL,
   ngayThayDoi  date  NULL,
   nguoiThayDoi  int   NULL
)  ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  gia_dinh 
--

CREATE TABLE  gia_dinh  (
   ID  int  NOT NULL,
   idNhanKhau  int   NULL,
   hoTen  varchar(100)    NULL,
   namSinh  date  NULL,
   gioiTinh  varchar(100)    NULL,
   quanHeVoiNhanKhau  varchar(100)    NULL,
   ngheNghiep  varchar(100)    NULL,
   diaChiHienTai  varchar(100)    NULL
)  ;

--
-- Đang đổ dữ liệu cho bảng  gia_dinh 
--

INSERT INTO  gia_dinh  ( ID ,  idNhanKhau ,  hoTen ,  namSinh ,  gioiTinh ,  quanHeVoiNhanKhau ,  ngheNghiep ,  diaChiHienTai ) VALUES
(2, 27, 'Nguyễn Minh Quân', '1995-05-31', 'Nam', 'Chồng', 'Kỹ sư', 'Số 2 Tạ Quang Bửu, Hai Bà Trưng, Hà Nội'),
(3, 28, 'Trần Thanh Duyên', '1997-12-23', 'Nữ', 'Vợ', 'Nhân viên văn phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(4, 29, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Vợ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(5, 29, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(6, 29, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(7, 30, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Chồng', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(8, 30, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(9, 30, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con Gái', 'Luật sư', ''),
(10, 31, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(11, 31, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(12, 31, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Em gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(13, 32, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(14, 32, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(15, 32, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Anh trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(16, 33, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Vợ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(17, 33, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(18, 33, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(19, 34, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(20, 34, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(21, 34, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Chồng', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(22, 35, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(23, 35, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(24, 35, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Em gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(25, 36, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(26, 36, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(27, 36, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Anh trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(28, 37, 'Bùi Thị Hà', '1948-02-03', 'Nữ', 'Vợ', 'Nội trợ', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(29, 37, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con Trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(30, 37, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con Gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội'),
(31, 38, 'Lý Văn Công', '1945-06-04', 'Nam', 'Chồng', 'Bộ đội về hưu', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(32, 38, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(33, 38, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  ho_khau 
--

CREATE TABLE  ho_khau  (
   ID  int  NOT NULL,
   maHoKhau  varchar(100)    NULL,
   idChuHo  int   NULL,
   maKhuVuc  varchar(100)    NULL,
   diaChi  varchar(100)    NULL,
   ngayLap  date  NULL,
   ngayChuyenDi  date  NULL,
   lyDoChuyen  text    NULL,
   nguoiThucHien  int   NULL
)  ;
SELECT MAX(id)+1 FROM ho_khau
CREATE SEQUENCE ho_khau_id_seq MINVALUE 100
ALTER TABLE ho_khau ALTER id SET DEFAULT nextval('ho_khau_id_seq')
ALTER SEQUENCE ho_khau_id_seq OWNED BY ho_khau.id
--
-- Đang đổ dữ liệu cho bảng  ho_khau 
--

INSERT INTO  ho_khau  ( ID ,  maHoKhau ,  idChuHo ,  maKhuVuc ,  diaChi ,  ngayLap ,  ngayChuyenDi ,  lyDoChuyen ,  nguoiThucHien ) VALUES
(13, 'TQB002', 28, 'HN03', 'Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(14, 'TQB001', 26, 'HN03', 'Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(15, 'TQB003', 29, 'HN03', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL),
(16, 'TQB004', 33, 'HN03', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  khai_tu 
--

CREATE TABLE  khai_tu  (
   ID  int  NOT NULL,
   soGiayKhaiTu  varchar(100)    NULL,
   idNguoiKhai  int   NULL,
   idNguoiChet  int   NULL,
   ngayKhai  date  NULL,
   ngayChet  date  NULL,
   lyDoChet  varchar(100)    NULL
)  ;

CREATE TABLE  xoa_nhan_khau  (
   ID  serial  NOT NULL,
   soGiay  varchar(100)    NULL,
   hoTen  varchar(100)    NULL,
   namSinh  date  NULL,
   gioiTinh  varchar(100)    NULL,
   ngayXoa  date  NULL,
   lyDo  varchar(100)    NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  nhan_khau 
--

CREATE TABLE  nhan_khau  (
   ID  int  NOT NULL,
   maNhanKhau  varchar(100)    NULL,
   hoTen  varchar(100)    NULL,
   bietDanh  varchar(100)    NULL,
   namSinh  date  NULL,
   gioiTinh  varchar(100)    NULL,
   noiSinh  varchar(100)    NULL,
   nguyenQuan  varchar(100)    NULL,
   danToc  varchar(100)    NULL,
   tonGiao  varchar(100)    NULL,
   quocTich  varchar(100)    NULL,
   soHoChieu  varchar(100)    NULL,
   noiThuongTru  varchar(100)    NULL,
   diaChiHienNay  varchar(100)    NULL,
   trinhDoHocVan  varchar(100)    NULL,
   TrinhDoChuyenMon  varchar(100)    NULL,
   bietTiengDanToc  varchar(100)    NULL,
   trinhDoNgoaiNgu  varchar(100)    NULL,
   ngheNghiep  varchar(100)    NULL,
   noiLamViec  varchar(100)    NULL,
   tienAn  varchar(100)    NULL,
   ngayChuyenDen  date  NULL,
   lyDoChuyenDen  varchar(100)    NULL,
   ngayChuyenDi  date  NULL,
   lyDoChuyenDi  varchar(100)    NULL,
   diaChiMoi  varchar(100)    NULL,
   ngayTao  date  NULL,
   idNguoiTao  int   NULL,
   ngayXoa  date  NULL,
   idNguoiXoa  int   NULL,
   lyDoXoa  varchar(100)    NULL,
   ghiChu  varchar(100)    NULL
)  ;

ALTER TABLE nhan_khau ADD COLUMN tcc varchar(30);
ALTER TABLE nhan_khau ADD COLUMN lienhe varchar(30);
ALTER TABLE nhan_khau 
ALTER COLUMN lienhe TYPE varchar(100);
--
-- Đang đổ dữ liệu cho bảng  nhan_khau 
--
SELECT MAX(id)+1 FROM nhan_khau
CREATE SEQUENCE nhan_khau_id_seq MINVALUE 100
ALTER TABLE nhan_khau ALTER id SET DEFAULT nextval('nhan_khau_id_seq')
ALTER SEQUENCE nhan_khau_id_seq OWNED BY nhan_khau.id

INSERT INTO  nhan_khau  ( ID ,  maNhanKhau ,  hoTen ,  bietDanh ,  namSinh ,  gioiTinh ,  noiSinh ,  nguyenQuan ,  danToc ,  tonGiao ,  quocTich ,  soHoChieu ,  noiThuongTru ,  diaChiHienNay ,  trinhDoHocVan ,  TrinhDoChuyenMon ,  bietTiengDanToc ,  trinhDoNgoaiNgu ,  ngheNghiep ,  noiLamViec ,  tienAn ,  ngayChuyenDen ,  lyDoChuyenDen ,  ngayChuyenDi ,  lyDoChuyenDi ,  diaChiMoi ,  ngayTao ,  idNguoiTao ,  ngayXoa ,  idNguoiXoa ,  lyDoXoa ,  ghiChu ) VALUES
(26, NULL, 'Trinh Văn An', '', '1990-12-07', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình đọ B', 'Giáo Viên', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(27, NULL, 'Trần Thanh Duyên', '', '1997-12-23', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Nhân viên văn phòng', 'Công ty ABC', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(28, NULL, 'Nguyễn Minh Quân', '', '1995-05-31', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Kỹ sư', 'Viettel', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(29, NULL, 'Nguyễn Tiến Dũng', '', '1964-06-03', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'Không', 'Không', 'Phó giám đốc', 'Công ty EXE', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(30, NULL, 'Vũ Mỹ Linh', '', '1965-12-06', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12', 'Cử Nhân', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(31, NULL, 'Nguyễn Tiến Đạt', '', '1990-09-09', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'không', 'Anh trình độ C', 'Kỹ sư điện', 'Công ty điện EVN', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(32, NULL, 'Nguyễn Trà My', '', '1997-12-12', 'Nữ', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'không', 'Anh trình đố D', 'Luật sư', 'Văn phòng luật sư 123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(33, NULL, 'Trần Văn Nam', '', '1980-07-09', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Tiến sĩ', 'Không', 'Anh trình độ D', 'Giảng viên đại học', 'Đại học Bách khoa Hà Nội', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(34, NULL, 'Nguyễn Minh Tuyết', '', '1985-09-02', 'Nữ', NULL, 'Nam Định', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Bác sĩ', 'Bệnh viện quốc tế HJK', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(35, NULL, 'Trần Trung Kiên', '', '2008-12-25', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '6/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(36, NULL, 'Trần Thúy Ngọc', '', '2013-01-15', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '1/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường tiểu học Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(37, NULL, 'Lý Văn Công', '', '1945-06-04', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12 chính quy', 'Không', 'Không', 'Không', 'Về hưu', 'Không', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(38, NULL, 'Bùi Thị Hà', '', '1948-02-03', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12', 'Không', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  tam_tru 
--

CREATE TABLE  tam_tru  (
   ID  int  NOT NULL,
   idNhanKhau  int   NULL,
   maGiayTamtru  varchar(100)    NULL,
   soDienThoaiNguoiDangKy  varchar(100)    NULL,
   tuNgay  date NOT NULL,
   denNgay  date NOT NULL,
   lyDo  text   NOT NULL
)  ;

ALTER TABLE tam_tru ALTER COLUMN lyDo DROP NOT NULL;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  tam_vang 
--

CREATE TABLE  tam_vang  (
   ID  int  NOT NULL,
   idNhanKhau  int   NULL,
   maGiayTamVang  varchar(100)    NULL,
   noiTamtru  varchar(100)    NULL,
   tuNgay  date  NULL,
   denNgay  date  NULL,
   lyDo  varchar(100)    NULL
)  ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  thanh_vien_cua_ho 
--

CREATE TABLE  thanh_vien_cua_ho  (
   idNhanKhau  int  NOT NULL,
   idHoKhau  int  NOT NULL,
   quanHeVoiChuHo  varchar(100)    NULL
)  ;

--
-- Đang đổ dữ liệu cho bảng  thanh_vien_cua_ho 
--

INSERT INTO  thanh_vien_cua_ho  ( idNhanKhau ,  idHoKhau ,  quanHeVoiChuHo ) VALUES
(26, 14, 'Chủ hộ'),
(27, 13, 'Vợ'),
(29, 15, 'Chủ hộ'),
(30, 15, 'Vợ'),
(31, 15, 'Con trai'),
(32, 15, 'Con gái'),
(33, 16, 'Chủ hộ'),
(34, 16, 'Vợ'),
(35, 16, 'Con trai'),
(36, 16, 'Con gái');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  tieu_su 
--

CREATE TABLE  tieu_su  (
   ID  int  NOT NULL,
   idNhanKhau  int   NULL,
   tuNgay  date  NULL,
   denNgay  date  NULL,
   diaChi  varchar(100)    NULL,
   ngheNghiep  varchar(100)    NULL,
   noiLamViec  varchar(100)    NULL
)  ;

--
-- Đang đổ dữ liệu cho bảng  tieu_su 
--

INSERT INTO  tieu_su  ( ID ,  idNhanKhau ,  tuNgay ,  denNgay ,  diaChi ,  ngheNghiep ,  noiLamViec ) VALUES
(2, 27, '2015-09-05', '2015-09-05', 'Số 45, ngõ 56, Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Viên', 'Đại học Thương mại'),
(3, 28, '2012-09-05', '2017-09-05', '556 La Thành, Hà Nội', 'Sinh Viên', 'Đại học Bách khoa Hà Nội'),
(4, 29, '1989-05-10', '2000-08-25', 'Số 5 Nguyễn Khuyến, Hà Nội', 'Quản lý nhận sự', 'Công ty BCC'),
(5, 30, '1987-05-23', '1997-03-01', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Nhân viên văn phòng', 'Công ty Zezs'),
(6, 31, '2008-09-05', '2013-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Bách khoa Hà Nội'),
(7, 32, '2015-09-05', '2019-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Luật Hà Nội'),
(8, 33, '1998-09-05', '2003-09-05', 'Số 66, ngõ 445 Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Vvên', 'Đại học Bách khoa Hà Nội'),
(9, 33, '2003-10-03', '2018-08-06', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Giảng viên', 'Đại học Công ngiệp Hà Nội'),
(10, 34, '2003-09-05', '2011-09-05', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Sinh viên', 'Đại học Y Hà Nội'),
(11, 34, '2011-10-03', '2015-08-09', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Bác sĩ nội trú', 'Bệnh viện Bạch Mai'),
(12, 37, '1961-01-01', '1963-01-01', 'Không rõ', 'Bộ đội', 'Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng  users 
--

CREATE TABLE  users  (
   ID  int  NOT NULL,
   userName  varchar(100)    NULL,
   passwd  varchar(100)    NULL
)  ;

--
-- Đang đổ dữ liệu cho bảng  users 
--

INSERT INTO  users  ( ID ,  userName ,  passwd ) VALUES
(1, 'admin', '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng  chung_minh_thu 
--
ALTER TABLE  chung_minh_thu 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  dinh_chinh 
--
ALTER TABLE  dinh_chinh 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  gia_dinh 
--
ALTER TABLE  gia_dinh 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  ho_khau 
--
ALTER TABLE  ho_khau 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  khai_tu 
--
ALTER TABLE  khai_tu 
  ADD PRIMARY KEY ( ID );
ALTER TABLE  xoa_nhan_khau 
  ADD PRIMARY KEY ( ID );
--
-- Chỉ mục cho bảng  nhan_khau 
--
ALTER TABLE  nhan_khau 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  tam_tru 
--
ALTER TABLE  tam_tru 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  tam_vang 
--
ALTER TABLE  tam_vang 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  thanh_vien_cua_ho 
--
ALTER TABLE  thanh_vien_cua_ho 
  ADD PRIMARY KEY ( idNhanKhau , idHoKhau );

--
-- Chỉ mục cho bảng  tieu_su 
--
ALTER TABLE  tieu_su 
  ADD PRIMARY KEY ( ID );

--
-- Chỉ mục cho bảng  users 
--
ALTER TABLE  users 
  ADD PRIMARY KEY ( ID );

--
ALTER TABLE  chung_minh_thu 
  ADD CONSTRAINT  chung_minh_thu_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID );

--
-- Các ràng buộc cho bảng  dinh_chinh 
--
ALTER TABLE  dinh_chinh 
  ADD CONSTRAINT  dinh_chinh_ibfk_1  FOREIGN KEY ( idHoKhau ) REFERENCES  ho_khau  ( ID ),
  ADD CONSTRAINT  dinh_chinh_ibfk_2  FOREIGN KEY ( nguoiThayDoi ) REFERENCES  users  ( ID );

--
-- Các ràng buộc cho bảng  gia_dinh 
--
ALTER TABLE  gia_dinh 
  ADD CONSTRAINT  gia_dinh_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID );

--
-- Các ràng buộc cho bảng  ho_khau 
--
ALTER TABLE  ho_khau 
  ADD CONSTRAINT  ho_khau_ibfk_1  FOREIGN KEY ( idChuHo ) REFERENCES  nhan_khau  ( ID );
ALTER TABLE ho_khau
   DROP CONSTRAINT ho_khau_ibfk_1
 , ADD  CONSTRAINT ho_khau_ibfk_1
   FOREIGN KEY ( idChuHo ) REFERENCES  nhan_khau  ( ID ) ON DELETE CASCADE;
--
-- Các ràng buộc cho bảng  khai_tu 
--
ALTER TABLE  khai_tu 
  ADD CONSTRAINT  khai_tu_ibfk_1  FOREIGN KEY ( idNguoiKhai ) REFERENCES  nhan_khau  ( ID ),
  ADD CONSTRAINT  khai_tu_ibfk_2  FOREIGN KEY ( idNguoiChet ) REFERENCES  nhan_khau  ( ID );

--
-- Các ràng buộc cho bảng  nhan_khau 
--
ALTER TABLE  nhan_khau 
  ADD CONSTRAINT  nhan_khau_ibfk_1  FOREIGN KEY ( idNguoiTao ) REFERENCES  users  ( ID ),
  ADD CONSTRAINT  nhan_khau_ibfk_2  FOREIGN KEY ( idNguoiXoa ) REFERENCES  users  ( ID );

--
-- Các ràng buộc cho bảng  tam_tru 
--
ALTER TABLE  tam_tru 
  ADD CONSTRAINT  tam_tru_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID );
ALTER TABLE tam_tru
   DROP CONSTRAINT tam_tru_ibfk_1
 , ADD  CONSTRAINT tam_tru_ibfk_1
   FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID ) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng  tam_vang 
--
ALTER TABLE  tam_vang 
  ADD CONSTRAINT  tam_vang_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID );
  
ALTER TABLE tam_vang
   DROP CONSTRAINT tam_vang_ibfk_1
 , ADD  CONSTRAINT tam_vang_ibfk_1
   FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID ) ON DELETE CASCADE;
--
-- Các ràng buộc cho bảng  thanh_vien_cua_ho 
--
ALTER TABLE  thanh_vien_cua_ho 
  ADD CONSTRAINT  thanh_vien_cua_ho_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID ),
  ADD CONSTRAINT  thanh_vien_cua_ho_ibfk_2  FOREIGN KEY ( idHoKhau ) REFERENCES  ho_khau  ( ID );

ALTER TABLE thanh_vien_cua_ho
   DROP CONSTRAINT thanh_vien_cua_ho_ibfk_1
 , ADD  CONSTRAINT thanh_vien_cua_ho_ibfk_1
   FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID ) ON DELETE CASCADE;
ALTER TABLE thanh_vien_cua_ho
   DROP CONSTRAINT thanh_vien_cua_ho_ibfk_2
 , ADD  CONSTRAINT thanh_vien_cua_ho_ibfk_2
   FOREIGN KEY ( idHoKhau ) REFERENCES  ho_khau  ( ID ) ON DELETE CASCADE;
--
-- Các ràng buộc cho bảng  tieu_su 
--
ALTER TABLE  tieu_su 
  ADD CONSTRAINT  tieu_su_ibfk_1  FOREIGN KEY ( idNhanKhau ) REFERENCES  nhan_khau  ( ID );
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
