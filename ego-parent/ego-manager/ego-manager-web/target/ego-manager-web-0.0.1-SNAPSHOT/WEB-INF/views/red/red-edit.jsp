<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<link href="${ctx}/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="redEditForm" class="itemForm" method="post">
		<input type="hidden" name="id">
	    <table cellpadding="5">
	        <tr>
	            <td>红包key:</td>
	            <td><input class="easyui-textbox" type="text" id="redkey" name="redkey" value="" data-options="required:true" readonly="readonly" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>排行榜key:</td>
	            <td><input class="easyui-textbox" type="text" id="topnkey" name="topnkey" value="" data-options="required:true" readonly="readonly" style="width: 280px;"></input></td>
	        </tr>
	        <tr> 
	            <td>红包总金额:</td>
	            <td><input class="easyui-numberbox" type="text" name="totalAmount" style="width: 280px;" data-options="min:1,max:99999999,required:true"></input></td>
	        </tr>
	        <tr>
	            <td>红包总数:</td>
	            <td><input class="easyui-numberbox" name="num" data-options="min:1,max:99999999,required:true" style="height:60px;width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>最小金额:</td>
	            <td><input class="easyui-numberbox" name="minAmount" data-options="min:1,max:99999999,required:true" style="height:60px;width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
				<td>状态:</td>
				<td>
					<input type="radio" name="redStatus" value="0" checked="checked" />下架
					<input type="radio" name="redStatus" value="1" />正常
				</td>
			</tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="redAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="redAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		var uid1 = uuid(12,16);
		var uid2 = uuid(12,16);
		$("#red_package_key").val(uid1)
		$("#topn_key").val(uid2)
	});
	var redAddPage  = {
			submitForm : function (){
				$.post("/red/saveOrUpdate",$("#redEditForm").serialize(), function(data){
					if(data.status == 200){
						$.messager.alert('提示','派发红包成功!');
						$("#redList").datagrid("reload");
					}else{
						$.messager.alert('提示',data.message);
					}
				});
			},
			clearForm : function(){
				$('#redEditForm').form('reset');
				redAddEditor.html('');
			}
	};
	
	//生成uuid
	function uuid(len, radix) {
		  var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
		  var uuid = [], i;
		  radix = radix || chars.length;
		 
		  if (len) {
		   for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
		  } else {
		   var r;
		   uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		   uuid[14] = '4';
		 
		   for (i = 0; i < 36; i++) {
		    if (!uuid[i]) {
		     r = 0 | Math.random()*16;
		     uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
		    }
		   }
		  }
		  return uuid.join('');
	}
</script>
