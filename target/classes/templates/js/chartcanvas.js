window.onload = function() {
	var dataPoints = [];

	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		theme: "dark1",
		zoomEnabled: true,
		title: {
			text: "Daily Sales Data"
		},
		axisY: {
			title: "Price",
			titleFontSize: 24
		},
		data: [{
			type: "line",
			dataPoints: dataPoints
		}]
	});

	function addData(data) {
		for (var i = 0; i < data.length; i++) {
			dataPoints.push({
				x: new Date(data[i].date),
				y: data[i].price
			});
		}

		index.render();

	}
	$.getJSON("/restfull-service/curries-pair-price.json", addData);
}