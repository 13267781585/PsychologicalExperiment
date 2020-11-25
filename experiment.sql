-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2020-11-25 20:05:13
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
-- 表的结构 `application`
--

CREATE TABLE `application` (
  `id` int(11) NOT NULL COMMENT '报名id',
  `experiment_id` int(11) NOT NULL COMMENT '实验id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `time_period` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '时间段',
  `tester_schedule` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '待完成' COMMENT '主试完成进度',
  `user_schedule` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '待完成' COMMENT '被试完成进度',
  `check_status` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '待审核' COMMENT '审核状态',
  `sign_timestamp` int(11) NOT NULL COMMENT '报名时间戳'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `application`
--

INSERT INTO `application` (`id`, `experiment_id`, `user_id`, `time_period`, `tester_schedule`, `user_schedule`, `check_status`, `sign_timestamp`) VALUES
(7, 1, 1, 'asdasd', '待完成', '待完成', '待审核', 31565487);

-- --------------------------------------------------------

--
-- 表的结构 `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL COMMENT '签到id',
  `user_id` int(11) NOT NULL COMMENT '被试id',
  `timestamp` int(11) NOT NULL COMMENT '时间戳',
  `days` tinyint(5) NOT NULL COMMENT '连续签到天数'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `attendance`
--

INSERT INTO `attendance` (`id`, `user_id`, `timestamp`, `days`) VALUES
(1, 1, 1606292881, 1),
(2, 2, 321654, 3);

-- --------------------------------------------------------

--
-- 表的结构 `cancel_time_period`
--

CREATE TABLE `cancel_time_period` (
  `id` int(11) NOT NULL COMMENT '取消时间段id',
  `time_period` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '取消时间段',
  `tester_id` int(11) NOT NULL COMMENT '主试id',
  `experiment_id` int(11) NOT NULL COMMENT '实验id'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `duration`
--

CREATE TABLE `duration` (
  `id` int(11) NOT NULL COMMENT '实验时添加id',
  `tester_id` int(11) NOT NULL COMMENT '主试id',
  `user_id` int(11) NOT NULL COMMENT '被试id',
  `increase` float NOT NULL COMMENT '增加时长',
  `timestamp` int(11) NOT NULL COMMENT '时间戳',
  `experiment_id` int(11) NOT NULL COMMENT '实验id'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(1, 2, '线上实验', '简单按键实验，问卷填写', '对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。', 1, 10, '文清123', '1、认真完成实验\r\n        2、视力正常。\r\n        3、男生\r\n        1、认真完成实验\r\n        2、视力正常。\r\n        3、男生', 35, 7575757, 127, 44, 30, '行为实验，简单有趣，有小礼物', '招募中', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICFHlYKsSkvScAVic8d84A5jIic3JeTT8HtIayvph1QnPwwy5yPnz95kk8pia8LWpWQ03NbYnDP3vng/132', '小李', '8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30'),
(2, 2, '线下实验', '简单按键实验，问卷填写', '对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。对电脑的信息提示做出本能反应，并在键盘输入相应的键，实验完后填写一份问卷。', 1, 10, '文清123', '1、认真完成实验\r\n        2、视力正常。\r\n        3、男生\r\n        1、认真完成实验\r\n        2、视力正常。\r\n        3、男生', 35, 57577547, 123, 46, 22, '行为实验，简单有趣，有小礼物', '招募中', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICFHlYKsSkvScAVic8d84A5jIic3JeTT8HtIayvph1QnPwwy5yPnz95kk8pia8LWpWQ03NbYnDP3vng/132', '小李', '8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30,8:30-9:30');

-- --------------------------------------------------------

--
-- 表的结构 `experiment_user_like`
--

CREATE TABLE `experiment_user_like` (
  `id` int(11) NOT NULL COMMENT '收藏记录id',
  `experiment_id` int(11) NOT NULL COMMENT '实验id',
  `user_id` int(11) NOT NULL COMMENT '用户id'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `experiment_user_like`
--

INSERT INTO `experiment_user_like` (`id`, `experiment_id`, `user_id`) VALUES
(1, 2, 3),
(2, 15, 3),
(3, 19, 3),
(4, 19, 3),
(5, 1, 3),
(18, 1, 1),
(17, 1, 1),
(16, 2, 3),
(15, 2, 3);

-- --------------------------------------------------------

--
-- 表的结构 `rating_scale`
--

CREATE TABLE `rating_scale` (
  `id` int(11) NOT NULL COMMENT '评分id',
  `experiment_id` int(11) NOT NULL COMMENT '实验id',
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '评分类型',
  `tester_id` int(11) NOT NULL COMMENT '主试id',
  `user_id` int(11) NOT NULL COMMENT '被试id',
  `score` int(11) NOT NULL COMMENT '评分分数',
  `timestamp` int(11) NOT NULL COMMENT '时间戳'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `rating_scale`
--

INSERT INTO `rating_scale` (`id`, `experiment_id`, `type`, `tester_id`, `user_id`, `score`, `timestamp`) VALUES
(11, 1, 'tester', 2, 1, 90, 31565487),
(10, 1, 'tester', 2, 1, 80, 31565487);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT '用户id',
  `open_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '微信授权id',
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `identity` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份',
  `face_url` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像地址',
  `college` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学院',
  `major` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业',
  `grade` smallint(5) DEFAULT NULL COMMENT '年级',
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sex` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `duration` float DEFAULT '0' COMMENT '实验时',
  `sno` int(11) DEFAULT NULL COMMENT '学号',
  `performance_score` float DEFAULT '-1' COMMENT '评分',
  `credit_score` float DEFAULT '100' COMMENT '信誉分',
  `coins` int(11) DEFAULT '0' COMMENT '代币数',
  `wechat` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '微信号'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `open_id`, `username`, `identity`, `face_url`, `college`, `major`, `grade`, `phone`, `sex`, `duration`, `sno`, `performance_score`, `credit_score`, `coins`, `wechat`) VALUES
(1, 'ozuU_5Qvqq-HaXuam_9nnbaPnWxU', '小周小周', '被试', 'https://wx.qlogo.cn/mmopen/vi_32/FcRibGPkicSKhwP0amLcMLhTlq6tb0LF6IGWVBAicWOuiaicMg9cjczWth0Fuf83Or4OjibRIKibFnr3cQQtgBIaibHlLg/132', '计算机科学与网络工程学院', '网络工程', 2018, '13302501152', '男', 56.5, 1806100118, 80, 95, 99, 'wxid_uz1up3p6rrya22'),
(2, 'ozuU_5e0GGDF-wFO-ZpBp-PjR0jM', '张三', '主试', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICFHlYKsSkvScAVic8d84A5jIic3JeTT8HtIayvph1QnPwwy5yPnz95kk8pia8LWpWQ03NbYnDP3vng/132', '教育学院', '应用教育', 2016, '13106607565', '女', 0, 20161254, 83.3333, 95, 5, 'zhc4280'),
(16, '1388899', NULL, '被试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(17, '1388899', NULL, '被试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL),
(18, '1388899', NULL, '被试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL),
(19, '1388899', NULL, '被试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL),
(20, '1388899', NULL, '主试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL),
(21, '138889910', NULL, '被试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL),
(22, '13888991', NULL, '主试', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, -1, 100, 0, NULL);

--
-- 转储表的索引
--

--
-- 表的索引 `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `cancel_time_period`
--
ALTER TABLE `cancel_time_period`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `duration`
--
ALTER TABLE `duration`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `experiment`
--
ALTER TABLE `experiment`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `experiment_user_like`
--
ALTER TABLE `experiment_user_like`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `rating_scale`
--
ALTER TABLE `rating_scale`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `application`
--
ALTER TABLE `application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名id', AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签到id', AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `cancel_time_period`
--
ALTER TABLE `cancel_time_period`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '取消时间段id';

--
-- 使用表AUTO_INCREMENT `duration`
--
ALTER TABLE `duration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实验时添加id';

--
-- 使用表AUTO_INCREMENT `experiment`
--
ALTER TABLE `experiment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实验id', AUTO_INCREMENT=20;

--
-- 使用表AUTO_INCREMENT `experiment_user_like`
--
ALTER TABLE `experiment_user_like`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏记录id', AUTO_INCREMENT=19;

--
-- 使用表AUTO_INCREMENT `rating_scale`
--
ALTER TABLE `rating_scale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评分id', AUTO_INCREMENT=12;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id', AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
