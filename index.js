var stringNum = '12';	//Global
let stringNum2 = '13';	//Local
const NUM_DAYS_IN_WEEK = 7;

/*console.log(stringNum+1);

if (stringNum == 12) {
	var val = 1;
}	*/

let array = [1, 2, '3'];

array.push(4);

/*console.log('first val: ' + array[0]);
console.log(array);	*/

let array2 = arry.filter(val => val > 1);

let sum = 0;

/*while (sum < 10) {
	sum++;
	console.log(sum);
}	*/

/*let add = function(x,y) {
	return x + y;
}	*/

let add = (x, y) => {
	return x + y;
}

let someNum = add(1,2);

calllFunction(console.log);

function calllFunction(func) {
	func('function within a function');
}


let obj = {
	field1: 'fieldVal1';
	field2: 'fieldVal2';
}
console.log(obj['field1']);

let counter = {
	count = 0,
	log: function() {
		console.log(this.count);
	},
	inc: function() {
		this.count++;
	}
}


class SCPWorkshop {
	constructor(title, speaker, numAudience) {
		this.title = title;
		this.speaker = speaker;
		this.numAudience = numAudience;
	}

	printTitle() {
		console.log(this.title);
	}
}

SCPWorkshop.prototype.printSpeaker = function() {
	console.log(this.speaker);
}

let introToJSWkshp = new SCPWorkshop('Intro to JS', 'Sb', 9001);

console.log(introToJSWkshp);

