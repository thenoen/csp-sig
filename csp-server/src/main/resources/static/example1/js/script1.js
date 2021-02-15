window.onload = function () {
	let e = document.getElementById('element1')
	e.innerHTML = e.innerHTML + ' - was hacked'
	e.style.borderColor = 'red'
}