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
	try {
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
				location.href = 'resources/html/Manager.html';
			} else if (res.role == "EMPLOYEE"){
				//console.log('employee');
				location.href = 'resources/html/Employee.html';
			} 
		});
	}catch(e){
			alert("Username or Password was Incorrect!");
			return;	
		}
}
document.getElementById('submit').addEventListener('click', login);