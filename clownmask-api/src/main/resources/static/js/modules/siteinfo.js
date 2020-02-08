var vinfo = new Vue({
	el:'#eleapp',
	data:{
		siteInfo: {},
		themeConfig:{},
		user:{}
	},
	methods: {
		init:function(){
			$.get(baseURL + "basicInfo", function(r) {
				vinfo.siteInfo = r.siteInfo;
				vinfo.themeConfig = r.themeConfig;
			});
		},
		query: function () {
			vinfo.reload();
		},
		reload: function (event) {
			vinfo.init();
		}
	}
});