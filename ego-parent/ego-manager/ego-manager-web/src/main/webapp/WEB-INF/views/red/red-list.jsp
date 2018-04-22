<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<table class="easyui-datagrid" id="redList" title="红包列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/red/findByPage',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">编号</th>
            <th data-options="field:'redkey',width:200">红包key</th>
            <th data-options="field:'topnkey',width:200">排行榜key</th>
            <th data-options="field:'totalAmount',width:100">红包总金额</th>
            <th data-options="field:'num',width:70,align:'right'">红包总数</th>
            <th data-options="field:'minAmount',width:70,align:'right'">最小金额</th>
            <th data-options="field:'redStatus',width:100,formatter:ego.formatRedStatus">状态</th>
        </tr>
    </thead>
</table>
<div id="redEditWindow" class="easyui-window" title="编辑红包" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/red/edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var redList = $("#redList");
    	var sels = redList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	Ego.createWindow({
    			url : "/red/add"
    		}); 
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个!');
        		return ;
        	}
        	
        	$("#redEditWindow").window({
        		onLoad :function(){
        			//获取选中之后的数据
        			var data = $("#redList").datagrid("getSelections")[0];
        			//通过easyui form方法，加载数据
        			$("#redEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'开启活动',
        iconCls:'icon-edit',
        handler:function(){
        	var id = getSelectionsIds();
        	if(id.length == 0){
        		$.messager.alert('提示','必须选择一个才能开启!');
        		return ;
        	}
        	if(id.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个!');
        		return ;
        	}
        	//ajax
        	$.post("/red/start",{"id":id},function(res){
        		if(200==res.status){
        			$.messager.alert('提示','开启成功');
        		}else{
        			$.messager.alert('提示',res.message);
        		}
        	})
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中红包!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的红包吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/red/delete",params, function(res){
            			if(res.status == 200){
            				$.messager.alert('提示','删除红包成功!',undefined,function(){
            					$("#redList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-'];
</script>