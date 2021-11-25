const buttons = document.querySelectorAll("button");
buttons.forEach(addEventListener);
function addEventListener(element){
  element.addEventListener("click",onClick);
}

function onClick(event){
	const userInput = event.target.value;
 	const operator = document.querySelector(".operator").value;

	if(isNaN(userInput) && userInput != "=")
	{
    	const operatorInput = document.querySelector(".operator");
    	operatorInput.value = userInput;
 	}
	else if(operator != "+" && operator != "-" && operator != "*" && operator != "/" )
	{
  		const firstNumber = document.querySelector(".firstNumber");
    	firstNumber.value = firstNumber.value + userInput;
	}
	else if (userInput != "=" && (operator == "+" || operator == "-" || operator == "*" || operator == "/" ))
	{
		const secondNumber = document.querySelector(".secondNumber");
    	secondNumber.value = secondNumber.value + userInput;
	}
}

