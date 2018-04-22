<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<link href="${ctx}/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${ctx}/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>商品类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="cat_id" style="width: 280px;"></input>	
	            </td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="goodsName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品卖点:</td>
	            <td><input class="easyui-textbox" name="keywords" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品成本:</td>
	            <td><input class="easyui-numberbox" type="text" name="costPrice" data-options="min:1,max:99999999,precision:2,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品市场价:</td>
	            <td><input class="easyui-numberbox" type="text" name="marketPrice" data-options="min:1,max:99999999,precision:2,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品市场价:</td>
	            <td><input class="easyui-numberbox" type="text" name="shopPrice" data-options="min:1,max:99999999,precision:2,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="storeCount" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>商品编号:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="goodsSn" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品图片:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                <input type="hidden" name="originalImg"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="goodsContent"></textarea>
	            </td>
	        </tr>
	        <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	    <input type="hidden" name="itemParamId"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor ;
	$(function(){
		//实例化编辑器
		itemEditEditor = ego.createEditor("#itemeEditForm [name=goodsContent]");
	});
	
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$("#itemeEditForm [name=price]").val(eval($("#itemeEditForm [name=priceView]").val()) * 1000);
		itemEditEditor.sync();
		
		var paramJson = [];
		$("#itemeEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		
		$("#itemeEditForm [name=itemParams]").val(paramJson);
		
		$.post("/goods/update",$("#itemeEditForm").serialize(), function(res){
			if(res.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}
		});
	}
</script>
