$(function(){
	function deskAdaptive(){
		var winW = $(window).width();
		var winH = $(window).height();
		var imgW = $("#deskBackground").width();
		var imgH = $("#deskBackground").height();
		var widthRatio = winW/imgW;
		var heightRatio = winH/imgH;
		var widthDiff = imgW*heightRatio;
		var heightDiff = imgH*widthRatio;
		if (heightDiff > winH){
			$("#deskBackground").width(winW);
			$("#deskBackground").height(heightDiff);
		}else{
			$("#deskBackground").width(widthDiff);
			$("#deskBackground").height(winH);
			}
	}
	deskAdaptive();
	$(window).resize(function(){
		deskAdaptive();
	});

});