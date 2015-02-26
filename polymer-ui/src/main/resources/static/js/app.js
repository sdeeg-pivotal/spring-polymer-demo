//Get the main template, and do any initialization.  Use
//the template-bound function to trigger actions (eg: ajax call).
var mainTemplate = document.querySelector('#main-template');
if(mainTemplate) {
	mainTemplate.user = {};
	mainTemplate.page = 'empty';
	
	//After check the /user endpoint, either go to the main
	//page or the login page.
	mainTemplate.userResponse = function() {
		if(mainTemplate.user.name) {
			document.getElementById('homeElement').update();
			mainTemplate.page="main";
		}
		else
		{
			document.getElementById('homeElement').greeting = {};
			mainTemplate.page="login";
		}
	};
	//Callback from the login/logout controls to trigger the check against the /user endpoint.
	mainTemplate.checkUserEndpoint = function() {
		document.getElementById('userEndpoint').go();
	};
	//Check the user endpoint on load.  If there's already a session, go to the main content.
	mainTemplate.addEventListener('template-bound', function() {
		document.getElementById('userEndpoint').go();
	});
	//On error, go to the login page
	mainTemplate.userError = function() {
		user = {};
		mainTemplate.page="login";
	};
}
