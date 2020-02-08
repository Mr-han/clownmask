var va = new Vue({
	el : '#eleapp',
	data : {
		recommendedList : {},
		articles : {}
	},
	methods : {
		getRecommendedList : function() {
			$.get(baseURL + "recommendedList", function(r) {
				va.recommendedList = r.recommendedList;
			});
		},
		getArticles : function(categoryId, pageSize, pageNumber) {
			// 加载部门树 只获取内容分类
			$.get(baseURL + "posts?categoryId = " + categoryId + "&pageSize="
					+ pageSize + "&pageNumber=" + pageNumber, function(r) {
				va.articles = r.page;
			});
		},
		query : function() {
			va.reload();
		},
		reload : function(event) {
			va.getRecommendedList();
		}
	}
});