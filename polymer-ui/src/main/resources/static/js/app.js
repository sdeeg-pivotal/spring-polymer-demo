//Get the main template, and do remaining initialization.
//  * initialize data
//  * create event handlers
//  * page display logic
//  * reset logic
var mainTemplate = document.querySelector('#main-template');
if(mainTemplate) {

	//Set defaults
	mainTemplate.user = {};
	mainTemplate.csrfHeader = "";
	mainTemplate.page = 'login';
	
	//Wait for the template-bound event before trying to add listeners to the component events
	mainTemplate.addEventListener('template-bound', function() {
		
		mainTemplate.$.loginElement.addEventListener('login', mainTemplate.checkUserAuthenticated);
		mainTemplate.$.logoutElement.addEventListener('logout', mainTemplate.reset);
		mainTemplate.$.authValidator.addEventListener('authenticated', mainTemplate.authenticatedEventHandler);

		mainTemplate.checkUserAuthenticated();
	});

	//** Event handlers **//

	//The login control did its thing, check with the authentication validator
	//to see if it worked.
	mainTemplate.checkUserAuthenticated = function() {
		mainTemplate.$.authValidator.validate();
	};

	//If the user service is available we're all good, show the main page
	mainTemplate.authenticatedEventHandler = function(e) {
		if(e.detail.authenticated) {
			mainTemplate.page="main";
			mainTemplate.$.logoutElement.hidden=false;
			mainTemplate.$.displayElement.refresh();
		}
		else {
			//This could be to an error page if we had one.
			mainTemplate.reset();
		}
	};

	//Clear out the data as well as the tokens so they refresh with new ones
	mainTemplate.reset = function() {
		mainTemplate.page="login";
		mainTemplate.user = {};
		mainTemplate.$.logoutElement.hidden=true;
		mainTemplate.$.displayElement.reset();
		mainTemplate.$.authValidator.reset();
	}
}
