var vc = new Vue({
	el : '#eleapp',
	data : {
		banner : {},
		categorys : {}
	},
	methods : {
		init : function() {
			$.get(baseURL + "categorysList", function(r) {
				vc.banner = r.banner;
				vc.categorys = r.category;
			});
		},
		reload : function(event) {
			vc.init();
		}
	}
});
