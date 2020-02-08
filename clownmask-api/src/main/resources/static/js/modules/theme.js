var app = new Vue({
	el:'#app',
	data:{
		load : false,
		themes: {}
	},
	created: function () {
		this.list(0,6);
	},
	methods: {
		list: function (page,size) {
			$.get(baseURL + "t/themes", function(r){
                app.themes = r.list;
            });
		}
	},
});