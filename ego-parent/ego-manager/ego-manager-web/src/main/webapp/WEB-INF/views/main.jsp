<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EGO商城后台管理系统</title>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/ego.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/default.css" />
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
	<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(${ctx}/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎 admin 
        <a href="#" style="text-decoration: none;" id="editpass">修改密码</a> 
        <a href="#" style="text-decoration: none;" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; ">
        <img src="images/blocks.gif" width="20" height="20" align="absmiddle" /> 
        ego商城后台管理系统
        </span>
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	<li>
         		<span>商品管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'${ctx }/goods/add'}">新增商品</li>
	         		<li data-options="attributes:{'url':'${ctx }/goods/list'}">查询商品</li>
	         		<li data-options="attributes:{'url':'${ctx }/goods/attr/list'}">规格参数</li>
	         	</ul>
         	</li>
         	<li>
         		<span>网站内容管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'${ctx }/content/cat/cat-tree'}">内容分类管理</li>
	         		<li data-options="attributes:{'url':'${ctx }/content/list'}">内容管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>活动管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'${ctx }/red/list'}">红包管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>solr管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'${ctx }/solr/importDataFromMysql'}">导入数据</li>
	         	</ul>
         	</li>
         	<li>
         		<span>系统管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'${ctx }/goods/cat/clearCache'}">清空商品分类缓存</li>
	         	</ul>
         	</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	欢迎使用EGO商城后台管理系统
		    </div>
		</div>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">孙暖@2018</div>
    </div>
    
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
function dataImport(){
	alert("1");
}

</script>
</body>
</html>