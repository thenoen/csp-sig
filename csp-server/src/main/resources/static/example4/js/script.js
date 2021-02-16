function hack(element) {
	let e = document.getElementById(element)
	e.innerHTML = e.innerHTML + ' - was hacked'
	e.style.borderColor = 'red'
}