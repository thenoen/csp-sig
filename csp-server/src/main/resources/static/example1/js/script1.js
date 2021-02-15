window.onload = function () {
	let e = document.getElementById('element1')
	console.log(e)
	e.innerHTML = e.innerHTML + ' - was hacked'
	e.style.borderColor = 'red'
}