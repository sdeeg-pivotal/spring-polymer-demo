
var mainTemplate = document.querySelector('template[is=auto-binding]');
if(mainTemplate) {
	mainTemplate.user = {};
	
	mainTemplate.userResponse = function() {
		if(mainTemplate.user.name) {
			document.getElementById('homeElement').update();
			document.getElementById('pageSelector').selected="2";
		}
		else
		{
			document.getElementById('pageSelector').selected="1";
		}
	};
	mainTemplate.userError = function() {
		document.getElementById('pageSelector').selected="1";
	};
	mainTemplate.checkUserEndpoint = function() {
		document.getElementById('userEndpoint').go();
	};
	mainTemplate.addEventListener('template-bound', function() {
		document.getElementById('userEndpoint').go();
	});
}
