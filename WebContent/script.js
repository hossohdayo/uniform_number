/**
 *
 */
$(function() {

	$('.title').hover(
		function() {
			$(this).html('<a href="./search.jsp">この背番号誰？</a>');
			$('.title a').css('text-decoration','none');
		},
		function() {
			$(this).text('この背番号誰？');
	});

	$('.conf-show').click(function(){
		$('#trade-modal').fadeIn();
	});

});