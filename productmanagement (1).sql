-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 09, 2025 lúc 07:48 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `productmanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `type`) VALUES
(2, 'Máy Giặt'),
(4, 'Máy Hút Bụi'),
(1, 'Máy Lạnh'),
(3, 'Máy Quạt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `nameProducts` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` decimal(17,2) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `nameProducts`, `type`, `price`, `stock`) VALUES
(1, 'Xe đạp 2 cẳng', 'xe đạp', 20000.00, 24),
(2, 'Tủ lạnh nóng', 'tủ lạnh', 2000000.00, 23),
(3, 'Máy Giặt Hasagi', 'Máy Giặt', 2000000000.00, 56),
(4, 'xe đạp 1 bánh', 'xe đạp', 234455.00, 23),
(5, 'Xe đạp thể thao 1', 'xe đạp', 1200000.00, 10),
(6, 'Tủ lạnh Sharp 2', 'tủ lạnh', 4500000.00, 5),
(7, 'Máy giặt LG 3', 'Máy Giặt', 7200000.00, 12),
(8, 'Máy lạnh Daikin 4', 'máy lạnh', 8500000.00, 0),
(9, 'Tivi Samsung 5', 'tivi', 5000000.00, 8),
(10, 'Xe đạp gấp 6', 'xe đạp', 1350000.00, 3),
(11, 'Tủ lạnh Toshiba 7', 'tủ lạnh', 3900000.00, 9),
(12, 'Máy giặt Samsung 8', 'Máy Giặt', 6500000.00, 7),
(13, 'Máy lạnh LG 9', 'máy lạnh', 7800000.00, 14),
(14, 'Tivi LG 10', 'tivi', 4200000.00, 6),
(15, 'Xe đạp địa hình 11', 'xe đạp', 1400000.00, 4),
(16, 'Tủ lạnh Aqua 12', 'tủ lạnh', 4000000.00, 10),
(17, 'Máy giặt Panasonic 13', 'Máy Giặt', 7000000.00, 6),
(18, 'Máy lạnh Panasonic 14', 'máy lạnh', 8200000.00, 2),
(19, 'Tivi TCL 15', 'tivi', 3500000.00, 0),
(20, 'Xe đạp trẻ em 16', 'xe đạp', 900000.00, 5),
(21, 'Tủ lạnh Hitachi 17', 'tủ lạnh', 5200000.00, 3),
(22, 'Máy giặt nội địa 18', 'Máy Giặt', 9800000.00, 1),
(23, 'Máy lạnh nội địa 19', 'máy lạnh', 9400000.00, 0),
(24, 'Tivi nội địa Nhật 20', 'tivi', 8800000.00, 4),
(25, 'Xe đạp mini 21', 'xe đạp', 1100000.00, 0),
(26, 'Tủ lạnh mini 22', 'tủ lạnh', 2900000.00, 6),
(27, 'Máy giặt nhỏ 23', 'Máy Giặt', 3000000.00, 8),
(28, 'Máy lạnh nhỏ 24', 'máy lạnh', 3100000.00, 5),
(29, 'Tivi mini 25', 'tivi', 2700000.00, 2),
(30, 'Xe đạp điện 26', 'xe đạp', 7500000.00, 12),
(31, 'Tủ lạnh điện tử 27', 'tủ lạnh', 6300000.00, 10),
(32, 'Máy giặt tự động 28', 'Máy Giặt', 7700000.00, 6),
(33, 'Máy lạnh cảm biến 29', 'máy lạnh', 9600000.00, 3),
(34, 'Tivi cảm ứng 30', 'tivi', 9900000.00, 7),
(35, 'Xe đạp đua 31', 'xe đạp', 2000000.00, 9),
(36, 'Tủ lạnh side-by-side 32', 'tủ lạnh', 8500000.00, 2),
(37, 'Máy giặt cửa ngang 33', 'Máy Giặt', 8900000.00, 4),
(38, 'Máy lạnh inverter 34', 'máy lạnh', 10000000.00, 1),
(39, 'Tivi Android 35', 'tivi', 6200000.00, 0),
(40, 'Xe đạp Nhật 36', 'xe đạp', 1850000.00, 5),
(41, 'Tủ lạnh Nhật 37', 'tủ lạnh', 6800000.00, 7),
(42, 'Máy giặt Nhật 38', 'Máy Giặt', 8500000.00, 3),
(43, 'Máy lạnh Nhật 39', 'máy lạnh', 9100000.00, 6),
(44, 'Tivi Nhật 40', 'tivi', 8000000.00, 2),
(45, 'Xe đạp trẻ em 41', 'xe đạp', 950000.00, 11),
(46, 'Tủ lạnh nhỏ gọn 42', 'tủ lạnh', 3300000.00, 9),
(47, 'Máy giặt lồng đứng 43', 'Máy Giặt', 5600000.00, 6),
(48, 'Máy lạnh nhỏ gọn 44', 'máy lạnh', 6200000.00, 3),
(49, 'Tivi treo tường 45', 'tivi', 4000000.00, 10),
(50, 'Xe đạp cổ điển 46', 'xe đạp', 1700000.00, 0),
(51, 'Tủ lạnh âm tủ 47', 'tủ lạnh', 9000000.00, 4),
(52, 'Máy giặt công nghiệp 48', 'Máy Giặt', 15000000.00, 2),
(53, 'Máy lạnh công nghiệp 49', 'máy lạnh', 20000000.00, 1),
(54, 'Tivi 8K 50', 'tivi', 25000000.00, 0),
(55, 'Máy lanh kikiki', 'tủ lạnh', 20000000.00, 23),
(56, 'Xe đạp TÔTTP', 'xe đạp', 2008866.00, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productsdetail`
--

CREATE TABLE `productsdetail` (
  `id` int(15) NOT NULL,
  `id_products` int(15) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `productsdetail`
--

INSERT INTO `productsdetail` (`id`, `id_products`, `status`) VALUES
(1, 2, 'hết hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` text DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(3, 'thắng', 'thangcoi0792@gmail.com', 'asd12345'),
(4, 'Quốc Thắng đẹp trai', 'thangcoi0988@gmail.com', 'asd12345');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_type` (`type`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `productsdetail`
--
ALTER TABLE `productsdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_productDetail_products` (`id_products`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT cho bảng `productsdetail`
--
ALTER TABLE `productsdetail`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `productsdetail`
--
ALTER TABLE `productsdetail`
  ADD CONSTRAINT `fk_productDetail_products` FOREIGN KEY (`id_products`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
