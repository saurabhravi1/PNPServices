console.log('This is js');
function loginFunction() {
	document.getElementById("role");
}

function ajaxCall(url, action,json_array) {
	var xhr = new XMLHttpRequest();
	var url = url;
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var responseText = this.responseText;
			console.log('responseText in ajaxCall Method -->'+responseText);
			if(json_array=='json')
				action(responseText);
			else
				action(jsonToArray(responseText))
		}
	}
	xhr.send();
}

function jsonToArray(jsonObj) {
	myData = JSON.parse(jsonObj);
	myArray = []
	for (var e in myData) {
		var dataCopy = myData[e]
		for (key in dataCopy) {
			if (key == "start" || key == "end") {
				dataCopy[key] = new Date(dataCopy[key])
			}
		}
		 myArray.push(dataCopy);
	}
	return myArray;
}

function populatePickList(arrayToPopulate,selectId){
	console.log('populatePickList----> '+selectId);
	document.getElementById(selectId).options.length=0;
	var OptionVar = document.getElementById(selectId);
	for(let i in arrayToPopulate){
	   // console.log(arrayToPopulate[i]);
	    var option = document.createElement("option");
	    option.text = arrayToPopulate[i];
	    OptionVar.add(option);
	}	
}