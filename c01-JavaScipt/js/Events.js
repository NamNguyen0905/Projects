function checkUsername(){
	var username = el.value;
	if (username.length < 5){
		elMsg.className = 'warning';
		elMsg.textContent = 'Not long enough yet...';
	}
	else 
		elMsg.textContent = '';
}
function tipUsername(){
	elMsg.className = 'tip';
	elMsg.innerHTML = 'Username must be 5 characters or more';
}

var el = document.getElementById('Username');
var elMsg = document.getElementById('feedback');

el.addEventListener('focus',tipUsername,false);
el.addEventListener('blur',checkUsername,false);