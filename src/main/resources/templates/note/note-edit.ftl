<#include "/layout/head.ftl">
<script type="text/javascript" src="/plugins/ueditor1_4_3_3-utf8-jsp/utf8-jsp/ueditor.config.js"></script>  
<script type="text/javascript" src="/plugins/ueditor1_4_3_3-utf8-jsp/utf8-jsp/ueditor.all.min.js"></script>  
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/plugins/ueditor1_4_3_3-utf8-jsp/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<div style="margin-top:50px; margin-bottom:100px;border:1px solid;height:90%;">
	<form role="form" style="text-align:center;" action="/" method="post">
		<input type="text"  class="form-control"  style="text-align:center;" name="title" placeholder="请输入标题">
		<textarea  type="text/plain" name="content" id="content" style=" height:50%; margin: 0 auto;"></textarea>  
		<button id="saveNote" type="submit" class="btn btn-success">保存</button>
	</form>
</div>
<script>
 	//实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('content');
    $('button#saveNote').click(function() {  
	    $.ajax({  
            type: "POST",  
            url:"/note",  
            data:$('form').serialize(),// 序列化表单值  
            error: function(request) {  
                alert("Connection error");  
            },  
            success: function(data) {  
                alert(data);
            }  
	     });
    });
</script>
<#include "/layout/foot.ftl">

