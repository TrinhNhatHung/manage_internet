CREATE TABLE May (
	ma_may nvarchar(10) PRIMARY KEY DEFAULT DBO.AUTO_IDMay(),
	vi_tri nvarchar(50),
	trang_thai nvarchar(50)
)

CREATE FUNCTION AUTO_IDMay()
RETURNS NVARCHAR(10)
AS
BEGIN
	DECLARE @ID NVARCHAR(10)
	IF (SELECT COUNT(ma_may) FROM May) = 0
		SET @ID = 'M1'
	ELSE
		BEGIN
			SELECT @ID = MAX(CONVERT(INT,SUBSTRING(ma_may,2, len(ma_may)))) FROM May
			SET @ID = 'M' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

INSERT INTO May (vi_tri, trang_thai)
VALUES ('10', 'ok')


CREATE TABLE DichVu (
	ma_dv nvarchar(10) PRIMARY KEY DEFAULT DBO.AUTO_IDDV(),
	ten_dv nvarchar(50),
	don_vi_tinh nvarchar(20),
	don_gia int
)

CREATE FUNCTION AUTO_IDDV()
RETURNS NVARCHAR(10)
AS
BEGIN
	DECLARE @ID NVARCHAR(10)
	IF (SELECT COUNT(ma_dv) FROM DichVu) = 0
		SET @ID = 'DV1'
	ELSE
		BEGIN
			SELECT @ID = MAX(CONVERT(INT, SUBSTRING(ma_dv,3, len(ma_dv)))) FROM DichVu
			SET @ID = 'DV' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

INSERT INTO DichVu(ten_dv, don_vi_tinh, don_gia)
VALUES ('Mi trung', 'To', '10000')

CREATE TABLE KhachHang (
	ma_kh nvarchar(10) PRIMARY KEY DEFAULT DBO.AUTO_IDKH(),
	ten_kh nvarchar(50),
	dia_chi nvarchar(100),
	so_dien_thoai nvarchar(20),
	email nvarchar(20)
)

CREATE FUNCTION AUTO_IDKH()
RETURNS NVARCHAR(10)
AS
BEGIN
	DECLARE @ID NVARCHAR(10)
	IF (SELECT COUNT(ma_kh) FROM KhachHang) = 0
		SET @ID = 'KH1'
	ELSE
		BEGIN
			SELECT @ID = MAX(CONVERT(INT,SUBSTRING(ma_kh,3, len(ma_kh)))) FROM KhachHang
			SET @ID = 'KH' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

INSERT INTO KhachHang(ten_kh, dia_chi, so_dien_thoai, email)
VALUES ('Nguyen Van A', 'DN', '0123456789', 'a@gmail.com')

ALTER TABLE SuDungDichVu
ADD CONSTRAINT FK_SDDV_KH
FOREIGN KEY (ma_kh) REFERENCES KhachHang(ma_kh);

ALTER TABLE SuDungDichVu
ADD CONSTRAINT FK_SDDV_DV
FOREIGN KEY (ma_dv) REFERENCES DichVu(ma_dv);

use internet

SELECT kh.ma_kh,
	   kh.ten_kh,
	   sdm.ma_may, 
	   m.vi_tri, 
	   m.trang_thai, 
	   sdm.ngay_bat_dau_su_dung,
	   sdm.gio_bat_dau_su_dung,
	   sdm.thoi_gian_su_dung, 
	   sddv.ma_dv, 
	   sddv.ngay_su_dung, 
	   sddv.gio_du_dung,
	   sddv.so_luong,
	   Tonghop.TongTien
FROM KhachHang kh
LEFT JOIN SuDungMay sdm ON sdm.ma_kh = kh.ma_kh
LEFT JOIN SuDungDichVu sddv ON sddv.ma_kh = kh.ma_kh
LEFT JOIN May m ON m.ma_may = sdm.ma_may
LEFT JOIN DichVu dv ON dv.ma_dv = sddv.ma_dv 
LEFT JOIN (
	SELECT sddv1.ma_kh, SUM(sddv1.so_luong * dv1.don_gia) AS TongTien
	FROM SuDungDichVu sddv1
	JOIN DichVu dv1 ON sddv1.ma_dv = dv1.ma_dv
	GROUP BY sddv1.ma_kh
) AS Tonghop ON kh.ma_kh = Tonghop.ma_kh



SELECT kh.ma_kh, kh.ten_kh, sdm.ma_may, sdm.ngay_bat_dau_su_dung,
		sdm.thoi_gian_su_dung, sddv.ma_dv, sddv.ngay_su_dung, sddv.so_luong
FROM KhachHang kh
LEFT JOIN SuDungMay sdm ON sdm.ma_kh = kh.ma_kh
LEFT JOIN SuDungDichVu sddv ON sddv.ma_kh = kh.ma_kh

DELETE  FROM KhachHang WHERE ma_kh = 'KH9'

ALTER TABLE SuDungDichVu  WITH CHECK ADD CONSTRAINT [FK_SDDV_KH] FOREIGN KEY(ma_kh)
REFERENCES KhachHang (ma_kh)
ON DELETE CASCADE

ALTER TABLE SuDungDichVu  WITH CHECK ADD CONSTRAINT [FK_SDDV_DV] FOREIGN KEY(ma_dv)
REFERENCES DichVu (ma_dv)
ON DELETE CASCADE

ALTER TABLE SuDungMay  WITH CHECK ADD CONSTRAINT [FK_SuDungMay_KH] FOREIGN KEY(ma_kh)
REFERENCES KhachHang (ma_kh)
ON DELETE CASCADE

ALTER TABLE SuDungMay  WITH CHECK ADD CONSTRAINT [FK_SuDungMay_May] FOREIGN KEY(ma_may)
REFERENCES May (ma_may)
ON DELETE CASCADE