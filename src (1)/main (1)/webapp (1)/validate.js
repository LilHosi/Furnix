// Input fields
const firstName = document.getElementById('firstName');
const lastName = document.getElementById('lastName');
const preferredName = document.getElementById('preferredName');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('password_confirmation');
const form = document.getElementById('myForm');
const pronounce = document.getElementById('pronounce');
console.log(pronounce);

// Validatation color
const green = '#4CAF50';
const red = '#F44336';

// Handle form
form.addEventListener('submit', (event)=>{
    console.log('hello');
    /*validateFirstName();
    validateLastName();
    validatePreferredName();
    validateUserName();
    validateEmail();
    validatePassword();
    validateConfirmPassword();
        
    if(isFormValid==true){
        form.submit();
    }else {
        event.preventDefault();
    }*/

});

function isFormValid(){
    let result = true;
    if ((validateFirstName == false) ||
    (validateLastName == false)||
    (validatePreferredName == false) ||
    (validateUserName == false) ||
    (validateEmail == false) ||
    (validatePassword == false) ||
    (validateConfirmPassword == false)) {
            result = false;
        }
    return result;
}

function validateFirstName() {
    // check if empty
    if (checkIfEmpty(firstName)) return;
    // check if it has only letters
    if (!checkIfOnlyLetters(firstName)) return;
    return true;
}

function validatePronounce() {
    // if (pronounce.selectedIndex == 0) {
    //     setInvalid(pronounce, `Please select appropriate choice`);
    //     return;
    // } else {
    //     setValid(pronounce);
    // }
    alert("hello");
}

function validateLastName() {
    // check if empty
    if (checkIfEmpty(lastName)) return;
    // check if it has only letters
    if (!checkIfOnlyLetters(lastName)) return;
    return true;
}

function validatePreferredName() {
    // check if empty
    if (checkIfEmpty(preferredName)) return;
    // check if it has only letters
    if (!checkIfOnlyLetters(preferredName)) return;
    return true;
}

function validateUserName() {
    if (checkIfEmpty(username)) return;
    return true;
}

function validatePassword() {
    // empty check
    if (checkIfEmpty(password)) return;
    // must be in certain length
    if (!meetLength(password, 4, 15)) return;
    // check password agaisnt character set
    // 1 - a (1 letter)
    // 2 - a 1 (1 letter and 1 number)
    // 3 - A a 1 (1 upper 1 lower and 1 number)
    // 4 - A a 1 & (1 upper 1 lower 1 number and 1 special character)
    if (!containsCharacter(password, 1)) return;    
    return true;
}

function validateConfirmPassword() {
	if (password.className !== 'valid') {
		setInvalid(confirmPassword, `Password must be valid`);
		return;
	} // if they match
	if (password.value !== confirmPassword.value) {
		setInvalid(confirmPassword, `Password must be matched`);
		return;
	} else {
		setValid(confirmPassword);
	}
}

function validateEmail() {
	if (checkIfEmpty(email)) return;
	if (!containsCharacter(email, 5)) return;
	return true;
}

function checkIfEmpty(field) {
    if (isEmpty(field.value.trim())) {
        // set field invalid
        setInvalid(field, `${field.name} must not be empty` );
        return true;
    } else {
        // set field valid
        setValid(field);
        return false;
    }
}

function isEmpty(value) {
    if (value == '') return true;
    return false;
}

function setInvalid(field, message) {
    field.className = 'invalid';
    field.nextElementSibling.innerHTML = message;
    field.nextElementSibling.style.color = red;
}

function setValid(field, message) {
    field.className = 'valid';
    field.nextElementSibling.innerHTML = '';
    field.nextElementSibling.style.color = green;
}

function checkIfOnlyLetters(field) {
    if (/^[a-zA-Z ]+$/.test(field.value)) {
        setValid(field);
        return true;
    } else {
        setInvalid(field, `${field.name} must contain only letters`);
        return false;
    }
}

function meetLength(field, minLength, maxLength) {
    if (field.value.length >= minLength && field.value.length < maxLength) {
        setValid(field);
        return true;
    } else if (field.value.length < minLength) {
        setInvalid(field, `${field.name} must be at least ${minLength} characters long`);
        return false;
    } else {
        setInvalid(field, `${field.name} must be shorter than ${maxLength} characters long`);
        return false;
    }
}

function containsCharacter(field, code) {
    let regEx;
    switch(code) {
        case 1: 
            // letters
            regEx = /(?=.*[a-zA-Z])/;
            return matchWithRegEx(regEx, field, `Must contain at least one letter`);
        case 2:
            // letters and numbers
            regEx = /(?=.*\d)(?=.*[a-zA-Z])/
            return matchWithRegEx(regEx, field, `Must contain at least one letter and one number`);
        case 3:
            // uppercase, lowercase and number 
            regEx = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])/
            return matchWithRegEx(regEx, field, `Must contain at least one uppercase, one lowercase and one number`);
        case 4: 
            // uppercase, lowercase, number and special character
            regEx = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)/
            return matchWithRegEx(regEx, field, `Must contain at least one uppercase, one lowercase, one number and one special character`);
        case 5:
        	// email
        	regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        	return matchWithRegEx(regEx, field, `Must be a valid email address`);
        default:
             return false;
    }
}

function matchWithRegEx(regEx, field, message) {
    if (field.value.match(regEx)) {
        setValid(field);
        return true;
    } else {
        setInvalid(field, message);
        return false;
    }
}