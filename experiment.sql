-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2020-11-25 17:08:45
-- 服务器版本： 5.7.26
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `experiment`
--

-- --------------------------------------------------------

--
-- 表的结构 `experiment`
--

CREATE TABLE `experiment` (
  `id` int(11) NOT NULL COMMENT '实验id',
  `tester_id` int(11) DEFAULT NULL COMMENT '主试id',
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实验类型',
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实验名称',
  `content` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实验内容',
  `duration` float DEFAULT NULL COMMENT '实验时',
  `reward` smallint(5) DEFAULT NULL COMMENT '报酬',
  `place` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地点',
  `requirement` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实验要求',
  `time` float DEFAULT NULL COMMENT '实验完成需要时间',
  `send_timestamp` int(11) DEFAULT NULL COMMENT '发布的时间戳',
  `page_view` int(11) DEFAULT '0' COMMENT '浏览次数',
  `enrollment` int(11) DEFAULT '0' COMMENT '报名人数',
  `total_likes` int(11) DEFAULT '0' COMMENT '收藏次数',
  `tag` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签',
  `status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
  `face_url` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '主试头像',
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '主试姓名',
  `time_periods` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '时间段'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `experiment`
--

INSERT INTO `experiment` (`id`, `tester_id`, `type`, `name`, `content`, `duration`, `reward`, `place`, `requirement`, `time`, `send_timestamp`, `page_view`, `enrollment`, `total_likes`, `tag`, `status`, `face_url`, `username`, `time_periods`) VALUES
(1, 2, '线下实验', '简单按键实验，问卷填写', '对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。', 1, 10, '文清123', '1、认真完成实验\r\n        2、视力正常。\r\n        3、男生\r\n        1、认真完成实验\r\n        2、视力正常。\r\n        3、男生', 35, 7575757, 127, 44, 30, '行为实验，简单有趣，有小礼物', '招募中', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICFHlYKsSkvScAVic8d84A5jIic3JeTT8HtIayvph1QnPwwy5yPnz95kk8pia8LWpWQ03NbYnDP3vng/132', '小李', '8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30'),
(2, 2, '线下实验', '简单按键实验，问卷填写', '对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。', 1, 10, '文清123', '1、认真完成实验\r\n        2、视力正常。\r\n        3、男生\r\n        1、认真完成实验\r\n        2、视力正常。\r\n        3、男生', 35, 57577547, 123, 46, 22, '行为实验，简单有趣，有小礼物', '招募中', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICFHlYKsSkvScAVic8d84A5jIic3JeTT8HtIayvph1QnPwwy5yPnz95kk8pia8LWpWQ03NbYnDP3vng/132', '小李', '8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30');

--
-- 转储表的索引
--

--
-- 表的索引 `experiment`
--
ALTER TABLE `experiment`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `experiment`
--
ALTER TABLE `experiment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实验id', AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
