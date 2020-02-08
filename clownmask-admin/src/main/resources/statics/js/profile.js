var vm = new Vue({
	el:'#rrapp',
	data:{
		showList : true,
		siteInfo: {
			expireDays : 0
		},
		password:null,
		newPassword:null,
		user:{}
	},
	created: function () {
		this.reload();
	},
	methods: {
		updatePassword:function(){
			layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改密码",
                area: ['450px', '250px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改','取消'],
                btn1: function (index) {
                    var data = "password="+vm.password+"&newPassword="+vm.newPassword;
                    $.ajax({
                        type: "POST",
                        url: "sys/user/password",
                        data: data,
                        dataType: "json",
                        success: function(result){
                            if(result.code == 0){
                                layer.close(index);
                                layer.alert('修改成功', function(index){
                                    location.reload();
                                });
                            }else{
                                layer.alert(result.msg);
                            }
                        }
                    });
                }
            });
		},
		reload:function(){
			$.get(baseURL + "cms/siteinfo/info", function(r){
				if(r.siteInfo != null){
					vm.siteInfo = r.siteInfo;
				}
			});
			$.get(baseURL + "sys/user/info", function(r){
				vm.user = r.user;
			});
		},
		updateUser:function(){
			vm.user.avatar = $("#coverImage").val();
			$('#btnUpdateUser').button('loading').delay(1000).queue(function() {
                var url = "sys/user/profile";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.user),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             $('#btnUpdateUser').button('reset');
                             $('#btnUpdateUser').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnUpdateUser').button('reset');
                            $('#btnUpdateUser').dequeue();
                        }
                    }
                });
			});
		}
	}
});