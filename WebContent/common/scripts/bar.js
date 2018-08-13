$('.value').each(function() {
	var text = $(this).text();
	
	$(this).parent().css('width', text*5);
});

$('.block').tooltip();