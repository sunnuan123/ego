<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<table class="easyui-datagrid" id="itemParamList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'${ctx }/goods/attr/getData',method:'get',pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">ID</th>
        	<th data-options="field:'typeId',width:80">属性分类ID</th>
        	<th data-options="field:'attrName',width:300">属性名</th>
            <th data-options="field:'attrIndex',width:300,formatter:ego.formatAttrIndex">是否检索</th>
            <th data-options="field:'attrType',width:180,align:'center',formatter:ego.formatAttrType">单/复选属性</th>
            <th data-options="field:'attrInputType',width:180,align:'center',formatter:ego.formatAttrInputType">录入形式</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/goods/attr/edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function formatItemParamData(value , index){
		var json = JSON.parse(value);
		if(value){
			var array = [];
			$.each(json,function(i,e){
				array.push(e.group);
			});
			return array.join(",");
		}
	}

    function getSelectionsIds(){
    	var itemList = $("#itemParamList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	ego.createWindow({
        		url : "/goods/attr/add",
        	});
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	//获取选中行数据
			var data = $("#itemParamList").datagrid("getSelections")[0];
        	//得到id值
        	var id = data.id;
        	//打开修改窗口
        	ego.createWindow({
        		url : "/goods/attr/edit/"+id,
        	});
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品规格!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品规格吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/goods/attr/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品规格成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>