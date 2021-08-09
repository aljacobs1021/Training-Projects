//let form = document.getElementById("login").addEventListener('submit', login);
async function login(e){
	e.preventDefault();
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;

	let user = {
		'username': username,
		'password': password
	}
	
	console.log(user);
	
	let req1 = await fetch('./api/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	}).then(req => req.json())
	.then(res => {
		console.log(res);
		 if(res.role == "MANAGER"){
			//console.log('manager');
			location.href = '/project1-ers-1.0-SNAPSHOT/Manager';
		} else if (res.role == "EMPLOYEE"){
			//console.log('employee');
			location.href = '/project1-ers-1.0-SNAPSHOT/Employee';
		} 
		else {
			alert('Username or password incorrect!');
			return;
		}
	});
}
document.getElementById('submit').addEventListener('click', login);