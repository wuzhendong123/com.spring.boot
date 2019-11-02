/*
Navicat MySQL Data Transfer

Source Server         : 192.168.16.160
Source Server Version : 50640
Source Host           : 192.168.16.160:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-11-02 17:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client_user
-- ----------------------------
DROP TABLE IF EXISTS `client_user`;
CREATE TABLE `client_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `access_token` varchar(100) DEFAULT NULL,
  `access_token_validity` datetime DEFAULT NULL,
  `refresh_token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of client_user
-- ----------------------------
INSERT INTO `client_user` VALUES ('6', 'bobo', 'xyz', '0f3151e2-373d-4f36-b13d-46284397d413', '2018-12-31 22:35:39', null);

-- ----------------------------
-- Table structure for dict_data
-- ----------------------------
DROP TABLE IF EXISTS `dict_data`;
CREATE TABLE `dict_data` (
  `code` varchar(30) NOT NULL DEFAULT '0' COMMENT '字典编码',
  `optimistic` int(11) DEFAULT NULL,
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT '' COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT '' COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` varchar(5) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of dict_data
-- ----------------------------
INSERT INTO `dict_data` VALUES ('0', '0', '1', '禁用', 'FALSE', 'sys_status_type', '', 'danger', 'N', 'TRUE', 'xiaoixaowu', '2019-03-30 15:37:11', '', null, '');
INSERT INTO `dict_data` VALUES ('1124626537589608449', '0', '0', '下拉框', 'select', 'sys_action_type', '', 'primary', 'N', 'TRUE', '', '2019-05-04 18:47:16', '', null, '');
INSERT INTO `dict_data` VALUES ('1124630673374605314', '0', '0', '文本框', 'input', 'sys_action_type', '', 'primary', 'N', 'TRUE', '', '2019-05-04 19:03:42', '', null, '');
INSERT INTO `dict_data` VALUES ('2', null, '0', 'SQL', 'SQL', 'sys_query_type', '', 'primary', 'N', 'TRUE', 'xiaoixaowu', '2019-04-20 23:35:39', '', null, '');
INSERT INTO `dict_data` VALUES ('3', '0', '0', '可用', 'TRUE', 'sys_status_type', '', 'primary', 'N', 'TRUE', 'xiaoixaowu', '2019-03-30 15:33:15', '', null, '');

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type` (
  `code` varchar(100) NOT NULL COMMENT '字典主键',
  `optimistic` int(11) DEFAULT NULL,
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` varchar(5) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`code`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES ('0', '0', '数据类型', 'sys_query_type', 'TRUE', 'xiaoxioawu', '2019-04-20 23:34:45', 'x', null, '');
INSERT INTO `dict_type` VALUES ('11', '0', '状态类型', 'sys_status_type', 'TRUE', 'xiaoxioawu', '2019-03-30 15:30:47', 'x', null, '');
INSERT INTO `dict_type` VALUES ('1124608844664750082', null, '动作类型', 'sys_action_type', 'TRUE', '', '2019-05-04 17:36:57', '', null, '');

-- ----------------------------
-- Table structure for dict_type_history
-- ----------------------------
DROP TABLE IF EXISTS `dict_type_history`;
CREATE TABLE `dict_type_history` (
  `code` varchar(100) NOT NULL COMMENT '字典主键',
  `optimistic` int(11) DEFAULT NULL,
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` varchar(5) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表历史';

-- ----------------------------
-- Records of dict_type_history
-- ----------------------------
INSERT INTO `dict_type_history` VALUES ('1171233276556288001', '0', '', '', '0', '', '2019-09-10 09:25:48', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171237774947295234', '0', '', '', '0', '', '2019-09-10 09:43:41', '', null, '');
INSERT INTO `dict_type_history` VALUES ('1171238407028912129', '0', '', '', '11', 'dddd', '2019-09-10 09:25:48', 'cccc', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171238869530669057', '0', '', '', '11', 'dddd', '2019-09-10 09:25:48', 'cccc', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171240707852087297', '0', '', '', '11', 'dddd', '2019-09-10 09:25:48', '5555', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171781967998455810', '0', '', '', '0', '', '2019-09-11 21:46:06', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171784081860579330', '0', '', '111', '0', '', '2019-09-11 21:54:30', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171785807103537153', '0', '', '22', '0', '', '2019-09-11 22:01:22', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171790110719483906', '0', '', '122', '0', '', '2019-09-11 22:18:28', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171791585067667457', '0', '', '422', '0', '', '2019-09-11 22:24:19', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1171792390739062785', '0', '', '922', '0', '', '2019-09-11 22:27:31', '', null, 'dddd');
INSERT INTO `dict_type_history` VALUES ('1174925530382835713', '0', '', '', '0', '', '2019-09-20 13:57:30', '', null, 'dddd');

-- ----------------------------
-- Table structure for function_route_temple
-- ----------------------------
DROP TABLE IF EXISTS `function_route_temple`;
CREATE TABLE `function_route_temple` (
  `code` varchar(20) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `ref_code` varchar(120) DEFAULT NULL COMMENT '引用模板标识',
  `html` varchar(1000) DEFAULT NULL COMMENT '内容展示',
  `express` varchar(1000) DEFAULT NULL COMMENT '执行表达式',
  `cn_express` varchar(120) DEFAULT NULL COMMENT '中文表达式(用于页面配置)',
  `html_layout` varchar(1000) DEFAULT NULL COMMENT 'html布局',
  `param_def` varchar(1000) DEFAULT NULL COMMENT '参数定义'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='函数模板定义';

-- ----------------------------
-- Records of function_route_temple
-- ----------------------------
INSERT INTO `function_route_temple` VALUES ('1123421836483305473', 'TRUE', '产品编码函数', null, '2019-05-01 11:00:13', null, '1123418006379110401', ' <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">产品编码：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\" name=\"product\" class=\"form-control\" placeholder=\"请输入文本\">\r\n                                </div>\r\n                            </div>', '#s.name.equals(${product})', '产品编码:${product}', null, null);
INSERT INTO `function_route_temple` VALUES ('1123428844670373889', 'TRUE', '下拉框', null, '2019-05-01 11:28:04', null, '1123418006379110401', ' <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">下拉框：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <select class=\"form-control\" name=\"select\">\r\n                                        <option>选项 1</option>\r\n                                        <option>选项 2</option>\r\n                                        <option>选项 3</option>\r\n                                        <option>选项 4</option>\r\n                                    </select>\r\n                                </div>\r\n                            </div>', '#s.name.equals(${select})', '下拉框名称:${select.text}', null, null);
INSERT INTO `function_route_temple` VALUES ('1124692223816962049', 'TRUE', '是否真实性', null, '2019-05-04 23:08:17', '0', '1124691489390137345', '<div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">真实性：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\" name=\"real\" class=\"form-control\" placeholder=\"请输入文本\">\r\n                                </div>\r\n                            </div>', '#s.real.equals(${real})', '商户真实性:${real}', null, null);
INSERT INTO `function_route_temple` VALUES ('1139153286398578690', 'TRUE', '发卡行', null, '2019-06-13 20:51:23', '2', '1124691489390137345', '<div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">发卡行：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\"  readonly  class=\"form-control\" placeholder=\"请输入文本\" onclick=\"findQuery(\'1139154125670420481\')\">\r\n                                </div>\r\n                            </div>', '#s.name.equals(${code})', '发卡行:${code.text}', null, null);

-- ----------------------------
-- Table structure for function_rule_ref
-- ----------------------------
DROP TABLE IF EXISTS `function_rule_ref`;
CREATE TABLE `function_rule_ref` (
  `code` varchar(20) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `fun_temple_code` varchar(120) DEFAULT NULL COMMENT '函数模板code',
  `rule_code` varchar(120) DEFAULT NULL COMMENT '规则code',
  `html` varchar(1000) DEFAULT NULL COMMENT '内容展示',
  `express` varchar(1000) DEFAULT NULL COMMENT '具体表达式',
  `param_array` varchar(1000) DEFAULT NULL COMMENT '[{key:key,value:value}]'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='函数规则引用';

-- ----------------------------
-- Records of function_rule_ref
-- ----------------------------
INSERT INTO `function_rule_ref` VALUES ('1124633735921152002', 'TRUE', null, '2019-05-04 19:15:52', '0', '1123428844670373889', '1124633735531081729', '下拉框名称:选项 3', '#s.name.equals(\'选项 3\')', '[{\"key\":\"select\",\"value\":\"选项 3\"},{\"key\":\"cn_express\",\"value\":\"下拉框名称:${select.text}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124643397768896514', 'TRUE', null, '2019-05-04 19:54:16', '0', '1123421836483305473', '1124643397160722433', '产品编码:11', '#s.name.equals(\'11\')', '[{\"key\":\"product\",\"value\":\"11\"},{\"key\":\"cn_express\",\"value\":\"产品编码:${product}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124662535706939394', 'FALSE', null, '2019-05-04 21:10:18', '1', '1123428844670373889', '1124662535388172289', '下拉框名称:选项 2', '#s.name.equals(\'选项 2\')', '[{\"key\":\"select\",\"value\":\"选项 2\"},{\"key\":\"cn_express\",\"value\":\"下拉框名称:${select.text}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124662535715328002', 'TRUE', null, '2019-05-04 21:10:18', '0', '1123428844670373889', '1124662535388172289', '下拉框名称:选项 4', '#s.name.equals(\'选项 4\')', '[{\"key\":\"select\",\"value\":\"选项 4\"},{\"key\":\"cn_express\",\"value\":\"下拉框名称:${select.text}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124662535723716610', 'FALSE', null, '2019-05-04 21:10:18', '1', '1123421836483305473', '1124662535388172289', '产品编码:', '#s.name.equals(\'\')', '[{\"key\":\"product\",\"value\":\"\"},{\"key\":\"cn_express\",\"value\":\"产品编码:${product}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124681856449531905', 'TRUE', null, '2019-05-04 22:27:05', '0', '1123428844670373889', '1124662535388172289', '下拉框名称:选项 1', '#s.name.equals(\'选项 1\')', '[{\"key\":\"select\",\"value\":\"选项 1\"},{\"key\":\"cn_express\",\"value\":\"下拉框名称:${select.text}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124681856470503425', 'TRUE', null, '2019-05-04 22:27:05', '0', '1123421836483305473', '1124662535388172289', '产品编码:hhh', '#s.name.equals(\'hhh\')', '[{\"key\":\"product\",\"value\":\"hhh\"},{\"key\":\"cn_express\",\"value\":\"产品编码:${product}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124695239039143938', 'TRUE', null, '2019-05-04 23:20:15', '0', '1124692223816962049', '1124695238795874306', '商户真实性:Y', '#s.real.equals(\'Y\')', '[{\"key\":\"real\",\"value\":\"Y\"},{\"key\":\"cn_express\",\"value\":\"商户真实性:${real}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1124696877770493954', 'TRUE', null, '2019-05-04 23:26:46', '0', '1124692223816962049', '1124696877669830657', '商户真实性:Y', '#s.real.equals(\'Y\')', '[{\"key\":\"real\",\"value\":\"Y\"},{\"key\":\"cn_express\",\"value\":\"商户真实性:${real}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1138485688505733122', 'TRUE', null, '2019-06-12 00:38:35', '0', '1124692223816962049', '1138485687524265986', '商户真实性:Y', '#s.real.equals(\'Y\')', '[{\"key\":\"real\",\"value\":\"Y\"},{\"key\":\"cn_express\",\"value\":\"商户真实性:${real}\"}]');
INSERT INTO `function_rule_ref` VALUES ('1139161446005915650', 'FALSE', null, '2019-06-13 21:23:48', '1', '1139153286398578690', '1124695238795874306', '发卡行:,建设银行,工商银行', '#s.name.equals(\',CCB,ICBC\')', '[{\"key\":\"cn_express\",\"value\":\"发卡行:${code.text}\"},{\"key\":\"code\",\"value\":\",CCB,ICBC\"}]');
INSERT INTO `function_rule_ref` VALUES ('1139411195137150978', 'TRUE', null, '2019-06-14 13:56:13', '0', '1139153286398578690', '1124695238795874306', '发卡行:,工商银行', '#s.name.equals(\',ICBC\')', '[{\"key\":\"cn_express\",\"value\":\"发卡行:${code.text}\"},{\"key\":\"code\",\"value\":\",ICBC\"}]');

-- ----------------------------
-- Table structure for fun_param_html_ref
-- ----------------------------
DROP TABLE IF EXISTS `fun_param_html_ref`;
CREATE TABLE `fun_param_html_ref` (
  `code` varchar(20) DEFAULT NULL,
  `query_code` varchar(120) DEFAULT NULL COMMENT '函数code',
  `status` varchar(120) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `param_html_code` varchar(120) DEFAULT NULL COMMENT '参数模板code',
  `html` varchar(1000) DEFAULT NULL COMMENT 'html内容',
  `param_exp` varchar(120) DEFAULT NULL COMMENT '参数表达式',
  `param_key` varchar(120) DEFAULT NULL COMMENT '参数key'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='函数参数html关系';

-- ----------------------------
-- Records of fun_param_html_ref
-- ----------------------------
INSERT INTO `fun_param_html_ref` VALUES ('1120714330321580033', '1120272138075385857', 'TRUE', '2019-04-23 23:41:33', null, '0', '1120305883453177857', '                            <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">日期</label>\r\n\r\n                                <div class=\"col-sm-9\">\r\n                                     <div class=\"form-group\">\r\n			                            <div class=\"input-group date\">\r\n			                                <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n			                                <input type=\"text\" class=\"form-control\" value=\"2018-04-20\" name=\"riqi\">\r\n			                            </div>\r\n			                        </div>\r\n                                </div>\r\n                            </div>', '', 'querycode');
INSERT INTO `fun_param_html_ref` VALUES ('1120714330321580034', '1120272138075385857', 'TRUE', '2019-04-23 23:41:33', null, '0', '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">状态</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"status\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'status');
INSERT INTO `fun_param_html_ref` VALUES ('1120714330346745858', '1120272138075385857', 'FALSE', '2019-04-23 23:41:33', null, '0', '1120305883453177857', '                            <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">日期</label>\r\n\r\n                                <div class=\"col-sm-9\">\r\n                                     <div class=\"form-group\">\r\n			                            <div class=\"input-group date\">\r\n			                                <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n			                                <input type=\"text\" class=\"form-control\" value=\"2018-04-20\" name=\"riqi\">\r\n			                            </div>\r\n			                        </div>\r\n                                </div>\r\n                            </div>', '', 'paramhtmlcode');
INSERT INTO `fun_param_html_ref` VALUES ('1120714330346745859', '1120272138075385857', 'TRUE', '2019-04-23 23:41:33', null, '2', '1120923571720294402', ' <div class=\"form-group\">     \r\n  <label class=\"col-sm-3 control-label\">上传</label>\r\n  <div class=\"custom-file col-sm-4\">\r\n    <input type=\"file\" class=\"custom-file-input\"  aria-describedby=\"inputGroupFileAddon01\" name=\"file\">    \r\n  </div>\r\n  <label class=\"custom-file-label col-sm-4\" for=\"inputGroupFile01\">Choose file</label>\r\n</div>', '', 'html');
INSERT INTO `fun_param_html_ref` VALUES ('1120714330346745860', '1120272138075385857', 'TRUE', '2019-04-23 23:41:33', null, '0', '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">exp</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"exp\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'paramexp');
INSERT INTO `fun_param_html_ref` VALUES ('1120714330363523073', '1120272138075385857', 'TRUE', '2019-04-23 23:41:33', null, '1', '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">函数编码</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"code\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', '1120714330363523073');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358170783746', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">ss</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"dd\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358170783747', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">ddd</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"ddd\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode1');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358170783748', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">ffff</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"fff\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode2');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358170783749', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">gggg</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"gggg\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode3');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358250475522', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">hhhh</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"hhhh\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode4');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358250475523', '1120276792003801090', 'FALSE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">jjjj</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"jjjj\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode5');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358250475524', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">kkkkkkk</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"kkkkkk\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode6');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358267252737', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">qqqq</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"qqqq\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode7');
INSERT INTO `fun_param_html_ref` VALUES ('1121058358267252738', '1120276792003801090', 'TRUE', '2019-04-24 22:28:36', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">wwww</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"wwwww\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'querycode8');
INSERT INTO `fun_param_html_ref` VALUES ('1121394364887646209', '1119630147843002369', 'TRUE', '2019-04-25 20:43:46', null, null, '1119790924738613249', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">name</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"name\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '', 'name');

-- ----------------------------
-- Table structure for fun_result_ref
-- ----------------------------
DROP TABLE IF EXISTS `fun_result_ref`;
CREATE TABLE `fun_result_ref` (
  `code` varchar(20) DEFAULT NULL,
  `query_code` varchar(120) DEFAULT NULL COMMENT '函数code',
  `status` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `clss_ui` varchar(120) DEFAULT NULL COMMENT '类样式',
  `param_exp` varchar(120) DEFAULT NULL COMMENT '参数表达式',
  `param_key` varchar(120) DEFAULT NULL COMMENT '参数key',
  `title` varchar(120) DEFAULT NULL COMMENT '标题',
  `row_total` int(11) DEFAULT NULL COMMENT '行合计'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='函数结果输出格式';

-- ----------------------------
-- Records of fun_result_ref
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `code` varchar(100) NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `optimistic` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `level` int(11) DEFAULT NULL COMMENT '菜单级别',
  `path` varchar(300) DEFAULT NULL COMMENT '记录到顶层路径',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `parent_code` varchar(30) DEFAULT NULL,
  `url` varchar(30) DEFAULT NULL,
  `icon` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1118084048821014530', null, null, '1', '字典管理', '2', null, 'TRUE', 'abc', '/dict/type/index', 'fa fa-book');
INSERT INTO `menu` VALUES ('1118848900036362241', null, null, '1', '系统工具', '3', null, 'TRUE', 'uuu', '#', 'fa fa-legal');
INSERT INTO `menu` VALUES ('1118849159630225409', null, '2019-04-18 20:10:02', '0', '拖拽管理', '1', null, 'TRUE', '1118848900036362241', '/tool/build.html', 'fa fa-object-group');
INSERT INTO `menu` VALUES ('1119453982712930305', null, '2019-04-20 12:13:23', '1', '查询管理', '4', null, 'TRUE', 'uuu', '#', 'fa fa-reorder');
INSERT INTO `menu` VALUES ('1119454211361218562', null, '2019-04-20 12:14:17', '1', 'HTML组件添加', '1', null, 'TRUE', '1119453982712930305', '/paramHtmlTemple/index', 'fa fa-barcode');
INSERT INTO `menu` VALUES ('1119569396717686786', '2019-06-16 15:33:09', '2019-06-16 15:33:09', '5', '查询函数管理', '4', null, 'TRUE', '1119453982712930305', '/queryfunction/index', 'fa fa-braille');
INSERT INTO `menu` VALUES ('1119845115972599809', null, '2019-04-21 14:07:36', '0', '通用工具', '5', null, 'TRUE', 'uuu', '#', 'fa fa-qrcode');
INSERT INTO `menu` VALUES ('1119845300995932161', null, '2019-04-21 14:08:20', '0', '通用查询', '1', null, 'TRUE', '1119845115972599809', '/generalQuery/index', 'fa fa-bar-chart-o');
INSERT INTO `menu` VALUES ('1119911627454451713', null, '2019-04-21 18:31:54', '0', '查询字段管理', '6', null, 'TRUE', '1119453982712930305', '/funParamHtmlRef/index', 'fa fa-share-alt');
INSERT INTO `menu` VALUES ('1123415899622162434', '2019-06-16 15:31:00', '2019-06-16 15:31:00', '1', '路由管理', '3', null, 'TRUE', '1140156057985781762', '/route/index', 'fa fa-snowflake-o');
INSERT INTO `menu` VALUES ('1123566807597244418', '2019-06-16 15:31:00', '2019-06-16 15:31:00', '1', '规则管理', '5', null, 'TRUE', '1140156057985781762', '/rule/index', 'fa fa-bolt');
INSERT INTO `menu` VALUES ('1124630326497275906', null, '2019-05-04 19:02:19', '1', '返回结果模板', '6', null, 'TRUE', '1140156057985781762', 'returnResultTemple/index', 'fa fa-plus-square-o');
INSERT INTO `menu` VALUES ('1124692550024761345', null, '2019-05-04 23:09:34', '2', '函数路由模板管理', '6', null, 'TRUE', '1140156057985781762', '/functionRouteTemple/index', 'fa fa-puzzle-piece');
INSERT INTO `menu` VALUES ('1140156057985781762', null, '2019-06-16 15:16:02', '0', '路由管理', '4', null, 'TRUE', 'uuu', '#', 'fa fa-asl-interpreting');
INSERT INTO `menu` VALUES ('abc', null, '2019-01-29 11:41:58', '0', '系统管理', '1', null, 'TRUE', 'uuu', '#', null);
INSERT INTO `menu` VALUES ('ccc', null, null, '1', '菜单管理', '0', null, 'TRUE', 'abc', '/menu/index', 'fa fa-reorder');
INSERT INTO `menu` VALUES ('uuu', null, '2019-01-27 17:59:22', '0', '总菜单', '0', null, 'TRUE', null, null, null);

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `name` varchar(30) DEFAULT NULL,
  `pass_word` varchar(60) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL COMMENT '操作员',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `salt` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('admin', 'c466f189d277fc0e6702ec3fe5ea18d7', null, 'TRUE', '2019-11-02 02:39:02', '0', '0', '');

-- ----------------------------
-- Table structure for param_html_temple
-- ----------------------------
DROP TABLE IF EXISTS `param_html_temple`;
CREATE TABLE `param_html_temple` (
  `code` varchar(20) DEFAULT NULL,
  `type` varchar(120) DEFAULT NULL COMMENT '组件类型(文本框,日期框)',
  `status` varchar(120) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `class_ui` varchar(120) DEFAULT NULL COMMENT 'css样式',
  `name` varchar(120) DEFAULT NULL COMMENT '模板名称',
  `html` varchar(1000) DEFAULT NULL COMMENT 'html内容',
  `example_html` varchar(1000) DEFAULT NULL COMMENT 'html例子',
  `example_html_param` varchar(100) DEFAULT NULL COMMENT 'html例子参数',
  `html_param` varchar(100) DEFAULT NULL COMMENT 'html参数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='参数html模板';

-- ----------------------------
-- Records of param_html_temple
-- ----------------------------
INSERT INTO `param_html_temple` VALUES ('1119784651242602498', null, 'TRUE', '2019-04-21 10:07:20', null, '0', null, '文本', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">${cn_name}</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"${input_name}\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">文本</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"input_name\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '[{\"key\":\"cn_name\",\"value\":\"文本\"},{\"key\":\"input_name\",\"value\":\"input_name\"}]', '[{\"key\":\"cn_name\"},{\"key\":\"input_name\"}]');
INSERT INTO `param_html_temple` VALUES ('1119790924738613249', null, 'TRUE', '2019-04-21 10:32:16', null, '1', null, '文本框', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">${cnName}</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"${inputName}\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '<div class=\"form-group\">\r\n            <label class=\"col-sm-3 control-label\">中文</label>\r\n            <div class=\"col-sm-8\">\r\n                <input class=\"form-control\" type=\"text\" name=\"name\"  onblur=\"htmlExec(this)\"  >\r\n            </div>\r\n        </div>', '[{\"key\":\"cnName\",\"value\":\"中文\"},{\"key\":\"inputName\",\"value\":\"name\"}]', '[{\"key\":\"cnName\"},{\"key\":\"inputName\"}]');
INSERT INTO `param_html_temple` VALUES ('1120305883453177857', null, 'TRUE', '2019-04-22 20:38:32', null, '0', null, '日期', '                            <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">${name}</label>\r\n\r\n                                <div class=\"col-sm-9\">\r\n                                     <div class=\"form-group\">\r\n			                            <div class=\"input-group date\">\r\n			                                <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n			                                <input type=\"text\" class=\"form-control\" value=\"2018-04-20\" name=\"${inputName}\">\r\n			                            </div>\r\n			                        </div>\r\n                                </div>\r\n                            </div>', '                            <div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">创建日期</label>\r\n\r\n                                <div class=\"col-sm-9\">\r\n                                     <div class=\"form-group\">\r\n			                            <div class=\"input-group date\">\r\n			                                <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n			                                <input type=\"text\" class=\"form-control\" value=\"2018-04-20\" name=\"riqi\">\r\n			                            </div>\r\n			                        </div>\r\n                                </div>\r\n                            </div>', '[{\"key\":\"name\",\"value\":\"创建日期\"},{\"key\":\"inputName\",\"value\":\"riqi\"}]', '[{\"key\":\"name\"},{\"key\":\"inputName\"}]');
INSERT INTO `param_html_temple` VALUES ('1120923571720294402', null, 'TRUE', '2019-04-24 13:33:00', null, '3', null, '上传文件', ' <div class=\"form-group\">     \r\n  <label class=\"col-sm-3 control-label\">上传</label>\r\n  <div class=\"custom-file col-sm-4\">\r\n    <input type=\"file\" class=\"custom-file-input\"  aria-describedby=\"inputGroupFileAddon01\" name=\"${file}\">    \r\n  </div>\r\n</div>', ' <div class=\"form-group\">     \r\n  <label class=\"col-sm-3 control-label\">上传</label>\r\n  <div class=\"custom-file col-sm-4\">\r\n    <input type=\"file\" class=\"custom-file-input\"  aria-describedby=\"inputGroupFileAddon01\" name=\"file\">    \r\n  </div>\r\n</div>', '[{\"key\":\"file\",\"value\":\"file\"}]', '[{\"key\":\"file\"}]');

-- ----------------------------
-- Table structure for query_function
-- ----------------------------
DROP TABLE IF EXISTS `query_function`;
CREATE TABLE `query_function` (
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '函数名称',
  `express` varchar(2000) DEFAULT NULL COMMENT '表达式',
  `type` varchar(120) DEFAULT NULL COMMENT '类型(sql,接口)',
  `status` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `data_version` int(11) DEFAULT NULL COMMENT '使用数据版本',
  `query_name` varchar(600) DEFAULT NULL COMMENT '查询参数',
  `result_name` varchar(600) DEFAULT NULL COMMENT '结果列表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='查询函数执行表达式';

-- ----------------------------
-- Records of query_function
-- ----------------------------
INSERT INTO `query_function` VALUES ('1119630147843002369', '模板查询内容', 'select express as express from  query_function where 1=1\r\nand name=#{name}', 'SQL', 'FALSE', null, '2019-04-20 23:53:24', '2', null, null, null);
INSERT INTO `query_function` VALUES ('1119641052123324418', '模板查询内容2', 'select express as express from  query_function where 1=1\r\nand name=#{name}\r\nand name2=#{name2}', 'SQL', 'TRUE', null, '2019-04-21 00:36:43', '0', null, null, null);
INSERT INTO `query_function` VALUES ('1119855254200950786', '函数按照名称模糊查询', 'select name as name,code as code  from query_function \r\n  <where>\r\n                   <if test=\"queryCode != null and queryCode != \'\'\">\r\n                    AND query_code = #{queryCode}\r\n                </if>\r\n                            <if test=\"status != null and status != \'\'\">\r\n                    AND status = #{status}\r\n                </if>\r\n                            <if test=\"paramHtmlCode != null and paramHtmlCode != \'\'\">\r\n                    AND param_html_code = #{paramHtmlCode}\r\n                </if>\r\n                            <if test=\"html != null and html != \'\'\">\r\n                    AND html = #{html}\r\n                </if>\r\n                            <if test=\"paramExp != null and paramExp != \'\'\">\r\n                    AND param_exp = #{paramExp}\r\n                </if>\r\n                            <if test=\"paramKey != null and paramKey != \'\'\">\r\n                    AND param_key = #{paramKey}\r\n                </if>\r\n            \r\n        </where>', 'SQL', 'TRUE', null, '2019-04-21 14:47:53', '10', null, null, null);
INSERT INTO `query_function` VALUES ('1120272138075385857', '函数名称查找', 'select name as name,code as code,11 as code_1,dd as dd  from query_function \r\n  <where>\r\n                   <if test=\"queryCode != null and queryCode != \'\'\">\r\n                    AND query_code = #{queryCode}\r\n                </if>\r\n                            <if test=\"status != null and status != \'\'\">\r\n                    AND status = #{status}\r\n                </if>\r\n                            <if test=\"paramHtmlCode != null and paramHtmlCode != \'\'\">\r\n                    AND param_html_code = #{paramHtmlCode}\r\n                </if>\r\n                            <if test=\"html != null and html != \'\'\">\r\n                    AND html = #{html}\r\n                </if>\r\n                            <if test=\"paramExp != null and paramExp != \'\'\">\r\n                    AND param_exp = #{paramExp}\r\n                </if>\r\n                            <if test=\"paramKey != null and paramKey != \'\'\">\r\n                    AND param_key = #{paramKey}\r\n                </if>\r\n            \r\n        </where>', 'SQL', 'TRUE', null, '2019-04-22 18:24:26', '1', null, null, null);
INSERT INTO `query_function` VALUES ('1120275773043781634', '添加函数', 'SELECT r.`code` as code ,r.html as html from fun_param_html_ref r  where query_code=#{queryCode}', 'SQL', 'TRUE', null, '2019-04-22 18:38:53', '0', null, null, null);
INSERT INTO `query_function` VALUES ('1120276792003801090', '函数test2', 'select r.code as code ,r.html as html ,r.html as html1 ,r.html as html2,r.html as html3,r.html as html4,as r.html as html5,r.html as html6,r.html as html7,r.html as html8 \r\nfrom fun_param_html_ref r  where query_code=#{queryCode} and \r\nquery_code=#{queryCode1} and query_code=#{queryCode2} and query_code=#{queryCode3} and query_code=#{queryCode4} and query_code=#{queryCode5} and query_code=#{queryCode6} and query_code=#{queryCode7} and query_code=#{queryCode8}', 'SQL', 'TRUE', null, '2019-04-22 18:42:56', '2', null, null, null);
INSERT INTO `query_function` VALUES ('1139154125670420481', '发卡行查询', 'select \'CCB\' as  value,\'建设银行\' as text from dual\r\nunion\r\nselect \'ICBC\' as  value,\'工商银行\' as text from dual', 'SQL', 'TRUE', null, '2019-06-13 20:54:43', '1', null, null, null);

-- ----------------------------
-- Table structure for return_result_rule_ref
-- ----------------------------
DROP TABLE IF EXISTS `return_result_rule_ref`;
CREATE TABLE `return_result_rule_ref` (
  `code` varchar(20) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `text` varchar(120) DEFAULT NULL COMMENT '中文描述',
  `value` varchar(120) DEFAULT NULL COMMENT '值',
  `rule_code` varchar(120) DEFAULT NULL COMMENT '规则code'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='返回结果规则关联';

-- ----------------------------
-- Records of return_result_rule_ref
-- ----------------------------
INSERT INTO `return_result_rule_ref` VALUES ('1124633736034398209', 'TRUE', null, '2019-05-04 19:15:52', '0', '通道编码:P310000_011', 'P310000_011', '1124633735531081729');
INSERT INTO `return_result_rule_ref` VALUES ('1124643397882142722', 'TRUE', null, '2019-05-04 19:54:16', '0', '通道编码:P310000_111', 'P310000_111', '1124643397160722433');
INSERT INTO `return_result_rule_ref` VALUES ('1124690383893225474', 'TRUE', null, '2019-05-04 23:00:58', '0', '通道编码:P310000_222', 'P310000_222', '1124662535388172289');
INSERT INTO `return_result_rule_ref` VALUES ('1124695239144001537', 'TRUE', null, '2019-05-04 23:20:15', '0', '通道编码:P310000_222', 'P310000_222', '1124695238795874306');
INSERT INTO `return_result_rule_ref` VALUES ('1124696877829214210', 'TRUE', null, '2019-05-04 23:26:46', '0', '通道编码:P310000_333', 'P310000_333', '1124696877669830657');
INSERT INTO `return_result_rule_ref` VALUES ('1138485688828694530', 'TRUE', null, '2019-06-12 00:38:35', '0', '通道编码:P310000_011', 'P310000_011', '1138485687524265986');

-- ----------------------------
-- Table structure for return_result_temple
-- ----------------------------
DROP TABLE IF EXISTS `return_result_temple`;
CREATE TABLE `return_result_temple` (
  `code` varchar(20) DEFAULT NULL,
  `status` varchar(120) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `name` varchar(220) DEFAULT NULL COMMENT '名称',
  `type` varchar(120) DEFAULT NULL COMMENT '类型(方法,select,text)',
  `cn_express` varchar(120) DEFAULT NULL COMMENT '中文表达式(用于页面配置)',
  `html` varchar(1000) DEFAULT NULL COMMENT '内容展示'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='返回结果模板';

-- ----------------------------
-- Records of return_result_temple
-- ----------------------------
INSERT INTO `return_result_temple` VALUES ('1124632968992681986', 'TRUE', null, '2019-05-04 19:12:49', '0', '通道编码', 'input', '通道编码:${returnValue}', '<div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">文本框：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\" name=\"returnValue\" class=\"form-control\" placeholder=\"请输入文本\">\r\n                                </div>\r\n                            </div>');
INSERT INTO `return_result_temple` VALUES ('1187289630311985154', 'TRUE', null, '2019-10-24 16:48:01', '2', '通道编码2', 'input', '通道编码:${returnValue}', '<div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">文本框：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\" name=\"returnValue\" class=\"form-control\" placeholder=\"请输入文本\">\r\n                                </div>\r\n                            </div>');
INSERT INTO `return_result_temple` VALUES ('1187289885657018369', 'TRUE', null, '2019-10-24 16:49:02', '0', '通道编码3', 'input', '通道编码:${returnValue}', '<div class=\"form-group\">\r\n                                <label class=\"col-sm-3 control-label\">文本框：</label>\r\n                                <div class=\"col-sm-9\">\r\n                                    <input type=\"text\" name=\"returnValue\" class=\"form-control\" placeholder=\"请输入文本\">\r\n                                </div>\r\n                            </div>');

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `code` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '规则名称',
  `status` varchar(30) DEFAULT NULL COMMENT '状态',
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_version` int(11) DEFAULT NULL COMMENT '使用数据版本'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='规则组';

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES ('1123418006379110401', '函数规则模板名称', 'TRUE', null, '2019-05-01 10:44:59', null, null);
INSERT INTO `route` VALUES ('1124691489390137345', '通道路由模板', 'TRUE', '0', '2019-05-04 23:05:21', null, null);

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `code` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '规则名称',
  `status` varchar(30) DEFAULT NULL COMMENT '状态',
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `route_code` varchar(30) DEFAULT NULL COMMENT '路由code',
  `success_action_type` varchar(30) DEFAULT NULL COMMENT '成功动作类型(方法,值)',
  `data_version` int(11) DEFAULT NULL COMMENT '使用数据版本',
  `level` int(11) DEFAULT NULL COMMENT '顺序',
  `parent_rule_code` varchar(30) DEFAULT NULL COMMENT '父类规则',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定义规则(组)执行一组表达式';

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('1123566507389935617', '测试规则', 'TRUE', '0', '1123418006379110401', null, null, '1', null, '2019-05-01 20:35:05', null);
INSERT INTO `rule` VALUES ('1124204757917949954', '测试规则2', 'TRUE', '0', '1123418006379110401', null, null, '1', '1123566507389935617', '2019-05-03 14:51:16', null);
INSERT INTO `rule` VALUES ('1124633735531081729', '测试规则3', 'TRUE', '0', '1123418006379110401', 'input', null, '2', null, '2019-05-04 19:15:52', null);
INSERT INTO `rule` VALUES ('1124643397160722433', '测试规则4', 'TRUE', '0', '1123418006379110401', 'input', null, '4', null, '2019-05-04 19:54:15', null);
INSERT INTO `rule` VALUES ('1124662535388172289', '测试规则3_1', 'TRUE', '7', '1123418006379110401', 'input', null, '3', '1124633735531081729', '2019-05-04 21:10:18', null);
INSERT INTO `rule` VALUES ('1124695238795874306', '测试规则1', 'TRUE', '2', '1124691489390137345', 'input', null, '1', null, '2019-05-04 23:20:15', null);
INSERT INTO `rule` VALUES ('1124696877669830657', '测试规则1_1', 'TRUE', '0', '1124691489390137345', 'input', null, '1', '1124695238795874306', '2019-05-04 23:26:46', null);
INSERT INTO `rule` VALUES ('1138485687524265986', '测试规则1_2', 'TRUE', '0', '1124691489390137345', 'input', null, '3', '1124696877669830657', '2019-06-12 00:38:35', null);

-- ----------------------------
-- Table structure for sys_operator_role_ref
-- ----------------------------
DROP TABLE IF EXISTS `sys_operator_role_ref`;
CREATE TABLE `sys_operator_role_ref` (
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `oper_code` varchar(30) DEFAULT NULL COMMENT '操作员code',
  `role_code` varchar(30) DEFAULT NULL COMMENT '角色code',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_operator_role_ref
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '权限名称',
  `permissions_mark` varchar(30) DEFAULT NULL COMMENT '权限编码',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限校验';

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu_ref
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_ref`;
CREATE TABLE `sys_role_menu_ref` (
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `rule_code` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `menu_code` varchar(30) DEFAULT NULL COMMENT '菜单code',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关系';

-- ----------------------------
-- Records of sys_role_menu_ref
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permissions_ref
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissions_ref`;
CREATE TABLE `sys_role_permissions_ref` (
  `code` varchar(30) NOT NULL,
  `optimistic` int(11) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `rule_code` varchar(30) DEFAULT NULL COMMENT '角色code',
  `per_code` varchar(30) DEFAULT NULL COMMENT '权限code',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和权限关系';

-- ----------------------------
-- Records of sys_role_permissions_ref
-- ----------------------------

-- ----------------------------
-- Table structure for temp_batch
-- ----------------------------
DROP TABLE IF EXISTS `temp_batch`;
CREATE TABLE `temp_batch` (
  `code` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `optimistic` int(11) DEFAULT NULL COMMENT '版本号',
  `update_time` datetime DEFAULT NULL,
  `mark` varchar(100) DEFAULT NULL COMMENT '标识',
  `bacth_no` varchar(100) DEFAULT NULL COMMENT '批次号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='临时批次';

-- ----------------------------
-- Records of temp_batch
-- ----------------------------
INSERT INTO `temp_batch` VALUES ('1125692031088295938', '2019-05-07 17:21:09', '0', null, 'sddd', 'ddd');
INSERT INTO `temp_batch` VALUES ('1125692031256068097', '2019-05-07 17:21:09', '0', null, 'asdasd', 'ddd');
INSERT INTO `temp_batch` VALUES ('1125692031264456706', '2019-05-07 17:21:09', '0', null, 'afsasfa', 'ddd');
INSERT INTO `temp_batch` VALUES ('1125692031268651010', '2019-05-07 17:21:09', '0', null, 'sdgg', 'ddd');
