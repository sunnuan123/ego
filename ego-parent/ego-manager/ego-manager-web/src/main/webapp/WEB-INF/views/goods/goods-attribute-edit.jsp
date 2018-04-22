<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<form id="itemParamEditForm">
<input type="hidden" name="id" value="${goodsAttr.id}" />
<table cellpadding="5" style="margin-left: 30px" id="itemParamAddTable" class="itemParam">
	<tr>
		<td>商品类目:</td>
		<td><a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a> 
			<input type="hidden" name="cat_id" id= style="width: 280px;" value="${goodsAttr.catId}"></input>
		</td>
	</tr>
	<tr>
		<td>属性名称:</td>
		<td>
			<input type="text" name="attrName" value="${goodsAttr.attrName }" style="width: 280px;"></input>
		</td>
	</tr>
	<tr>
		<td>能否进行检索:</td>
		<td>
			<input type="radio" name="attrIndex" value="0" <c:if test="${goodsAttr.attrIndex eq 0 }"> checked="checked" </c:if>/>不需要检索
			<input type="radio" name="attrIndex" value="1" <c:if test="${goodsAttr.attrIndex eq 1 }"> checked="checked" </c:if>/>关键字检索索
		</td>
	</tr>
	<tr>
		<td>该属性值的录入方式:</td>
		<td>
			<input type="radio" name="attrInputType" value="0" <c:if test="${goodsAttr.attrInputType eq 0 }"> checked="checked" </c:if> />手工录入
			<input type="radio" name="attrInputType" value="1" <c:if test="${goodsAttr.attrInputType eq 1 }"> checked="checked" </c:if> />从下面的列表中选择（一行代表一个可选值）
			<input type="radio" name="attrInputType" value="2" <c:if test="${goodsAttr.attrInputType eq 2 }"> checked="checked" </c:if> />多行文本框
		</td>
	</tr>
	<tr>
		<td>可选值列表:</td>
		<td>
			<textarea name="attrValues" rows="" cols="">${goodsAttr.attrValues }</textarea>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<a href="javascript:void(0)" class="easyui-linkbutton submit">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton close">关闭</a>
		</td>
	</tr>
</table>
</form>
<div  class="itemParamAddTemplate" style="display: none;">
	<li class="param">
		<ul>
			<li>
				<input class="easyui-textbox" style="width: 150px;" name="group"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton addParam"  title="添加参数" data-options="plain:true,iconCls:'icon-add'"></a>
			</li>
			<li>
				<span>|-------</span><input  style="width: 150px;" class="easyui-textbox" name="param"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton delParam" title="删除" data-options="plain:true,iconCls:'icon-cancel'"></a>						
			</li>
		</ul>
	</li>
</div>
<script style="text/javascript">
	$(function(){
		ego.initItemCat({
			fun:function(node){
			$(".addGroupTr").hide().find(".param").remove();
				//  判断选择的类目是否已经添加过规格
			  $.getJSON("/goods/param/query/itemcatid/" + node.id,function(data){
				  if(data.status == 200 && data.data){
					  $.messager.alert("提示", "该类目已经添加，请选择其他类目。", undefined, function(){
						 $("#itemParamAddTable .selectItemCat").click();
					  });
					  return ;
				  }
				  $(".addGroupTr").show();
			  });
			}
		});
		
		$(".addGroup").click(function(){
			  var temple = $(".itemParamAddTemplate li").eq(0).clone();
			  $(this).parent().parent().append(temple);
			  temple.find(".addParam").click(function(){
				  var li = $(".itemParamAddTemplate li").eq(2).clone();
				  li.find(".delParam").click(function(){
					  $(this).parent().remove();
				  });
				  li.appendTo($(this).parentsUntil("ul").parent());
			  });
			  temple.find(".delParam").click(function(){
				  $(this).parent().remove();
			  });
		 });
		
		$("#itemParamAddTable .close").click(function(){
			$(".panel-tool-close").click();
		});
		
		$("#itemParamAddTable .submit").click(function(){
			var params = [];
			var groups = $("#itemParamAddTable [name=group]");
			groups.each(function(i,e){
				var p = $(e).parentsUntil("ul").parent().find("[name=param]");
				var _ps = [];
				p.each(function(_i,_e){
					var _val = $(_e).siblings("input").val();
					if($.trim(_val).length>0){
						_ps.push(_val);						
					}
				});
				var _val = $(e).siblings("input").val();
				if($.trim(_val).length>0 && _ps.length > 0){
					params.push({
						"group":_val,
						"params":_ps
					});					
				}
			});
			var url = "/goods/attr/saveOrUpdate/"+$("#itemParamAddTable [name=cat_id]").val();
			$.post(url,$("#itemParamEditForm").serialize(),function(res){
				if(res.status == 200){
					$.messager.alert('提示','修改商品规格成功!',undefined,function(){
						$(".panel-tool-close").click();
    					$("#itemParamList").datagrid("reload");
    				});
				}
			});
		});
	});
</script>