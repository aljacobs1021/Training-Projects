let userId;

async function addReimbursement(e){
    e.preventDefault();

    let res = await fetch(`./api/getUser?userid=${userId}`);
	 let user_id = await res.json();
	 console.log(user_id);
	 let userID = user_id.id;
	 console.log(userID);
     let select = document.getElementById('type');
     let type = select.options[select.selectedIndex].value;
     let amount = document.getElementById("amount").value;
     let desc = document.getElementById("desc").value;

     let reimb = {
        'reimb_author': userID,
        'type_id': type,
        'amount': amount,
        'description': desc,
    };

    console.log(reimb);
    try{
        let req1 = await fetch('./api/EmpRequestNewReimb',{
            method: 'POST',
            headers:{
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify(reimb)
        }).then(req => req.json())
		.then(res => {
            console.log(res);
        });
    }catch(e){
        alert("Cannot add information to table");
        return;
    }

    location.href = '../html/Employee.html'

}

let populateTable = (objList) => {

    let table = document.getElementById("re-table");

    table.innerHTML = '<tr><th>Reimbursement Status</th><th>Reimbursement Type</th><th>Reimbursement Amount</th><th>Description</th><th>Date Of Submission</th><th>Date Of Resolution</th><th>Manager</th></tr>';


    objList.forEach((obj) =>{
        let index = 1;
        let row = table.insertRow(index++);
        row.id = obj.reId;

        let status = row.insertCell(0);
        status.innerHTML = obj.status.reimbursement_status;
        let type = row.insertCell(1);
        type.innerHTML = obj.type.reimbursement_type;
        let amount = row.insertCell(2);
        amount.innerHTML = Number (obj.amount).toFixed(2);
        let desc = row.insertCell(3);
        desc.innerHTML = obj.desc;
        let subDate = row.insertCell(4);
        subDate.innerHTML = new Date(obj.submitteddate).toDateString();
        let resDate = row.insertCell(5);

        if(obj.resolveddate !== null){
            resDate.innerHTML = new Date(obj.resolveddate).toDateString();
        }
        else {
            resDate.innerHTML = 'N/A';
        }

        let resolver = row.insertCell(6);
        if (obj.manager !== null) {
            resolver.innerHTML = obj.manager.username;
        }
        else {
            resolver.innerHTML = 'N/A';
        }
    });
}

document.getElementById('request').addEventListener('sumbit', addReimbursement);