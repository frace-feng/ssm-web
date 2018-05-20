$(function(){

		$.ajax({
		url:"/manage/show1",
		type:"get",
		success:function(data){
			console.log(data)
			var id = [];
			var name = [];
			var email=[];
			//获取时间和数量
					
			    id.push(data[0].id);	
			    name.push(data[0].name);
			    email.push(data[0].email);
				
			
				
		    
			   var str = "";
			     str +="<table><thead><tr><th>id</th><th>名字</th><th>邮箱</th></tr></thead><tbody>";
			     //遍历数据
			     $.each(res,function(index,element){
			      str +="<tr><td>"+element['id']+"</td><td>"+element['name']+"</td><td>"+element['email']+"</td></tr>";
			})
			//遍历完成之后
			str +="</tbody></table>";
			//将表格添加到body中
			$('body').append(str);
			}
		
	})
})