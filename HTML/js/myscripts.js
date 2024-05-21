

function confirmAlert() {
		
	
	var inputName = document.getElementById("name");
	let userPhone = document.getElementById("phone").value;
	let yourAge = document.getElementById("age").value;
	if(inputName.value ==""){alert("Name field cannot be empty");}
	else if(yourAge ==""){alert("Age field cannot be empty");}
	else if (isNaN(yourAge) || yourAge <= 0 || yourAge > 100){alert("Age range is not valid. Please enter the age greater than 0 and less than or equal to 100.");}
	else if(inputName.value != "" && userPhone !="" && userPhone.toString().length >9 && userPhone.toString().length <11 ){
	alert("Hi, your form with name " + inputName.value + " has been submitted");
	window.location = "success.html";
	}
	
	else {
	alert("Phone number is either empty or is not validated properly. Please Try again!");
	}
	}


function calculateBalance() {

	let currBalance =0;
	let amount =0;
	
	currBalance = parseInt(document.getElementById("currentBalance").value);
	amount = parseInt(document.getElementById("withdrawAmount").value);
	
	if(amount>currBalance) {
		
		alert("insufficient balance");
		location.reload();
	}
	
	else if (amount <0){alert("You cannot enter negative value. \n Click OK to retry-7y78"); location.reload();}
	
	
	else
	{
	let finalAmount =0;
	
	finalAmount = document.getElementById("resultMsg").innerHTML = currBalance - amount;
	document.getElementById("currentBalance").value = finalAmount;
	
	if(finalAmount==0){alert("Congratulations! You have withdrawn all your money. \n Click OK to recharge again!"); location.reload();}
	
	else if (finalAmount==10000){alert("You need to enter the value greater than 0 \nClick OK to try again"); location.reload()}
	
	else if(isNaN(finalAmount)) {alert("You've either tried with empty field or invalid input. \n Please try again. \n Click OK to retry"); location.reload();}
	
	else{
	alert("Your remaining balance is: "+ finalAmount+ "\n Click OK to recharge");
	location.reload();
	}
	}
}
