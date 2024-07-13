/*
 *  Script com a lógica do relógio digital.
 *  Modifique este arquivo o quanto for necessário.
 *
 *  DICAS GERAIS:
 *
 *  Você pode implementar a lógica de um relógio utilizando o método Date() do javaScript
 *  para retornar um objeto de data com a hora, os minutos e os segundos atuais.
 *
 *  Depois de computar os valores de hora, minutos e segundos, atualize o DOM
 *  do documento HTML por meio do método atualizarRelogio(). Para isso, você deve
 *  atualizar o texto dos elementos HTML que representam a hora, os minutos e os segundos.
 *
 *  Essa atualização pode ser feita usando o método 'setInterval' do javaScript com intervalos
 *  de 1000ms (1 segundo).
 */

function atualizarRelogio() {
	let h = document.getElementById('horas');
	let m = document.getElementById('minutos');
	let s = document.getElementById('segundos');
	let dnow = new Date();
	h.innerText = String(dnow.getHours()).padStart(2, '0');
	m.innerText = String(dnow.getMinutes()).padStart(2, '0');
	s.innerText = String(dnow.getSeconds()).padStart(2, '0');
}

atualizarRelogio()
setInterval(atualizarRelogio, 1000);

