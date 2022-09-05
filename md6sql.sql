drop DATABASE webthueny;
CREATE DATABASE webthueny;
USE webthueny;
INSERT INTO role values(1,'user'),(2,'admin'),(3,'ccdv');

INSERT  into city (name,country_id) values('An Giang',1),
('Kon Tum',1),
('Bà Rịa – Vũng Tàu',1),
('Lai Châu',1),
('Bắc Giang',1),
('Lâm Đồng',1),
('Bắc Kạn',1),
('Lạng Sơn',1),
('Bạc Liêu',1),
('Lào Cai',1),
('Bắc Ninh',1),
('Long An',1),
('Bến Tre',1),
('Nam Định',1),
('Bình Định',1),
('Nghệ An',1),
('Bình Dương',1),
('Ninh Bình',1),
('Bình Phước',1),
('Ninh Thuận',1),
('Bình Thuận',1),
('Phú Thọ',1),
('Cà Mau',1),
('Phú Yên',1),
('Cần Thơ',1),
('Quảng Bình',1),
('Cao Bằng',1),
('Quảng Nam',1),
('Đà Nẵng',1),
('Quảng Ngãi',1),
('Đắk Lắk',1),
('Quảng Ninh',1),
('Đắk Nông',1),
('Quảng Trị',1),
('Điện Biên',1),
('Sóc Trăng',1),
('Đồng Nai',1),
('Sơn La',1),
('Đồng Tháp',1),
('Tây Ninh',1),
('Gia Lai',1),
('Thái Bình',1),
('Hà Giang',1),
('Thái Nguyên',1),
('Hà Nam',1),
('Thanh Hóa',1),
('Hà Nội',1),
('Thừa Thiên Huế',1),
('Hà Tĩnh',1),
('Tiền Giang',1),
('Hải Dương',1),
('TP Hồ Chí Minh',1),
('Hải Phòng',1),
('Trà Vinh',1),
('Hậu Giang',1),
('Tuyên Quang',1),
('Hòa Bình',1),
('Vĩnh Long',1),
('Hưng Yên',1),
('Vĩnh Phúc',1),
('Khánh Hòa',1),
('Yên Bái',1);

INSERT Into country (name)values('Việt Nam');
INSERT into service (category,name) values ('basic','Ra mắt người nhà'),('basic','Ra mắt bạn bè'),('basic','Du lịch chung cùng nhóm bạn'),
('basic','Đi chơi chung'),('basic','Tham dự sinh nhật'),('basic','Trò chuyện offline'),('basic','Trò chuyện online'),
('basic','Đi chơi tết'),('basic','Đi chơi ngày lễ'),('free','Nắm tay'),('free','Nói yêu'),('free','Nhìn mắt'),('advance','Nắm tay'),
('advance','Hôn tay'),('advance','Ôm'),('advance','Nhõng nhẽo'),('advance','Cử chỉ thân mật'),('advance','Nói lời yêu');



delimiter //
 DROP TRIGGER IF EXISTS after_delete_country //
 CREATE TRIGGER after_delete_country AFTER DELETE
 ON country
 FOR EACH ROW
 BEGIN
 	DELETE FROM city
	WHERE old.id=city.country_id;
   
 END//
 delimiter ;

delimiter //
 DROP TRIGGER IF EXISTS after_delete_user //
 CREATE TRIGGER after_delete_user AFTER DELETE
 ON app_user
 FOR EACH ROW
 BEGIN
 	DELETE FROM profile
	WHERE old.id=profile.app_user_id;
    DELETE FROM app_user_roles
	WHERE old.id=app_user_roles.app_user_id;
 END//
 delimiter ;